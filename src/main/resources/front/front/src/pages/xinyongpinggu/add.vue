<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="账号" prop="zhanghao">
				<el-input v-model="ruleForm.zhanghao" 
					placeholder="账号" clearable :disabled=" false  ||ro.zhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="姓名" prop="xingming">
				<el-input v-model="ruleForm.xingming" 
					placeholder="姓名" clearable :disabled=" false  ||ro.xingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
				<file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
					@change="touxiangUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="头像" prop="touxiang">
				<img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item"  label="评估等级" prop="pinggudengji">
				<el-select v-model="ruleForm.pinggudengji" placeholder="请选择评估等级" :disabled=" false  ||ro.pinggudengji" >
					<el-option
						v-for="(item,index) in pinggudengjiOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="评估结果" prop="pinggujieguo">
				<el-select v-model="ruleForm.pinggujieguo" placeholder="请选择评估结果" :disabled=" false  ||ro.pinggujieguo" >
					<el-option
						v-for="(item,index) in pinggujieguoOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="评估时间" prop="pinggushijian">
				<el-date-picker
					:disabled=" false  ||ro.pinggushijian"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.pinggushijian" 
					type="date"
					placeholder="评估时间">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="专员账号" prop="zhuanyuanzhanghao">
				<el-input v-model="ruleForm.zhuanyuanzhanghao" 
					placeholder="专员账号" clearable :disabled=" false  ||ro.zhuanyuanzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="专员姓名" prop="zhuanyuanxingming">
				<el-input v-model="ruleForm.zhuanyuanxingming" 
					placeholder="专员姓名" clearable :disabled=" false  ||ro.zhuanyuanxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="评估依据" prop="pingguyiju">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="评估依据"
					v-model="ruleForm.pingguyiju">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交信息</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					zhanghao : false,
					xingming : false,
					touxiang : false,
					pinggudengji : false,
					pingguyiju : false,
					pinggujieguo : false,
					pinggushijian : false,
					zhuanyuanzhanghao : false,
					zhuanyuanxingming : false,
					crossuserid : false,
					crossrefid : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					zhanghao: '',
					xingming: '',
					touxiang: '',
					pinggudengji: '',
					pingguyiju: '',
					pinggujieguo: '',
					pinggushijian: '',
					zhuanyuanzhanghao: '',
					zhuanyuanxingming: '',
					crossuserid: '',
					crossrefid: '',
				},
				pinggudengjiOptions: [],
				pinggujieguoOptions: [],


				rules: {
					zhanghao: [
						{ required: true, message: '账号不能为空', trigger: 'blur' },
					],
					xingming: [
					],
					touxiang: [
					],
					pinggudengji: [
					],
					pingguyiju: [
					],
					pinggujieguo: [
					],
					pinggushijian: [
					],
					zhuanyuanzhanghao: [
						{ required: true, message: '专员账号不能为空', trigger: 'blur' },
					],
					zhuanyuanxingming: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.pinggushijian = this.getCurDate()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
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
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o].split(",")[0];
							this.ro.touxiang = true;
							continue;
						}
						if(o=='pinggudengji'){
							this.ruleForm.pinggudengji = obj[o];
							this.ro.pinggudengji = true;
							continue;
						}
						if(o=='pingguyiju'){
							this.ruleForm.pingguyiju = obj[o];
							this.ro.pingguyiju = true;
							continue;
						}
						if(o=='pinggujieguo'){
							this.ruleForm.pinggujieguo = obj[o];
							this.ro.pinggujieguo = true;
							continue;
						}
						if(o=='pinggushijian'){
							this.ruleForm.pinggushijian = obj[o];
							this.ro.pinggushijian = true;
							continue;
						}
						if(o=='zhuanyuanzhanghao'){
							this.ruleForm.zhuanyuanzhanghao = obj[o];
							this.ro.zhuanyuanzhanghao = true;
							continue;
						}
						if(o=='zhuanyuanxingming'){
							this.ruleForm.zhuanyuanxingming = obj[o];
							this.ro.zhuanyuanxingming = true;
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
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.zhuanyuanzhanghao!=''&&json.zhuanyuanzhanghao) || json.zhuanyuanzhanghao==0){
							this.ruleForm.zhuanyuanzhanghao = json.zhuanyuanzhanghao;
							this.ro.zhuanyuanzhanghao = true;
						}
						if((json.zhuanyuanxingming!=''&&json.zhuanyuanxingming) || json.zhuanyuanxingming==0){
							this.ruleForm.zhuanyuanxingming = json.zhuanyuanxingming;
							this.ro.zhuanyuanxingming = true;
						}
					}
				});
				this.pinggudengjiOptions = "★,★★,★★★,★★★★,★★★★★".split(',')
				this.pinggujieguoOptions = "通过,不通过".split(',')

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`xinyongpinggu/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				var finishNum = 0;
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
								else {
									crossuserid=Number(localStorage.getItem('frontUserid'));
									crossrefid=obj['id'];
									crossoptnum=localStorage.getItem('statusColumnName');
									crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
								}
							}
							if(crossrefid && crossuserid) {
								this.ruleForm.crossuserid=crossuserid;
								this.ruleForm.crossrefid=crossrefid;
								var params = {
									page: 1,
									limit: 10,
									crossuserid:crossuserid,
									crossrefid:crossrefid,
								}
								await this.$http.get('xinyongpinggu/list', {
									params: params
								}).then(res => {
									finishNum = res.data.data.total
								});
							}
							if(finishNum>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							}
						}


						await this.$http.post(`xinyongpinggu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
				this.$router.go(-1);
			},
			touxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 6px 0 0;
				margin: 0 0 20px 0;
				background: #f6f6f6;
				border-color: #475a8310;
				border-width:  0 0 4px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #475a8330;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				text-align: center;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 0px;
					clip-path: polygon(85% 0, 100% 50%, 85% 100%, 0% 100%, 15% 50%, 0% 0%);
					background: #475a83;
					width: auto;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					color: #fff;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 0px;
					clip-path: polygon(85% 0, 100% 50%, 85% 100%, 0% 100%, 15% 50%, 0% 0%);
					background: #e6cca6;
					width: auto;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
						text-align: center;
					}
				}
				.closeBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
						color: #fff;
						text-align: center;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
