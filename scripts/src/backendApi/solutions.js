import $ from 'jquery';

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
      success: params.success,
      error: (response) => { console.log("SUBMISSION ERROR"); }
    });
  }
};
