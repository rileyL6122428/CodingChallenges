import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, IndexRoute, hashHistory } from 'react-router'

import Navbar from './components/Navbar/_Navbar.jsx';
import CodingChallengeIndex from './components/CodingChallengeIndex/_CodingChallengeIndex.page.jsx';
import CodingChallenge from './components/CodingChallenge/_CodingChallenge.page.jsx';

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
      <IndexRoute component={CodingChallengeIndex} />
      <Route navbar-name="Challenges"
              path='coding-challenges'
              component={CodingChallengeIndex} />

      <Route  path='coding-challenge/:challengeId'
              component={CodingChallenge} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  let root = document.getElementById('content');
  ReactDOM.render(AppRoutes, root);
});
