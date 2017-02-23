export default class ChallengeListFilter {

  constructor() {
    this.difficultyFilters = ({ easy: false, medium: false, hard: false });
    this.nameFilter = "";
  }

  filter(challenges) {
    if(this._difficultyFilterUnset() && this._nameFilterUnset()) { return challenges; }

    let filteredChallenges = [];

    challenges.forEach((challenge) => {
      if(this._difficultyFilterMatches(challenge) && this._nameFilterMatches(challenge))
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

  _nameFilterUnset() {
    return !this.nameFilter;
  }

  _difficultyFilterMatches(challenge) {
    return (
      this._difficultyFilterUnset() ||
      this.difficultyFilters[challenge.difficulty]
    );
  }


  _nameFilterMatches(challenge) {
    if(this._nameFilterUnset()) { return true; }

    
  }

  toggleDifficultyFilter(difficulty) {
    this.difficultyFilters[difficulty] = !this.difficultyFilters[difficulty];
  }

  setNameFilter(name) {
    this.nameFilter = name;
  }
}
