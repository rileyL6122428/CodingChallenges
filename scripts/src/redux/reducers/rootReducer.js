import CodingChallengeReducer from './codingCHallenge.reducer.js';

import { combineReducers } from 'redux';

export const RootReducer = combineReducers({
  codingChallenges: CodingChallengeReducer
});
