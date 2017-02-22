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
          <div class="difficulty-filters">
            <label htmlFor="easy-checkbox">Easy</label>
            <input type="checkbox" id="easy-checkbox"/>

            <label htmlFor="medium-checkbox">Medium</label>
            <input type="checkbox" id="medium-checkbox"/>

            <label htmlFor="hard-checkbox">Hard</label>
            <input type="checkbox" id="hard-checkbox"/>
          </div>

          <input type="text" placeholder="filter by name" />
        </div>

        <div id="coding-challenge-list">
          <ul>
            <li>This is a sample list item</li>
            <li>This is a sample list item</li>
            <li>This is a sample list item</li>
          </ul>
        </div>
      </section>
    );
  }
}
