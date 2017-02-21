//REACT
var React = require('react');
var ReactDOM = require('react-dom');

// ROUTER
var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;

//COMPONENTS
import HelloWorld from './components/HelloWorld.jsx';

var App = React.createClass({
  render: function (){
    return(<div>{ this.props.children }</div>);
  }
});

var Router = (
  <Router history={hashHistory} >
    <Route path='/' component={App} >
      <Route path='hello-world' component={HelloWorld} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  var root = document.getElementById('content');
  ReactDOM.render(Router, root);
});
