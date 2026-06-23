const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot3913hmjw/",
            name: "springboot3913hmjw",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot3913hmjw/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Hadoop的信贷风险评估的数据可视化分析与预测系统的设计与实现"
        } 
    }
}
export default base
