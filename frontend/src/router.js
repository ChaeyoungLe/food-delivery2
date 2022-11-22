
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"
import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import MenuView from "./components/MenuView"
import MenuViewDetail from "./components/MenuViewDetail"
import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderListView from "./components/OrderListView"
import OrderListViewDetail from "./components/OrderListViewDetail"
import NotificationLogManager from "./components/listers/NotificationLogCards"
import NotificationLogDetail from "./components/listers/NotificationLogDetail"

import OrderStateView from "./components/OrderStateView"
import OrderStateViewDetail from "./components/OrderStateViewDetail"
import DeliveItemManager from "./components/listers/DeliveItemCards"
import DeliveItemDetail from "./components/listers/DeliveItemDetail"

import CheckItemView from "./components/CheckItemView"
import CheckItemViewDetail from "./components/CheckItemViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/menus',
                name: 'MenuView',
                component: MenuView
            },
            {
                path: '/menus/:id',
                name: 'MenuViewDetail',
                component: MenuViewDetail
            },
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orderLists',
                name: 'OrderListView',
                component: OrderListView
            },
            {
                path: '/orderLists/:id',
                name: 'OrderListViewDetail',
                component: OrderListViewDetail
            },
            {
                path: '/notificationLogs',
                name: 'NotificationLogManager',
                component: NotificationLogManager
            },
            {
                path: '/notificationLogs/:id',
                name: 'NotificationLogDetail',
                component: NotificationLogDetail
            },

            {
                path: '/orderStates',
                name: 'OrderStateView',
                component: OrderStateView
            },
            {
                path: '/orderStates/:id',
                name: 'OrderStateViewDetail',
                component: OrderStateViewDetail
            },
            {
                path: '/deliveItems',
                name: 'DeliveItemManager',
                component: DeliveItemManager
            },
            {
                path: '/deliveItems/:id',
                name: 'DeliveItemDetail',
                component: DeliveItemDetail
            },

            {
                path: '/checkItems',
                name: 'CheckItemView',
                component: CheckItemView
            },
            {
                path: '/checkItems/:id',
                name: 'CheckItemViewDetail',
                component: CheckItemViewDetail
            },


    ]
})
