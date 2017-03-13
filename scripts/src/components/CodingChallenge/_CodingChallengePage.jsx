import Store from '../../redux/store.js';
import { addChallenge } from '../../redux/actions/codingChallenge.actions.js';
import codingChallengeRequests from '../../backendApi/codingChallenges.js';

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
        <div id="coding-challenge-info">
          <div id="info-images">
            <img id="monster-image" src="/images/monsters/Three.svg" />
          </div>

          <div id="info-text">
            <h2>FiggBuzz</h2>
            <ul id="monster-attributes">
              <li className="attribute">
                <span className="attribute-type">ELEMENT TYPE: </span>
                <span className="attribute-value">Grass</span>
              </li>
              <li className="attribute">
                <span className="attribute-type">WEAKNESSES  :</span>
                <ul className="attribute-values">
                  <li>Conditionals</li>
                  <li>Modulo Aritmethic</li>
                </ul>
              </li>
              <li className="attribute">
                <span className="attribute-type">DESCRIPTION  :</span>
                <span className="attribute-value">Insert FiggBuzz Description</span>
              </li>
            </ul>
          </div>
        </div>

        <SolutionSubmission codingChallenge={codingChallenge} />
      </section>
    );
  }
}
