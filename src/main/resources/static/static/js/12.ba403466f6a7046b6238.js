webpackJsonp([12],{FZua:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=i("Xxa5"),o=i.n(r),s=i("exGp"),n=i.n(s);function a(t){if(this.options={id:"",canvasId:"verifyCanvas",width:"80",height:"30",type:"number",code:""},"[object Object]"===Object.prototype.toString.call(t))for(var e in t)this.options[e]=t[e];else this.options.id=t;this.options.numArr="0,1,2,3,4,5,6,7,8,9".split(","),this.options.letterArr="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","),this._init(),this.refresh()}function l(t,e){return Math.floor(Math.random()*(e-t)+t)}function c(t,e){return"rgb("+l(t,e)+","+l(t,e)+","+l(t,e)+")"}a.prototype={version:"1.0.0",_init:function(){var t=document.getElementById(this.options.id),e=document.createElement("canvas");this.options.width="160",this.options.height="50",e.id=this.options.canvasId,e.width=this.options.width,e.height=this.options.height,e.style.cursor="pointer",e.innerHTML="您的浏览器版本不支持canvas",t.appendChild(e);var i=this;e.onclick=function(){i.refresh()}},refresh:function(){var t=void 0,e=void 0,i=document.getElementById(this.options.canvasId),r=i.getContext("2d");for(i.getContext,r.textBaseline="middle",r.fillStyle=c(180,240),r.fillRect(0,0,this.options.width,this.options.height),e="blend"===this.options.type?this.options.numArr.concat(this.options.letterArr):"number"===this.options.type?this.options.numArr:this.options.letterArr,t=1;t<=4;t++){var o=e[l(0,e.length)];this.options.code+=o,r.font=l(this.options.height/2,this.options.height)+"px SimHei",r.fillStyle=c(50,160),r.shadowOffsetX=l(-3,3),r.shadowOffsetY=l(-3,3),r.shadowBlur=l(-3,3),r.shadowColor="rgba(0, 0, 0, 0.3)";var s=this.options.width/5*t,n=this.options.height/2,a=l(-30,30);r.translate(s,n),r.rotate(a*Math.PI/180),r.fillText(o,0,0),r.rotate(-a*Math.PI/180),r.translate(-s,-n)}for(t=0;t<4;t++)r.strokeStyle=c(40,180),r.beginPath(),r.moveTo(l(0,this.options.width),l(0,this.options.height)),r.lineTo(l(0,this.options.width),l(0,this.options.height)),r.stroke();for(t=0;t<this.options.width/4;t++)r.fillStyle=c(0,255),r.beginPath(),r.arc(l(0,this.options.width),l(0,this.options.height),1,0,2*Math.PI),r.fill()},validate:function(t){return(t=t.toLowerCase())===this.options.code.toLowerCase()}};var u=i("RwfU"),p={name:"loginForm",data:function(){return{form:{user_id:"",user_pwd:"",code:""},rules:{user_id:[{required:!0,message:"请输入用户账号",trigger:"blur"}],user_pwd:[{required:!0,message:"请输入用户密码",trigger:"blur"}],code:[{required:!0,message:"请输入验证码",trigger:"blur"},{validator:this.checkCode,trigger:"blur"}]}}},methods:{retrievePWD:function(){this.$router.push({path:"/pwd/reset"})},checkCode:function(t,e,i){if(this.verifyCode.validate(e))return i();i(new Error("验证码不正确"))},submitForm:function(){var t=this;return n()(o.a.mark(function e(){return o.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,t.$refs.ruleForm.validate(function(){var e=n()(o.a.mark(function e(i){var r,s;return o.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(!i){e.next=17;break}return r={user_id:t.form.user_id,user_pwd:t.form.user_pwd},e.prev=2,e.next=5,t.$http.post("api/user/login",r);case 5:if(200===(s=e.sent).data.code){e.next=10;break}Object(u.a)(s.data.msg),e.next=12;break;case 10:return e.next=12,t.$router.push("/home/welcome");case 12:e.next=17;break;case 14:e.prev=14,e.t0=e.catch(2),Object(u.a)(e.t0);case 17:case"end":return e.stop()}},e,t,[[2,14]])}));return function(t){return e.apply(this,arguments)}}());case 2:case"end":return e.stop()}},e,t)}))()}},mounted:function(){this.verifyCode=new a("v_container")}},d={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"login-wrap"},[i("div",{staticClass:"ms-title"},[t._v("信息库管理系统")]),t._v(" "),i("div",{staticClass:"ms-login"},[i("el-form",{ref:"ruleForm",attrs:{model:t.form,rules:t.rules,"label-width":"0px"}},[i("el-form-item",{attrs:{prop:"user_id"}},[i("el-input",{attrs:{clearable:"",placeholder:"请输入账号"},model:{value:t.form.user_id,callback:function(e){t.$set(t.form,"user_id",e)},expression:"form.user_id"}})],1),t._v(" "),i("el-form-item",{attrs:{prop:"user_pwd"}},[i("el-input",{attrs:{clearable:"",type:"password",placeholder:"请输入密码"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.submitForm.apply(null,arguments)}},model:{value:t.form.user_pwd,callback:function(e){t.$set(t.form,"user_pwd",e)},expression:"form.user_pwd"}})],1),t._v(" "),i("el-form-item",{staticClass:"verifyCodeItemCss",attrs:{prop:"code"}},[i("el-input",{staticClass:"verify_css",attrs:{clearable:"",placeholder:"请输入验证码"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.submitForm.apply(null,arguments)}},model:{value:t.form.code,callback:function(e){t.$set(t.form,"code",e)},expression:"form.code"}}),t._v(" "),i("div",{attrs:{id:"v_container"}})],1),t._v(" "),i("div",{staticClass:"login-btn"},[i("el-button",{staticClass:"loginBtn",attrs:{type:"primary"},on:{click:t.submitForm}},[t._v("登录")])],1),t._v(" "),i("div",{staticClass:"tips",staticStyle:{float:"left"}},[i("el-link",{attrs:{type:"white"},on:{click:t.retrievePWD}},[t._v("忘记密码")])],1)],1)],1)])},staticRenderFns:[]};var h={name:"login",components:{LoginForm:i("VU/8")(p,d,!1,function(t){i("h3Nt")},"data-v-10d12b29",null).exports}},f={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("vue-particles",{staticClass:"login-background",attrs:{color:"#97D0F2",particleOpacity:.7,particlesNumber:50,shapeType:"circle",particleSize:4,linesColor:"#97D0F2",linesWidth:1,lineLinked:!0,lineOpacity:.4,linesDistance:150,moveSpeed:3,hoverEffect:!0,hoverMode:"grab",clickEffect:!0,clickMode:"push"}}),this._v(" "),e("login-form")],1)},staticRenderFns:[]};var m=i("VU/8")(h,f,!1,function(t){i("G/Rt")},"data-v-83b7b1ec",null);e.default=m.exports},"G/Rt":function(t,e){},h3Nt:function(t,e){}});
//# sourceMappingURL=12.ba403466f6a7046b6238.js.map