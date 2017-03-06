import { CodingChallengeReducer } from './codingChallenge.reducer.js';
import { GradeReducer } from './grade.reducer.js';

import { combineReducers } from 'redux';

export var RootReducer = combineReducers({
  codingChallenges: CodingChallengeReducer,
  grade: GradeReducer
});
