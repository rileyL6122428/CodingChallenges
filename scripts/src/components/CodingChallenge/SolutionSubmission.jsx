import React from 'react';
import solutionRequests from '../../backendApi/solutions.js';
import SubmissionOutput from './SubmissionOutput.jsx';

import SolutionUtils from '../../utils/SolutionUtils.js';

import CodeMirror from 'react-codemirror';
import '../../../../node_modules/codemirror/mode/clike/clike.js';
import '../../../../node_modules/codemirror/addon/edit/matchbrackets.js';
import '../../../../node_modules/codemirror/addon/edit/closebrackets.js';

export default class SolutionSubmission extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      code: this._defaultSolution(),
      editorOptions: SolutionUtils.editorOptions()
    };
  }

  componentWillReceiveProps(nextProps) {
    this._setDefaultSolution(nextProps);
  }

  _setDefaultSolution(nextProps) {
    if(this.props.codingChallenge !== nextProps.codingChallenge)
      this.setState({ code: this._defaultSolution(nextProps) });
  }

  _defaultSolution(nextProps) {
    let methodSignature = nextProps? nextProps.codingChallenge.methodSignature : this.props.codingChallenge.methodSignature;
    return SolutionUtils.defaultSolution(methodSignature);
  }

  _updateSolution(updatedCode) {
    this.setState({ code: updatedCode });
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
        <CodeMirror onChange={this._updateSolution.bind(this)} value={this.state.code} options={this.state.editorOptions} />
        <button onClick={this._submitSolution.bind(this)}>Submit</button>
        <SubmissionOutput />
      </div>
    );
  }
}
