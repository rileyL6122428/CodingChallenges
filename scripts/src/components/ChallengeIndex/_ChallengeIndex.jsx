import DifficultyFilter from './DifficultyFilter.jsx';
import NameFilter from './NameFilter.jsx'
import CodingChallengeList from './CodingChallengeList.jsx';
import $ from 'jquery';
import React from 'react';

export default class ChallengeIndex extends React.Component {
  constructor(props) {
    super(props);
    this.state = { challenges: [] }
  }

  componentDidMount() {
    let self = this;
    $.ajax({
      url: "./api/coding-challenges",
      type: "GET",
      success: (response) => {
        self.setState({ challenges: response });
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
