const { createRouter, createWebHashHistory } = VueRouter;

import HomeComp from './components/HomeComp.js';
import LibraryComp from './components/LibraryComp.js';
import WeatherComp from './components/WeatherComp.js';

const routes = [
  { path: '/', component: HomeComp },
  { path: '/library', component: LibraryComp },
  { path: '/weather', component: WeatherComp }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;
