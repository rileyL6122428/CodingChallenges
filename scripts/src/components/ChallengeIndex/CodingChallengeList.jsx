import React from 'react';

export default class CodingChallengeList extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <ul>
        {this.props.challenges.map((challenge, idx) => {
          return <li key={idx}>Name: { challenge.name }</li>;
        })}
      </ul>
    );
  }
}
