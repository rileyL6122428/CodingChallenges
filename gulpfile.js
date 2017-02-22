var browserify = require('browserify');
var babelify = require('babelify');
var buffer = require('vinyl-buffer');
var gulp = require('gulp');
var source = require('vinyl-source-stream');
var sourcemaps = require('gulp-sourcemaps');
var partialify = require('partialify');
var gutil = require('gulp-util');
var watchify = require('watchify');
var path = require('path');
var Karma = require('karma').Server;

function logError(error) {
    if (error._babel) {
        gutil.log(
            gutil.colors.red(error.name)
            + ': ' + gutil.colors.yellow(error.message)
            + '\n' + error.codeFrame
        );
    } else {
        gutil.log(gutil.colors.red(error.message));
    }

    this.emit('end');
}

gulp.task('scripts', function() {
    var bundler = watchify(browserify('./scripts/src/app.jsx', {
        debug: true,
        paths: ['./node_modules', './scripts/src'],
    }))
        .transform(babelify, {
            presets: ['es2015', 'react'],
        })
        .transform(partialify);

    function rebundle() {
        bundler.bundle()
            .on('error', logError)
            .pipe(source('bundle.js'))
            .pipe(buffer())
            .pipe(sourcemaps.init({loadMaps: true}))
            .pipe(sourcemaps.write('./'))
            .pipe(gulp.dest('./src/main/webapp'));
    }

    bundler.on('update', rebundle);

    return rebundle();
});

gulp.task('watch', ['scripts'], function() {
    gulp.watch('./scripts/src/*', ['scripts/src']);
});

gulp.task('test', function(done) {
    new Karma({
        configFile: path.join(__dirname, 'karma.conf.js'),
        singleRun: true,
        autoWatch: false,
        browsers: ['PhantomJS'],
        //browsers: ['Chrome'],
        reporters: ['dots'],
    }, done).start();
});

gulp.task('debug-test', function(done) {
    new Karma({
        configFile: path.join(__dirname, 'karma.conf.js'),
        singleRun: false,
        browsers: ['Chrome'],
        autoWatch: false,
        reporters: ['dots'],
    }, done).start();
});

gulp.task('default', ['watch']);
