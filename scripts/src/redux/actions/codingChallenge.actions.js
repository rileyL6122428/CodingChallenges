import { CODING_CHALLENGES } from '../constants/codingChallenges.js';

function addChallenges(challengesList) {
  let payload = {};

  challengesList.forEach((challenge) => payload[challenge.id] = challenge);

  return ({
    payload,
    type: CODING_CHALLENGES.ADD_CHALLENGES
  });
}

export { addChallenges };
