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




<template>
  <div>          
    <Table border :columns="columns" :data="data"></Table> 
     <!-- 分页 -->
      <div>
      <Page
      :total="dataCount"
      :page-size="pageSize"
      show-total
      class="paging"
      @on-change="changepage"
      ></Page>
      </div>      
  </div>              
</template>
                   

<script>
import axios from "axios";

export default{
  data() {
    return {
      
      test: [],
      dataCount: "",
      pageSize: 6,

      columns: [
        {
          
          title: "序号",           
          width: 100,
          align: "center",
          render: (h, params) => {
              return h("span", params.index + (this.pageNum - 1) * this.pageSize + 1);
          },
          
        },
        {
          title: "时间",
          key: "UPDATE_TIME",
          align: "center"
        },
         {
          title: "类型",
          key: "SENSOR_NAME",
          align: "center"
        },
        {
          title: "检测值",
          key: "STR_DATA_VALUE",
          width: 100,
          align: "center"
        }
        
      ],
      data: [],

    } 
  },  
  props: {
    
    Type: {
      type: String,
      default: () => { }
    },    
    
  },
  
  mounted() {
    
  },

  created() {    
    
    this.getSCCAdata(this.Type);      
  },

  methods: {
    
    ////////调单煤矿实时数据
    getSCCAdata(type) {      
      axios
        .get("/api/sensor&person-info/sensorCurrentList-info",{
          params:{               
                SENSOR_NAME: type                     
           }      
        })
        .then(res => {
          this.test= res.data.rows;        
          this.dataCount = this.test.length;  
              
          // 初始化显示，小于每页显示条数，全显，大于每页显示条数，取前每页条数显示
          if (this.test.length < this.pageSize) {
            this.data = this.test;
          } else {
            this.data = this.test.slice(0, this.pageSize);
          }
        })
        .catch(error => {});
    },
    //表格切换页面
    changepage(index) {
      this.pageNum=index;
      var _start = (index - 1) * this.pageSize;
      var _end = index * this.pageSize;
      this.data = this.test.slice(_start, _end);
    }
    
  },
    
    


}
  

</script>