import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AdminHomeView from '../views/AdminHomeView.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView
    },
    {
        path: '/jjdx',
        name: 'JueJiDeXing',
        component: () => import( '../views/JueJiDeXing.vue')
    },
    {
        path: '/admin/login',
        name: 'AdminLogin',
        component: () => import( '../views/AdminLoginView.vue')
    },
    {
        path: '/admin/home',
        name: 'AdminHome',
        component: AdminHomeView
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
