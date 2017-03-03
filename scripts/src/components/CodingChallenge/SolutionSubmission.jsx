import React from 'react';
import $ from 'jquery';

export default class SolutionSubmission extends React.Component {

  constructor(props) {
    super(props);

    this.state = { solution: "" };
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
      data: { sourceCode: this.state.solution },
      success: (response) => { debugger },

      error: (response) => {
        console.log("ERROR");
        debugger
      }
    });
  }

  render() {
    return (
      <div id="solution-submission">
        <textarea onChange={this.updateSolution.bind(this)} value={ this.state.solution } rows="10" cols="50" />
        <button>Submit</button>
      </div>
    );
  }
}
