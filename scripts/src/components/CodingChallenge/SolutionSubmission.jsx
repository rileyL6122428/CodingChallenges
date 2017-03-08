import React from 'react';
import solutionRequests from '../../backendApi/solutions.js';
import SubmissionOutput from './SubmissionOutput.jsx';
import SolutionEditor from './SolutionEditor.jsx';
import SolutionUtils from '../../utils/SolutionUtils.js';

export default class SolutionSubmission extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      code: SolutionUtils.defaultSolution(this.props.codingChallenge)
    };
  }

  componentWillReceiveProps(nextProps) {
    if(this._codingChallengeHasBeenUpdated(nextProps))
      this.setState({ code: SolutionUtils.defaultSolution(nextProps.codingChallenge) });
  }

  _codingChallengeHasBeenUpdated(nextProps) {
    return this.props.codingChallenge !== nextProps.codingChallenge
  }

  _submitSolution(clickEvent) {
    solutionRequests.submitSolution({
      sourceCode: this.state.code,
      challengeId: this.props.codingChallenge.id,
    });
  }

  render() {
    return (
      <div id="solution-submission">
        <SolutionEditor updateSolution={(code) => this.setState({code})}
                        codingChallenge={this.props.codingChallenge}
                        code={this.state.code} />

        <button onClick={this._submitSolution.bind(this)}>Submit</button>
        <SubmissionOutput />
      </div>
    );
  }
}
