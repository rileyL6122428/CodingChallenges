import Store from '../../../src/redux/store.js';
import codingChallengeRequests from '../../../src/backendApi/codingChallenges.js';

import CodingChallengePage from "../../../src/components/CodingChallenge/_CodingChallengePage.jsx";

describe("CodingChallenge", () => {
  it("is defined", () => expect(CodingChallengePage).toBeDefined());

  let codingChallengePage;

  beforeEach(() => codingChallengePage = new CodingChallengePage());

  describe("#componentDidMount", () => {
    let  propsMock;
    beforeEach(() => {
      propsMock = { params: { challengeID: 1 } };
      codingChallengePage.props = propsMock
    });

    it("places a subscription callback into the redux store", () => {
      let setCodingChallengeMock = function mockFunction() {};
      spyOn(codingChallengePage.setCodingChallenge, 'bind').and.returnValue(setCodingChallengeMock);
      spyOn(Store, "subscribe");

      codingChallengePage.componentDidMount();

      expect(Store.subscribe).toHaveBeenCalledWith(setCodingChallengeMock);
    });

    it("makes a request to the backend to get the coding challenge in question", () => {
      spyOn(codingChallengeRequests, "getCodingChallenge");

      codingChallengePage.componentDidMount();
      
      expect(codingChallengeRequests.getCodingChallenge).toHaveBeenCalledWith(propsMock.params.challengeId);
    });
  });

  describe("#componentWillUnmount", () => {
    xit("unsubscribes from the redux store");
  })

  describe("#setCodingChallenge", () => {
    xit("obtains the correct codingChallenge Instance from the redux store");
    xit("sets the appropriate state on the CodingChallengeComponent");
  });
});
