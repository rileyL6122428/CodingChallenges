export default class ChallengeListFilter {

  constructor() {
    this.difficultyFilters = ({ easy: false, medium: false, hard: false });
    this.nameFilter = "";
  }

  toggleDifficultyFilter(difficulty) {
    this.difficultyFilters[difficulty] = !this.difficultyFilters[difficulty];
  }

  setNameFilter(name) {
    this.nameFilter = name;
  }

  filter(challenges) {
    if(this._difficultyFilterUnset()) { return challenges; }

    let filteredChallenges = [];

    challenges.forEach((challenge) => {
      if(this._difficultyFilterMatches(challenge))
        filteredChallenges.push(challenge);
    });

    return filteredChallenges;
  }

  _difficultyFilterUnset() {
    return (
      this.difficultyFilters.easy === this.difficultyFilters.medium &&
      this.difficultyFilters.easy === this.difficultyFilters.hard
    );
  }

  _difficultyFilterMatches(challenge) {
    return this.difficultyFilters[challenge.difficulty];
  }
}
