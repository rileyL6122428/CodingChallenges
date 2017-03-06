import React from 'react';
// import $ from 'jquery';
import solutionRequests from '../../backendApi/solutions.js';

export default class SolutionSubmission extends React.Component {

  constructor(props) {
    super(props);
    this.state = { solution: "" , solutionPassed: "YET TO SUBMIT" };
  }

  componentWillReceiveProps(nextProps) {
    this.state.solution = "Class Solution { \n\n" +
      "\tpublic " + nextProps.codingChallenge.methodSignature + "{ \n" +
      "\t\t\n" +
      "\t} \n\n" +
      "}";
  }

  updateSolution(editEvent) {
    let updatedSolution = editEvent.target.value;
    this.setState({ solution: updatedSolution });
  }

  submitSolution() {
    solutionRequests.submitSolution({
      sourceCode: this.state.solution,
      challengeId: this.props.codingChallenge.id,
      success: this._flagSolutionPassed.bind(this)
    });
  }

  _flagSolutionPassed(submissionResponse) {
    this.setState({
      solutionPassed: (submissionResponse.passesTests) ? "PASSED" : "FAILED"
    });
  }

  render() {
    return (
      <div id="solution-submission">
        <textarea onChange={this.updateSolution.bind(this)} value={ this.state.solution } rows="10" cols="50" />
        <button onClick={this.submitSolution.bind(this)}>Submit</button>
        <div>
          <p>Solution passed: {this.state.solutionPassed}</p>
        </div>
      </div>
    );
  }
}
