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
				<el-form-item class="input" v-if="type!='info'"  label="编号" prop="number" >
					<el-input v-model="ruleForm.number" placeholder="编号" clearable  :readonly="ro.number"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="编号" prop="number" >
					<el-input v-model="ruleForm.number" placeholder="编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="性别" prop="gender" >
					<el-input v-model="ruleForm.gender" placeholder="性别" clearable  :readonly="ro.gender"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="性别" prop="gender" >
					<el-input v-model="ruleForm.gender" placeholder="性别" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="年龄" prop="age" >
					<el-input v-model.number="ruleForm.age" placeholder="年龄" clearable  :readonly="ro.age"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="年龄" prop="age" >
					<el-input v-model="ruleForm.age" placeholder="年龄" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="地区" prop="area" >
					<el-input v-model="ruleForm.area" placeholder="地区" clearable  :readonly="ro.area"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="地区" prop="area" >
					<el-input v-model="ruleForm.area" placeholder="地区" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="教育程度" prop="educationlevel" >
					<el-input v-model="ruleForm.educationlevel" placeholder="教育程度" clearable  :readonly="ro.educationlevel"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="教育程度" prop="educationlevel" >
					<el-input v-model="ruleForm.educationlevel" placeholder="教育程度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="婚姻状况" prop="maritalstatus" >
					<el-input v-model="ruleForm.maritalstatus" placeholder="婚姻状况" clearable  :readonly="ro.maritalstatus"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="婚姻状况" prop="maritalstatus" >
					<el-input v-model="ruleForm.maritalstatus" placeholder="婚姻状况" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="家庭人数" prop="householdsize" >
					<el-input v-model.number="ruleForm.householdsize" placeholder="家庭人数" clearable  :readonly="ro.householdsize"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="家庭人数" prop="householdsize" >
					<el-input v-model="ruleForm.householdsize" placeholder="家庭人数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="年收入" prop="annualincome" >
					<el-input v-model.number="ruleForm.annualincome" placeholder="年收入" clearable  :readonly="ro.annualincome"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="年收入" prop="annualincome" >
					<el-input v-model="ruleForm.annualincome" placeholder="年收入" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="月收入" prop="monthlyincome" >
					<el-input v-model.number="ruleForm.monthlyincome" placeholder="月收入" clearable  :readonly="ro.monthlyincome"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="月收入" prop="monthlyincome" >
					<el-input v-model="ruleForm.monthlyincome" placeholder="月收入" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="职业" prop="career" >
					<el-input v-model="ruleForm.career" placeholder="职业" clearable  :readonly="ro.career"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="职业" prop="career" >
					<el-input v-model="ruleForm.career" placeholder="职业" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="工作年限" prop="yearsofservice" >
					<el-input v-model.number="ruleForm.yearsofservice" placeholder="工作年限" clearable  :readonly="ro.yearsofservice"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="工作年限" prop="yearsofservice" >
					<el-input v-model="ruleForm.yearsofservice" placeholder="工作年限" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="资产总额" prop="totalassets" >
					<el-input-number v-model="ruleForm.totalassets" placeholder="资产总额" :disabled="ro.totalassets"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="资产总额" prop="totalassets" >
					<el-input v-model="ruleForm.totalassets" placeholder="资产总额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="负债总额" prop="totalliabilities" >
					<el-input-number v-model="ruleForm.totalliabilities" placeholder="负债总额" :disabled="ro.totalliabilities"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="负债总额" prop="totalliabilities" >
					<el-input v-model="ruleForm.totalliabilities" placeholder="负债总额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="负债率" prop="debtratio" >
					<el-input v-model="ruleForm.debtratio" placeholder="负债率" clearable  :readonly="ro.debtratio"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="负债率" prop="debtratio" >
					<el-input v-model="ruleForm.debtratio" placeholder="负债率" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用卡额度" prop="creditlimit" >
					<el-input-number v-model="ruleForm.creditlimit" placeholder="信用卡额度" :disabled="ro.creditlimit"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="信用卡额度" prop="creditlimit" >
					<el-input v-model="ruleForm.creditlimit" placeholder="信用卡额度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用卡使用率" prop="creditcardusagerate" >
					<el-input v-model="ruleForm.creditcardusagerate" placeholder="信用卡使用率" clearable  :readonly="ro.creditcardusagerate"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="信用卡使用率" prop="creditcardusagerate" >
					<el-input v-model="ruleForm.creditcardusagerate" placeholder="信用卡使用率" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用评分" prop="creditscore" >
					<el-input v-model.number="ruleForm.creditscore" placeholder="信用评分" clearable  :readonly="ro.creditscore"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="信用评分" prop="creditscore" >
					<el-input v-model="ruleForm.creditscore" placeholder="信用评分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用历史长度" prop="credithistorylength" >
					<el-input v-model="ruleForm.credithistorylength" placeholder="信用历史长度" clearable  :readonly="ro.credithistorylength"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="信用历史长度" prop="credithistorylength" >
					<el-input v-model="ruleForm.credithistorylength" placeholder="信用历史长度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="逾期次数" prop="numberofoverduetimes" >
					<el-input v-model.number="ruleForm.numberofoverduetimes" placeholder="逾期次数" clearable  :readonly="ro.numberofoverduetimes"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="逾期次数" prop="numberofoverduetimes" >
					<el-input v-model="ruleForm.numberofoverduetimes" placeholder="逾期次数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="严重逾期次数" prop="seriousoverduetimes" >
					<el-input v-model.number="ruleForm.seriousoverduetimes" placeholder="严重逾期次数" clearable  :readonly="ro.seriousoverduetimes"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="严重逾期次数" prop="seriousoverduetimes" >
					<el-input v-model="ruleForm.seriousoverduetimes" placeholder="严重逾期次数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="逾期金额" prop="overdueamount" >
					<el-input-number v-model="ruleForm.overdueamount" placeholder="逾期金额" :disabled="ro.overdueamount"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="逾期金额" prop="overdueamount" >
					<el-input v-model="ruleForm.overdueamount" placeholder="逾期金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="逾期天数" prop="overduedays" >
					<el-input v-model.number="ruleForm.overduedays" placeholder="逾期天数" clearable  :readonly="ro.overduedays"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="逾期天数" prop="overduedays" >
					<el-input v-model="ruleForm.overduedays" placeholder="逾期天数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="信用查询次数" prop="creditinquiryfrequency" >
					<el-input v-model.number="ruleForm.creditinquiryfrequency" placeholder="信用查询次数" clearable  :readonly="ro.creditinquiryfrequency"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="信用查询次数" prop="creditinquiryfrequency" >
					<el-input v-model="ruleForm.creditinquiryfrequency" placeholder="信用查询次数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款金额" prop="loanamount" >
					<el-input-number v-model="ruleForm.loanamount" placeholder="贷款金额" :disabled="ro.loanamount"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款金额" prop="loanamount" >
					<el-input v-model="ruleForm.loanamount" placeholder="贷款金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款期限" prop="loanterm" >
					<el-input v-model="ruleForm.loanterm" placeholder="贷款期限" clearable  :readonly="ro.loanterm"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款期限" prop="loanterm" >
					<el-input v-model="ruleForm.loanterm" placeholder="贷款期限" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款利率" prop="lendingrate" >
					<el-input v-model="ruleForm.lendingrate" placeholder="贷款利率" clearable  :readonly="ro.lendingrate"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款利率" prop="lendingrate" >
					<el-input v-model="ruleForm.lendingrate" placeholder="贷款利率" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="还款方式" prop="repaymentmethod" >
					<el-input v-model="ruleForm.repaymentmethod" placeholder="还款方式" clearable  :readonly="ro.repaymentmethod"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="还款方式" prop="repaymentmethod" >
					<el-input v-model="ruleForm.repaymentmethod" placeholder="还款方式" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="贷款用途" prop="loanpurpose" >
					<el-input v-model="ruleForm.loanpurpose" placeholder="贷款用途" clearable  :readonly="ro.loanpurpose"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="贷款用途" prop="loanpurpose" >
					<el-input v-model="ruleForm.loanpurpose" placeholder="贷款用途" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="剩余贷款期限" prop="remainingloanterm" >
					<el-input v-model="ruleForm.remainingloanterm" placeholder="剩余贷款期限" clearable  :readonly="ro.remainingloanterm"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="剩余贷款期限" prop="remainingloanterm" >
					<el-input v-model="ruleForm.remainingloanterm" placeholder="剩余贷款期限" readonly></el-input>
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
		isIntNumer,
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
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					number : false,
					gender : false,
					age : false,
					area : false,
					educationlevel : false,
					maritalstatus : false,
					householdsize : false,
					annualincome : false,
					monthlyincome : false,
					career : false,
					yearsofservice : false,
					totalassets : false,
					totalliabilities : false,
					debtratio : false,
					creditlimit : false,
					creditcardusagerate : false,
					creditscore : false,
					credithistorylength : false,
					numberofoverduetimes : false,
					seriousoverduetimes : false,
					overdueamount : false,
					overduedays : false,
					creditinquiryfrequency : false,
					loanamount : false,
					loanterm : false,
					lendingrate : false,
					repaymentmethod : false,
					loanpurpose : false,
					remainingloanterm : false,
				},
			
				ruleForm: {
					number: '',
					gender: '',
					age: '',
					area: '',
					educationlevel: '',
					maritalstatus: '',
					householdsize: '',
					annualincome: '',
					monthlyincome: '',
					career: '',
					yearsofservice: '',
					totalassets: '',
					totalliabilities: '',
					debtratio: '',
					creditlimit: '',
					creditcardusagerate: '',
					creditscore: '',
					credithistorylength: '',
					numberofoverduetimes: '',
					seriousoverduetimes: '',
					overdueamount: '',
					overduedays: '',
					creditinquiryfrequency: '',
					loanamount: '',
					loanterm: '',
					lendingrate: '',
					repaymentmethod: '',
					loanpurpose: '',
					remainingloanterm: '',
				},

				rules: {
					number: [
						{ required: true, message: '编号不能为空', trigger: 'blur' },
					],
					gender: [
					],
					age: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					area: [
					],
					educationlevel: [
					],
					maritalstatus: [
					],
					householdsize: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					annualincome: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					monthlyincome: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					career: [
					],
					yearsofservice: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					totalassets: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					totalliabilities: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					debtratio: [
					],
					creditlimit: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					creditcardusagerate: [
					],
					creditscore: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					credithistorylength: [
					],
					numberofoverduetimes: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					seriousoverduetimes: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					overdueamount: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					overduedays: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					creditinquiryfrequency: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					loanamount: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					loanterm: [
					],
					lendingrate: [
					],
					repaymentmethod: [
					],
					loanpurpose: [
					],
					remainingloanterm: [
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
						if(o=='number'){
							this.ruleForm.number = obj[o];
							this.ro.number = true;
							continue;
						}
						if(o=='gender'){
							this.ruleForm.gender = obj[o];
							this.ro.gender = true;
							continue;
						}
						if(o=='age'){
							this.ruleForm.age = obj[o];
							this.ro.age = true;
							continue;
						}
						if(o=='area'){
							this.ruleForm.area = obj[o];
							this.ro.area = true;
							continue;
						}
						if(o=='educationlevel'){
							this.ruleForm.educationlevel = obj[o];
							this.ro.educationlevel = true;
							continue;
						}
						if(o=='maritalstatus'){
							this.ruleForm.maritalstatus = obj[o];
							this.ro.maritalstatus = true;
							continue;
						}
						if(o=='householdsize'){
							this.ruleForm.householdsize = obj[o];
							this.ro.householdsize = true;
							continue;
						}
						if(o=='annualincome'){
							this.ruleForm.annualincome = obj[o];
							this.ro.annualincome = true;
							continue;
						}
						if(o=='monthlyincome'){
							this.ruleForm.monthlyincome = obj[o];
							this.ro.monthlyincome = true;
							continue;
						}
						if(o=='career'){
							this.ruleForm.career = obj[o];
							this.ro.career = true;
							continue;
						}
						if(o=='yearsofservice'){
							this.ruleForm.yearsofservice = obj[o];
							this.ro.yearsofservice = true;
							continue;
						}
						if(o=='totalassets'){
							this.ruleForm.totalassets = obj[o];
							this.ro.totalassets = true;
							continue;
						}
						if(o=='totalliabilities'){
							this.ruleForm.totalliabilities = obj[o];
							this.ro.totalliabilities = true;
							continue;
						}
						if(o=='debtratio'){
							this.ruleForm.debtratio = obj[o];
							this.ro.debtratio = true;
							continue;
						}
						if(o=='creditlimit'){
							this.ruleForm.creditlimit = obj[o];
							this.ro.creditlimit = true;
							continue;
						}
						if(o=='creditcardusagerate'){
							this.ruleForm.creditcardusagerate = obj[o];
							this.ro.creditcardusagerate = true;
							continue;
						}
						if(o=='creditscore'){
							this.ruleForm.creditscore = obj[o];
							this.ro.creditscore = true;
							continue;
						}
						if(o=='credithistorylength'){
							this.ruleForm.credithistorylength = obj[o];
							this.ro.credithistorylength = true;
							continue;
						}
						if(o=='numberofoverduetimes'){
							this.ruleForm.numberofoverduetimes = obj[o];
							this.ro.numberofoverduetimes = true;
							continue;
						}
						if(o=='seriousoverduetimes'){
							this.ruleForm.seriousoverduetimes = obj[o];
							this.ro.seriousoverduetimes = true;
							continue;
						}
						if(o=='overdueamount'){
							this.ruleForm.overdueamount = obj[o];
							this.ro.overdueamount = true;
							continue;
						}
						if(o=='overduedays'){
							this.ruleForm.overduedays = obj[o];
							this.ro.overduedays = true;
							continue;
						}
						if(o=='creditinquiryfrequency'){
							this.ruleForm.creditinquiryfrequency = obj[o];
							this.ro.creditinquiryfrequency = true;
							continue;
						}
						if(o=='loanamount'){
							this.ruleForm.loanamount = obj[o];
							this.ro.loanamount = true;
							continue;
						}
						if(o=='loanterm'){
							this.ruleForm.loanterm = obj[o];
							this.ro.loanterm = true;
							continue;
						}
						if(o=='lendingrate'){
							this.ruleForm.lendingrate = obj[o];
							this.ro.lendingrate = true;
							continue;
						}
						if(o=='repaymentmethod'){
							this.ruleForm.repaymentmethod = obj[o];
							this.ro.repaymentmethod = true;
							continue;
						}
						if(o=='loanpurpose'){
							this.ruleForm.loanpurpose = obj[o];
							this.ro.loanpurpose = true;
							continue;
						}
						if(o=='remainingloanterm'){
							this.ruleForm.remainingloanterm = obj[o];
							this.ro.remainingloanterm = true;
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
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `creditdata/info/${id}`,
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
					var objcross = this.$storage.getObj('crossObj');
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
								}
							}
							
							await this.$http({
								url: `creditdata/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.creditdataCrossAddOrUpdateFlag = false;
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
				this.parent.creditdataCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
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
