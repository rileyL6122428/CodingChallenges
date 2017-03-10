import StorageFormats from '../utils/storageFormats.js';
import { HINTS } from '../constants/hints.js';

function addHints(hintsList) {
  return {
    payload: StorageFormats.idMap(hintsList),
    type: HINTS.ADD_HINTS
  };
}

export { addHints };
