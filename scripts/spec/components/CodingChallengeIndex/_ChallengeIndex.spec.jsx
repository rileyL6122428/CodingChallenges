import Store from '../../../src/redux/store.js';
import ChallengeListFilter from '../../../src/components/CodingChallengeIndex/classes/ChallengeListFilter.js';
import codingChallengeRequests from '../../../src/backendApi/codingChallenges.js';
import ChallengeIndex from '../../../src/components/CodingChallengeIndex/_CodingChallengeIndex.page.jsx';

describe("Challenge Index", () => {
  it("is defined", () => expect(ChallengeIndex).toBeDefined());

  let challengeIndex, state;
  beforeEach(() => challengeIndex = new ChallengeIndex());
  beforeEach(() => state = challengeIndex.state);

  describe("#constructor", () => {
    it("instantiates with an empty list of challenges", () => {
      expect(state.challenges).toEqual([]);
    });

    it("instantiates with a challenge list filter", () => {
      expect(state.challengeListFilter).toEqual(jasmine.any(ChallengeListFilter));
    });
  });

  describe("#setCodingChallenges", () => {
    let storeStateMock;

    beforeEach(() => {
      storeStateMock = {
        codingChallenges: { "1": { name: "CHALLENGE 1"}, "2": { name: "CHALLENGE 2"} }
      };
    });

    beforeEach(() => spyOn(Store, 'getState').and.returnValue(storeStateMock));
    beforeEach(() => spyOn(challengeIndex, 'setState'));

    it("it sets the challenges on the state object", () => {
      challengeIndex.setCodingChallenges();

      expect(Store.getState).toHaveBeenCalled();
      expect(challengeIndex.setState)
          .toHaveBeenCalledWith({ challenges: [{name: "CHALLENGE 1"}, {name: "CHALLENGE 2"}] });
    });
  })

  describe("#componentDidMount", () => {
    let setChallengesCBMock, unsubscribeFromStoreMock;

    beforeEach(() => {
      setChallengesCBMock = function setChallengesMock() {};
      spyOn(challengeIndex.setCodingChallenges, 'bind').and.returnValue(setChallengesCBMock);

      unsubscribeFromStoreMock = function unsubscribeMock() {};
      spyOn(Store, 'subscribe').and.returnValue(unsubscribeFromStoreMock);
    });

    beforeEach(() => spyOn(codingChallengeRequests, 'getCodingChallenges'));

    it("subscribes to the redux store", () => {
      challengeIndex.componentDidMount();
      expect(Store.subscribe).toHaveBeenCalledWith(setChallengesCBMock);
    });

    it("defines an unsubcription function", () => {
      challengeIndex.componentDidMount();
      expect(challengeIndex.unsubscribeFromStore).toBe(unsubscribeFromStoreMock);
    });

    it("requests coding challenges from the backend", () => {
      challengeIndex.componentDidMount();
      expect(codingChallengeRequests.getCodingChallenges).toHaveBeenCalled();
    });
  });
});
