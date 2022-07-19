const TOKEN_KEY = "X-AUTH-TOKEN";
const MEMBER_KEY = "MEMBER-INFO";

export const getToken = () => {
  return localStorage.getItem(TOKEN_KEY);
}

export const setToken = token => {
  localStorage.setItem(TOKEN_KEY, token);
}

export const removeToken = () => {
  localStorage.removeItem(TOKEN_KEY);
}

export const getMemberInfo = () => {
  return JSON.parse(localStorage.getItem(MEMBER_KEY));
}

export const setMemberInfo = memberInfo => {
  localStorage.setItem(MEMBER_KEY, JSON.stringify(memberInfo));
}

export const removeMemberInfo = () => {
  localStorage.removeItem(MEMBER_KEY);
}

export default {
  getToken,
  setToken,
  removeToken,
  getMemberInfo,
  setMemberInfo,
  removeMemberInfo
}