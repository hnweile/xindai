<template>
	<div class="main-content" :style='{"color":"#666","padding":"30px","fontSize":"16px"}'>
		<!-- number -->
		<!-- age -->
		<!-- annualincome -->
		<!-- totalassets -->
		<!-- creditscore -->
		<!-- totalliabilities -->
		<!-- creditlimit -->
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px","flexWrap":"wrap","justifyContent":"space-between","display":"flex"}' :inline="true" :model="searchForm">
				<el-row :style='{"margin":"10px 0","display":"block"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">编号</label>
						<el-input v-model="searchForm.number" placeholder="编号" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-fangdajing02" :style='{"margin":"0 2px","fontSize":"inherit","color":"#fff","height":"40px"}'></span>
						查询
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"margin":"10px 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}'>
					<el-button class="add" v-if="isAuth('creditdataforecast','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia14" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						添加
					</el-button>
					<el-button class="del" v-if="isAuth('creditdataforecast','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu15" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						删除
					</el-button>

					<el-button class="btn18" v-if="isAuth('creditdataforecast','导入')" type="success" @click="importHandler()">
						<span class="icon iconfont icon-daoru11" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						导入
					</el-button>
					<el-button class="btn18" v-if="isAuth('creditdataforecast','上传模板')" type="success" @click="importClcik">
						<span class="icon iconfont icon-shangchuan8" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						上传模板
					</el-button>
					<el-button class="btn18" v-if="isAuth('creditdataforecast','下载模板')" type="success" @click="download('upload/creditdataforecast_template.xlsx')">
						<span class="icon iconfont icon-xiazai7" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						下载模板
					</el-button>

					<download-excel v-if="isAuth('creditdataforecast','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "信贷数据.xls">
						<!-- 导出excel -->
						<el-button class="btn18" type="success">
							<span class="icon iconfont icon-daochu4" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
							导出
						</el-button>
					</download-excel>
					<el-button class="btn18" type="success" @click="cleanClick()">
						<span class="icon iconfont icon-shuju10" :style='{"margin":"0 0px","fontSize":"inherit","color":"inherit","height":"34px"}'></span>
						数据清洗
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"width":"100%","padding":"0px"}'>
				<el-table class="tables"
					:stripe='true'
					:style='{"width":"100%","padding":"0","borderColor":"#eee","borderStyle":"solid","borderWidth":"1px 0 0 1px","background":"none"}' 
					:border='true'
					v-if="isAuth('creditdataforecast','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="number"
						label="编号">
						<template slot-scope="scope">
							{{scope.row.number}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="age"
						label="年龄">
						<template slot-scope="scope">
							{{scope.row.age}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="annualincome"
						label="年收入">
						<template slot-scope="scope">
							{{scope.row.annualincome}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="totalassets"
						label="资产总额">
						<template slot-scope="scope">
							{{scope.row.totalassets}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="creditscore"
						label="信用评分">
						<template slot-scope="scope">
							{{scope.row.creditscore}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="totalliabilities"
						label="负债总额">
						<template slot-scope="scope">
							{{scope.row.totalliabilities}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="creditlimit"
						label="信用卡额度">
						<template slot-scope="scope">
							{{scope.row.creditlimit}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="loanamount"
						label="贷款金额">
						<template slot-scope="scope">
							{{scope.row.loanamount}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('creditdataforecast','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-tianjia14" :style='{"margin":"0 0px","fontSize":"14px","color":"inherit","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="edit" v-if=" isAuth('creditdataforecast','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai11" :style='{"margin":"0 0px","fontSize":"14px","color":"inherit","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('creditdataforecast','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-shanchu6" :style='{"margin":"0 0px","fontSize":"14px","color":"inherit","height":"40px"}'></span>
								删除
							</el-button>
							<el-button class="btn8" type="success" @click="forecastClick(scope.row)">
								<span class="icon iconfont icon-huifu18" :style='{"margin":"0 0px","fontSize":"14px","color":"inherit","height":"40px"}'></span>
								 预测 							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="< "
				next-text="> "
				:hide-on-single-page="false"
				:style='{"padding":"10px","boxShadow":"1px 2px 6px #ddd","margin":"20px auto 0","whiteSpace":"nowrap","color":"#333","borderRadius":"4px","textAlign":"center","background":"#fff","width":"60%","minWidth":"60%","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



		<el-dialog title="导入" :visible.sync="importVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item class="upload" label="文件" prop="excelFile">
				  <excel-file-upload
				  tip="点击上传直接导入excel文件"
				  action="creditdataforecast/importExcel"
				  :limit="1"
				  :fileUrls="importUrl"
				  @change="importChange"
				  ></excel-file-upload>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="importHandler()">关 闭</el-button>
			</span>
		</el-dialog>
		<el-dialog title="上传模板" :visible.sync="importVis" width="50%">
			<el-form ref="form" :model="importForm" label-width="80px">
				<el-form-item class="upload" label="文件" prop="excelFile">
					<el-upload class="upload-demo" drag :action="$base.url + 'file/upload?type=creditdataforecast_template'"
						:show-file-list="false" :on-success="importSuccess">
						<i class="el-icon-upload"></i>
						<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
					</el-upload>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="importVis=false">关 闭</el-button>
			</span>
		</el-dialog>


		<el-dialog title="可视化图表" :visible.sync="forecastVisible" width="50%">
			<div style="display: flex;flex-wrap:wrap">
				<img v-for="item in forecastImgList" :src="$base.url + item" alt="" style="width: 100%;">
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import axios from 'axios';
	import AddOrUpdate from "./add-or-update";
	import {
		Loading
	} from 'element-ui';
	export default {
		data() {
			return {
				indexQueryCondition: '',
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				importVisiable: false,
				importVis: false,
				importForm: {},
				importUrl: '',
				addOrUpdateFlag:false,
				layouts: ["total","prev","pager","next","sizes"],
//导出excel
				json_fields: {
					"编号": "number",    //常规字段
					"年龄": "age",    //常规字段
					"年收入": "annualincome",    //常规字段
					"资产总额": "totalassets",    //常规字段
					"信用评分": "creditscore",    //常规字段
					"负债总额": "totalliabilities",    //常规字段
					"信用卡额度": "creditlimit",    //常规字段
					"贷款金额": "loanamount",    //常规字段
				},
				json_meta: [
					[
						{
							" key ": " charset ",
							" value ": " utf- 8 "
						}
					]
				],
				forecastVisible: false,
				forecastImgList: [],
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange();
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
		},
		methods: {
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},





			init () {
			},
			search() {
				this.pageIndex = 1;
				this.getDataList();
			},

			// 获取数据列表
			getDataList() {
				this.dataListLoading = true;
				let params = {
					page: this.pageIndex,
					limit: this.pageSize,
					sort: 'id',
					order: 'desc',
				}
 				if(this.searchForm.number!='' && this.searchForm.number!=undefined){
					params['number'] = '%' + this.searchForm.number + '%'
				}
				let user = JSON.parse(this.$storage.getObj('userForm'))
				this.$http({
					url: "creditdataforecast/page",
					method: "get",
					params: params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.dataList = data.data.list;
						this.totalPage = data.data.total;
					} else {
						this.dataList = [];
						this.totalPage = 0;
					}
					this.dataListLoading = false;
				});
			},
			// 每页数
			sizeChangeHandle(val) {
				this.pageSize = val;
				this.pageIndex = 1;
				this.getDataList();
			},
			// 当前页
			currentChangeHandle(val) {
				this.pageIndex = val;
				this.getDataList();
			},
			// 多选
			selectionChangeHandler(val) {
				this.dataListSelections = val;
			},
			// 添加/修改
			addOrUpdateHandler(id,type) {
				this.showFlag = false;
				this.addOrUpdateFlag = true;
				this.crossAddOrUpdateFlag = false;
				if(type!='info'&&type!='msg'){
					type = 'else';
				}
				this.$nextTick(() => {
					this.$refs.addOrUpdate.init(id,type);
				});
			},
			importChange(){
				this.importHandler()
				this.getDataList()
			},
			importClcik() {
				this.importVis = true
			},
			importSuccess(e) {
				if(e.code==0){
					this.$message.success('上传成功');
					this.importVis = false
					
				}
			},
			importHandler() {
				this.importUrl = ''
				this.importVisiable = !this.importVisiable;
			},
			// 下载
			download(file){
				let arr = file.replace(new RegExp('upload/', "g"), "")
				axios.get(this.$base.url + 'file/download?fileName=' + arr, {
					headers: {
						token: this.$storage.get('Token')
					},
					responseType: "blob"
				}).then(({
					data
				}) => {
					const binaryData = [];
					binaryData.push(data);
					const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
						type: 'application/pdf;chartset=UTF-8'
					}))
					const a = document.createElement('a')
					a.href = objectUrl
					a.download = arr
					// a.click()
					// 下面这个写法兼容火狐
					a.dispatchEvent(new MouseEvent('click', {
						bubbles: true,
						cancelable: true,
						view: window
					}))
					window.URL.revokeObjectURL(data)
				},err=>{
					axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
						headers: {
							token: this.$storage.get('Token')
						},
						responseType: "blob"
					}).then(({
						data
					}) => {
						const binaryData = [];
						binaryData.push(data);
						const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
							type: 'application/pdf;chartset=UTF-8'
						}))
						const a = document.createElement('a')
						a.href = objectUrl
						a.download = arr
						// a.click()
						// 下面这个写法兼容火狐
						a.dispatchEvent(new MouseEvent('click', {
							bubbles: true,
							cancelable: true,
							view: window
						}))
						window.URL.revokeObjectURL(data)
					})
				})
			},
			// 删除
			async deleteHandler(id ) {
				var ids = id? [Number(id)]: this.dataListSelections.map(item => {
					return Number(item.id);
				});
				await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(async () => {
					await this.$http({
						url: "creditdataforecast/delete",
						method: "post",
						data: ids
					}).then(async ({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "操作成功",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.search();
								}
							});
			
						} else {
							this.$message.error(data.msg);
						}
					});
				});
			},


			forecastClick(row) {
				this.$confirm(`是否进行数据预测?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(()=>{
					let loading = null
					loading = Loading.service({
						target: this.$refs['roleMenuBox'],
						fullscreen: false,
						text: '数据预测中...'
					})
					let arr = 'number,age,annualincome,totalassets,creditscore,totalliabilities,creditlimit'.split(',')
					let brr = {
						id: row.id
					}
					for(let x in arr){
						brr[arr[x]] = row[arr[x]]
					}
					this.$http({
						url: 'creditdataforecast/forecast',
						method: 'post',
						data: brr
					}).then(res=>{
						if(res.data&&res.data.code==0){
							if (loading) loading.close()
							this.$message({
								message: "数据预测完成！",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList()
								}
							});
						}
					})
				})
			},
			forecastImgClick(){
				let loading = null
				loading = Loading.service({
					target: this.$refs['roleMenuBox'],
					fullscreen: false,
					text: '图表生成中...'
				})
				this.$http({
					url: 'creditdataforecast/forecastimgs',
					method: 'get',
				}).then(res=>{
					if (loading) loading.close()
					if(res.data&&res.data.code==0){
						if(res.data.data) {
							this.$message({
								message: "操作成功！",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.forecastImgList = res.data.data
									this.forecastVisible = true
								}
							});
						}else {
							this.$message({
								message: "请先完成预测！",
								type: "error",
								duration: 1500
							});
						}
					}
				},err=>{
					this.$message({
						message: "请先完成预测！",
						type: "error",
						duration: 1500
					});
				})
			},
			cleanClick() {
				this.$confirm(`是否进行数据清洗?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(()=>{
					let loading = null
					loading = Loading.service({
						target: this.$refs['roleMenuBox'],
						fullscreen: false,
						text: '数据清洗中...'
					})
					this.$http({
						url: 'creditdataforecast/cleanse',
						method: 'get'
					}).then(res=>{
						if(res.data&&res.data.code==0){
							if (loading) loading.close()
							this.$message({
								message: "数据清洗完成！",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList()
								}
							});
						}
					})
				})
			},
		}

	};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}
	
	.center-form-pv {
		.el-date-editor.el-input {
			width: auto;
		}
	}
	
	.el-input {
		width: auto;
	}
	
	// form
	.center-form-pv .el-input {
		width: 100%;
	}
	.center-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #ddd;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 170px;
		font-size: 16px;
		height: 34px;
	}
	.center-form-pv .el-select {
		width: 100%;
	}
	.center-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #ddd;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 170px;
		font-size: 16px;
		height: 34px;
	}
	.center-form-pv .el-date-editor {
		width: 100%;
	}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #ddd;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		width: 170px;
		font-size: 16px;
		height: 34px;
	}
	
	.center-form-pv .search {
		border: 0;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 10px;
		color: #fff;
		background: #00ad45;
		width: auto;
		font-size: inherit;
		height: 34px;
	}
	
	.center-form-pv .search:hover {
		opacity: 0.8;
	}
	
	.center-form-pv .actions .add {
		border: 1px solid #00ad45;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 8px 0 5px;
		margin: 4px;
		color: #00ad45;
		background: #fff;
		width: auto;
		font-size: inherit;
		height: 34px;
	}
	
	.center-form-pv .actions .add:hover {
		color: #fff;
		background: #00ad45;
	}
	
	.center-form-pv .actions .del {
		border: 1px solid #e16b76;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 4px;
		color: #e16b76;
		background: #fff;
		width: auto;
		font-size: inherit;
		height: 34px;
	}
	
	.center-form-pv .actions .del:hover {
		color: #fff;
		background: #e16b76;
	}
	
	.center-form-pv .actions .statis {
		border: 1px solid #e1976b;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 4px;
		color: #e1976b;
		background: #fff;
		width: auto;
		font-size: inherit;
		height: 34px;
	}
	
	.center-form-pv .actions .statis:hover {
		color: #fff;
		background: #e1976b;
	}
	
	.center-form-pv .actions .btn18 {
		border: 1px solid #666;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 4px;
		color: inherit;
		background: #fff;
		width: auto;
		font-size: inherit;
		height: 34px;
	}
	
	.center-form-pv .actions .btn18:hover {
		color: #fff;
		background: #666;
	}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
		color: #999;
		font-weight: 500;
		width: 100%;
	}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
		background: #333;
	}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
		padding: 10px 0;
		background: none;
		border-color: #c2c2c2;
		border-width: 0 1px 1px 0;
		border-style: solid;
		text-align: center;
	}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
		padding: 0 0 0 5px;
		word-wrap: normal;
		color: #fff;
		white-space: normal;
		font-weight: bold;
		display: flex;
		vertical-align: middle;
		font-size: 14px;
		line-height: 24px;
		text-overflow: ellipsis;
		word-break: break-all;
		width: 100%;
		justify-content: center;
		align-items: center;
		position: relative;
	}

	.el-table /deep/ .el-table__body-wrapper {
	}
	.el-table /deep/ .el-table__body-wrapper tbody {
		width: 100%;
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
		background: #fff;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
		padding: 4px 0;
		color: #333;
		background: #fff;
		border-color: #c2c2c2;
		border-width: 0 1px 1px 0;
		border-style: solid;
		text-align: center;
	}
	
		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: #edf1ef50;
	}
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
		padding: 4px 0;
		color: #333;
		background: #edf1ef;
		border-color: #c2c2c2;
		border-width: 0 1px 1px 0;
		border-style: solid;
		text-align: center;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
		padding: 4px 0;
		color: #333;
		background: #fff;
		border-color: #c2c2c2;
		border-width: 0 1px 1px 0;
		border-style: solid;
		text-align: center;
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
		padding: 0 0 0 5px;
		overflow: hidden;
		word-break: break-all;
		white-space: normal;
		font-size: 14px;
		line-height: 24px;
		text-overflow: ellipsis;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
		border: 1px solid #00ad45;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 0 5px 5px 0;
		color: #00ad45;
		background: #fff;
		width: auto;
		font-size: 14px;
		height: 32px;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
		color: #fff;
		background: #00ad45;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
		border: 1px solid #2990ff;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 0 5px 5px 0;
		color: #2990ff;
		background: #fff;
		width: auto;
		font-size: 14px;
		height: 32px;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
		color: #fff;
		background: #2990ff;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
		border: 1px solid #e16b76;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 0 5px 5px 0;
		color: #e16b76;
		background: #fff;
		width: auto;
		font-size: 14px;
		height: 32px;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
		color: #fff;
		background: #e16b76;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
		border: 1px solid #666;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 5px;
		margin: 0 5px 5px 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 14px;
		height: 32px;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
		color: #fff;
		background: #666;
	}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}

	.main-content .el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}

	.main-content .el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #00ad45;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #00ad45;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	// list one
	.one .list1-view {
		border: 0;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 15px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #00ad45;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	
	.one .list1-view:hover {
		opacity: 0.8;
	}
	
	.one .list1-edit {
		border: 0;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 15px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #00ad45;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	
	.one .list1-edit:hover {
		opacity: 0.8;
	}
	
	.one .list1-del {
		border: 0;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 15px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #00ad45;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	
	.one .list1-del:hover {
		opacity: 0.8;
	}
	
	.one .list1-btn8 {
		border: 0;
		cursor: pointer;
		border-radius: 4px;
		padding: 0 24px;
		margin: 0 5px 5px 0;
		color: #fff;
		background: #00ad45;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	
	.one .list1-btn8:hover {
		opacity: 0.8;
	}
	
	.main-content .el-table .el-switch {
		display: inline-flex;
		vertical-align: middle;
		line-height: 30px;
		position: relative;
		align-items: center;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
		cursor: pointer;
		margin: 0 10px 0 0;
		color: #333;
		font-weight: 500;
		display: inline-block;
		vertical-align: middle;
		font-size: 16px;
		transition: .2s;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
		cursor: pointer;
		margin: 0 0 0 10px;
		color: #333;
		font-weight: 500;
		display: inline-block;
		vertical-align: middle;
		font-size: 16px;
		transition: .2s;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
		border: 1px solid #75c0d6;
		cursor: pointer;
		border-radius: 15px;
		margin: 0;
		background: #75c0d6;
		display: inline-block;
		width: 40px;
		box-sizing: border-box;
		transition: border-color .3s,background-color .3s;
		height: 20px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
		border-radius: 100%;
		top: 1px;
		left: 1px;
		background: #FFF;
		width: 16px;
		position: absolute;
		transition: all .3s;
		height: 16px;
	}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
		margin: 0 0 0 -17px;
		left: 100%;
	}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
		cursor: pointer;
		display: inline-block;
		vertical-align: middle;
		font-size: 0;
		position: relative;
	}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
		margin: 0 3px;
		display: inline-block;
		font-size: 18px;
		position: relative;
		transition: .3s;
	}

</style>
