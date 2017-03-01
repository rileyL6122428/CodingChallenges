import Store from '../../../src/redux/store.js';
import codingChallengeRequests from '../../../src/backendApi/codingChallenges.js';

import CodingChallengePage from "../../../src/components/CodingChallenge/_CodingChallengePage.jsx";

describe("CodingChallenge", () => {
  it("is defined", () => expect(CodingChallengePage).toBeDefined());

  let codingChallengePage, propsMock;

  beforeEach(() => {
    codingChallengePage = new CodingChallengePage();
    propsMock = { params: { challengeId: 1 } };
    codingChallengePage.props = propsMock;
  });

  beforeEach(() => spyOn(codingChallengeRequests, "getCodingChallenge"));

  describe("#componentDidMount", () => {

    it("places a subscription callback into the redux store", () => {
      let setCodingChallengeMock = function mockFunction() {};
      spyOn(codingChallengePage.setCodingChallenge, 'bind').and.returnValue(setCodingChallengeMock);
      spyOn(Store, "subscribe");

      codingChallengePage.componentDidMount();

      expect(Store.subscribe).toHaveBeenCalledWith(setCodingChallengeMock);
    });

    it("makes a request to the backend to get the coding challenge in question", () => {
      codingChallengePage.componentDidMount();

      expect(codingChallengeRequests.getCodingChallenge).toHaveBeenCalledWith(propsMock.params.challengeId);
    });
  });

  describe("#componentWillUnmount", () => {
    it("unsubscribes from the redux store", () => {
      let unsubscribeCB = jasmine.createSpy("unsubscribe");
      spyOn(Store, 'subscribe').and.returnValue(unsubscribeCB);
      codingChallengePage.componentDidMount();

      codingChallengePage.componentWillUnmount();

      expect(unsubscribeCB).toHaveBeenCalled();
    });
  })

  describe("#setCodingChallenge", () => {
    let codingChallengeMock, challengeStoreMock;

    beforeEach(() => {
      codingChallengeMock = {
        name: "MOCK_NAME",
        description: "MOCK_DESCRIPTION",
        methodSignature: "MOCK_METHOD_SIGNATURE"
      };

      challengeStoreMock = {};
      challengeStoreMock[propsMock.params.challengeId] = codingChallengeMock;
    });

    it("sets the appropriate state on the codingChallengeComponent", () => {
      spyOn(Store,'getState').and.returnValue({ codingChallenges: challengeStoreMock });
      spyOn(codingChallengePage, 'setState');

      codingChallengePage.setCodingChallenge();

      expect(codingChallengePage.setState).toHaveBeenCalledWith(codingChallengeMock);
    });
  });
});
