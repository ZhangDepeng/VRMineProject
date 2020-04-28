<style scoped>
  .demo{
        height: 550px;
        width: 100%;
        border: 1px solid #dcdee2;
    }
    .demo-top{
      height:50px;
      padding: 10px;
      width: 100%;
    }
    
</style>

<template>
  <div class="demo">
    <div class="demo-top">
      <b>一周报警信息共[{{dataCount}}]条</b>
    </div>
    <div class="demo-table">
      <Table height="450" :data="tableData" :columns="columns1" border></Table>
      <div style="margin: 10px;overflow: hidden">
        <div style="float: right;">
          <Page
            :total="dataCount"
            :page-size="pageSize"
            show-total
            @on-change="changePage"
            show-elevator
          ></Page>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      personAlarmData: [],
      pageSize:10,
      dataCount: 0,
      tableData:[],
      columns1: [
        {
          title: "序号",
          type: 'index',
        },
        {
          title: "员工编号",
          key: "STAFF_CODE"
        },
        {
          title: "姓名",
          key: "STAFF_NAME"
        },
        {
          title: "部门",
          key: "DEPARTMENT"
        },
        {
          title: "工种",
          key: "WORK_TYPE"
        },
        {
          title: "职务",
          key: "DUTY"
        },
        {
          title: "工作区域",
          key: "AREA_NAME"
        },
        {
          title: "所在分站名称",
          key: "STATION_NAME"
        },
        {
          title: "所在分站时间",
          key: "IN_STATION_TIME"
        },
        {
          title: "入矿时间",
          key: "IN_MINE_TIME"
        },
        {
          title: "状态",
          key: "STATUS"
        },
        {
          title: "操作",
          key: "operating"
        }
      ]
    };
  },
  created() {
    this.getPersonAlarm();
  },

  methods: {
    getPersonAlarm: function() {
    this.$axios("api/sensor&person-info/personAlarmList-info")
        .then(res => {
          this.personAlarmData = res.data.rows;
          this.dataCount = res.data.rows.length;
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
	            this.tableData = this.phonerData.slice(_start,_end);
            },
  }
};
</script>

