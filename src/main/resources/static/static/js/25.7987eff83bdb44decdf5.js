webpackJsonp([25],{IxCn:function(e,t){},"w/LV":function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n("woOf"),l=n.n(a),i=n("vMJZ"),s=n("BRgg"),r=n("xT6B"),u={keyword:null,pageNum:1,pageSize:5,publishStatus:null,verifyStatus:null,productSn:null,productCategoryId:null,brandId:null},o={name:"productList",data:function(){return{operates:[{label:"批量删除",value:"delete"}],operateType:null,listQuery:l()({},u),list:null,total:null,listLoading:!0,multipleSelection:[],rankOptions:[]}},created:function(){this.getList(),this.getRankList()},filters:{formatCreateTime:function(e){var t=new Date(e);return Object(r.a)(t,"yyyy-MM-dd hh:mm:ss")}},methods:{getList:function(){var e=this;this.listLoading=!0,Object(i.a)(this.listQuery).then(function(t){e.listLoading=!1,e.list=t.data.list,e.total=t.data.total})},getRankList:function(){var e=this;Object(s.c)({pageNum:1,pageSize:100}).then(function(t){e.rankOptions=[];for(var n=t.data.list,a=0;a<n.length;a++)e.rankOptions.push({label:n[a].name,value:n[a].level})})},handleSearchList:function(){this.listQuery.pageNum=1,this.getList()},handleAddProduct:function(){this.$router.push({path:"/pms/addProduct"})},handleBatchOperate:function(){var e=this;null!=this.operateType?null==this.multipleSelection||this.multipleSelection.length<1?this.$message({message:"请选择要操作的会员",type:"warning",duration:1e3}):this.$confirm("是否要进行该批量操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t=multipleSelection[0].id;e.updateDeleteStatus(1,t),e.getList()}):this.$message({message:"请选择操作类型",type:"warning",duration:1e3})},handleSizeChange:function(e){this.listQuery.pageNum=1,this.listQuery.pageSize=e,this.getList()},handleCurrentChange:function(e){this.listQuery.pageNum=e,this.getList()},handleSelectionChange:function(e){this.multipleSelection=e},handleResetSearch:function(){this.listQuery=l()({},u)},handleDelete:function(e,t){var n=this;this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e=t.userId;n.updateDeleteStatus(e)})},handleUpdateProduct:function(e,t){this.$router.push({path:"/ums/updateUser",query:{id:t.userId}})},updateDeleteStatus:function(e){var t=this,n=new URLSearchParams;n.append("id",e),Object(i.g)(n).then(function(e){t.$message({message:"删除成功",type:"success",duration:1e3})}),this.getList()}}},c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container"},[n("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[n("i",{staticClass:"el-icon-tickets"}),e._v(" "),n("span",[e._v("会员列表")])]),e._v(" "),n("div",{staticClass:"table-container"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],ref:"productTable",staticStyle:{width:"100%"},attrs:{data:e.list,border:""},on:{"selection-change":e.handleSelectionChange}},[n("el-table-column",{attrs:{label:"用户ID",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.userId))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"头像",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[n("img",{staticStyle:{height:"80px"},attrs:{src:e.row.headImg}})]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"姓名",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("p",[e._v(e._s(t.row.name))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"性别",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("p",[e._v(e._s(t.row.gender))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"等级",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("p",[e._v(e._s(t.row.rank.name))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"手机号码",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("p",[e._v(e._s(t.row.phoneNum))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"注册时间",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatCreateTime")(t.row.createTime)))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"上次登录时间",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatCreateTime")(t.row.updateTime)))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"状态",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.status))]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"操作",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("p",[n("el-button",{attrs:{size:"mini"},on:{click:function(n){e.handleUpdateProduct(t.$index,t.row)}}},[e._v("编辑\n            ")]),e._v(" "),n("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(n){e.handleDelete(t.$index,t.row)}}},[e._v("删除\n            ")])],1)]}}])})],1)],1),e._v(" "),n("div",{staticClass:"pagination-container"},[n("el-pagination",{attrs:{background:"",layout:"total, sizes,prev, pager, next,jumper","page-size":e.listQuery.pageSize,"page-sizes":[5,10,15],"current-page":e.listQuery.pageNum,total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.listQuery,"pageNum",t)}}})],1),e._v(" "),e._m(0)],1)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("p",[t("br"),this._v(" "),t("br"),this._v(" "),t("br"),this._v(" "),t("br")])}]};var d=n("VU/8")(o,c,!1,function(e){n("IxCn")},null,null);t.default=d.exports}});
//# sourceMappingURL=25.7987eff83bdb44decdf5.js.map