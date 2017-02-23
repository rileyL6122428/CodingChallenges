import React from 'react';
import DateUtils from '../../utils/DateUtils.js';

export default class CodingChallengeListItem extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <li>
        <div>Difficulty: { this.props.challenge.difficulty }</div>
        <div>Name: { this.props.challenge.name }</div>
        <div>Date added: { DateUtils.monthDayYear(this.props.challenge.dateCreated) }</div>
      </li>
    );
  }
}
