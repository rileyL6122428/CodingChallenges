import $ from 'jquery';
import Store from '../redux/store.js';
import { addChallenges, addChallenge } from '../redux/actions/codingChallenge.actions.js';

export default {
  getCodingChallenges: () => {
    $.ajax({
      url: "/api/coding-challenges",
      type: "GET",
      success: (response) => Store.dispatch(addChallenges(response)),
    });
  },

  getCodingChallenge: (id) => {
    $.ajax({
      url: "/api/coding-challenge/" + id,
      type: "GET",
      success: (response) => Store.dispatch(addChallenge(response)),
      error: () => console.log("AN ERROR OCCURRED")
    });
  }
};
