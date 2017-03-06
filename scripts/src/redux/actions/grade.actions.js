import { GRADES } from "../constants/grades.js";

function addGrade(grade) {
  return ({
    payload: grade
    type: GRADES.ADD_GRADE
  });
}

function removeGrade() {
  return ({
    payload: null,
    type: GRADES.REMOVE_GRADE
  });
}

export { addGrade };
