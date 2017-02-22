import DifficultyFilter from './DifficultyFilter.jsx';
import NameFilter from './NameFilter.jsx'
import CodingChallengeList from './CodingChallengeList.jsx';
import React from 'react';

export default class ChallengeIndex extends React.Component {
  constructor(props) {
    super(props);
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
          <CodingChallengeList />
        </div>
      </section>
    );
  }
}
