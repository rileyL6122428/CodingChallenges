import $ from 'jquery';
import { addGrade } from '../redux/actions/grade.actions.js';
import Store from '../redux/store.js';

export default {
  submitSolution: (params) => {
    $.ajax({
      url: "/api/solution",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        sourceCode: params.sourceCode,
        challengeId: params.challengeId
      }),
      success: (solutionGrade) => Store.dispatch(addGrade(solutionGrade)),
      error: (response) => console.log("SUBMISSION ERROR")
    });
  }
};
