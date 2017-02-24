import React from 'react';

export default class DifficultyFilter extends React.Component {
  constructor(props) {
    super(props);
  }

  toggleFilter(event) {
    this.props.filter.toggleDifficultyFilter(event.target.value);
    this.props.rerender()
  }

  render() {
    return (
      <div id="difficulty-filters">
        <div className="difficulty-filter">
          <input onChange={this.toggleFilter.bind(this)} type="checkbox" id="easy-checkbox" value="easy" />
          <label htmlFor="easy-checkbox">Easy</label>
        </div>

        <div className="difficulty-filter">
          <input onChange={this.toggleFilter.bind(this)} type="checkbox" id="medium-checkbox" value="medium"/>
          <label htmlFor="medium-checkbox">Medium</label>
        </div>

        <div className="difficulty-filter">
          <input onChange={this.toggleFilter.bind(this)} type="checkbox" id="hard-checkbox" value="hard"/>
          <label htmlFor="hard-checkbox">Hard</label>
        </div>
      </div>
    );
  }
}
