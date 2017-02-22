import React from 'react';

export default class NameFilter extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return <input type="text" placeholder="filter by name" />;
  }
}
