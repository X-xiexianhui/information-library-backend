webpackJsonp([15],{"1Rjz":function(t,e){t.exports={box:"qDf3beOnIE22bdnNwYZ6Z_0",logo:"_1tHfzqI2Lhix3nNwvfIc1s_0",btn:"_2MC3ebYNR4ll6tsRwMbHov_0"}},HQeU:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=n("Xxa5"),a=n.n(i),s=n("exGp"),r=n.n(s),c=n("RwfU"),o=n("Er6Z"),u={name:"dataMenu",created:function(){this.initMenu()},data:function(){return{menuList:[],form_id:0,is_admin:!1}},methods:{changeRouter:function(t){this.$router.push({path:"/home/data",query:{form_id:t}})},initMenu:function(){var t=this;return r()(a.a.mark(function e(){var n,i;return a.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,n=t.$cookies.get("login_cookie").split("_"),t.is_admin="系统管理员"===n[2],e.next=5,t.$http.get("api/menu/init");case 5:200!==(i=e.sent).data.code?Object(o.a)(i.data):t.menuList=i.data.data,e.next=12;break;case 9:e.prev=9,e.t0=e.catch(0),Object(c.a)(e.t0.message);case 12:case"end":return e.stop()}},e,t,[[0,9]])}))()}}},l={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"menu"},[n("el-menu",{attrs:{"background-color":"#545c64","text-color":"#409EFF","active-text-color":"#ffd04b"}},[t._l(t.menuList,function(e,i){return n("el-submenu",{key:i,attrs:{index:e.name}},[n("template",{slot:"title"},[n("span",{staticClass:"submenu"},[t._v(t._s(e.name))])]),t._v(" "),t._l(e.child,function(e){return n("el-menu-item",{key:e.menu_id,attrs:{index:"/home/data?form_id="+e.form_id}},[n("a",{staticClass:"menuLink",on:{click:function(n){return t.changeRouter(e.form_id)}}},[t._v("\n          "+t._s(e.child_name)+"\n        ")])])})],2)}),t._v(" "),n("el-menu-item",{attrs:{index:"/home/statistics"}},[n("a",{staticStyle:{"text-align":"left",display:"block"},on:{click:function(e){return t.$router.push("/home/statistics")}}},[t._v("数据统计")])]),t._v(" "),n("el-menu-item",{attrs:{index:"/home/recycle"}},[n("a",{staticStyle:{"text-align":"left",display:"block"},on:{click:function(e){return t.$router.push("/home/recycle")}}},[t._v("回收站")])]),t._v(" "),t.is_admin?n("el-menu-item",{attrs:{index:"/home/dump"}},[n("a",{staticStyle:{"text-align":"left",display:"block"},on:{click:function(e){return t.$router.push("/home/dump")}}},[t._v("备份数据")])]):t._e(),t._v(" "),t.is_admin?n("el-menu-item",{attrs:{index:"/db"}},[n("a",{staticStyle:{"text-align":"left",display:"block"},on:{click:function(e){return t.$router.push("/db")}}},[t._v("管理后台")])]):t._e()],2)],1)},staticRenderFns:[]};var d={name:"home",components:{DataMenu:n("VU/8")(u,l,!1,function(t){n("Q1Y0")},"data-v-60001691",null).exports,userAvatar:n("dQJQ").a},methods:{goToBack:function(){this.$router.push("/db")}}},m={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"nav"},[e("div",{class:this.$style.box},[e("div",{class:this.$style.logo},[e("img",{class:this.$style.logo,attrs:{src:n("7Otq"),alt:"信息库管理系统"}})]),this._v(" "),e("div",{class:this.$style.btn},[e("div",[e("user-avatar")],1)])]),this._v(" "),e("el-container",[e("el-aside",{attrs:{width:"200px"}},[e("data-menu")],1),this._v(" "),e("el-main",[e("router-view")],1)],1)],1)},staticRenderFns:[]};var _=n("VU/8")(d,m,!1,function(t){this.$style=n("1Rjz")},null,null);e.default=_.exports},Q1Y0:function(t,e){}});
//# sourceMappingURL=15.c33d3e0a6885250ddf73.js.map