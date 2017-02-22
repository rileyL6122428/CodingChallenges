import $ from 'jquery';
import Store from '../../redux/store.js';
import { addChallenges } from '../../redux/actions/codingChallenge.actions.js';

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
    let self = this;

    Store.subscribe(function() {
      self.setState({challenges: Object.values(Store.getState().codingChallenges) })
    })

    $.ajax({
      url: "./api/coding-challenges",
      type: "GET",
      success: (response) => {
        // self.setState({ challenges: response });
        let test = addChallenges;
        debugger
        Store.dispatch(addChallenges(response));
      },
    });
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
