import React from 'react';

export default class NameFilter extends React.Component {
  constructor(props) {
    super(props);
  }

  _updateFilter(event) {
    this.props.filter.setNameFilter(event.target.value);
    this.props.rerender();
  }

  render() {
    return <input onChange={this._updateFilter.bind(this)} type="text" placeholder="filter by name" />;
  }
}
