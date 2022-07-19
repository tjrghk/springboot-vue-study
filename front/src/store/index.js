import { createStore } from 'vuex'
import auth from './module/auth'
import member from './module/member'


export default createStore({
  modules: {
    auth,
    member
  }
})
