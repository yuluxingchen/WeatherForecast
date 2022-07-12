import store from "./store";
import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

NProgress.configure({ showSpinner: false })

router.beforeEach((to, from, next) => {
  NProgress.start()
  to.meta.title && store.dispatch('settings/setTitle', to.meta.title)
  if (to.path === '/login') {
    next({ path: '/' })
    NProgress.done()
  } else {
    next()
  }
})

router.afterEach(() => {
  NProgress.done()
})
