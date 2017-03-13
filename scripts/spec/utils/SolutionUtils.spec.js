import SolutionUtils from '../../src/utils/SolutionUtils.js';

describe("SolutionUtils", () => {
  describe("#defaultSolution", () => {
    it("contains the method signature of the supplied coding challenge", () => {
      let codingChallenge = { methodSignature: "MOCK_METHOD_SIGNATURE" };
      let defaultSolution = SolutionUtils.defaultSolution(codingChallenge);
      expect(defaultSolution).toContain(codingChallenge.methodSignature);
    })
  });
});
