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
    <Table border :columns="columns" :data="data">    
     
    </Table>   
  </div>              
</template>
        
         
       
      
    
  


<script>
import axios from "axios";

export default{
  data() {
    return {
      test: [],
      dataCount: "",
      pageSize: 5,

      columns: [
        {
          title: "",
          key: "",
          width: 100,
          align: "center"
        }
      ],
      data: [],

    } 
  },   
 
  mounted() {
    
  },

  created() {    
    this.getSCCAdata();      
  },

  methods: {
    
  },
    
    

    ////////调单煤矿实时报警数据
    getSCCAdata() {
      axios
        .get("/api/sensor&person-info/sensorAlarmList-info")
        .then(res => {
          this.test= res.data.rows;        
          this.dataCount = this.test.length;     
        })
        .catch(error => {});
    },
    

}
  

</script>

