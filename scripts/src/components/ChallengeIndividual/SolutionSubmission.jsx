import React from 'react';

export default class SolutionSubmission extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div id="solution-submission">
        <textarea readOnly value={ this.props.methodSignature } rows="10" cols="50" />
        <button>Submit</button>
      </div>
    );
  }
}
