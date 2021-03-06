import Store from '../../redux/store.js';
import { addChallenges } from '../../redux/actions/codingChallenge.actions.js';

import codingChallengeRequests from '../../backendApi/codingChallenges.js';
import ChallengeListFilter from './classes/ChallengeListFilter.js';

import DifficultyFilter from './DifficultyFilter.jsx';
import NameFilter from './NameFilter.jsx'
import CodingChallengeList from './CodingChallengeList.jsx';

import React from 'react';

export default class CodingChallengeIndexPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      challenges: [],
      challengeListFilter: new ChallengeListFilter()
    };
  }

  componentDidMount() {
    let subscriptionCB = this.setCodingChallenges.bind(this);
    this.unsubscribeFromStore = Store.subscribe(subscriptionCB);

    codingChallengeRequests.getCodingChallenges();
  }

  componentWillUnmount() {
    this.unsubscribeFromStore();
  }

  setCodingChallenges() {
    let codingChallengeStore = Store.getState().codingChallenges;
    let challenges = Object.values(codingChallengeStore);
    this.setState({ challenges });
  }

  render() {
    return (
      <section id="coding-challenges">
        <h1>Coding Challenges</h1>

        <div id="search-filters">
          <DifficultyFilter
              rerender={this.forceUpdate.bind(this)}
              filter={ this.state.challengeListFilter } />

          <NameFilter
              rerender={this.forceUpdate.bind(this)}
              filter={ this.state.challengeListFilter } />
        </div>

        <div id="coding-challenge-list">
          <CodingChallengeList
              challenges={ this.state.challenges }
              filter={ this.state.challengeListFilter } />
        </div>
      </section>
    );
  }
}
