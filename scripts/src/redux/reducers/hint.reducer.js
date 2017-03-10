import { HINTS } from '../constants/hints.js';

const INITIAL_STATE = {};

export function HintReducer (prevState = INITIAL_STATE, action) {
  switch(action.type) {
    case HINTS.ADD_HINTS:
      return _addHints(prevState, action.payload);
    default:
      return prevState;
  }
}

function _addHints(prevState, hints) {
  return Object.assign(prevState, hints);
}
