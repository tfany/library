webpackJsonp([2],{CmKi:function(e,t,a){"use strict";var r=a("woOf"),i=a.n(r),s=a("mRsl"),o=a("s/Rn"),l=a("UgCr"),n={name:"ProductInfoDetail",props:{value:Object,isEdit:{type:Boolean,default:!1}},data:function(){return{hasEditCreated:!1,selectProductCateValue:[],productCateOptions:[],brandOptions:[],rules:{bookName:[{required:!0,message:"请输入书籍名称",trigger:"blur"},{min:1,max:140,message:"长度在 1 到 140 个字符",trigger:"blur"}],categoryId:[{required:!0,message:"请选择书籍分类",trigger:"blur"}],supplierName:[{required:!0,message:"请选择书籍出版社",trigger:"blur"}],bookId:[{required:!0,message:"请输入ISBN",trigger:"blur"}],author:[{required:!0,message:"请输入作者",trigger:"blur"}],price:[{required:!0,message:"请输入价格",trigger:"blur"}],stock:[{required:!0,message:"请输入库存",trigger:"blur"}]}}},created:function(){this.getProductCateList(),this.getBrandList()},computed:{bookId:function(){return this.value.id}},watch:{productId:function(e){this.isEdit&&(this.hasEditCreated||void 0!==e&&null!=e&&0!==e&&this.handleEditCreated())}},methods:{handleEditCreated:function(){""!==this.value.bookId&&(this.selectProductCateValue.push(this.value.parentId),this.selectProductCateValue.push(this.value.categoryId)),this.hasEditCreated=!0},getProductCateList:function(){var e=this;Object(s.d)().then(function(t){var a=t.data;e.productCateOptions=[];for(var r=0;r<a.length;r++){var i=[];if(null!=a[r].children&&a[r].children.length>0)for(var s=0;s<a[r].children.length;s++)i.push({label:a[r].children[s].categoryName,value:a[r].children[s].categoryId}),e.value.categoryId===a[r].children[s].categoryId&&(e.value.parentId=a[s].categoryId);e.productCateOptions.push({label:a[r].categoryName,value:a[r].categoryId,children:i})}e.isEdit&&e.handleEditCreated()})},getBrandList:function(){var e=this;Object(o.c)({pageNum:1,pageSize:100}).then(function(t){e.brandOptions=[];for(var a=t.data.list,r=0;r<a.length;r++)e.brandOptions.push({label:a[r].supplierName,value:a[r].supplierId})})},handleNext:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return t.$message({message:"验证失败",type:"error",duration:1e3}),!1;t.$emit("nextStep")})},handleBrandChange:function(e){for(var t="",a="",r=0;r<this.brandOptions.length;r++)if(this.brandOptions[r].value===e){t=this.brandOptions[r].label,a=this.brandOptions[r].value;break}this.value.supplierId=a,this.value.supplierName=t},handleCategory:function(e){this.value.categoryId=e[1]}}},u={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"margin-top":"50px"}},[a("el-form",{ref:"productInfoForm",staticStyle:{width:"600px"},attrs:{model:e.value,rules:e.rules,"label-width":"120px",size:"small"}},[a("el-form-item",{attrs:{label:"书籍分类：",prop:"categoryId"}},[a("el-cascader",{attrs:{options:e.productCateOptions},on:{change:e.handleCategory},model:{value:e.selectProductCateValue,callback:function(t){e.selectProductCateValue=t},expression:"selectProductCateValue"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"书籍名称：",prop:"bookName"}},[a("el-input",{model:{value:e.value.bookName,callback:function(t){e.$set(e.value,"bookName",t)},expression:"value.bookName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"作者：",prop:"author"}},[a("el-input",{model:{value:e.value.author,callback:function(t){e.$set(e.value,"author",t)},expression:"value.author"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"出版社：",prop:"supplierName"}},[a("el-select",{attrs:{placeholder:"请选择出版社"},on:{change:e.handleBrandChange},model:{value:e.value.supplierName,callback:function(t){e.$set(e.value,"supplierName",t)},expression:"value.supplierName"}},e._l(e.brandOptions,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"ISBN：",prop:"bookId"}},[a("el-input",{model:{value:e.value.bookId,callback:function(t){e.$set(e.value,"bookId",t)},expression:"value.bookId"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"书籍售价：",prop:"price"}},[a("el-input",{model:{value:e.value.price,callback:function(t){e.$set(e.value,"price",t)},expression:"value.price"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"书籍库存：",prop:"stock"}},[a("el-input",{model:{value:e.value.stock,callback:function(t){e.$set(e.value,"stock",t)},expression:"value.stock"}})],1),e._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){e.handleNext("productInfoForm")}}},[e._v("下一步，填写图书封面")])],1)],1)],1)},staticRenderFns:[]};var c=a("VU/8")(n,u,!1,function(e){a("FKcN")},"data-v-53fe231a",null).exports,d={name:"ProductRelationDetail",props:{value:Object,isEdit:{type:Boolean,default:!1}},data:function(){return{ImageUrl:""}},computed:{url:{get:function(){return"http://localhost:8080/book/upload/"+this.value.bookId},set:function(){}}},methods:{imgPreview:function(e){var t=e.name;/(.jpg|.jpeg|.gif|.png|.bmp)$/.test(t.toLowerCase())?this.ImageUrl=e.url:this.$message.error("请选择图片文件")},success:function(e){200===e.code?(this.$message({message:"封面上传成功",type:"success"}),null!=e.data&&(this.value.img=e.data)):this.$message({message:"网络不太好，请重新上传",type:"error"})},handlePrev:function(){this.$emit("prevStep")},handleFinishCommit:function(){this.$emit("finishCommit",this.isEdit)}}},p={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"margin-top":"50px"}},[a("el-form",{ref:"productRelationForm",staticStyle:{width:"680px"},attrs:{model:e.value,"label-width":"120px",size:"small"}},[e.isEdit?a("p",[e._v("  旧封面： "),a("img",{staticClass:"avatar",attrs:{src:e.value.img}})]):e._e(),e._v(" "),a("br"),e._v(" "),a("br"),e._v(" "),e.isEdit?a("p",[e._v("新封面：")]):a("p",[e._v(" 请选择封面")]),e._v(" "),a("el-upload",{staticClass:"upload-poster",attrs:{"list-type":"picture-card",action:e.url,"show-file-list":!1,"on-change":e.imgPreview,"auto-upload":!0,"on-success":e.success}},[e.ImageUrl?a("img",{staticClass:"avatar",attrs:{src:e.ImageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),e._v(" "),a("el-form-item",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{size:"medium"},on:{click:e.handlePrev}},[e._v("上一步，填写图书属性")]),e._v(" "),a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:e.handleFinishCommit}},[e._v("完成，提交图书")])],1)],1)],1)},staticRenderFns:[]};var h={author:"",bookId:"",bookName:"",img:"",price:"",public_time:"",rent:"",stock:"",categoryId:"",parentId:"",categoryName:"",supplierId:"",supplierName:""},m={name:"ProductDetail",components:{ProductInfoDetail:c,ProductRelationDetail:a("VU/8")(d,p,!1,function(e){a("um3J")},"data-v-2e6e1a01",null).exports},props:{isEdit:{type:Boolean,default:!1}},data:function(){return{active:0,productParam:i()({},h),showStatus:[!0,!1]}},created:function(){var e=this;this.isEdit&&Object(l.f)(this.$route.query.id).then(function(t){e.productParam=t.data})},methods:{hideAll:function(){for(var e=0;e<this.showStatus.length;e++)this.showStatus[e]=!1},prevStep:function(){this.active>0&&this.active<this.showStatus.length&&(this.active--,this.hideAll(),this.showStatus[this.active]=!0)},nextStep:function(){this.active<this.showStatus.length-1&&(this.active++,this.hideAll(),this.showStatus[this.active]=!0)},finishCommit:function(e){var t=this;this.$confirm("是否要提交该产品","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e?Object(l.h)(t.$route.query.id,t.productParam).then(function(e){t.$alert("编辑成功",{type:"success"}),t.$router.push("/pms/product")}):Object(l.a)(t.productParam).then(function(e){t.$alert("提交成功",{type:"success"}),t.$router.push("/pms/product")})})}}},v={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",{staticClass:"form-container",attrs:{shadow:"never"}},[a("el-steps",{attrs:{active:e.active,"finish-status":"success","align-center":""}},[a("el-step",{attrs:{title:"填写图书信息"}}),e._v(" "),a("el-step",{attrs:{title:"选择图书封面"}})],1),e._v(" "),a("product-info-detail",{directives:[{name:"show",rawName:"v-show",value:e.showStatus[0],expression:"showStatus[0]"}],attrs:{"is-edit":e.isEdit},on:{nextStep:e.nextStep},model:{value:e.productParam,callback:function(t){e.productParam=t},expression:"productParam"}}),e._v(" "),a("product-relation-detail",{directives:[{name:"show",rawName:"v-show",value:e.showStatus[1],expression:"showStatus[1]"}],attrs:{"is-edit":e.isEdit},on:{prevStep:e.prevStep,finishCommit:e.finishCommit},model:{value:e.productParam,callback:function(t){e.productParam=t},expression:"productParam"}})],1)},staticRenderFns:[]};var f=a("VU/8")(m,v,!1,function(e){a("clIM")},null,null);t.a=f.exports},FKcN:function(e,t){},N3DD:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={name:"addProduct",components:{ProductDetail:a("CmKi").a}},i={render:function(){var e=this.$createElement;return(this._self._c||e)("product-detail",{attrs:{"is-edit":!1}})},staticRenderFns:[]};var s=a("VU/8")(r,i,!1,function(e){a("UnvB")},null,null);t.default=s.exports},UnvB:function(e,t){},clIM:function(e,t){},um3J:function(e,t){}});
//# sourceMappingURL=2.435247de55724f31533b.js.map