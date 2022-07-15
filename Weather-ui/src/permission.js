import store from "./store";
import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

// 页面进度加载条
NProgress.configure({ showSpinner: false })

router.beforeEach((to, from, next) => {
  NProgress.start()
  to.meta.title && store.dispatch('settings/setTitle', to.meta.title)
  store.dispatch('GenerateRoutes').then(accessRoutes => {
    router.addRoutes(accessRoutes)
    next()
    NProgress.done()
  })
})

router.afterEach(() => {
  NProgress.done()
})
