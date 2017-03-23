import Store from '../../redux/store.js';
import { addChallenge } from '../../redux/actions/codingChallenge.actions.js';
import codingChallengeRequests from '../../backendApi/codingChallenges.js';

import SolutionSubmission from './SolutionSubmission.jsx';

import React from 'react';

export default class CodingChallengeInfo extends React.Component {

  constructor(props) {
    super(props);
  }


  render() {
    let codingChallenge = this.props.codingChallenge;
    
    return (
        <div id="coding-challenge-info">

          <div id="info-images">
            <img id="monster-image" src="/images/monsters/Three.svg" />
          </div>

          <div id="info-text">
            <h2>{codingChallenge.name}</h2>

            <ul id="monster-attributes">
              <li className="attribute">
                <span className="attribute-value">{codingChallenge.description}</span>
              </li>
            </ul>
          </div>

        </div>
    );
  }
}
// <span className="attribute-type">DESCRIPTION:</span>
