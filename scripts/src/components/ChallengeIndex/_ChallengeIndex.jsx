import $ from 'jquery';
import Store from '../../redux/store.js';
import { addChallenges } from '../../redux/actions/codingChallenge.actions.js';

import codingChallengeRequests from '../../backendApi/codingChallenges.js';

import DifficultyFilter from './DifficultyFilter.jsx';
import NameFilter from './NameFilter.jsx'
import CodingChallengeList from './CodingChallengeList.jsx';
import React from 'react';

export default class ChallengeIndex extends React.Component {
  constructor(props) {
    super(props);
    this.state = { challenges: [] }
  }

  componentDidMount() {
    let subscriptionCB = this._setCodingChallenges.bind(this);
    this.unsubscribeFromStore = Store.subscribe(subscriptionCB);

    codingChallengeRequests.getCodingChallenges();
  }

  componentWillUnmount() {
    this.unsubscribeFromStore();
  }

  _setCodingChallenges() {
    let codingChallengeStore = Store.getState().codingChallenges;
    let challenges = Object.values(codingChallengeStore);
    this.setState({ challenges });
  }

  render() {
    return (
      <section id="coding-challenges">
        <h1>Coding Challenges</h1>

        <div id="search-filters">
          <DifficultyFilter />
          <NameFilter />
        </div>

        <div id="coding-challenge-list">
          <CodingChallengeList challenges={this.state.challenges}/>
        </div>
      </section>
    );
  }
}
