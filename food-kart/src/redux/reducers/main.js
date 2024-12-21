import { combineReducers } from "redux";
import { cartReducer } from "./reducer";

const rootred = combineReducers({
    cart:cartReducer,
})

export default rootred;