import CodingChallengeListItem from './CodingChallengeListItem.jsx';
import React from 'react';

export default class CodingChallengeList extends React.Component {
  constructor(props) {
    super(props);
  }

  filteredList() {
    let challenges = this.props.challenges;
    let listFilter = this.props.filter;

    return listFilter.filter(challenges);
  }

  render() {
    return (
      <ul>
        {this.filteredList().map((challenge, idx) => {
          return <CodingChallengeListItem key={idx} challenge={challenge} />;
        })}
      </ul>
    );
  }
}
