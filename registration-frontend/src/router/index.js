import { createRouter, createWebHistory } from 'vue-router'
const routes = [
  {
    path: '/',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: "/registration",
    name: "registration",
    component: () => import("../views/Registration/List.vue")
  },
  {
    path: "/registration/add",
    name: "registration-add",
    component: () => import("../views/Registration/Add.vue")
  },
  {
    path: "/registration/update/:id",
    name: "registration-update",
    component: () => import("../views/Registration/Update.vue")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
