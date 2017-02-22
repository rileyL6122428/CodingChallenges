import { CodingChallengeReducer } from './codingChallenge.reducer.js';

import { combineReducers } from 'redux';

export var RootReducer = combineReducers({
  codingChallenges: CodingChallengeReducer
});
