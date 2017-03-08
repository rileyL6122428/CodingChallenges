import React from 'react';
import solutionRequests from '../../backendApi/solutions.js';
import SubmissionOutput from './SubmissionOutput.jsx';

import CodeMirror from 'react-codemirror';
import '../../../../node_modules/codemirror/mode/clike/clike.js';
import '../../../../node_modules/codemirror/addon/edit/matchbrackets.js';
import '../../../../node_modules/codemirror/addon/edit/closebrackets.js';

export default class SolutionSubmission extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      solution: "" ,
      editorOptions: {
        mode: "text/x-java",
        matchBrackets: true,
        autoCloseBrackets: true,
        lineNumbers: true
      }
    };
  }

  componentWillReceiveProps(nextProps) {
    this.setDefaultSolution(nextProps);
  }

  setDefaultSolution(nextProps) {
    if(this.props.codingChallenge !== nextProps.codingChallenge)
      this.setState({ solution: this._defaultSolution(nextProps) });
  }

  _defaultSolution(nextProps) {
    return (
      "public class Solution { \n\n" +
      "\tpublic " + nextProps.codingChallenge.methodSignature + "{ \n" +
      "\t\t\n" +
      "\t} \n\n" +
      "}"
    );
  }

  updateSolution(updatedSourceCode) {
    this.setState({ solution: updatedSourceCode });
  }

  submitSolution(clickEvent) {
    solutionRequests.submitSolution({
      sourceCode: this.state.solution,
      challengeId: this.props.codingChallenge.id,
    });
  }

  render() {
    return (
      <div id="solution-submission">
        <CodeMirror onChange={this.updateSolution.bind(this)} value={this.state.solution} options={this.state.editorOptions} />
        <button onClick={this.submitSolution.bind(this)}>Submit</button>
        <SubmissionOutput />
      </div>
    );
  }
}
