import CodingChallengeListItem from './CodingChallengeListItem.jsx';
import React from 'react';

export default class CodingChallengeList extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    let challenges = this.props.challenges;
    let listFilter = this.props.filter;

    return (
      <ul>
        {listFilter.filter(challenges).map((challenge, idx) => {
          return <CodingChallengeListItem key={idx} challenge={challenge} />;
        })}
      </ul>
    );
  }
}
