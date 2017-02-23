export default class ChallengeListFilter {

  constructor() {
    this.difficultyFilters = ({ easy: false, medium: false, hard: false });
    this.nameFilterWords = [];
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
    return this.nameFilterWords.length === 0;
  }

  _difficultyFilterMatches(challenge) {
    return (
      this._difficultyFilterUnset() ||
      this.difficultyFilters[challenge.difficulty]
    );
  }


  _nameFilterMatches(challenge) {
    if(this._nameFilterUnset()) { return true; }

    return this.nameFilterWords.every((filterWord) => {
      return challenge.name.toLowerCase().split(/\s+/).some((nameWord) => {
        return nameWord.match(new RegExp(filterWord));
      });
    });
  }

  toggleDifficultyFilter(difficulty) {
    this.difficultyFilters[difficulty] = !this.difficultyFilters[difficulty];
  }

  setNameFilter(name) {
    this.nameFilterWords = name
                            .toLowerCase()
                            .split(/\s+/)
                            .filter((word) => { return word.length !== 0 });
  }
}
