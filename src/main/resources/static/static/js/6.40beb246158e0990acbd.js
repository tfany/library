webpackJsonp([6],{"3Jz+":function(e,t){},AHgH:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n={name:"updateBrand",components:{BrandDetail:r("Pz8e").a}},a={render:function(){var e=this.$createElement;return(this._self._c||e)("brand-detail",{attrs:{"is-edit":!0}})},staticRenderFns:[]};var i=r("VU/8")(n,a,!1,function(e){r("b3+u")},null,null);t.default=i.exports},Pz8e:function(e,t,r){"use strict";var n=r("woOf"),a=r.n(n),i=r("s/Rn"),s=r("E4LH"),o={supplierId:"",supplierName:"",phoneNum:""},u={name:"BrandDetail",props:{isEdit:{type:Boolean,default:!1}},data:function(){return{brand:a()({},o),rules:{supplierName:[{required:!0,message:"请输入供应商名称",trigger:"blur"},{min:2,max:140,message:"长度在 2 到 140 个字符",trigger:"blur"}],phoneNum:[{validator:function(e,t,r){Object(s.c)(t)?r():r(new Error("请输入正确的手机号码"))},message:"请输入正确的手机号码"}]}}},created:function(){var e=this;this.isEdit?Object(i.d)(this.$route.query.id).then(function(t){e.brand=t.data}):this.brand=a()({},o)},methods:{onSubmit:function(e){var t=this;this.$refs[e].validate(function(r){if(!r)return t.$alert("操作失败",{type:"error"}),!1;t.$confirm("是否提交数据","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.isEdit?Object(i.e)(t.$route.query.id,t.brand).then(function(r){t.$refs[e].resetFields(),t.$alert("修改成功",{type:"success"}),t.$router.back()}):Object(i.a)(t.brand).then(function(r){t.$refs[e].resetFields(),t.brand=a()({},o),t.$alert("添加成功",{type:"success"})})})})},resetForm:function(e){this.$refs[e].resetFields(),this.brand=a()({},o)}}},l={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("el-card",{staticClass:"form-container",attrs:{shadow:"never"}},[r("el-form",{ref:"brandFrom",attrs:{model:e.brand,rules:e.rules,"label-width":"150px"}},[r("el-form-item",{attrs:{label:"供应商名称：",prop:"supplierName"}},[r("el-input",{model:{value:e.brand.supplierName,callback:function(t){e.$set(e.brand,"supplierName",t)},expression:"brand.supplierName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"供应商联系方式：",prop:"phoneNum"}},[r("el-input",{model:{value:e.brand.phoneNum,callback:function(t){e.$set(e.brand,"phoneNum",t)},expression:"brand.phoneNum"}})],1),e._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){e.onSubmit("brandFrom")}}},[e._v("提交")]),e._v(" "),e.isEdit?e._e():r("el-button",{on:{click:function(t){e.resetForm("brandFrom")}}},[e._v("重置")])],1)],1)],1)},staticRenderFns:[]};var c=r("VU/8")(u,l,!1,function(e){r("3Jz+")},null,null);t.a=c.exports},"b3+u":function(e,t){}});
//# sourceMappingURL=6.40beb246158e0990acbd.js.map