import StorageFormats from '../utils/storageFormats.js';
import { CODING_CHALLENGES } from '../constants/codingChallenges.js';

function addChallenges(challengesList) {
  return {
    payload: StorageFormats.idMap(challengesList, formattedCodingChallenge),
    type: CODING_CHALLENGES.ADD_CHALLENGES
  };
}

function addChallenge(challenge) {
  return {
    payload: formattedCodingChallenge(challenge),
    type: CODING_CHALLENGES.ADD_CHALLENGE
  };
}

function formattedCodingChallenge(codingChallenge) {
  return {
    id: codingChallenge.id,
    name: codingChallenge.name,
    dateCreated: codingChallenge.dateCreated,
    description: codingChallenge.description,
    difficulty: codingChallenge.difficulty,
    imageUrl: codingChallenge.imageUrl,
    methodSignature: codingChallenge.methodSignature,
    hintIds: codingChallenge.hints.map((hint) => { return hint.id })
  };
}

export { addChallenges, addChallenge };
