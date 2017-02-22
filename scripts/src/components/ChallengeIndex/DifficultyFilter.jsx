import React from 'react';

export default class DifficultyFilter extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="difficulty-filters">
        <label htmlFor="easy-checkbox">Easy</label>
        <input type="checkbox" id="easy-checkbox"/>

        <label htmlFor="medium-checkbox">Medium</label>
        <input type="checkbox" id="medium-checkbox"/>

        <label htmlFor="hard-checkbox">Hard</label>
        <input type="checkbox" id="hard-checkbox"/>
      </div>
    );
  }
}
