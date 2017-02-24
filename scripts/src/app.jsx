import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, IndexRoute, hashHistory } from 'react-router'

import Navbar from './components/Navbar/_Navbar.jsx';
import ChallengeIndex from './components/ChallengeIndex/_ChallengeIndex.jsx';

class App extends React.Component {
  constructor(props) { super(props); }
  render () {
    //TODO, NEED TO REFACTOR THE routes[0] BELOW
    return (
      <div>
        <Navbar routes={ this.props.routes[0].childRoutes } />
        { this.props.children }
      </div>
    );
  }
};

let AppRoutes = (
  <Router history={hashHistory} >
    <Route path='/' component={App} >
      <IndexRoute component={ChallengeIndex} />
      <Route navbar-name="Challenges" path='coding-challenges' component={ChallengeIndex} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  let root = document.getElementById('content');
  ReactDOM.render(AppRoutes, root);
});
