import jwt from "@/common/jwt"
import http from "@/common/http"

const auth = {
    state: {
        token: jwt.getToken(),
        isAuthenticated: !!jwt.getToken(),
        memberInfo : jwt.getMemberInfo()
    },
    getters: {
        getToken: function (state) {
            return state.token;
        },
        isAuthenticated: function (state) {
            return state.isAuthenticated;
        },
        getMemberInfo: function (state) {
            return state.memberInfo;
        },
    },
    mutations: {
        setLogin: function (state, payload) {
            state.token = payload.token;
            state.isAuthenticated = true;
            state.memberInfo = payload.memberInfo;
            
            jwt.setToken(payload.token);
            jwt.setMemberInfo(payload.memberInfo);
        },
        setLogout: function (state) {
            state.token = null
            state.isAuthenticated = false;
            state.memberInfo = null;

            jwt.removeToken();
            jwt.removeMemberInfo();
        }
    },
    actions: {
        login(context, request) {
            return new Promise((resolve, reject) => {
                http.post("/auth/signIn", request)
                    .then(response => {
                        context.commit("setLogin", response.data);
                        resolve(response);
                    })
                    .catch(error => {
                        reject(error);
                    })
            });
        },
        register(context, request) {
            return new Promise((resolve, reject) => {
                http.post("/auth/signUp", request)
                    .then(response => {
                        resolve(response)
                    })
                    .catch(error => {
                        reject(error)
                    })
            });
        }
    }
}

export default auth