import axios from "axios"
import store from "../store"
import router from '../router'

const http = axios.create({
  headers: { "content-type": "application/json" }
});

http.interceptors.request.use(
  config => {
    const isAuthenticated = store.getters["isAuthenticated"]
    if (isAuthenticated) {
      config.headers.common["X-AUTH-TOKEN"] = store.getters["getToken"];
    }

    return config;
  },
  error => {
    Promise.reject(error);
  }
);

http.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    const isAuthenticated = store.getters["isAuthenticated"]
    if (isAuthenticated && 403 === error.response.status ) {
      router.replace("/logout");
    }

    return Promise.reject(error);
  }
);

export default http;