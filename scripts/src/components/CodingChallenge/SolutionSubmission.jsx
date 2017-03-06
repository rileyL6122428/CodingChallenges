import React from 'react';
import solutionRequests from '../../backendApi/solutions.js';
import SubmissionOutput from './SubmissionOutput.jsx';

export default class SolutionSubmission extends React.Component {
  constructor(props) {
    super(props);
    this.state = { solution: "" , solutionPassed: "YET TO SUBMIT" };
  }

  componentWillMount() {
    this.state.solution = this._defaultSolution(this.props);
  }

  _defaultSolution(props) {
    return (
      "Class Solution { \n\n" +
      "\tpublic " + props.codingChallenge.methodSignature + "{ \n" +
      "\t\t\n" +
      "\t} \n\n" +
      "}"
    );
  }

  updateSolution(editEvent) {
    let updatedSolution = editEvent.target.value;
    this.setState({ solution: updatedSolution });
  }

  submitSolution(clickEvent) {
    clickEvent.preventDefault();
    solutionRequests.submitSolution({
      sourceCode: this.state.solution,
      challengeId: this.props.codingChallenge.id,
    });
  }

  render() {
    return (
      <div id="solution-submission">
        <textarea onChange={this.updateSolution.bind(this)} value={ this.state.solution } rows="10" cols="50" />
        <button onClick={this.submitSolution.bind(this)}>Submit</button>
        <SubmissionOutput />
      </div>
    );
  }
}
