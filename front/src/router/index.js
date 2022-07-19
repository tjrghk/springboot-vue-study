import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/components/Login'
import Register from '@/components/Register'
import Main from '@/components/Main'
import Content from '@/view/Content'
import store from '@/store'

const beforeAuth = isAuth => (from, to, next) => {
    const isAuthenticated = store.getters["isAuthenticated"];
    if ((isAuthenticated && isAuth) || (!isAuthenticated && !isAuth)) {
        if(from.path === '/') return next("/main");
      
        return next();
    } else {
      // 홈 화면으로 이동
      next("/login");
    }
}


// 경로 지정
const routes = [
    {            
        path: '/',
        beforeEnter: beforeAuth(true),      
    },
    {            
        path: '/main',
        name: 'main',
        component: Main,
        children: [
            {
              path: "",
              component: Content,
              name: "content",
            },
        ],
        beforeEnter: beforeAuth(true),      
    },
    {
        path: '/login',
        name: 'login',    
        component: Login,
        beforeEnter: beforeAuth(false),
    },
    {
        path: '/register',
        name: 'register',    
        component: Register,
        beforeEnter: beforeAuth(false),
    },
    {
        path: '/logout',
        name: 'logout',    
        beforeEnter: (from, to, next) => {
            store.commit("setLogout");
            next("/login");
        },
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router;