import React from 'react';
import $ from 'jquery';

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
    $.ajax({
      url: "/api/solution/" + this.props.codingChallenge.id,
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({ sourceCode: this.state.solution }),
      success: (response) => {
        this.setState({ solutionPassed: (response.passesTests) ? "PASSED" : "FAILED" });
      },

      error: (response) => {
        console.log("ERROR");
      }
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
