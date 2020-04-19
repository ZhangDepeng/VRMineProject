<style scoped>
.phone{
        height: 600px;
        width: 100%;
        border: 1px solid #dcdee2;
    }
</style>

<template>
      <div class="phone">
        <Table height="550" :data="tableData" :columns="columns1" border @on-row-dblclick="rowClick"></Table>
        <div style="margin: 10px;overflow: hidden">
          <div style="float: right;">
            <Page :total="dataCount" :page-size="pageSize" show-total  @on-change="changePage" show-elevator></Page>
          </div>
        </div>
      </div>
</template>
<script src="public\Build\Cesium\Cesium.js"></script>
<script>
// import Cesium from "cesium/Cesium.js";
export default {
  data() {
    return {
      sensorData: [],
      pageSize:10,
      dataCount: 0,
      tableData:[],
      columns1: [
        {
          title: "ID",
          key: "sensorID"
        },
        {
          title: "名称",
          key: "sensorName"
        },
        {
          title: "X坐标",
          key: "posX"
        },
        {
          title: "Y坐标",
          key: "posY"
        },
        {
          title: "Z坐标",
          key: "posZ"
        },
        {
          title: "安装地点",
          key: "position"
        }
      ],
    };
  },
  props: {
    // API URL
    url: {
      type: String,
      default: ""
    },
    viewer: {
      type: Object,
      default: () => {}
    },
    // URL路径中的参数，如：/posts/#{id}/comments
    pathParams: {
      type: Object,
      default: () => {}
    },
    // Query参数
    options: {
      type: Object,
      default: function() {
        return { params: {} };
      }
    }
  },
  mounted() {
    this.getSensor();
  },
  methods: {
    
    getSensor: function() {
      this.$axios("/api/sensor/电话")
        .then(res => {
          this.phoneData = res.data.data;
          this.dataCount = res.data.data.length;
          if (this.dataCount < this.pageSize) {
            this.tableData = this.phoneData;
          } else {
            this.tableData = this.phoneData.slice(0, this.pageSize);
          };
        })
        .catch(error => {});
    },
    changePage (index) {
                var _start = (index-1) * this.pageSize;
	            var _end = index * this.pageSize;
	            this.tableData = this.phoneData.slice(_start,_end);
            },
    rowClick(row) {
      //  console.log(row.equipmentID);
      var getByIdEntity=this.viewer.entities.getById(4*100000+row.sensorID);//tableType*100000
      // console.log(getByIdEntity)
      this.viewer.trackedEntity = getByIdEntity;
    
  }
  },
  
  
};
</script>

