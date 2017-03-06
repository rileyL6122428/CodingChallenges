import { GRADES } from '../constants/grades.js';

const INITIAL_STATE = null;

export function GradeReducer(prevState = INITIAL_STATE, action) {
  switch(action.type) {
    case GRADES.ADD_GRADE:
      return action.payload;
    case GRADES.REMOVE_GRADE:
      return null;
    default:
      return prevState;
  }
}
