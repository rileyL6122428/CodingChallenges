import Store from '../../redux/store.js';
import { addChallenge } from '../../redux/actions/codingChallenge.actions.js';
import codingChallengeRequests from '../../backendApi/codingChallenges.js';

import React from 'react';

export default class CodingChallenge extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      name: "",
      description: "",
      methodSignature: ""
    }
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

    this.setState({
      name: codingChallenge.name,
      description: codingChallenge.description,
      methodSignature: codingChallenge.methodSignature
    });
  }

  render() {
    return (
      <section id="coding-challenge">
        <h1>Coding Challenge</h1>

        <div id="coding-challenge-info">
          <h2>{ this.state.name }</h2>
          <p>{ this.state.description }</p>
        </div>

        <div id="solution-submission">
          <textarea readOnly value={ this.state.methodSignature } rows="10" cols="50" />
        </div>
      </section>
    );
  }
}
