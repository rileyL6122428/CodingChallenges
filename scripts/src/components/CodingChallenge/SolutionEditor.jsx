import React from 'react';
import CodeMirror from 'react-codemirror';

import SolutionUtils from '../../utils/SolutionUtils.js';
import '../../../../node_modules/codemirror/mode/clike/clike.js';
import '../../../../node_modules/codemirror/addon/edit/matchbrackets.js';
import '../../../../node_modules/codemirror/addon/edit/closebrackets.js';

export default class SolutionEditor extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      editorOptions: {
        mode: "text/x-java",
        matchBrackets: true,
        autoCloseBrackets: true,
        lineNumbers: true
      }
    };
  }

  render() {
    return (
        <CodeMirror onChange={this.props.updateSolution}
                    value={this.props.code}
                    options={this.state.editorOptions} />
    );
  }
}
