import CodingChallenge from "../../../src/components/CodingChallenge/_CodingChallenge.page.jsx";

describe("CodingChallenge", () => {
  it("is defined", () => expect(CodingChallenge).toBeDefined());

  describe("#componentDidMount", () => {
    xit("places a subscription callback into the redux store");
    xit("makes a request to the backend to get the coding challenge in question");
  });

  describe("#componentWillUnmount", () => {
    xit("unsubscribes from the redux store");
  })

  describe("#setCodingChallenge", () => {
    xit("obtains the correct codingChallenge Instance from the redux store");
    xit("sets the appropriate state on the CodingChallengeComponent");
  });
});
