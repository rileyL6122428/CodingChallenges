import Store from '../../redux/store.js';
import { addChallenge } from '../../redux/actions/codingChallenge.actions.js';
import codingChallengeRequests from '../../backendApi/codingChallenges.js';

import CodingChallengeInfo from './CodingChallengeInfo.jsx';
import SolutionSubmission from './SolutionSubmission.jsx';

import React from 'react';

export default class CodingChallengePage extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      codingChallenge: {
        name: "",
        description: "",
        methodSignature: "",
      }
    };
  }

  componentDidMount() {
    let subscriptionCB = this.setCodingChallenge.bind(this);
    this.unsubscribeFromStore = Store.subscribe(subscriptionCB);
    codingChallengeRequests.getCodingChallenge(this.props.params.challengeId);
  }

  componentWillUnmount() {
    this.unsubscribeFromStore();
  }

  setCodingChallenge() {
    let codingChallengeStore = Store.getState().codingChallenges;
    let codingChallenge = codingChallengeStore[this.props.params.challengeId];
    this.setState({ codingChallenge });
  }

  render() {
    let codingChallenge = this.state.codingChallenge;
    return (
      <section id="coding-challenge">
        <CodingChallengeInfo codingChallenge={codingChallenge} />
        <SolutionSubmission codingChallenge={codingChallenge} />
      </section>
    );
  }
}
