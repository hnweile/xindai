<template>
	<div class="content" :style='{"alignContent":"flex-start","padding":"0 0 20px 0","overflow":"hidden","background":"rgb(17, 17, 17)","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"100%"}'>
		<div id="particles"></div>
		<div :style='{"padding":"24px 0 0","margin":"0 0 20px 0","background":"url(http://codegen.caihongy.cn/20250106/5bd33b9661bd4632a61f91ee3e87c0c6.png) no-repeat top center","display":"flex","width":"100%","position":"relative","justifyContent":"center","height":"96px","zIndex":"2"}'>
			<!-- 标题 -->
			<div :style='{"margin":"0","fontSize":"20px","color":"rgb(255, 255, 255)","textAlign":"center","fontWeight":"700"}'>欢迎使用 {{this.$project.projectName}}</div>
			<!-- 时间 -->
			<div :style='{"top":"45px","color":"rgb(34, 157, 255)","display":"inline-block","lineHeight":"44px","fontSize":"16px","position":"absolute","right":"2%","height":"44px"}'>{{ dates }} <span @click="backClick" style="cursor:pointer;padding: 0 0 0 8px;">管理界面</span></div>
		</div>
		<div :style='{"padding":"0 20px","flex":"auto","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"0","zIndex":"2"}'>
			<div :style='{"width":"20%","padding":"15px","flexDirection":"column","background":"url(http://codegen.caihongy.cn/20250106/7db27eb0e39349b8b771cf620e80d883.png) no-repeat center / 100% 100%","display":"flex","gap":"10px"}'>
				<div class="echarts1">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							性别统计
						</div>
					</div>
					<div :style='{"width":"100%","flex":"auto","height":"0"}'>
						<div id="creditdataChart1" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts2">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							年龄区间
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart2" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts3">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							年收入
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart3" style="width:100%;height:100%;"></div>
					</div>
				</div>
			</div>
			<div :style='{"padding":"15px","margin":"0 20px","flexWrap":"wrap","flexDirection":"row","flex":"auto","background":"url(http://codegen.caihongy.cn/20250106/7db27eb0e39349b8b771cf620e80d883.png) no-repeat center / 100% 100%","display":"flex","width":"0"}'>
				<!-- 统计 -->
				<div :style='{"alignContent":"center","padding":"0 0 20px 0","margin":"0","color":"#fff","alignItems":"center","background":"none","display":"flex","gap":"12px","width":"100%","fontSize":"14px","justifyContent":"space-evenly","height":"100px"}'>

					<div :style='{"padding":"0","margin":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20250107/1f7eba19214f45b0927b3bd789f47556.png) no-repeat center / 100% 100%","flexDirection":"row","flex":"1 1 auto","display":"flex","width":"190px","position":"relative","justifyContent":"space-evenly","height":"78px","maxWidth":"240px"}'>
						<div :style='{"width":"43px","margin":"0 10px","background":"url(http://codegen.caihongy.cn/20250107/e407db36b663494fafda6bf3c65cc6cf.png) no-repeat ","flex":"none","display":"block","height":"43px"}'></div>
						<div :style='{"padding":"0","alignItems":"center","flexWrap":"wrap","flexDirection":"row","flex":"auto","display":"flex","width":"0","height":"auto"}'>
							<div :style='{"whiteSpace":"nowrap","overflow":"hidden","color":"inherit","width":"100%","lineHeight":"24px","fontSize":"inherit","position":"relative","textOverflow":"ellipsis","height":"24px"}'>信贷数据总数</div>
							<div :style='{"lineHeight":"24px","fontSize":"18px","color":"rgb(52, 171, 255)","fontWeight":"bold","order":"20"}'>{{creditdataCount}}</div>
						</div>
					</div>
				</div>
				<div class="echarts7">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							贷款金额
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart7" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts8">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							信用评分
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart8" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts9">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							信贷数据
						</div>
					</div>
					<el-table id="creditdataTable" :data="creditdataList" border :stripe="true" :style='{"padding":"0","borderColor":"rgba(92,135,230,.3)","borderWidth":"0","background":"none","width":"100%","overflow-y":"scroll","borderStyle":"solid","height":"calc(100% - 36px)"}'>
						<el-table-column :resizable="true" :sortable="false" prop="number" label="编号"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="gender" label="性别"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="age" label="年龄"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="annualincome" label="年收入"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="totalassets" label="资产总额"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="totalliabilities" label="负债总额"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="creditlimit" label="信用卡额度"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="creditscore" label="信用评分"/>
						</el-table-column>
						<el-table-column :resizable="true" :sortable="false" prop="loanamount" label="贷款金额"/>
						</el-table-column>
					</el-table>
				</div>
				<div class="forecast-box" :style='{"padding":"0","margin":"0","alignItems":"flex-start","flexDirection":"row","display":"flex","transition":"0.3s","justifyContent":"flex-start","flexWrap":"wrap","background":"none","flex":"0 0 auto","gap":"8px","width":"33.33%","height":"calc(40% - 50px)","order":"20"}'>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							编号
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.number" placeholder="请输入编号"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							年龄
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.age" placeholder="请输入年龄"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							年收入
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.annualincome" placeholder="请输入年收入"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							资产总额
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.totalassets" placeholder="请输入资产总额"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							信用评分
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.creditscore" placeholder="请输入信用评分"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							负债总额
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.totalliabilities" placeholder="请输入负债总额"></input>
					</div>
					<div :style='{"border":"1px solid rgb(52, 171, 255)","padding":"0 10px","margin":"0","alignItems":"center","borderRadius":"5px","display":"flex","width":"calc(50% - 4px)","justifyContent":"space-between","order":"1"}'>
						<div :style='{"width":"auto","fontSize":"12px","color":"#999","textAlign":"left"}'>
							信用卡额度
						</div>
						<input :style='{"border":"none","padding":"0 10px","margin":"0","outline":"none","color":"#fff","background":"transparent","flex":"auto","width":"0","lineHeight":"30px","height":"30px"}' v-model="forecastForm.creditlimit" placeholder="请输入信用卡额度"></input>
					</div>
					<div :style='{"padding":"0 0 0 30px","margin":"0","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","fontSize":"16px","height":"auto"}'>
						预测贷款金额：{{form.loanamount}}
					</div>
					<div @click="forecastClick" :style='{"border":"1px solid rgb(255, 156, 12)","cursor":"pointer","margin":"0","color":"rgb(255, 156, 12)","borderRadius":"5px","textAlign":"center","background":"none","width":"calc(33.33% - 8px)","lineHeight":"34px","height":"34px","order":"2"}'>
						立即预测
					</div>
				</div>
			</div>
			<div :style='{"padding":"15px","flexWrap":"wrap","flexDirection":"column","background":"url(http://codegen.caihongy.cn/20250106/7db27eb0e39349b8b771cf620e80d883.png) no-repeat center / 100% 100%","display":"flex","gap":"10px","width":"20%"}'>
				<div class="echarts4">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							资产总额
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart4" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts5">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							负债总额
						</div>
					</div>
					<div :style='{"width":"100%","padding":"0","flex":"auto","height":"0"}'>
						<div id="creditdataChart5" style="width:100%;height:100%;"></div>
					</div>
				</div>
				<div class="echarts6">
					<div :style='{"padding":"0 0 0 30px","margin":"0","textAlign":"left","background":"url(http://codegen.caihongy.cn/20250107/3565ea449bfe47fe97db61984b2d1b0a.png) no-repeat left center","flex":"none","width":"100%","height":"auto"}'>
						<div :style='{"fontSize":"18px","lineHeight":"24px","color":"#fff","textAlign":"left","background":"none","fontWeight":"500"}'>
							信用卡额度
						</div>
					</div>
					<div :style='{"width":"100%","flex":"auto","height":"0"}'>
						<div id="creditdataChart6" style="width:100%;height:100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	import * as echarts from 'echarts'
	import chinaJson from "@/components/echarts/china.json";
	require('@/utils/particles.js')
	import {
		Loading
	} from 'element-ui';
	import router from '@/router/router-static'
	export default {
		data() {
			return {
				line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":3000,"symbol":"emptyCircle","animationEasing":"exponentialOut","showSymbol":true,"symbolSize":8,"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line2: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"emptyCircle","animationEasing":"exponentialOut","showSymbol":true,"symbolSize":8,"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line3: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"emptyCircle","animationEasing":"exponentialOut","areaStyle":{"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(21,154,255, 0.5)"},{"offset":1,"color":"rgba(21,154,255, 0)"}],"type":"linear"}},"showSymbol":true,"symbolSize":4,"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line4: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"symbol":"emptyCircle","animationEasing":"exponentialOut","areaStyle":{"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(21,154,255, 0.5)"},{"offset":1,"color":"rgba(21,154,255, 0)"}],"type":"linear"}},"showSymbol":true,"symbolSize":4,"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"axis","textStyle":{"color":"#fff"}},"title":{"show":false}},
				line5: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"dashed","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"grid":{"right":"20","top":"40","left":"20","bottom":"20","containLabel":true},"legend":{"shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"itemHeight":10,"show":true,"icon":"roundRect","type":"scroll","top":"top","lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"borderWidth":0,"itemWidth":16,"shadowColor":"rgba(0,0,0,.3)","height":"auto","padding":0,"itemGap":6,"backgroundColor":"transparent","orient":"horizontal","bottom":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","borderRadius":0,"left":"center","width":"80%","textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0}},"series":{"animationDuration":6000,"symbol":"emptyCircle","animationEasing":"exponentialOut","showSymbol":true,"symbolSize":4,"animation":true},"series2":{"barWidth":"auto","animationDuration":6000,"animationEasing":"exponentialOut","color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(251, 140, 61, 0.1)"},{"offset":1,"color":"rgba(251, 140, 61, 1)"}],"type":"linear"},"barMaxWidth":"10px","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","borderRadius":[5,5,0,0],"shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"barCategoryGap":"20%","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false}},
				bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"bottom","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"center","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"itemStyle":{"borderType":"solid","shadowOffsetX":5,"borderColor":"inherit","shadowOffsetY":5,"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(21,154,255, 0.1)"},{"offset":1,"color":"rgba(21,154,255, 1)"}],"type":"linear"},"borderRadius":[5,5,0,0],"shadowBlur":10,"borderWidth":0,"opacity":1,"shadowColor":"rgba(0, 0, 0, 0.4)"},"colorBy":"series","animationEasing":"exponentialOut","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false},"base":{"animate":true,"interval":6000}},
				bar2: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#959aa5","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":false,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#959aa5","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"bottom","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"center","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"itemStyle":{"borderType":"solid","shadowOffsetX":5,"borderColor":"inherit","shadowOffsetY":5,"color":{"x":0,"y":0,"y2":0,"x2":1,"colorStops":[{"offset":0,"color":"rgba(21,154,255, 1)"},{"offset":1,"color":"rgba(21,154,255, 0.1)"}],"type":"linear"},"borderRadius":[0,5,5,0],"shadowBlur":10,"borderWidth":0,"opacity":1,"shadowColor":"rgba(0, 0, 0, 0.4)"},"colorBy":"series","animationEasing":"exponentialOut","animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false},"base":{"animate":true,"interval":6000}},
				bar3: {"polar":{"radius":[20,"85%"]},"backgroundColor":"transparent","radiusAxis":{"type":"category"},"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"legend":{"show":false},"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"series":{"animationDuration":6000,"barWidth":"auto","colorBy":"data","animationEasing":"exponentialOut","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":{"x":0,"y":0,"y2":1,"x2":0,"colorStops":[{"offset":0,"color":"rgba(21,154,255, 0.1)"},{"offset":1,"color":"rgba(21,154,255, 1)"}],"type":"linear"},"shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"coordinateSystem":"polar","label":{"formatter":"{b}: {c}","show":true,"fontSize":10,"position":"middle"},"animation":true,"barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false},"base":{"animate":true,"interval":6000},"angleAxis":{"startAngle":90}},
				pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"padding":[0,0,0,20],"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":6000,"animationEasing":"exponentialOut","top":30,"left":30,"bottom":30,"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"right":30,"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","formatter":"{d}%","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"inside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"radius":[0,"75%"],"animation":true}},
				pie2: {"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"legend":{"padding":[0,0,0,10],"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":12,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":6000,"animationEasing":"exponentialOut","avoidLabelOverlap":false,"emphasis":{"label":{"show":false,"fontSize":40,"fontWeight":"bold"}},"itemStyle":{"borderRadius":10},"label":{"color":"inherit","show":false,"position":"center"},"labelLine":{"show":false},"padAngle":5,"animation":true},"tooltip":{"backgroundColor":"#123","trigger":"item","textStyle":{"color":"#fff"}},"title":{"show":false}},
				pie3: {"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"grid":{"right":"20","top":"20","left":"20","bottom":"20","containLabel":true},"legend":{"padding":[0,0,0,10],"itemGap":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":6000,"animationEasing":"exponentialOut","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"rgb(3, 12, 59)","shadowOffsetY":0,"color":"","borderRadius":10,"shadowBlur":200,"borderWidth":0,"opacity":1,"shadowColor":"rgba(0, 0, 0, 0.5)"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":true},"radius":["0%","75%"],"animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"show":false}},
				funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"itemHeight":8,"show":true,"icon":"roundRect","type":"scroll","top":"bottom","lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"borderWidth":0,"itemWidth":14,"shadowColor":"rgba(0,0,0,.3)","height":"auto","padding":0,"itemGap":10,"backgroundColor":"transparent","orient":"horizontal","bottom":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","borderRadius":0,"left":"center","width":"100%","textStyle":{"textBorderWidth":0,"color":"#959aa5","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0}},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel2: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"padding":[0,0,0,10],"itemGap":4,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel3: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"padding":[0,0,0,10],"itemGap":4,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel4: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"padding":[0,0,0,10],"itemGap":4,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				funnel5: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false},"legend":{"padding":[0,0,0,10],"itemGap":4,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":8,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"center","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":14,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"gap":2}},
				map: {"tooltip":{"formatter":"{b} : {c}","trigger":"item"},"backgroundColor":"transparent","title":{"borderType":"solid","padding":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":false,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"aspectScale":0.75,"itemStyle":{"areaColor":"#a8d5fc"},"zoom":1.8,"label":{"emphasis":{"show":true,"textStyle":{"color":"#3ba372"}},"normal":{"color":"#3ba372","show":true}},"roam":true,"showLegendSymbol":false,"animation":false},"visualMap":{"min":0,"text":["High","Low"],"inRange":{"color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"]},"max":500,"calculable":true,"seriesIndex":[0]}},
				boardBase: {"funnelNum":6,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":6},
				gauge: {"tooltip":{"formatter":"{b} : {c}","trigger":"item"},"backgroundColor":"transparent","color":["#159aff","#66e1df","#e47e4b","#dd5b5b","#ffc97a","#d0deee","#4f84d4","#9a60b4"],"title":{"show":false,"textStyle":{"textBorderWidth":0,"color":"#ccc","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"top":"top","left":"left"},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":10,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":10,"width":"auto","fontSize":12,"height":12},"title":{"color":"#ccc","fontSize":12},"animation":true}},
				myChart0: null,
				creditdataList: [],
				creditdataTimer: null,
				dates: '',
				creditdataCount: 0,
				forecastForm: {},
				form: {},
				particlesJson: {"retina_detect":true,"particles":{"number":{"density":{"value_area":800,"enable":true},"value":6},"move":{"straight":true,"random":true,"bounce":false,"enable":true,"attract":{"rotateX":600,"enable":false,"rotateY":600},"speed":6,"direction":"bottom","out_mode":"out"},"color":{"value":"#fff"},"shape":{"image":{"width":20,"src":"http://codegen.caihongy.cn/20250107/b882f1314b36414880a516760acd5ce6.png","height":20},"polygon":{"nb_sides":5},"type":"image","stroke":{"color":"#000000","width":0}},"size":{"anim":{"size_min":0.1,"sync":false,"enable":false,"speed":40},"random":true,"value":10},"line_linked":{"width":1,"distance":150,"color":"#ffffff","opacity":0.4,"enable":false},"opacity":{"anim":{"opacity_min":0,"sync":false,"enable":false,"speed":30},"random":true,"value":0.5}},"interactivity":{"detect_on":"canvas","events":{"resize":true,"onclick":{"mode":"push","enable":false},"onhover":{"mode":"grab","enable":false}},"modes":{"grab":{"distance":400,"line_linked":{"opacity":1}},"bubble":{"duration":2,"distance":250,"size":0,"opacity":0,"speed":3},"repulse":{"duration":0.4,"distance":400},"push":{"particles_nb":4},"remove":{"particles_nb":2}}}}
			};
		},
		mounted(){
			this.init();
			this.getcreditdataList()
			particlesJS('particles',this.particlesJson)
		},
		created() {
			this.$nextTick(()=>{
				this.times()
				setTimeout(()=>{
					this.getcreditdataCount();
					this.creditdataChat1();
					this.creditdataChat2();
					this.creditdataChat3();
					this.creditdataChat4();
					this.creditdataChat5();
					this.creditdataChat6();
					this.creditdataChat7();
					this.creditdataChat8();
				},500)
			})
		},
		methods:{
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
					this.$http({
						url: 'creditdataforecast/save',
						method: 'post',
						data: this.forecastForm
					}).then(res=>{
						if(res.data&&res.data.code==0){
							this.forecastForm.id = res.data.data
							this.$http({
								url: 'creditdataforecast/forecast',
								method: 'post',
								data: this.forecastForm
							}).then(obj=>{
								if(obj.data&&obj.data.code==0){
									this.$http({
										url: 'creditdataforecast/info/' + res.data.data,
										method: 'get'
									}).then(rs2=>{
										if(rs2.data&&rs2.data.code==0){
											if (loading) loading.close()
											this.$message({
												message: "数据预测完成！",
												type: "success",
												duration: 1500,
												onClose: () => {
													this.form = rs2.data.data
												}
											});
										}
									})
									
								}
							})
						}
					})
					
				})
			},
			getcreditdataList() {
				let params = {
					page: 1,
					limit: 10,
				}
				this.$http({
					url: "creditdata/page",
					method: "get",
					params: params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.creditdataList = data.data.list;
						let div = document.getElementById('creditdataTable')
						var scrollTop = -1
						function move() {
							if (div){
								if(div.scrollTop==scrollTop){
									div.scrollTo({
										top: 0, 
										behavior: "smooth"
									});
									return false
								}
								scrollTop = div.scrollTop
								div.scrollTo({ 
									top: div.scrollTop + 40, 
									behavior: "smooth"
								});
							}
								
						}
						this.creditdataTimer = setInterval(move, 2000);
						div.addEventListener('mouseenter', e => {
							e.stopPropagation()
							clearInterval(this.creditdataTimer);
						})
						div.addEventListener('mouseleave', e => {
							e.stopPropagation()
							this.creditdataTimer = setInterval(move, 2000);
						})
					}
				});
			},
			backClick(){
				this.$router.replace({ path: "/" });
			},
			myChartInterval(type, xAxisData, seriesData, myChart) {
				this.$nextTick(() => {
					setInterval(() => {
						let xAxis = xAxisData.shift()
						xAxisData.push(xAxis)
						let series = seriesData.shift()
						seriesData.push(series)
			
						if (type == 1) {
							myChart.setOption({
								xAxis: [{
									data: xAxisData
								}],
								series: [{
									data: seriesData
								}]
							});
						}
						if (type == 2) {
							myChart.setOption({
								yAxis: [{
									data: xAxisData
								}],
								series: [{
									data: seriesData
								}]
							});
						}
					}, 6000);
				})
			},
			wordclouds(wordcloudData,echartsId) {
				let wordcloud = {"maskImage":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAKc0lEQVR4Xu2dBawdRRSGcYoFKIRCsEJocHcv7lDcyYOgQYLTEuQVb/AQmuIWHIq7FvfgEPThWiBYCBbO9zj35fa9K7t7Z1bmzElObt92duac//wzszs7MvlkUUwjMLlp76Pzk0UCGCdBJEAkgHEEjLsfW4BIAOMIGHc/tgCRALkhsIyUtILo0qKzi84pOpXoPKK/in4v2iP6teg3+vcH8vuS6N+5Wem+oCUky0XU3yHqL76js6i/f8jvT+rzW/L7lOibolz3Kj5bAAK7nehWogR+xoyeQIy7Re8QvT8PUDLaWbsNUg8X3Ux0c9GFMuYH6V9Vv2+QXyqDc3FNgEFi4d6iO4qu4dza/2sEJLhR9BbRMrUMBBu/+aVmuxbIgN/jRGktnIgrAtC8b686zIll7TOhmaRmXC/6Q/vkXlLQqu0supPoul5KGJhpj1y6WfXFTst0QYD9xYgTRenTihBqxlGiD+dcOKQ/WZQaX4TQCpwveoZo5meFTggwVAq+QnR4Ed43KPNxuXaYKITwKRD9dNEun4WkyPtdSbun6HMp7ulLmoUAc8jd1Hp0riyFerznQ8n7TNGLPJWxl+R7hOhinvLPmu1EuZFnA/z+LE0maQmwsGQ+skTsb+TrL3LxLNXf04DRIu20Gvgj5XdWR3n6yOY6yZTWiVfIRJKGACtLjseIbp0o5+ITjdXWoKdDU+bX4B/cYT553X6XkuDZJAUmJQD9HhnzPl8loV+EsAwuZRGe8q8RHZHl5gLvgfSbiPJ80FKSEICaP0Z07XaZlfT/7xO7ukVfSGnfSnofQFZRJojRtNjPtzK+HQF4p+c1Y5sqIlBn8z0aTIaVkwgtHaRhNK/KMl6M55nt/WZOtCLAYLmJms/IXghCF0ZQX2njzHKabosQnBYfLhWlJWg4WNaKAF1yE+/5IQl94qqizYZSGcp+SNTHMHaROI5WUg+woRkBNpSUF4vyBBya3KZgvN7PsaX0elXectLE5RNJvK/og/1vakQA3nMJPl/yQpVbNdi192U+2XaLbhuqw+IXH88gwY/1PjYiAIHnY0PowscknvAZR+eDUsiEr8WSbyYMkvVJfwLwLfsd0azfsKtGGkjAGIGF4BMbnn0W0N/eWPUnwLFy7dSqRTHamwoBXgt5uxtAAN75bxLlM2eUcBF4WVxj7sbH/VuA3eQCw55RwkdglLjIAN8kXQDvv+uH73v0UBDgdXCjegIw8PGYKA+BUcJHgLmU64k+UXsIPE7+YHpTFDsI9I4O1ggQm387ga95+rn8Y14IwHDvG6Iz2cPAtMf/iPeLQYBNRflcGsUeAiMgwNGifQMD9jAw7fFICHCV6B6mYbDr/FUQgPHw1e1iYNrzpyDAa6J8C49iD4HXIABjwkPt+R49JvYQgOXXs0U4TCIwEQKwlIi1/FEMIgABmDJsZQKIwRC3dPl9CPC06GoRGZMIPA0BmCVbtaVPJqPlwenxEIAlxcwWjWIPgXEQ4CTR4+35Hj0WBEZDgC7R0FYAxegmQ+B4CMAqoAeSpY+pAkNgOASYXpTvAcsG5lx0pzUCzA5erTYj6AL546CImCkEiPkhNQKwzx3Lo6LYQWAXYl4jAEPBdAMhrga2E9Lknn4pSZkC0FO/NOxauQArooSPAKuje9dD1hOARSHMDo4SPgJsqHlefwJMIxfYZy7kNfLhh7a9h0wAZn9j9lMcsDqYZgESTN0+n5iioggw/7NvDWijDSLiJNGKRjaB2ewaxhvfX7W0jQjArhm0Aj72vE9gY0ziCYF/NfiT7P7SiACUz7eBLk+GxGyLQYBd1AeM9jYjAOf6nCOa1yEIxUBip1SGfdnlfEJ/l5sRgHTsknm2KDuER6kuAl9p8BuO9LYiAC7vpySYobr+m7ecLe6pyA2lHQG4KU4YqS6H6MZp+ptKEgKwcSQM2rO6OJi0nAO1qP1fdEoA7ufgw9GiO5iEsnpOc8Zit2jb85OStAA19zknh0zZYixKeRFIuit6rwdpCEB6C3vqlje07S1jnJ8j/HjtSyRpCUCmS2p3EOKu2olAK2mie7WFTnWYZBYC4D8DRTwTcC5wlOIR4Dhdan7aY3FSdwH1rjKs2C26ZfH+m7aAGd3EIbeDI+vRXl4LL+r4VNORF+eZwEPwn8kKRNYuoL48DliiO2C3sSj5IfCINvss7s0sLghA4RyxBgk2zmxJvDENAo9qzX8yzU2N0roiAHmvokb1bkIcxRsCj2vNf8JFCS4JgD3sM9AtuoEL42IeAxDgcy74QgIn4poAGMV8c7oDdqOO4g4BmnuCT/PvTHwQAOPWVBKs48xS2xnxoMd7Pg9+TsUXATCSs4Zh7HCnFtvLjFc8cPSyZsMnAQgVLQDGr2Uvbk48ZnCHmj/gwEcnuUsmvgmAncwr5JkgtONYXcWgWT6c+k3lYZjXm+RBAIxn2RkkiLuRJQslH3QIPh94vEpeBMAJdiLBKQ5vjtIcAT7l0uzncoZDngTAZUYKIcHKkQENEeBoe/BhUkcukjcBcIqVR3QHK+biYXUKYfoWNf/OPE0uggD4x5oDSMDXxCj/b9lPzb89bzCKIgB+bqFOL5e30yUrjwO7CD4LN3OXIgmAs8wownmr5xW/pc0+O3YUIkUTAKfZp5juwNqpJW8r+SdZrZs3C8pAAHzeRknArGML8q7WfE5rL1TKQgBAYHcSuoPFC0XEf+HvafBZuVO4lIkAgMHKI0iwaOHI+DGAwznwjw04SiFlIwCg7CjKM0Foy9I/1JrPdnylkTISAHDYxQoSDCsNUp0Z8pHW/L7NmTrLzt3dZSUAHu6qoFX9PKMerflXuwubu5zKTAC83F1JsKA7l3PN6VMN/pW5lpqisLITAFfY147uYGgKv8qQlOP4ukUvL4MxzWyoAgGwvUtJMF+ZwayzjU0Z+LBzWdntrQoBwHEvrVHzlhxUduKm5l9Scjt7zasSAbB3bwV37pKC+7Xax0lslZCqEQBQ99HuYK6SIfytNvvjSmZXS3OqSAAcYvs6HgyHlATs77Tmjy2JPYnNqCoBcPAABX2OxN76SThRa/6FfrL3m2uVCQAyByoJZvcLU9Pcf9DyOYCpklJ1AgA6p53RHQzOOQI/afDPz7lcp8WFQAAAOURJkNcW9z9rs9977EqVJRQCEINDtUbO7DkgHLXSLco2rJWXkAhAMA7X4MzkKTK/ac1vuvmyp3K9ZRsaAQCKzZF5JnC9w/nvSq4zvUWjgIxDJAAwHqUkmM4Rpn9o8Mc4yq802YRKAAA+RoM2qEO0/9Rm/4wO8ynl7SETAMBHKQk4EzGLcLpWt+hpWW6uwj2hE4AYHKvdwVQpA/KP1vxTU95XqeQWCEBAjlMSTJEwOhyxRs0/OWH6yiazQgACdIIGNYnPBJ83ieAlCRghgUBgmanTSgg86UyINQLgL8GlNWgkNPn8P12ACbFGAII6pQaZ54J6OUWv8/BnRiwSgOByOjo1nTcEhNc8/u47VNkKA6wSoBbfc+Uf84iyEulvK0Gv99M6AcCC8QGTwcf5SACL1b7O50iASADjCBh3P7YAkQDGETDufmwBIgGMI2Dc/f8AJVd0m1ANi90AAAAASUVORK5CYII=","option":{"tooltip":{"show":false},"backgroundColor":"transparent","series":[{"sizeRange":[9,32],"layoutAnimation":true,"shape":"circle","data":[{"name":"花鸟市场","value":1446},{"name":"汽车","value":928},{"name":"视频","value":906},{"name":"电视","value":825},{"name":"Lover Boy 88","value":514},{"name":"动漫","value":486},{"name":"音乐","value":53},{"name":"直播","value":163},{"name":"广播电台","value":86},{"name":"戏曲曲艺","value":17},{"name":"演出票务","value":6},{"name":"给陌生的你听","value":1},{"name":"资讯","value":1437},{"name":"商业财经","value":422},{"name":"娱乐八卦","value":353},{"name":"军事","value":331},{"name":"科技资讯","value":313},{"name":"社会时政","value":307},{"name":"时尚","value":43},{"name":"网络奇闻","value":15},{"name":"旅游出行","value":438},{"name":"景点类型","value":957},{"name":"国内游","value":927},{"name":"远途出行方式","value":908},{"name":"酒店","value":693},{"name":"关注景点","value":611},{"name":"旅游网站偏好","value":512},{"name":"出国游","value":382},{"name":"交通票务","value":312},{"name":"旅游方式","value":187},{"name":"旅游主题","value":163},{"name":"港澳台","value":104},{"name":"本地周边游","value":3},{"name":"小卖家","value":1331},{"name":"全日制学校","value":941},{"name":"基础教育科目","value":585},{"name":"考试培训","value":473},{"name":"语言学习","value":358},{"name":"留学","value":246},{"name":"K12课程培训","value":207},{"name":"艺术培训","value":194},{"name":"技能培训","value":104},{"name":"IT培训","value":87},{"name":"高等教育专业","value":63},{"name":"家教","value":48},{"name":"体育培训","value":23},{"name":"职场培训","value":5},{"name":"金融财经","value":1328},{"name":"银行","value":765},{"name":"股票","value":452},{"name":"保险","value":415},{"name":"贷款","value":253},{"name":"基金","value":211},{"name":"信用卡","value":180},{"name":"外汇","value":138},{"name":"P2P","value":116},{"name":"贵金属","value":98},{"name":"债券","value":93},{"name":"网络理财","value":92},{"name":"信托","value":90},{"name":"征信","value":76},{"name":"期货","value":76},{"name":"公积金","value":40},{"name":"银行理财","value":36},{"name":"银行业务","value":30},{"name":"典当","value":7},{"name":"海外置业","value":1},{"name":"汽车","value":1309},{"name":"汽车档次","value":965},{"name":"汽车品牌","value":900},{"name":"汽车车型","value":727},{"name":"购车阶段","value":461},{"name":"二手车","value":309},{"name":"汽车美容","value":260},{"name":"新能源汽车","value":173},{"name":"汽车维修","value":155},{"name":"租车服务","value":136},{"name":"车展","value":121},{"name":"违章查询","value":76},{"name":"汽车改装","value":62},{"name":"汽车用品","value":37},{"name":"路况查询","value":32},{"name":"汽车保险","value":28},{"name":"陪驾代驾","value":4},{"name":"网络购物","value":1275},{"name":"做我的猫","value":1088},{"name":"只想要你知道","value":907},{"name":"团购","value":837},{"name":"比价","value":201},{"name":"海淘","value":195},{"name":"移动APP购物","value":179},{"name":"支付方式","value":119},{"name":"代购","value":43},{"name":"体育健身","value":1234},{"name":"体育赛事项目","value":802},{"name":"运动项目","value":405},{"name":"体育类赛事","value":337},{"name":"健身项目","value":199},{"name":"健身房健身","value":78},{"name":"运动健身","value":77},{"name":"家庭健身","value":36},{"name":"健身器械","value":29},{"name":"办公室健身","value":3},{"name":"商务服务","value":1201},{"name":"法律咨询","value":508},{"name":"化工材料","value":147},{"name":"广告服务","value":125},{"name":"会计审计","value":115},{"name":"人员招聘","value":101},{"name":"印刷打印","value":66},{"name":"知识产权","value":32},{"name":"翻译","value":22},{"name":"安全安保","value":9},{"name":"公关服务","value":8},{"name":"商旅服务","value":2},{"name":"展会服务","value":2},{"name":"特许经营","value":1},{"name":"休闲爱好","value":1169},{"name":"收藏","value":412},{"name":"摄影","value":393},{"name":"温泉","value":230},{"name":"博彩彩票","value":211},{"name":"美术","value":207},{"name":"书法","value":139},{"name":"DIY手工","value":75},{"name":"舞蹈","value":23},{"name":"钓鱼","value":21},{"name":"棋牌桌游","value":17},{"name":"KTV","value":6},{"name":"密室","value":5},{"name":"采摘","value":4},{"name":"电玩","value":1},{"name":"真人CS","value":1},{"name":"轰趴","value":1},{"name":"家电数码","value":1111},{"name":"手机","value":885},{"name":"电脑","value":543},{"name":"大家电","value":321},{"name":"家电关注品牌","value":253},{"name":"网络设备","value":162},{"name":"摄影器材","value":149},{"name":"影音设备","value":133},{"name":"办公数码设备","value":113},{"name":"生活电器","value":67},{"name":"厨房电器","value":54},{"name":"智能设备","value":45},{"name":"个人护理电器","value":22},{"name":"服饰鞋包","value":1047},{"name":"服装","value":566},{"name":"饰品","value":289},{"name":"鞋","value":184},{"name":"箱包","value":168},{"name":"奢侈品","value":137},{"name":"母婴亲子","value":1041},{"name":"孕婴保健","value":505},{"name":"母婴社区","value":299},{"name":"早教","value":103},{"name":"奶粉辅食","value":66},{"name":"童车童床","value":41},{"name":"关注品牌","value":271},{"name":"宝宝玩乐","value":30},{"name":"母婴护理服务","value":25},{"name":"纸尿裤湿巾","value":16},{"name":"妈妈用品","value":15},{"name":"宝宝起名","value":12},{"name":"童装童鞋","value":9},{"name":"胎教","value":8},{"name":"宝宝安全","value":1},{"name":"宝宝洗护用品","value":1},{"name":"软件应用","value":1018},{"name":"系统工具","value":896},{"name":"理财购物","value":440},{"name":"生活实用","value":365},{"name":"影音图像","value":256},{"name":"社交通讯","value":214},{"name":"手机美化","value":39},{"name":"办公学习","value":28},{"name":"应用市场","value":23},{"name":"母婴育儿","value":14},{"name":"游戏","value":946},{"name":"手机游戏","value":565},{"name":"PC游戏","value":353},{"name":"网页游戏","value":254},{"name":"游戏机","value":188},{"name":"模拟辅助","value":166},{"name":"个护美容","value":942},{"name":"护肤品","value":177},{"name":"彩妆","value":133},{"name":"美发","value":80},{"name":"香水","value":50},{"name":"个人护理","value":46},{"name":"美甲","value":26},{"name":"SPA美体","value":21},{"name":"花鸟萌宠","value":914},{"name":"绿植花卉","value":311},{"name":"狗","value":257},{"name":"其他宠物","value":131},{"name":"水族","value":125},{"name":"猫","value":122},{"name":"动物","value":81},{"name":"鸟","value":67},{"name":"宠物用品","value":41},{"name":"宠物服务","value":26},{"name":"书籍阅读","value":913},{"name":"网络小说","value":483},{"name":"关注书籍","value":128},{"name":"文学","value":105},{"name":"报刊杂志","value":77},{"name":"人文社科","value":22},{"name":"建材家居","value":907},{"name":"装修建材","value":644},{"name":"家具","value":273},{"name":"家居风格","value":187},{"name":"家居家装关注品牌","value":140},{"name":"家纺","value":107},{"name":"厨具","value":47},{"name":"灯具","value":43},{"name":"家居饰品","value":29},{"name":"家居日常用品","value":10},{"name":"生活服务","value":883},{"name":"物流配送","value":536},{"name":"家政服务","value":108},{"name":"摄影服务","value":49},{"name":"搬家服务","value":38},{"name":"物业维修","value":37},{"name":"婚庆服务","value":24},{"name":"二手回收","value":24},{"name":"鲜花配送","value":3},{"name":"维修服务","value":3},{"name":"殡葬服务","value":1},{"name":"求职创业","value":874},{"name":"创业","value":363},{"name":"目标职位","value":162},{"name":"目标行业","value":50},{"name":"兼职","value":21},{"name":"期望年薪","value":20},{"name":"实习","value":16},{"name":"雇主类型","value":10},{"name":"星座运势","value":789},{"name":"星座","value":316},{"name":"算命","value":303},{"name":"解梦","value":196},{"name":"风水","value":93},{"name":"面相分析","value":47},{"name":"手相","value":32},{"name":"公益","value":90}],"keepAspect":false,"type":"wordCloud","rotationRange":[-90,90],"gridSize":8,"shrinkToFit":false,"top":"center","left":"center","width":"80%","emphasis":{"focus":"self","textStyle":{"textShadowColor":"#333","textShadowBlur":4}},"drawOutOfBound":false,"rotationStep":45,"textStyle":{"color":"function(){return\"rgb(\"+[Math.round(Math.floor(Math.random() * (100 - 255)) + 255),Math.round(Math.floor(Math.random() * (100 - 255)) + 255),Math.round(Math.floor(Math.random() * (100 - 255)) + 255)].join(\",\")+\")\"}","fontWeight":500,"fontFamily":"sans-serif"},"height":"80%","maskImage":{}}]}}
				wordcloud = JSON.parse(JSON.stringify(wordcloud), (k, v) => {
					if(typeof v == 'string' && v.indexOf('function') > -1){
						return eval("(function(){return "+v+" })()")
					}
					return v;
				})
				wordcloud.option.series[0].data=wordcloudData;
				
				this.myChart0 = echarts.init(document.getElementById(echartsId));
				let myChart = this.myChart0
				let img = wordcloud.maskImage
			
				if (img) {
					var maskImage = new Image();
					maskImage.src = img
					maskImage.onload = function() {
						wordcloud.option.series[0].maskImage = maskImage
						myChart.clear()
						myChart.setOption(wordcloud.option)
					}
				} else {
					delete wordcloud.option.series[0].maskImage
					myChart.clear()
					myChart.setOption(wordcloud.option)
				}
			},
			getTimeStrToDay(game_over_timestamp) {
				if (game_over_timestamp == 0)
					return "";
				var date = new Date(parseInt(game_over_timestamp));
				var now = new Date();
				var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
				var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
				var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
				let arr = ["日", "一", "二", "三", "四", "五", "六"];
				let d = arr[date.getDay()]
				return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
			},
			times() {
				setInterval(()=>{
					let date = new Date().getTime()
					this.dates = this.getTimeStrToDay(date)
				}, 1000)
			},
			filterTime(time) {
				const date = new Date(time)
				const Y = date.getFullYear()
				const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
				const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
			  
				const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
				const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
				const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
			  
				return `${Y}-${M}-${D} ${H}:${I}:${S}`
			},
			init(){
				if(this.$storage.get('Token')){
					this.$http({
						url: `${this.$storage.get('sessionTable')}/session`,
						method: "get"
					}).then(({ data }) => {
						if (data && data.code != 0) {
						router.push({ name: 'login' })
						}
					});
				}else{
					router.push({ name: 'login' })
				}
			},
			getcreditdataCount() {
				this.$http({
					url: `creditdata/count`,
					method: "get"
				}).then(({
					data
				}) => {
					if (data && data.code == 0) {
						this.creditdataCount = data.data
					}
				})
			},
			//统计接口1
			creditdataChat1() {
				this.$nextTick(()=>{

					var creditdataChart1 = echarts.init(document.getElementById("creditdataChart1"),'macarons');
					this.$http({
						url: "creditdata/group/gender",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].gender);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].gender
								})
							}
							var option = {};
							let titleObj = this.bar3.title
							titleObj.text = '性别统计'
							
							const legendObj = this.bar3.legend
							
							let seriesObj = {
								data: yAxis,
								type: 'bar'
							}
							seriesObj = Object.assign(seriesObj , this.bar3.series)
							const gridObj = this.bar3.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar3.tooltip?this.bar3.tooltip:{})
							const polarObj = this.bar3.polar
							const angleAxisObj = this.bar3.angleAxis
							let radiusAxisObj = {
								data: xAxis
							}
							radiusAxisObj = Object.assign(radiusAxisObj,this.bar3.radiusAxis)
							option = {
								backgroundColor: this.bar3.backgroundColor,
								color: this.bar3.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								polar: polarObj,
								angleAxis: angleAxisObj,
								radiusAxis: radiusAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart1.setOption(option);
				

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart1.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口2
			creditdataChat2() {
				this.$nextTick(()=>{

					var creditdataChart2 = echarts.init(document.getElementById("creditdataChart2"),'macarons');
					this.$http({
						url: "creditdata/sectionStat/age",
						method: "get",
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].age);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].age
								})
							}
							var option = {};
							let titleObj = this.bar.title
							titleObj.text = '年龄区间'
							
							const legendObj = this.bar.legend
							
							let xAxisObj = this.bar.xAxis
							xAxisObj.type = 'category'
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.bar.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
									data: yAxis,
									type: 'bar'
								}
							seriesObj = Object.assign(seriesObj , this.bar.series)
							const gridObj = this.bar.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
							option = {
								backgroundColor: this.bar.backgroundColor,
								color: this.bar.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart2.setOption(option);
				
							this.myChartInterval(1, option.xAxis.data, option.series[0].data, creditdataChart2)

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart2.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口3
			creditdataChat3() {
				this.$nextTick(()=>{

					var creditdataChart3 = echarts.init(document.getElementById("creditdataChart3"),'macarons');
					this.$http({
						url: `creditdata/value/number/annualincome`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.line2.title
							titleObj.text = '年收入'
							
							const legendObj = this.line2.legend
							
							let xAxisObj = this.line2.xAxis
							xAxisObj.type = 'category'
							xAxisObj.boundaryGap = false
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.line2.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'line',
								areaStyle: {}
							}
							seriesObj = Object.assign(seriesObj , this.line2.series)
							const gridObj = this.line2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.line2.tooltip?this.line2.tooltip:{})
							option = {
								backgroundColor: this.line2.backgroundColor,
								color: this.line2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart3.setOption(option);
				

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart3.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口4
			creditdataChat4() {
				this.$nextTick(()=>{

					var creditdataChart4 = echarts.init(document.getElementById("creditdataChart4"),'macarons');
					this.$http({
						url: `creditdata/value/number/totalassets`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.bar2.title
							titleObj.text = '资产总额'
							
							const legendObj = this.bar2.legend
							
							let xAxisObj = this.bar2.xAxis
							xAxisObj.type = 'value'
							
							
							let yAxisObj = this.bar2.yAxis
							yAxisObj.type = 'category'
							yAxisObj.data = xAxis
							let seriesObj = {
								data: yAxis,
								type: 'bar'
							}
							seriesObj = Object.assign(seriesObj , this.bar2.series)
							const gridObj = this.bar2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar2.tooltip?this.bar2.tooltip:{})
							option = {
								backgroundColor: this.bar2.backgroundColor,
								color: this.bar2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart4.setOption(option);
				
							this.myChartInterval(2, option.yAxis.data, option.series[0].data, creditdataChart4)

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart4.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			//统计接口5
			creditdataChat5() {
				this.$nextTick(()=>{

					var creditdataChart5 = echarts.init(document.getElementById("creditdataChart5"),'macarons');
					this.$http({
						url: `creditdata/value/number/totalliabilities`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.barNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.bar.title
							titleObj.text = '负债总额'
							
							const legendObj = this.bar.legend
							
							let xAxisObj = this.bar.xAxis
							xAxisObj.type = 'category'
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.bar.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'bar'
							}
							seriesObj = Object.assign(seriesObj , this.bar.series)
							const gridObj = this.bar.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
							option = {
								backgroundColor: this.bar.backgroundColor,
								color: this.bar.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart5.setOption(option);

							this.myChartInterval(1, option.xAxis.data, option.series[0].data, creditdataChart5)

							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart5.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			// 统计接口6
			creditdataChat6() {
				this.$nextTick(()=>{

					var creditdataChart6 = echarts.init(document.getElementById("creditdataChart6"),'macarons');
					this.$http({
						url: `creditdata/value/number/creditlimit`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.line2.title
							titleObj.text = '信用卡额度'
							
							const legendObj = this.line2.legend
							
							let xAxisObj = this.line2.xAxis
							xAxisObj.type = 'category'
							xAxisObj.boundaryGap = false
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.line2.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'line',
								areaStyle: {}
							}
							seriesObj = Object.assign(seriesObj , this.line2.series)
							const gridObj = this.line2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.line2.tooltip?this.line2.tooltip:{})
							option = {
								backgroundColor: this.line2.backgroundColor,
								color: this.line2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart6.setOption(option);


							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart6.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			// 统计接口7
			creditdataChat7() {
				this.$nextTick(()=>{

					var creditdataChart7 = echarts.init(document.getElementById("creditdataChart7"),'macarons');
					this.$http({
						url: `creditdata/value/number/loanamount`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.pieNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.pie2?this.pie2.title:this.pie.title
							titleObj.text = '贷款金额'
							
							const legendObj = this.pie2.legend
							
							let seriesObj = {
								type: 'pie',
								radius: ['25%', '55%'],
								center: ['50%', '60%'],
								data: pArray,
								emphasis: {
									itemStyle: {
										shadowBlur: 10,
										shadowOffsetX: 0,
										shadowColor: 'rgba(0, 0, 0, 0.5)'
									}
								}
							}
							seriesObj = Object.assign(seriesObj , this.pie2.series)
							const gridObj = this.pie2.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c} ({d}%)'
							}
							tooltipObj = Object.assign(tooltipObj , this.pie2.tooltip?this.pie2.tooltip:{})
							option = {
								backgroundColor: this.pie2.backgroundColor,
								color: this.pie2.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart7.setOption(option);


							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart7.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
			// 统计接口8
			creditdataChat8() {
				this.$nextTick(()=>{

					var creditdataChart8 = echarts.init(document.getElementById("creditdataChart8"),'macarons');
					this.$http({
						url: `creditdata/value/number/creditscore`,
						method: "get",
						params: {
							order: 'desc'
						}
					}).then(({ data }) => {
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis = [];
							let yAxis = [];
							let pArray = []
							for(let i=0;i<res.length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis.push(res[i].number);
								yAxis.push(parseFloat((res[i].total)));
								pArray.push({
									value: parseFloat((res[i].total)),
									name: res[i].number
								})
							}
							var option = {};
							let titleObj = this.line4.title
							titleObj.text = '信用评分'
							
							const legendObj = this.line4.legend
							
							let xAxisObj = this.line4.xAxis
							xAxisObj.type = 'category'
							xAxisObj.boundaryGap = false
							xAxisObj.data = xAxis
							
							
							let yAxisObj = this.line4.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = {
								data: yAxis,
								type: 'line',
								areaStyle: {},
								smooth: true
							}
							seriesObj = Object.assign(seriesObj , this.line4.series)
							const gridObj = this.line4.grid
							let tooltipObj = {
								trigger: 'item',
								formatter: '{b} : {c}'
							}
							tooltipObj = Object.assign(tooltipObj , this.line4.tooltip?this.line4.tooltip:{})
							option = {
								backgroundColor: this.line4.backgroundColor,
								color: this.line4.color,
								title: titleObj,
								legend: legendObj,
								tooltip: tooltipObj,
								grid: gridObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: [seriesObj]
							};
							// 使用刚指定的配置项和数据显示图表。
							creditdataChart8.setOption(option);


							//根据窗口的大小变动图表
							window.addEventListener('resize', () => {
								creditdataChart8.resize();
							},false);
						}else{
							this.$message({
								message: data.msg,
								type: "warning",
								duration: 1500,
							})
						}
					});
				})
			},
		}
	};
</script>
<style lang="scss" scoped>
	// table
	.el-table:before{
		display: none;
	}
	.el-table:after{
		display: none;
	}
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #fff;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 6px 0;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				color: rgb(52, 171, 255);
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #fff;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: rgba(52, 171, 255,0.1);
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 6px 0;
				color: #fff;
				background: rgba(52, 171, 255,0.2);
				border-color: rgba(92,135,230,.3);
				border-width: 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #fff;
				background: none;
				border-color: rgba(92,135,230,.3);
				border-width: 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	.echarts1 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: 1 1 auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts1:hover {
			}
	.echarts2 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts2:hover {
			}
	.echarts3 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts3:hover {
			}
	.echarts4 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts4:hover {
			}
	.echarts5 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
			}
	.echarts5:hover {
			}
	.echarts6 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: 1 1 auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: 0;
				order: 6;
			}
	.echarts6:hover {
			}
	.echarts7 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: 0 0 auto;
				display: flex;
				width: 33.33%;
				transition: 0.3s;
				height: calc(40% - 50px);
				order: 3;
			}
	.echarts7:hover {
			}
	.echarts8 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: auto;
				display: flex;
				width: 33.33%;
				transition: 0.3s;
				height: calc(40% - 50px);
				order: 2;
			}
	.echarts8:hover {
			}
	.echarts9 {
				padding: 0;
				margin: 0;
				flex-direction: column;
				background: none;
				flex: 1 1 auto;
				display: flex;
				width: 100%;
				transition: 0.3s;
				height: calc(60% - 50px);
				order: 1;
			}
	.echarts9:hover {
			}
	#particles{
		background-repeat: no-repeat;
		z-index: 1;
		background-size: cover;
		width: 100%;
		position: absolute;
		background-position: 50% 50%;
		height: 100%;
	}
	::-webkit-scrollbar {
		display: none; /* 针对Webkit浏览器 */
	}
</style>

