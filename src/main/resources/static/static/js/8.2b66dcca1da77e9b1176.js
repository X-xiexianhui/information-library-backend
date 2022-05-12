webpackJsonp([8],{"2itn":function(e,t){},"8oRS":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("Xxa5"),l=a.n(r),n=a("exGp"),o=a.n(n),u=a("RwfU"),s=a("mvHQ"),i=a.n(s),c=a("mtWM"),d=a.n(c),f=a("So6Q"),m=a("g7ZD"),h=a("Er6Z"),v={name:"authEditForm",props:{form_data:{type:Object,default:function(){return{role_name:"",form_name:"",addAuth:"",del:"",search:"",editAuth:""}}}},data:function(){return{form:JSON.parse(i()(this.form_data)),dialogVisible:!1,formRule:{addAuth:[{required:!0,message:"请选择新增权限",trigger:"blur"}],del:[{required:!0,message:"请选择删除权限",trigger:"blur"}],search:[{required:!0,message:"请选择查询权限",trigger:"blur"}],editAuth:[{required:!0,message:"请选择修改权限",trigger:"blur"}]},addList:[{label:"不允许新增",value:"w0"},{label:"允许新增",value:"w1"}],delList:[{label:"不允许删除",value:"d0"},{label:"仅允许删除所填数据",value:"d1"},{label:"允许删除全部数据",value:"d2"}],searchList:[{label:"仅允许查询所填数据",value:"s0"},{label:"允许查询全部数据",value:"s1"}],editList:[{label:"不允许修改",value:"u0"},{label:"仅允许修改所填数据",value:"u1"},{label:"允许修改全部数据",value:"u2"}]}},watch:{form_data:function(e){this.form=JSON.parse(i()(e))}},created:function(){var e=this;m.a.$on("showAuthEditForm",function(){e.dialogVisible=!0})},methods:{closeEvent:function(){this.dialogVisible=!1,this.$refs.form.resetFields()},save:function(){var e=this;return o()(l.a.mark(function t(){return l.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.$refs.form.validate(function(){var t=o()(l.a.mark(function t(a){var r,n;return l.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(a){t.next=2;break}return t.abrupt("return");case 2:return t.prev=2,r=Object(f.a)(e.form_data,e.form),t.next=6,d.a.post("/api/auth/edit",{role_name:e.form.role_name,form_name:e.form.form_name,update:r});case 6:200!==(n=t.sent).data.code?Object(h.a)(n.data):(m.a.$emit("refreshAuthList",n.data.data.reverse()),e.closeEvent()),t.next=13;break;case 10:t.prev=10,t.t0=t.catch(2),Object(u.a)(t.t0.message);case 13:case"end":return t.stop()}},t,e,[[2,10]])}));return function(e){return t.apply(this,arguments)}}());case 2:case"end":return t.stop()}},t,e)}))()}}},p={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{"close-on-click-modal":!1,visible:e.dialogVisible,"before-close":e.closeEvent},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"form",staticStyle:{width:"50%",margin:"auto"},attrs:{model:e.form,rules:e.formRule,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"角色名称：",prop:"role_name"}},[[a("div",{staticStyle:{"text-align":"left"}},[e._v(e._s(e.form.role_name))])]],2),e._v(" "),a("el-form-item",{attrs:{label:"表单名称：",prop:"form_name"}},[[a("div",{staticStyle:{"text-align":"left"}},[e._v(e._s(e.form.form_name))])]],2),e._v(" "),a("el-form-item",{attrs:{label:"新增权限",prop:"addAuth"}},[a("el-select",{attrs:{placeholder:"请选择新增权限"},model:{value:e.form.addAuth,callback:function(t){e.$set(e.form,"addAuth",t)},expression:"form.addAuth"}},e._l(e.addList,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"删除权限",prop:"del"}},[a("el-select",{attrs:{placeholder:"请选择删除权限"},model:{value:e.form.del,callback:function(t){e.$set(e.form,"del",t)},expression:"form.del"}},e._l(e.delList,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"查询权限",prop:"search"}},[a("el-select",{attrs:{placeholder:"请选择查询权限"},model:{value:e.form.search,callback:function(t){e.$set(e.form,"search",t)},expression:"form.search"}},e._l(e.searchList,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),a("el-form-item",{attrs:{label:"修改权限",prop:"editAuth"}},[a("el-select",{attrs:{placeholder:"请选择修改权限"},model:{value:e.form.editAuth,callback:function(t){e.$set(e.form,"editAuth",t)},expression:"form.editAuth"}},e._l(e.editList,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),a("span",{staticStyle:{margin:"auto"}},[a("el-button",{on:{click:e.closeEvent}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确 定")])],1)],1)},staticRenderFns:[]};var b={name:"authList",components:{AuthEditForm:a("VU/8")(v,p,!1,function(e){a("zHAf")},"data-v-11e4c34d",null).exports},data:function(){return{toolBarConfig:{slots:{buttons:"toolbar_buttons"}},searchName:"",tablePage:{currentPage:1,pageSize:10},tableColumn:[{field:"role_name",title:"角色名称"},{field:"form_name",title:"表单名称"},{field:"addAuth",title:"新增权限",slots:{default:"add_default"}},{field:"del",title:"删除权限",slots:{default:"del_default"}},{field:"search",title:"查询权限",slots:{default:"search_default"}},{field:"editAuth",title:"修改权限",slots:{default:"update_default"}}],authList:{w0:"不允许新增",w1:"允许新增",d0:"不允许删除",d1:"仅允许删除所填数据",d2:"允许删除全部数据",s0:"仅允许查询所填数据",s1:"允许查询全部数据",u0:"不允许修改",u1:"仅允许修改所填数据",u2:"允许修改全部数据"},tableData:[],form_data:{role_name:"",form_name:"",addAuth:"",del:"",search:"",editAuth:""}}},created:function(){var e=this;this.query(""),m.a.$on("refreshAuthList",function(t){e.tableData=t})},methods:{query:function(e){var t=this;return o()(l.a.mark(function a(){var r;return l.a.wrap(function(a){for(;;)switch(a.prev=a.next){case 0:return a.prev=0,a.next=3,t.$http.get("api/auth/query",{params:{role_name:e}});case 3:200!==(r=a.sent).data.code?Object(h.a)(r.data):(t.tableData=r.data.data,t.page()),a.next=10;break;case 7:a.prev=7,a.t0=a.catch(0),Object(u.a)(a.t0);case 10:case"end":return a.stop()}},a,t,[[0,7]])}))()},formatAuth:function(e){return this.authList[e]},handlePageChange:function(e){var t=e.currentPage,a=e.pageSize;this.tablePage.currentPage=t,this.tablePage.pageSize=a,this.currentData=this.tableData.slice((t-1)*a,a*t)},editEvent:function(){var e=this.$refs.roleTable.getCurrentRecord();if(!e)return Object(u.a)("请先选择需要修改的数据");this.form_data=e,m.a.$emit("showAuthEditForm")},page:function(){var e=this.tablePage.pageSize;this.currentData=this.tableData.slice(0,e)}}},g={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("vxe-grid",{ref:"roleTable",attrs:{border:"",resizable:"","toolbar-config":e.toolBarConfig,"row-config":{isCurrent:!0},columns:e.tableColumn,data:e.tableData},scopedSlots:e._u([{key:"toolbar_buttons",fn:function(){return[a("vxe-input",{attrs:{placeholder:"请输入角色名称",clearable:""},model:{value:e.searchName,callback:function(t){e.searchName=t},expression:"searchName"}}),e._v(" "),a("vxe-button",{attrs:{status:"primary"},on:{click:function(t){return e.query(e.searchName)}}},[e._v("搜索")]),e._v(" "),a("vxe-button",{attrs:{status:"success"},on:{click:e.editEvent}},[e._v("修改")]),e._v(" "),a("vxe-button",{on:{click:function(t){return e.$refs.roleTable.exportData()}}},[e._v("导出")])]},proxy:!0},{key:"add_default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.formatAuth(r.addAuth)))])]}},{key:"del_default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.formatAuth(r.del)))])]}},{key:"search_default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.formatAuth(r.search)))])]}},{key:"update_default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.formatAuth(r.editAuth)))])]}},{key:"pager",fn:function(){return[a("vxe-pager",{attrs:{layouts:["Sizes","PrevJump","PrevPage","Number","NextPage","NextJump","FullJump","Total"],"current-page":e.tablePage.currentPage,"page-size":e.tablePage.pageSize,total:e.tableData.length},on:{"update:currentPage":function(t){return e.$set(e.tablePage,"currentPage",t)},"update:current-page":function(t){return e.$set(e.tablePage,"currentPage",t)},"update:pageSize":function(t){return e.$set(e.tablePage,"pageSize",t)},"update:page-size":function(t){return e.$set(e.tablePage,"pageSize",t)},"page-change":e.handlePageChange}})]},proxy:!0}])}),e._v(" "),a("auth-edit-form",{attrs:{form_data:e.form_data}})],1)},staticRenderFns:[]};var _=a("VU/8")(b,g,!1,function(e){a("modq")},"data-v-640c84d6",null).exports,x={name:"authPage",components:{PageHead:a("Neex").a,AuthList:_}},A={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("page-head",{staticClass:"nav"}),this._v(" "),t("el-container",[t("el-card",[t("auth-list")],1)],1)],1)},staticRenderFns:[]};var k=a("VU/8")(x,A,!1,function(e){a("2itn")},"data-v-1d4d6d2d",null);t.default=k.exports},modq:function(e,t){},zHAf:function(e,t){}});
//# sourceMappingURL=8.2b66dcca1da77e9b1176.js.map