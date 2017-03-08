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

  editorOptions: () => {
    return ({
      mode: "text/x-java",
      matchBrackets: true,
      autoCloseBrackets: true,
      lineNumbers: true
    });
  }
}

export default SolutionUtils;
