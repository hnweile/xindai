<template>
	<div class="home-preview">




		<!-- 商品推荐 -->
		<div id="animate_recommenddaikuanxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">贷款信息推荐</span>
				<span class="recommend_subhead">{{'daikuanxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="daikuanxinxiRecommend.length" class="list list16 index-pv1">
				<div v-for="item,index in daikuanxinxiRecommend" :key="index"  @click="toDetail('daikuanxinxiDetail', item)" class="list-item animation-box">
					<div class="img">
						<img v-if="preHttp(item.fengmian)&&preHttp2(item.fengmian)" :src="item.fengmian" alt="" />
						<img v-else-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					</div>
					<div class="infoBox">
						<div class="info-left">
							<div class="name">{{item.daikuanmingcheng}}</div>
							<div class="time_item">
								<span class="icon iconfont icon-shijian21"></span>
								<span class="label">发布时间：</span>
								<span class="text">{{item.addtime.split(' ')[0]}}</span>
							</div>
							<div class="collect_item">
								<span class="icon iconfont icon-shoucang10"></span>
								<span class="label">收藏：</span>
								<span class="text">{{item.storeupnum}}</span>
							</div>
							<div class="view_item">
								<span class="icon iconfont icon-chakan9"></span>
								<span class="label">浏览次数：</span>
								<span class="text">{{item.clicknum}}</span>
							</div>
						</div>
						<div class="desc ql-snow ql-editor" v-html="item.jianjie"></div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('daikuanxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				daikuanxinxiRecommend: [],





			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},


			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommenddaikuanxinxi',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "daikuanxinxi/autoSort";
				data = {
					page: 1,
					limit: 8,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.daikuanxinxiRecommend = res.data.data.list;
					}
				});
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.recommend {
			padding: 30px 0 20px;
			margin: 0;
			background: url(http://codegen.caihongy.cn/20240921/ebc35c8acefe4345b647fbb80cf13e74.jpg) fixed no-repeat center top / cover,#fff;
			width: 100%;
			position: relative;
			.recommend_title_box {
				padding: 0 0 20px;
				margin: 0 0 60px;
				background: url(http://codegen.caihongy.cn/20240921/d1174ef38e674130b0bd28e07897ab45.png) no-repeat center bottom;
				width: 100%;
				position: relative;
				text-align: center;
				.recommend_title {
					margin: 0 10px 0 0;
					color: #333;
					background: none;
					width: auto;
					font-size: 26px;
					line-height: 40px;
					text-align: center;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					width: auto;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list16 {
				padding: 0;
				margin: 40px auto 0;
				color: #333;
				background: none;
				display: flex;
				width: 1200px;
				font-size: 14px;
				justify-content: space-between;
				flex-wrap: wrap;
				height: auto;
				.list-item {
					padding: 0;
					margin: 0 0 20px;
					background: #fff;
					display: flex;
					width: 49%;
					position: relative;
					height: auto;
					.img {
						border: 0px solid #e8d1ad;
						padding: 10px;
						overflow: hidden;
						background: none;
						width: 200px;
						height: 200px;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							height: 100%;
						}
					}
					.infoBox {
						padding: 10px 10px;
						overflow: hidden;
						flex: 1;
						display: flex;
						height: auto;
						.info-left {
							padding: 0;
							width: 100%;
							line-height: 24px;
							.name {
								padding: 0 10px;
								overflow: hidden;
								color: #333;
								white-space: nowrap;
								font-weight: 600;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
							}
							.price {
								padding: 0 10px;
								color: #f00;
								font-size: 16px;
								line-height: 2;
							}
							.time_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
								}
								.label {
								}
								.text {
								}
							}
							.publisher_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
								}
								.label {
								}
								.text {
								}
							}
							.like_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
								}
								.label {
								}
								.text {
								}
							}
							.collect_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
								}
								.label {
								}
								.text {
								}
							}
							.view_item {
								padding: 0 10px;
								display: inline-block;
								.icon {
									margin: 0 2px 0 0;
									display: none;
								}
								.label {
								}
								.text {
								}
							}
						}
						.desc {
							color: #666;
							flex: 1;
							display: none;
							font-size: 14px;
							line-height: 1.5;
						}
					}
				}
				.list-item:hover {
					cursor: pointer;
					background: #c7cfe180;
					.infoBox {
						.info-left {
							.name {
							}
							.price {
							}
							.time_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.publisher_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.like_item {
								.icon {
									color: #fff;
								}
								.label {
								}
								.text {
								}
							}
							.collect_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
							.view_item {
								.icon {
								}
								.label {
								}
								.text {
								}
							}
						}
						.desc {
							color: #fff;
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px calc((100% - 1200px)/2)  0 0;
				background: #475a8310;
				display: inline-block;
				width: auto;
				line-height: 32px;
				float: right;
				text-align: right;
				.text {
					color: #333;
					font-size: 15px;
				}
				.icon {
					color: #333;
					font-size: 15px;
				}
			}
		}
	}
</style>
