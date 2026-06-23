<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="账号" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="账号" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="手机" prop="shouji" >
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="手机" prop="shouji" >
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="身份证" prop="shenfenzheng" >
					<el-input v-model="ruleForm.shenfenzheng" placeholder="身份证" clearable  :readonly="ro.shenfenzheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="身份证" prop="shenfenzheng" >
					<el-input v-model="ruleForm.shenfenzheng" placeholder="身份证" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款名称" prop="daikuanmingcheng" >
					<el-input v-model="ruleForm.daikuanmingcheng" placeholder="贷款名称" clearable  :readonly="ro.daikuanmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款名称" prop="daikuanmingcheng" >
					<el-input v-model="ruleForm.daikuanmingcheng" placeholder="贷款名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款种类" prop="daikuanzhonglei" >
					<el-input v-model="ruleForm.daikuanzhonglei" placeholder="贷款种类" clearable  :readonly="ro.daikuanzhonglei"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款种类" prop="daikuanzhonglei" >
					<el-input v-model="ruleForm.daikuanzhonglei" placeholder="贷款种类" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="金额" prop="jine" >
					<el-input-number v-model="ruleForm.jine" placeholder="金额" :disabled="ro.jine"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="金额" prop="jine" >
					<el-input v-model="ruleForm.jine" placeholder="金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="保证人" prop="baozhengren" >
					<el-input v-model="ruleForm.baozhengren" placeholder="保证人" clearable  :readonly="ro.baozhengren"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="保证人" prop="baozhengren" >
					<el-input v-model="ruleForm.baozhengren" placeholder="保证人" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.touxiang" label="头像" prop="touxiang" >
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="touxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.touxiang" label="头像" prop="touxiang" >
					<img v-if="ruleForm.touxiang.substring(0,4)=='http'&&ruleForm.touxiang.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang" width="100" height="100">
					<img v-else-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="抵押资产" prop="diyazichan" >
					<el-input-number v-model="ruleForm.diyazichan" placeholder="抵押资产" :disabled="ro.diyazichan"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="抵押资产" prop="diyazichan" >
					<el-input v-model="ruleForm.diyazichan" placeholder="抵押资产" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info'&& !ro.zichancailiao" label="资产材料" prop="zichancailiao" >
					<file-upload
						tip="点击上传资产材料"
						action="file/upload"
						:limit="1"
						:type="3"
						:multiple="true"
						:fileUrls="ruleForm.zichancailiao?ruleForm.zichancailiao:''"
						@change="zichancailiaoUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item v-else-if="ruleForm.zichancailiao" label="资产材料" prop="zichancailiao" >
					<el-button class="downBtn" type="text" size="small" @click="download($base.url+ruleForm.zichancailiao)">
						<span class="icon iconfont icon-xiazai6"></span>
						下载
					</el-button>
				</el-form-item>
				<el-form-item v-else-if="!ruleForm.zichancailiao" label="资产材料" prop="zichancailiao" >
					<el-button class="unBtn" type="text" size="small">
						<span class="icon iconfont icon-xihuan"></span>
						暂无
					</el-button>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="申请时间" prop="shenqingshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shenqingshijian" 
						type="datetime"
						:readonly="ro.shenqingshijian"
						placeholder="申请时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shenqingshijian" label="申请时间" prop="shenqingshijian" >
					<el-input v-model="ruleForm.shenqingshijian" placeholder="申请时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					zhanghao : false,
					xingming : false,
					shouji : false,
					shenfenzheng : false,
					daikuanmingcheng : false,
					daikuanzhonglei : false,
					jine : false,
					baozhengren : false,
					touxiang : false,
					diyazichan : false,
					zichancailiao : false,
					shenqingshijian : false,
					crossuserid : false,
					crossrefid : false,
				},
			
				ruleForm: {
					zhanghao: '',
					xingming: '',
					shouji: '',
					shenfenzheng: '',
					daikuanmingcheng: '',
					daikuanzhonglei: '',
					jine: '',
					baozhengren: '',
					touxiang: '',
					diyazichan: '',
					zichancailiao: '',
					shenqingshijian: '',
					crossuserid: '',
					crossrefid: '',
				},

				rules: {
					zhanghao: [
					],
					xingming: [
					],
					shouji: [
					],
					shenfenzheng: [
					],
					daikuanmingcheng: [
					],
					daikuanzhonglei: [
					],
					jine: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					baozhengren: [
					],
					touxiang: [
					],
					diyazichan: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					zichancailiao: [
					],
					shenqingshijian: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.shenqingshijian = this.getCurDateTime()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='zhanghao'){
							this.ruleForm.zhanghao = obj[o];
							this.ro.zhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
						if(o=='shenfenzheng'){
							this.ruleForm.shenfenzheng = obj[o];
							this.ro.shenfenzheng = true;
							continue;
						}
						if(o=='daikuanmingcheng'){
							this.ruleForm.daikuanmingcheng = obj[o];
							this.ro.daikuanmingcheng = true;
							continue;
						}
						if(o=='daikuanzhonglei'){
							this.ruleForm.daikuanzhonglei = obj[o];
							this.ro.daikuanzhonglei = true;
							continue;
						}
						if(o=='jine'){
							this.ruleForm.jine = obj[o];
							this.ro.jine = true;
							continue;
						}
						if(o=='baozhengren'){
							this.ruleForm.baozhengren = obj[o];
							this.ro.baozhengren = true;
							continue;
						}
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o];
							this.ro.touxiang = true;
							continue;
						}
						if(o=='diyazichan'){
							this.ruleForm.diyazichan = obj[o];
							this.ro.diyazichan = true;
							continue;
						}
						if(o=='zichancailiao'){
							this.ruleForm.zichancailiao = obj[o];
							this.ro.zichancailiao = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.zhanghao!=''&&json.zhanghao) || json.zhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.zhanghao = json.zhanghao
							this.ro.zhanghao = true;
						}
						if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.xingming = json.xingming
							this.ro.xingming = true;
						}
						if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shouji = json.shouji
							this.ro.shouji = true;
						}
						if(((json.shenfenzheng!=''&&json.shenfenzheng) || json.shenfenzheng==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shenfenzheng = json.shenfenzheng
							this.ro.shenfenzheng = true;
						}
						if(((json.touxiang!=''&&json.touxiang) || json.touxiang==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.touxiang = json.touxiang
							this.ro.touxiang = true;
						}
						if(this.$storage.get("role")!="管理员") {
							this.ro.shenqingshijian = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `daikuanshenqing/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.touxiang!=null) {
						this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
					}
					if(this.ruleForm.zichancailiao!=null) {
						this.ruleForm.zichancailiao = this.ruleForm.zichancailiao.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					//更新跨表属性
					var crossuserid;
					var crossrefid;
					var crossoptnum;
					var finishNum = 0;
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
									else {
										crossuserid=this.$storage.get('userid');
										crossrefid=obj['id'];
										crossoptnum=this.$storage.get('statusColumnName');
										crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
									}
								}
								if(crossrefid && crossuserid) {
									this.ruleForm.crossuserid = crossuserid;
									this.ruleForm.crossrefid = crossrefid;
									let params = { 
										page: 1, 
										limit: 10, 
										crossuserid:this.ruleForm.crossuserid,
										crossrefid:this.ruleForm.crossrefid,
									} 
									await this.$http({ 
										url: "daikuanshenqing/page", 
										method: "get", 
										params: params 
									}).then(({ 
										data 
									}) => { 
										if (data && data.code === 0) {
											finishNum = data.data.total
										}
									})
								}
								if(finishNum>=crossoptnum) {
									this.$message.error(this.$storage.get('tips'));
									return false;
								}
							}
							
							await this.$http({
								url: `daikuanshenqing/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.daikuanshenqingCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.daikuanshenqingCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			touxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls;
			},
			zichancailiaoUploadChange(fileUrls) {
				this.ruleForm.zichancailiao = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		border-radius: 12px;
		padding: 30px 20% 30px 10%;
		background: rgba(255,255,255,0);
		border-color: #ddd;
		border-width: 1px;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 2px 20px;
		margin: 0 0 20px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 500;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		color: #666;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: auto;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: auto;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(238,238,238,1) 100%);
		width: auto;
		font-size: 16px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(238,238,238,1) 100%);
		width: auto;
		font-size: 16px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		object-fit: cover;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		object-fit: cover;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		object-fit: cover;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #838fa1;
		font-size: 16px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 0px solid #ccc;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 16px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 16px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #00ad45;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #00ad45;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #00ad45;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #00ad45;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #00ad45;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
