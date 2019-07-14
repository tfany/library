webpackJsonp([11],{PIBP:function(e,t){},VUgr:function(e,t){},eHpo:function(e,t){},v0rS:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("woOf"),r=a.n(s),i=a("E4LH"),n={name:"UserInfoDetail",props:{value:Object,isEdit:{type:Boolean,default:!1}},data:function(){return{hasEditCreated:!1,rankOptions:[],pwdType:"password",rules:{name:[{required:!0,message:"请输入姓名",trigger:"blur"},{min:1,max:30,message:"长度在 1 到 30 个字符",trigger:"blur"}],gender:[{required:!0,message:"请选择性别",trigger:"blur"}],level:[{required:!0,message:"请选择等级",trigger:"blur"}],phoneNum:[{required:!0,validator:function(e,t,a){Object(i.c)(t)?a():a(new Error("请输入正确的手机号码"))},message:"请输入正确的手机号码"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"blur"}]}}},methods:{handleEditCreated:function(){this.hasEditCreated=!0},showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleNext:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return t.$message({message:"验证失败",type:"error",duration:1e3}),!1;t.$emit("nextStep")})},handleIndex:function(){this.$router.push("/customer")}}},o={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"margin-top":"50px"}},[a("el-form",{ref:"userInfoForm",staticStyle:{width:"600px"},attrs:{model:e.value,rules:e.rules,"label-width":"120px",size:"small"}},[a("el-form-item",{attrs:{label:"姓名：",prop:"name"}},[a("el-input",{attrs:{size:"small"},model:{value:e.value.name,callback:function(t){e.$set(e.value,"name",t)},expression:"value.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"性别：",prop:"gender"}},[a("el-select",{attrs:{placeholder:"性别"},model:{value:e.value.gender,callback:function(t){e.$set(e.value,"gender",t)},expression:"value.gender"}},[a("el-option",{key:"0",attrs:{value:"男",label:"男"}}),e._v(" "),a("el-option",{key:"1",attrs:{value:"女",label:"女"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"手机号码：",prop:"phoneNum"}},[a("el-input",{model:{value:e.value.phoneNum,callback:function(t){e.$set(e.value,"phoneNum",t)},expression:"value.phoneNum"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"密码：",prop:"password"}},[a("el-input",{attrs:{name:"password",type:e.pwdType,autoComplete:"on",placeholder:"请输入密码"},model:{value:e.value.password,callback:function(t){e.$set(e.value,"password",t)},expression:"value.password"}},[a("span",{attrs:{slot:"suffix"},on:{click:e.showPwd},slot:"suffix"},[a("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"eye"}})],1)])],1),e._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:e.handleIndex}},[e._v("返回首页")]),e._v(" "),a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){e.handleNext("userInfoForm")}}},[e._v("下一步，修改头像")])],1)],1)],1)},staticRenderFns:[]};var l=a("VU/8")(n,o,!1,function(e){a("PIBP")},"data-v-08f6c237",null).exports,u={name:"UserRelationDetail",props:{value:Object,isEdit:{type:Boolean,default:!1}},data:function(){return{ImageUrl:""}},computed:{url:{get:function(){return"http://101.201.239.223:8090/user/upload/"+this.value.userId},set:function(){}}},methods:{imgPreview:function(e){var t=e.name;/(.jpg|.jpeg|.gif|.png|.bmp)$/.test(t.toLowerCase())?this.ImageUrl=e.url:this.$message.error("请选择图片文件")},success:function(e){200===e.code?(this.$message({message:"头像上传成功",type:"success"}),null!=e.data&&(this.value.headImg=e.data)):this.$message({message:"网络不太好，请重新上传",type:"error"})},handlePrev:function(){this.$emit("prevStep")},handleFinishCommit:function(){this.$emit("finishCommit",this.isEdit)}}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"margin-top":"50px"}},[a("el-form",{ref:"productRelationForm",staticStyle:{width:"680px"},attrs:{model:e.value,"label-width":"120px",size:"small"}},[a("p",[e._v("  原头像： "),a("img",{staticClass:"avatar",attrs:{src:e.value.headImg}})]),e._v(" "),a("br"),e._v(" "),a("br"),e._v(" "),e.isEdit?a("p",[e._v("新头像：")]):a("p",[e._v(" 请选择头像")]),e._v(" "),a("el-upload",{staticClass:"upload-poster",attrs:{"list-type":"picture-card",action:e.url,"show-file-list":!1,"on-change":e.imgPreview,"auto-upload":!0,"on-success":e.success}},[e.ImageUrl?a("img",{staticClass:"avatar",attrs:{src:e.ImageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),e._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{size:"medium"},on:{click:e.handlePrev}},[e._v("上一步，填写基本")]),e._v(" "),a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:e.handleFinishCommit}},[e._v("完成，提交")])],1)],1)],1)},staticRenderFns:[]};var m=a("VU/8")(u,c,!1,function(e){a("eHpo")},"data-v-56379c3c",null).exports,p=a("vMJZ"),d={userId:"",name:"",gender:"",password:"",phoneNum:"",createTime:"",updateTime:"",status:"",headImg:"",rank:"",level:""},h={name:"UserDetail",components:{UserInfoDetail:l,UserRelationDetail:m},data:function(){return{active:0,productParam:r()({},d),showStatus:[!0,!1]}},created:function(){var e=this;Object(p.b)(this.$route.query.id).then(function(t){e.productParam=t.data})},methods:{hideAll:function(){for(var e=0;e<this.showStatus.length;e++)this.showStatus[e]=!1},prevStep:function(){this.active>0&&this.active<this.showStatus.length&&(this.active--,this.hideAll(),this.showStatus[this.active]=!0)},nextStep:function(){this.active<this.showStatus.length-1&&(this.active++,this.hideAll(),this.showStatus[this.active]=!0)},finishCommit:function(){var e=this;this.$confirm("是否要提交该产品","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(p.h)(e.$route.query.id,e.productParam).then(function(t){e.$alert("提交成功",{type:"success"}),e.$router.back()})})}}},v={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",{staticClass:"form-container",attrs:{shadow:"never"}},[a("el-steps",{attrs:{active:e.active,"finish-status":"success","align-center":""}},[a("el-step",{attrs:{title:"修改基本信息"}}),e._v(" "),a("el-step",{attrs:{title:"修改头像"}})],1),e._v(" "),a("user-info-detail",{directives:[{name:"show",rawName:"v-show",value:e.showStatus[0],expression:"showStatus[0]"}],on:{nextStep:e.nextStep},model:{value:e.productParam,callback:function(t){e.productParam=t},expression:"productParam"}}),e._v(" "),a("user-relation-detail",{directives:[{name:"show",rawName:"v-show",value:e.showStatus[1],expression:"showStatus[1]"}],on:{prevStep:e.prevStep,finishCommit:e.finishCommit},model:{value:e.productParam,callback:function(t){e.productParam=t},expression:"productParam"}})],1)},staticRenderFns:[]};var f=a("VU/8")(h,v,!1,function(e){a("VUgr")},null,null);t.default=f.exports}});
//# sourceMappingURL=11.1b8efd2ce1e57d5c1115.js.map