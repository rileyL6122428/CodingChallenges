var SolutionUtils = {
  defaultSolution: (methodSignature) => {
    return (
      "public class Solution { \n\n" +
      "\tpublic " + methodSignature + "{ \n" +
      "\t\t\n" +
      "\t} \n\n" +
      "}"
    );
  },

}

export default SolutionUtils;
