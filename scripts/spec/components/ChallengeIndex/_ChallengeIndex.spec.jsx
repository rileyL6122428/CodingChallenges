import React from 'react';
import ReactTestUtils from 'react-addons-test-utils';

import Store from '../../../src/redux/store.js';
import ChallengeListFilter from '../../../src/components/ChallengeIndex/classes/ChallengeListFilter.js';
import ChallengeIndex from '../../../src/components/ChallengeIndex/_ChallengeIndex.jsx';

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

  describe("#componentDidUpdate", () => {
    beforeEach(() => {
      spyOn(Store, 'subscribe');
    })

    xit("subscribes to the redux store", () => {

    });

    xit("defines an unsubcription function", () => {

    });

    xit("requests coding challenges from the backend", () => {

    });
  });
});
