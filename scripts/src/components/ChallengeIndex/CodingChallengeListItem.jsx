import React from 'react';

export default class CodingChallengeListItem extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    let dateCreated = new Date(this.props.challenge.dateCreated);
    let dateStr = dateCreated.getMonth() + "/" + dateCreated.getDate() + "/" + dateCreated.getFullYear();
    return (
      <li>
        <div>Difficulty: { this.props.challenge.difficulty }</div>
        <div>Name: { this.props.challenge.name }</div>
        <div>Date added: { dateStr }</div>
      </li>
    );
  }
}
