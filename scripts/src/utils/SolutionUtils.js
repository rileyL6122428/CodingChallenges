var SolutionUtils = {

  defaultSolution: (codingChallenge) => {
    return (
      "public class Solution { \n\n" +
      "\tpublic " + codingChallenge.methodSignature + "{ \n" +
      "\t\t\n" +
      "\t} \n\n" +
      "}"
    );
  },

}

export default SolutionUtils;
