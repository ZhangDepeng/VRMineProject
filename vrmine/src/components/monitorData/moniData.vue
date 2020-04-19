<style scoped>
.demo-split {
  height: 700px;
  border: 1px solid #dcdee2;
}
.demo-split-pane {
  padding: 10px;
}
.demo-split-pane.no-padding {
  height: 700px;
  padding: 0;
}
.paging1 {
  float: right;
  margin-top: 10px;
  margin-bottom: 10px;
}
.paging2 {
  float: right;
  margin-top: 10px;
  margin-bottom: 10px;
}
</style>

<!---->

<template>
  <div>
    <Table :columns="columns1" :data="data1" highlight-row @on-current-change="handleRowChange" >
      <template slot-scope="{ }" slot="action">
        <Button type="primary" @click="ShowModal" >历史监测数据</Button>
        <Modal
          v-model="showModal"
          title="历史监测数据"
          width="1000px"
          height="500px"  
          footer-hide
          scrollable 
          :transfer="false"
        >
          <div class="demo-split">
            <Split v-model="split3">
              <div slot="right" class="demo-split-pane no-padding">
                <Split v-model="split4" mode="vertical">
                  <div slot="top" class="demo-split-pane">
                    <div style="width:600px;height:400px" ref="myChart"></div>
                  </div>
                  <div slot="bottom" class="demo-split-pane">
                    <Tag type="border">自定义查询：起始时间——结束时间</Tag> 
                    <Date-picker                    
                      type="datetimerange"                     
                      :value="time"            
                      placeholder="选择日期和时间"
                      format="yyyy-MM-dd HH:mm"
                      style="width: 300px"
                      @on-change="handleChange"
                    ></Date-picker>                                            
                    <br />
                   
                    <Tag type="border">请选择绘图周期：</Tag>
                    <Button @click="dataAnddraw(1)" style="margin-left:20px;">时</Button>
                    <Button @click="dataAnddraw(2)" style="margin-left:20px;">天</Button>
                    <Button @click="dataAnddraw(3)" style="margin-left:20px;">周</Button>
                    <Button @click="dataAnddraw(4)" style="margin-left:20px;">月</Button>
                  </div>
                </Split>
              </div>
              <div slot="left" class="demo-split-pane">
                <Table border :columns="columns2" :data="data2"></Table>
                <!-- 分页 -->
                <Page
                  :total="dataCount3"
                  :page-size="pageSize2"
                  show-total
                  class="paging2"
                  @on-change="changepage2"
                ></Page>
              </div>
            </Split>
          </div>
        </Modal>
      </template>
    </Table>
    <!-- 分页 -->
    <Page
      :total="dataCount1"
      :page-size="pageSize1"
      show-total
      class="paging1"
      @on-change="changepage1"
    ></Page>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      showModal: false,
      split3: 0.35,
      split4: 0.8,
      sensorid:'',//传感器id      
      time:[],//时间选择器显示的时间
      Params:[],//调接口的参数     
      test1: [],
      dataCount1: 0,
      pageSize1: 8,
      test2: [],
      test3:[],
      dataCount2: 0,
      dataCount3:0,
      pageSize2: 10,
      chartTime:[],
      chartValue:[],
    

      columns1: [
        {
          title: "传感器ID",
          key: "SENSOR_ID",
          width: 100,
          align: "center"
        },
        {
          title: "位置",
          key: "LOCATION",
          width: 150,
          align: "center"
        },
        {
          title: "传感器类型",
          key: "SENSOR_NAME",
          width: 150,
          align: "center"
        },
        {
          title: "当前值",
          key: "DATA_VALUE",
          width: 80,
          align: "center"
        },
        {
          title: "数据获取时间",
          key: "UPDATE_TIME",
          width: 250,
          align: "center"
        },
        {
          title: "操作",
          slot: "action",
          width: 150,
          align: "center"
        }
      ],
      data1: [],

      columns2: [
        {
          title: "序号",           
          width: 100,
          align: "center",
          render: (h, params) => {
              return h("span", params.index + (this.pageNum2 - 1) * this.pageSize2 + 1);
          },          
        },
        {
          title: "时间",
          key: "TIME",
          align: "center"
        },
        {
          title: "检测值",
          key: "STR_DATA_VALUE",
          width: 100,
          align: "center"
        }
      ],
      data2: [], 
    };
  },

  mounted() {
    this.defaultdata(1);//显示默认时间和图表   
  },

  created() {    
    this.getSCRTdata();     
  },

  methods: {
    
    //请求默认时间的数据
    defaultdata(n){
      this.cuttotime(n);
      this.getSSdaydata();
    },

    //显示默认弹窗
    ShowModal() {
      this.$nextTick(() => {
        //  执行echarts方法
        this.drawchart();
      });

      this.showModal = true;
    },
    
    //点击历史监测按钮
    handleRowChange(currentRow){
        this.sensorid=currentRow.SENSOR_ID;//获取当前传感器id                                               
    },


    ////////调单煤矿实时监控接口数据
    getSCRTdata() {
      //单煤矿实时数据
      axios
        .get("/api/sensor&person-info/sensorCurrentList-info")
        .then(res => {
          this.test1 = res.data.rows;        
          this.dataCount1 = this.test1.length;
          
          // 初始化显示，小于每页显示条数，全显，大于每页显示条数，取前每页条数显示
          if (this.test1.length < this.pageSize1) {
            this.data1 = this.test1;
          } else {
            this.data1 = this.test1.slice(0, this.pageSize1);
          }
        })
        .catch(error => {});
    },
    //表格切换页面
    changepage1(index) {
      var _start = (index - 1) * this.pageSize1;
      var _end = index * this.pageSize1;
      this.data1 = this.test1.slice(_start, _end);
    },

   
    ///////调某一传感器历史数据接口
    getSSdaydata() {      
      axios
         .get("/api/sensor&person-info/sensorDataList-info",{   
           params:{
                start_TIME: this.time[0],
                end_TIME: this.time[1],
                SENSOR_ID: this.sensorid                     
           }      
        })       
        .then(res => {
          this.test2 = res.data.rows;
          this.dataCount2 = this.test2.length; 
                  
          //每20条数据取一条
          var n=0;
          for(var i=0;i<this.dataCount2;i+=20){
          this.test3[n]=this.test2[i];
          n++;          
          }                             
          this.dataCount3=this.test3.length;//表格显示的数据条数 
          
          //Echarts图表显示的数据
          for(var i=0;i<this.dataCount3;i++){              
              this.chartValue[i] = this.test3[i].STR_DATA_VALUE;
          } 
           for(var i=0;i<this.dataCount3;i+=4){
              this.chartTime[i] = this.test3[i].TIME;             
          } 
                                         
          // 初始化显示，小于每页显示条数，全显；大于每页显示条数，取前每页条数显示
          if (this.test3.length < this.pageSize2) {
            this.data2 = this.test3;
          } else {
            this.data2 = this.test3.slice(0, this.pageSize2);
          }
        })
        .catch(error => {});
    },
    //表格切换页面
    changepage2(index) {
      this.pageNum2=index;
      var _start = (index - 1) * this.pageSize2;
      var _end = index * this.pageSize2;
      this.data2 = this.test3.slice(_start, _end);
    },

 ///点击查询更新data和图表
    dataAnddraw(n){     
      this.cuttotime(n);         
      this.getSSdaydata();
     this.drawchart();            
    },

    //切换时间
    cuttotime(n) {
      var end = new Date();     
      var y = end.getFullYear(); // 获取当前年份
      var m = end.getMonth() + 1; // 获取当前月份(0-11,0代表1月所以要加1);
      m = m < 10 ? ('0' + m) : m;
      var d = end.getDate(); // 获取当前日（1-31）
      d = d < 10 ? ('0' + d) : d;       
      var h = end.getHours();
      h = h < 10 ? ('0' + h) : h;
      var minute = end.getMinutes();
      minute = minute < 10 ? ('0' + minute) : minute;      
      this.time[1] =  y + '-' + m + '-' + d + ' ' + h + ':' + minute;
      
      switch (n) {
        case 1:
          var start0 = new Date();
          start0.setTime(start0.getTime() - 3600 * 1000 );     
          var y = start0.getFullYear(); // 获取当前年份
          var m = start0.getMonth() + 1; // 获取当前月份(0-11,0代表1月所以要加1);
          m = m < 10 ? ('0' + m) : m;
          var d = start0.getDate(); // 获取当前日（1-31）
          d = d < 10 ? ('0' + d) : d;       
          var h = start0.getHours();
          h = h < 10 ? ('0' + h) : h;
          var minute = start0.getMinutes();
          minute = minute < 10 ? ('0' + minute) : minute;              
          this.time[0] =  y + '-' + m + '-' + d + ' ' + h + ':' + minute;                                                
          break;

        case 2:
          var start0 = new Date();
          start0.setTime(start0.getTime() - 3600 * 1000 * 24);     
          var y = start0.getFullYear(); // 获取当前年份
          var m = start0.getMonth() + 1; // 获取当前月份(0-11,0代表1月所以要加1);
          m = m < 10 ? ('0' + m) : m;
          var d = start0.getDate(); // 获取当前日（1-31）
          d = d < 10 ? ('0' + d) : d;       
          var h = start0.getHours();
          h = h < 10 ? ('0' + h) : h;
          var minute = start0.getMinutes();
          minute = minute < 10 ? ('0' + minute) : minute;                
          this.time[0] =  y + '-' + m + '-' + d + ' ' + h + ':' + minute;                                         
          break;

        case 3:         
          var start0 = new Date();
          start0.setTime(start0.getTime() - 3600 * 1000 * 24 * 7);     
          var y = start0.getFullYear(); // 获取当前年份
          var m = start0.getMonth() + 1; // 获取当前月份(0-11,0代表1月所以要加1);
          m = m < 10 ? ('0' + m) : m;
          var d = start0.getDate(); // 获取当前日（1-31）
          d = d < 10 ? ('0' + d) : d;       
          var h = start0.getHours();
          h = h < 10 ? ('0' + h) : h;
          var minute = start0.getMinutes();
          minute = minute < 10 ? ('0' + minute) : minute;             
          this.time[0] =  y + '-' + m + '-' + d + ' ' + h + ':' + minute;          
          break;

        case 4:
          var start0 = new Date();
          start0.setTime(start0.getTime() - 3600 * 1000 * 24 * 30);     
          var y = start0.getFullYear(); // 获取当前年份
          var m = start0.getMonth() + 1; // 获取当前月份(0-11,0代表1月所以要加1);
          m = m < 10 ? ('0' + m) : m;
          var d = start0.getDate(); // 获取当前日（1-31）
          d = d < 10 ? ('0' + d) : d;       
          var h = start0.getHours();
          h = h < 10 ? ('0' + h) : h;
          var minute = start0.getMinutes();
          minute = minute < 10 ? ('0' + minute) : minute;    
          this.time[0] =  y + '-' + m + '-' + d + ' ' + h + ':' + minute;                  
          break;
        default:
      }
    },

    handleChange(time){
      this.time = time;
    },
    
   

    //显示不同时间范围对应图表
    drawchart() {

      //初始化echarts实例
      var myChart = this.$echarts.init(this.$refs.myChart);
   

        //图表的设置
        var option = {
          textStyle: {
            color: "rgba(0,0,0,1)"
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              saveAsImage: {
                type: "png", //	设置图片格式 png或者'jpeg
                name: "监测数据图表",
                backgroundColor: "#FFF",
                excludeComponents: ["toolbox"],
                show: true,
                title: "保存图片"
              },
              dataView: { show: true, readOnly: false },
              magicType: { show: true, type: ["line", "bar"] }
            }
          },
          xAxis: {
            type: "category",
            boundaryGap: false,
            data:this.chartTime,
          
          },
          yAxis: {
            type: "value"           
          },
          series: [
            {
              data: this.chartValue,
              type: "line",             
            }
          ]
        };
     

      myChart.setOption(option); //设置
      option
    }
  }
};
</script>

