import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, IndexRoute, hashHistory } from 'react-router'

import HelloWorld from './components/HelloWorld.jsx';
import ChallengeIndex from './components/ChallengeIndex/_ChallengeIndex.jsx';

class App extends React.Component {
  constructor(props) { super(props); }
  render () { return<div>{ this.props.children }</div>; }
};

let AppRoutes = (
  <Router history={hashHistory} >
    <Route path='/' component={App} >
      <IndexRoute component={ChallengeIndex} />
      <Route path='hello-world' component={HelloWorld} />
      <Route path='coding-challenges' component={ChallengeIndex} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  let root = document.getElementById('content');
  ReactDOM.render(AppRoutes, root);
});
