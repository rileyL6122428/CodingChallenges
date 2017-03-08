import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, IndexRoute, hashHistory } from 'react-router'

import Navbar from './components/Navbar/_Navbar.jsx';
import CodingChallengeIndexPage from './components/CodingChallengeIndex/_CodingChallengeIndexPage.jsx';
import CodingChallengePage from './components/CodingChallenge/_CodingChallengePage.jsx';
import DexTop from './components/DexBorder/DexTop.jsx';
import DexBottom from './components/DexBorder/DexBottom.jsx';

class App extends React.Component {
  constructor(props) { super(props); }
  render () {
    //TODO, NEED TO REFACTOR THE routes[0] BELOW
    return (
      <div>
        <DexTop />
        <Navbar routes={ this.props.routes[0].childRoutes } />
        { this.props.children }
        <DexBottom />
      </div>
    );
  }
};

let AppRoutes = (
  <Router history={hashHistory} >
    <Route path='/' component={App} >
      <IndexRoute component={CodingChallengeIndexPage} />
      <Route navbar-name="Challenges"
              path='coding-challenges'
              component={CodingChallengeIndexPage} />

      <Route  path='coding-challenge/:challengeId'
              component={CodingChallengePage} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  let root = document.getElementById('content');
  ReactDOM.render(AppRoutes, root);
});
