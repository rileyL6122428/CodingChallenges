import React from 'react';
import DateUtils from '../../utils/DateUtils.js';
import { Link } from 'react-router'

export default class CodingChallengeListItem extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <li className="coding-challenge">
        <Link to={"coding-challenge/" + this.props.challenge.id}>
          <div className="challenge-difficulty">
            { this.props.challenge.difficulty }
          </div>

          <div className="challenge-name">
            { this.props.challenge.name }
          </div>

          <div className="challenge-date-created">
            { DateUtils.monthDayYear(this.props.challenge.dateCreated) }
          </div>
        </Link>
      </li>
    );
  }
}
