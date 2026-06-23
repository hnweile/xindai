import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import fengkongzhuanyuanList from '../pages/fengkongzhuanyuan/list'
import fengkongzhuanyuanDetail from '../pages/fengkongzhuanyuan/detail'
import fengkongzhuanyuanAdd from '../pages/fengkongzhuanyuan/add'
import daikuanxinxiList from '../pages/daikuanxinxi/list'
import daikuanxinxiDetail from '../pages/daikuanxinxi/detail'
import daikuanxinxiAdd from '../pages/daikuanxinxi/add'
import daikuanshenqingList from '../pages/daikuanshenqing/list'
import daikuanshenqingDetail from '../pages/daikuanshenqing/detail'
import daikuanshenqingAdd from '../pages/daikuanshenqing/add'
import xinyongpingguList from '../pages/xinyongpinggu/list'
import xinyongpingguDetail from '../pages/xinyongpinggu/detail'
import xinyongpingguAdd from '../pages/xinyongpinggu/add'
import creditdataList from '../pages/creditdata/list'
import creditdataDetail from '../pages/creditdata/detail'
import creditdataAdd from '../pages/creditdata/add'
import creditdataforecastList from '../pages/creditdataforecast/list'
import creditdataforecastDetail from '../pages/creditdataforecast/detail'
import creditdataforecastAdd from '../pages/creditdataforecast/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'fengkongzhuanyuan',
					component: fengkongzhuanyuanList
				},
				{
					path: 'fengkongzhuanyuanDetail',
					component: fengkongzhuanyuanDetail
				},
				{
					path: 'fengkongzhuanyuanAdd',
					component: fengkongzhuanyuanAdd
				},
				{
					path: 'daikuanxinxi',
					component: daikuanxinxiList
				},
				{
					path: 'daikuanxinxiDetail',
					component: daikuanxinxiDetail
				},
				{
					path: 'daikuanxinxiAdd',
					component: daikuanxinxiAdd
				},
				{
					path: 'daikuanshenqing',
					component: daikuanshenqingList
				},
				{
					path: 'daikuanshenqingDetail',
					component: daikuanshenqingDetail
				},
				{
					path: 'daikuanshenqingAdd',
					component: daikuanshenqingAdd
				},
				{
					path: 'xinyongpinggu',
					component: xinyongpingguList
				},
				{
					path: 'xinyongpingguDetail',
					component: xinyongpingguDetail
				},
				{
					path: 'xinyongpingguAdd',
					component: xinyongpingguAdd
				},
				{
					path: 'creditdata',
					component: creditdataList
				},
				{
					path: 'creditdataDetail',
					component: creditdataDetail
				},
				{
					path: 'creditdataAdd',
					component: creditdataAdd
				},
				{
					path: 'creditdataforecast',
					component: creditdataforecastList
				},
				{
					path: 'creditdataforecastDetail',
					component: creditdataforecastDetail
				},
				{
					path: 'creditdataforecastAdd',
					component: creditdataforecastAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
