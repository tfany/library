webpackJsonp([22],{Evjk:function(t,e){},ZHZN:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("M9A7"),i=a("vMJZ"),n={name:"ProductRelationDetail",data:function(){return{ImageUrl:"",value:{}}},created:function(){this.getUserInfo()},computed:{url:{get:function(){return"http://101.201.239.223:8090/manager/upload/"+this.value.id},set:function(){}}},methods:{imgPreview:function(t){var e=t.name;/(.jpg|.jpeg|.gif|.png|.bmp)$/.test(e.toLowerCase())?this.ImageUrl=t.url:this.$message.error("请选择图片文件")},success:function(t){200===t.code?(this.$message({message:"封面头像成功",type:"success"}),null!=t.data&&(this.value.img=t.data)):this.$message({message:"网络不太好，请重新上传",type:"error"})},getUserInfo:function(){var t=this;Object(s.a)().then(function(e){t.value=e.data})},handlePrev:function(){this.$emit("prevStep")},handleFinishCommit:function(){var t=this;this.$confirm("确认修改吗","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e={};e.headImg=t.value.img,Object(i.f)(e).then(function(e){t.$alert("修改成功",{type:"success"}),t.$router.push("/info/index")})})}}},r={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-card",{staticClass:"form-container",attrs:{shadow:"never"}},[a("div",{staticStyle:{"margin-top":"50px"}},[a("el-form",{ref:"productRelationForm",staticStyle:{width:"680px"},attrs:{model:t.value,"label-width":"120px",size:"small"}},[a("p",[t._v(" 旧头像： "),a("img",{staticClass:"avatar",attrs:{src:t.value.icon}})]),t._v(" "),a("br"),t._v(" "),a("br"),t._v(" "),a("p",[t._v(" 请选择头像")]),t._v(" "),a("el-upload",{staticClass:"upload-poster",attrs:{"list-type":"picture-card",action:t.url,"show-file-list":!1,"on-change":t.imgPreview,"auto-upload":!0,"on-success":t.success}},[t.ImageUrl?a("img",{staticClass:"avatar",attrs:{src:t.ImageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),t._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:t.handleFinishCommit}},[t._v("修改头像")])],1)],1)],1)])},staticRenderFns:[]};var c=a("VU/8")(n,r,!1,function(t){a("Evjk")},"data-v-4388829c",null);e.default=c.exports}});
//# sourceMappingURL=22.4e215a8702c6136db5c8.js.map