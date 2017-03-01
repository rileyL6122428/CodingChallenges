import Store from '../../../src/redux/store.js';
import codingChallengeRequests from '../../../src/backendApi/codingChallenges.js';

import CodingChallengePage from "../../../src/components/CodingChallenge/_CodingChallengePage.jsx";

describe("CodingChallenge", () => {
  it("is defined", () => expect(CodingChallengePage).toBeDefined());

  let codingChallengePage;

  beforeEach(() => codingChallengePage = new CodingChallengePage());

  describe("#componentDidMount", () => {
    let setCodingChallengeMock;
    beforeEach(() => setCodingChallengeMock = {});

    beforeEach(() => spyOn(codingChallengePage.setCodingChallenge, 'bind'))

    beforeEach(() => spyOn(Store, "subscribe"));


    xit("places a subscription callback into the redux store", () => {

    });

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
