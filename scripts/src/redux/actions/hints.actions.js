import StorageFormats from '../../utils/StorageFormats.js';
import { HINTS } from '../constants/hints.js';

function addHints(hintsList) {
  return {
    payload: StorageFormats.idMap(hintsList),
    type: HINTS.ADD_HINTS
  };
}

export { addHints };
