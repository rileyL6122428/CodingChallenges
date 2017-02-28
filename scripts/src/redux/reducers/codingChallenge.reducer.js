import { CODING_CHALLENGES } from '../constants/codingChallenges.js';

const INITIAL_STATE = {};

export function CodingChallengeReducer (prevState = INITIAL_STATE, action) {
  switch(action.type) {
    case CODING_CHALLENGES.ADD_CHALLENGES:
      return _addChallenges(prevState, action.payload);
    case CODING_CHALLENGES.ADD_CHALLENGE:
      return _addChallenge(prevState, action.payload);
    default:
      return prevState;
  }
}

function _addChallenges(prevState, codingChallenges) {
  return Object.assign(prevState, codingChallenges);
}

function _addChallenge(prevState, codingChallenge) {
  prevState[codingChallenge.id] = codingChallenge;
  return prevState;
}
