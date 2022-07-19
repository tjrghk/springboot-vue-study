import http from "@/common/http"

const member = {
    state: {
        members : null,
    },
    getters: {
        getMembers: function (state) {
            return state.members;
        }
    },
    mutations: {
        setMembers: function (state, payload) {
            state.members = payload;
        }
    },
    actions: {
        members(context) {
            return new Promise((resolve, reject) => {
                http.get("/api/members")
                    .then(response => {
                        context.commit("setMembers", response.data);
                        resolve(response);
                    })
                    .catch(error => {
                        reject(error);
                    })
            });
        }
    }
}

export default member