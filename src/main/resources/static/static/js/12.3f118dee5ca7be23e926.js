webpackJsonp([12],{"Gpb+":function(t,e,r){"use strict";var a=r("woOf"),s=r.n(a),o=r("mRsl"),i={description:"",categoryImg:"",categoryName:"",parentId:"",categoryId:""},c={name:"ProductCateDetail",props:{isEdit:{type:Boolean,default:!1}},data:function(){return{productCate:s()({},i),selectProductCateList:[],imgUrl:"",rules:{categoryName:[{required:!0,message:"请输入分类名称",trigger:"blur"},{min:1,max:140,message:"长度在 1 到 140 个字符",trigger:"blur"}]}}},computed:{url:{get:function(){return this.isEdit?"http://101.201.239.223:8090/category/upload/"+this.$route.query.id:"http://101.201.239.223:8090/category/upload/-1"},set:function(){}}},created:function(){var t=this;this.isEdit?Object(o.e)(this.$route.query.id).then(function(e){t.productCate=e.data,t.imgUrl=e.data.categoryImg}):this.productCate=s()({},i),this.getSelectProductCateList()},methods:{getSelectProductCateList:function(){var t=this;Object(o.c)(0,{pageSize:100,pageNum:1}).then(function(e){t.selectProductCateList=e.data.list,t.selectProductCateList.unshift({id:null,name:"无上级分类"})})},onSubmit:function(t){var e=this;this.$refs[t].validate(function(r){if(!r)return e.$message({message:"验证失败",type:"error",duration:1e3}),!1;e.$confirm("是否提交数据","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.isEdit?Object(o.f)(e.$route.query.id,e.productCate).then(function(t){e.$message({message:"修改成功",type:"success",duration:1e3}),e.productCate.imgUrl="",e.$router.back()}):Object(o.a)(e.productCate).then(function(r){e.$refs[t].resetFields(),e.resetForm(t),e.$message({message:"提交成功",type:"success",duration:1e3}),e.productCate.imgUrl=""})})})},resetForm:function(t){this.$refs[t].resetFields(),this.productCate=s()({},i),this.getSelectProductCateList()},imgPreview:function(t){var e=t.name;/(.jpg|.jpeg|.gif|.png|.bmp)$/.test(e.toLowerCase())?this.imgUrl=t.url:this.$message.error("请选择图片文件")},success:function(t){200===t.code?(this.$message({message:"封面上传成功",type:"success"}),null!=t.data&&(this.productCate.categoryImg=t.data)):this.$message({message:"网络不太好，请重新上传",type:"error"})}}},n={render:function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("el-card",{staticClass:"form-container",attrs:{shadow:"never"}},[r("el-form",{ref:"productCateFrom",attrs:{model:t.productCate,rules:t.rules,"label-width":"150px"}},[r("el-form-item",{attrs:{label:"分类名称：",prop:"categoryName"}},[r("el-input",{model:{value:t.productCate.categoryName,callback:function(e){t.$set(t.productCate,"categoryName",e)},expression:"productCate.categoryName"}})],1),t._v(" "),r("el-form-item",{attrs:{label:"上级分类："}},[r("el-select",{attrs:{placeholder:"请选择分类"},model:{value:t.productCate.parentId,callback:function(e){t.$set(t.productCate,"parentId",e)},expression:"productCate.parentId"}},t._l(t.selectProductCateList,function(t){return r("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})}))],1),t._v(" "),r("el-form-item",{attrs:{label:"分类图标："}},[r("el-upload",{staticClass:"upload-poster",attrs:{"list-type":"picture-card",action:t.url,"show-file-list":!1,"on-change":t.imgPreview,"auto-upload":!0,"on-success":t.success}},[t.imgUrl?r("img",{staticClass:"avatar",attrs:{src:t.imgUrl}}):r("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),r("br"),t._v(" "),r("el-form-item",{attrs:{label:"分类描述："}},[r("el-input",{attrs:{type:"textarea",autosize:!0},model:{value:t.productCate.description,callback:function(e){t.$set(t.productCate,"description",e)},expression:"productCate.description"}})],1),t._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(e){t.onSubmit("productCateFrom")}}},[t._v("提交")]),t._v(" "),t.isEdit?t._e():r("el-button",{on:{click:function(e){t.resetForm("productCateFrom")}}},[t._v("重置")])],1)],1)],1)},staticRenderFns:[]};var u=r("VU/8")(c,n,!1,function(t){r("i+oP")},"data-v-9abdea50",null);e.a=u.exports},Hcfc:function(t,e){},"i+oP":function(t,e){},"tU/9":function(t,e,r){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a={name:"addProductCate",components:{ProductCateDetail:r("Gpb+").a}},s={render:function(){var t=this.$createElement;return(this._self._c||t)("product-cate-detail",{attrs:{"is-edit":!1}})},staticRenderFns:[]};var o=r("VU/8")(a,s,!1,function(t){r("Hcfc")},null,null);e.default=o.exports}});
//# sourceMappingURL=12.3f118dee5ca7be23e926.js.map