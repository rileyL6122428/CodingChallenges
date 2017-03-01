import Store from '../../../src/redux/store.js';
import ChallengeListFilter from '../../../src/components/CodingChallengeIndex/classes/ChallengeListFilter.js';
import codingChallengeRequests from '../../../src/backendApi/codingChallenges.js';
import ChallengeIndexPage from '../../../src/components/CodingChallengeIndex/_CodingChallengeIndexPage.jsx';

describe("Challenge Index", () => {
  it("is defined", () => expect(ChallengeIndexPage).toBeDefined());

  let challengeIndexPage, state;
  beforeEach(() => challengeIndexPage = new ChallengeIndexPage());
  beforeEach(() => state = challengeIndexPage.state);

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
    beforeEach(() => spyOn(challengeIndexPage, 'setState'));

    it("it sets the challenges on the state object", () => {
      challengeIndexPage.setCodingChallenges();

      expect(Store.getState).toHaveBeenCalled();
      expect(challengeIndexPage.setState)
          .toHaveBeenCalledWith({ challenges: [{name: "CHALLENGE 1"}, {name: "CHALLENGE 2"}] });
    });
  })

  describe("#componentDidMount", () => {
    let setChallengesCBMock, unsubscribeFromStoreMock;

    beforeEach(() => {
      setChallengesCBMock = function setChallengesMock() {};
      spyOn(challengeIndexPage.setCodingChallenges, 'bind').and.returnValue(setChallengesCBMock);

      unsubscribeFromStoreMock = function unsubscribeMock() {};
      spyOn(Store, 'subscribe').and.returnValue(unsubscribeFromStoreMock);
    });

    beforeEach(() => spyOn(codingChallengeRequests, 'getCodingChallenges'));

    it("subscribes to the redux store", () => {
      challengeIndexPage.componentDidMount();
      expect(Store.subscribe).toHaveBeenCalledWith(setChallengesCBMock);
    });

    it("defines an unsubcription function", () => {
      challengeIndexPage.componentDidMount();
      expect(challengeIndexPage.unsubscribeFromStore).toBe(unsubscribeFromStoreMock);
    });

    it("requests coding challenges from the backend", () => {
      challengeIndexPage.componentDidMount();
      expect(codingChallengeRequests.getCodingChallenges).toHaveBeenCalled();
    });
  });
});
