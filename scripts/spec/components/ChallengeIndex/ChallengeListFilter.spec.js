import ChallengeListFilter from '../../../src/components/ChallengeIndex/ChallengeListFilter.js';

describe("ChallengeListFilter", () => {
  let listFilter, challenges;
  let fizzBuzz,
      reverseString,
      stringContains,
      binarySearch,
      multipleOccurrences,
      regexStar;

  beforeEach(() => listFilter = new ChallengeListFilter());

  beforeEach(() => {
    fizzBuzz = { difficulty: "easy", name: "CHALLENGE 1 FIZZ BUZZ" };
    reverseString = { difficulty: "easy", name: "CHALLENGE 2 REVERSE STRING" };
    stringContains = { difficulty: "easy", name: "CHALLENGE 3 STRING CONTAINS" };
    binarySearch = { difficulty: "medium", name: "CHALLENGE 4 BINARY SEARCH" };
    multipleOccurrences = { difficulty: "medium", name: "CHALLENGE 5 MULTIPLE OCCURRENCES" };
    regexStar = { difficulty: "hard", name: "CHALLENGE 6 IMPLEMENT REGEX STAR" };

    challenges = [
      fizzBuzz,
      reverseString,
      stringContains,
      binarySearch,
      multipleOccurrences,
      regexStar
    ];
  });

  describe("#filter", () => {
    it("returns the supplied list when no filters are set", () => {
      let filteredList = listFilter.filter(challenges);
      expect(filteredList).toEqual(challenges);
    });

    describe("difficulty filter", () => {
      it("returns a list of easy challenges when only the easy difficulty filter is set", () => {
        listFilter.toggleDifficultyFilter("easy");
        let filteredList = listFilter.filter(challenges);

        const NUMBER_OF_EASY_CHALLENGES = 3;
        expect(filteredList.length).toEqual(NUMBER_OF_EASY_CHALLENGES);
        expect(filteredList[0]).toBe(fizzBuzz);
        expect(filteredList[1]).toBe(reverseString);
        expect(filteredList[2]).toBe(stringContains);
      });

      xit("returns a list of medium challenges when only the medium difficulty filter is set", () => {
        listFilter.toggleDifficultyFilter("medium");
      });

      xit("returns a list of hard challenges when only the hard difficulty filter is set", () => {
        listFilter.toggleDifficultyFilter("hard");
      });
    });

    describe("name filter", () => {
      xit("returns a list of challenges with names that partially match all words in the input");
    });
  });
});
