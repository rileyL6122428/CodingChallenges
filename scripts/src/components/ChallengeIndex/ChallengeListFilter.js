export default class ChallengeListFilter {

  constructor() {
    this.difficultyFilters = ({ easy: false, medium: false, hard: false });
  }

  toggleDifficultyFilter(difficulty) {
    this.difficultyFilters[difficulty] = !this.difficultyFilters[difficulty];
  }

  filter(challenges) {
    if(this._difficultyFilterUnset()) { return challenges; }

    let filteredChallenges = [];

    challenges.forEach((challenge) => {
      if(this._difficultyIsSelected(challenge))
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

  _difficultyIsSelected(challenge) {
    return this.difficultyFilters[challenge.difficulty];
  }
}
