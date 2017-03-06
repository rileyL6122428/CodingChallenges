import React from 'react';
import Store from '../../redux/store.js';
import { removeGrade } from '../../redux/actions/grade.actions.js';

export default class SubmissionOutput extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount() {
    this.unsubscribeFromStore = Store.subscribe(this.setGrade.bind(this));
  }

  setGrade() {
    let grade = Object.assign({}, Store.getState().grade);
    this.setState({ grade });
  }

  componentWillUnmount() {
    this.unsubscribeFromStore();
    Store.dispatch(removeGrade());
  }

  message() {
    if(this.state.grade === undefined || this.state.grade.passing === undefined)
      return this.waitingForSubmissionMessage();
    else if(this.state.grade.passing)
      return this.successMessage();
    else
      return this.errorMessage();
  }

  waitingForSubmissionMessage() {
    return <p>WAITING FOR SUBMISSION</p>;
  }

  successMessage() {
    return <p>YOUR CODE PASSED</p>;
  }

  errorMessage() {
    return <p>{this.state.grade.errorMessage}</p>;
  }

  render() {
    return <div id="submission-output">{ this.message() }</div>;
  }
}
