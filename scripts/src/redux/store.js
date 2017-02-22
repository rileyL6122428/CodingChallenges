import { RootReducer } from './reducers/rootReducer.js';
import { createStore } from 'redux';

let Store = createStore(RootReducer);
export default Store;
