import $ from 'jquery';
import Store from '../redux/store.js';
import { addChallenges } from '../redux/actions/codingChallenge.actions.js';

export default {
  getCodingChallenges: () => {
    $.ajax({
      url: "./api/coding-challenges",
      type: "GET",
      success: (response) => Store.dispatch(addChallenges(response)),
    });
  }
};
