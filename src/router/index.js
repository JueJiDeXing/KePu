import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'


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
        path: '/admin',
        name: 'Admin',
        component: () => import( '../views/AdminView.vue')
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
