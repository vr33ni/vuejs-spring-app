import { createWebHistory, createRouter } from "vue-router";

const routes =  [
  {
    path: "/",
    alias: "/home",
    name: "home",
    component: () => import("./components/Home.vue")
  },
  {
    path: "/shop",
    name: "shop",
    component: () => import("./components/shop/Shop.vue"),
        children: [
        { path: 'boards', component:() => import("./components/shop/Boards.vue") },
        { path: 'wetsuits', component:() => import("./components/shop/Wetsuits.vue") },
        { path: 'accessories', component:() => import("./components/shop/Accessories.vue") },

      ]
  },
  {
    path: "/contact",
    name: "contact",
    component: () => import("./components/Contact.vue")
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;