<style scoped>
  .demo-split {
    height: 600px;
    width: 100%;
    border: 1px solid #dcdee2;
  }

  .split-pane {
    padding: 10px;
    height: 500px;
  }

  .demo-top {
    height: 50px;
    border: 1px solid #dcdee2;
    padding: 10px;
    width: 100%;
  }
</style>

<template>
  <div class="demo-split">
    <div class="demo-top">
      <b>当前井下共[{{dataCount}}]人</b>
      <div style="float: right;">
        <Input search enter-button="查询" placeholder="请输入姓名" @on-search="searchData">
        <span slot="prepend">关键字：</span>
        </Input>
      </div>
    </div>
    <Split v-model="split1" class="split-pane">
      <div slot="left" class="split-pane">
        <Scroll height="470">
          <div v-for="checked in checkData" :key="checked">
            <Button size="large" style="border:none;" @click="changeTable(checked)">{{checked}}</Button>
          </div>
        </Scroll>
      </div>

      <div slot="right" class="split-pane">
        <Modal v-model="showDialog" :z-index="111111" title="人员定位历史数据" draggable scrollable footer-hide width="1000px">
          <historical-track-data v-if="showDialog" :xxxData="xxxData"></historical-track-data>
        </Modal>
        <Table height="420" size="small" :data="tableData" :columns="columns1" border @on-row-dblclick="rowClick">
          <template slot-scope="{ row }" slot="operating">
            <Button type="primary" style="margin-right: 5px" @click="openModal(row)">历史轨迹</Button>
          </template>
        </Table>
        <div style="margin: 10px;overflow: hidden">
          <div style="margin: 10px;overflow: hidden">
            <div style="float: right;">
              <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changePage" show-elevator></Page>
            </div>
          </div>
        </div>
      </div>
    </Split>
  </div>
</template>

<script>
  import historicalTrackData from "./historicalTrackData.vue";
  export default {
    data() {
      return {
        split1: 0.2,
        pageSize: 10,
        dataCount: 0,
        showDialog: false,
        xxxData: null,
        tableData: [],
        checkData: ["全部分站"],
        personId: [],
        personRealTimeData: [],
        columns1: [
          {
            title: "序号",
            type: "index",
            align: "center",
            fixed: 'left',
            width: 70
          },
          {
            title: "员工编号",
            key: "STAFF_CODE",
            align: "center",
            width: 100
          },
          {
            title: "姓名",
            key: "STAFF_NAME",
            align: "center",
            fixed: 'left',
            width: 100
          },
          {
            title: "部门",
            key: "DEPARTMENT",
            align: "center",
            width: 100
          },
          {
            title: "工种",
            key: "WORK_TYPE",
            align: "center",
            width: 100
          },
          {
            title: "职务",
            key: "DUTY",
            align: "center",
            width: 100
          },
          {
            title: "工作区域",
            key: "BS_LOC_AREA",
            align: "center",
            width: 100
          },
          {
            title: "所在分站位置",
            key: "STATION_NAME",
            align: "center",
            width: 110
          },
          {
            title: "所在分站时间",
            key: "IN_TIME",
            align: "center",
            width: 170
          },
          {
            title: "入矿时间",
            key: "ENTER_WELL_TIME",
            align: "center",
            width: 170
          },
          {
            title: "状态",
            key: "PERSONNEL_STATUS",
            align: "center",
            width: 100
          },
          {
            title: "操作",
            slot: "operating",
            align: "center",
            width: 100
          }
        ],
        checked: false
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
        default: () => { }
      },
      // URL路径中的参数，如：/posts/#{id}/comments
      pathParams: {
        type: Object,
        default: () => { }
      },
      // Query参数
      options: {
        type: Object,
        default: function () {
          return { params: {} };
        }
      }
    },
    mounted() {
      this.getpersonRealTimeList();
    },
    methods: {
      getpersonRealTimeList: function (stationName, name) {
        this.$axios({
          url: "api/sensor&person-info/personRealTimeList-info",
          method: "get",
          params: {
            station: stationName,
            name: name
          }
        })
          .then(res => {
            this.personRealTimeData = res.data.rows;
            // console.log("date"+this.personRealTimeData)
            this.dataCount = res.data.rows.length;
            this.personRealTimeData.forEach(a => {
              var current = a.STATION_NAME;
              if (this.checkData.indexOf(current) === -1) {
                this.checkData.push(current);
              }
            });
            if (this.dataCount < this.pageSize) {
              this.tableData = this.personRealTimeData;
            } else {
              this.tableData = this.personRealTimeData.slice(0, this.pageSize);
            }
          })
          .catch(error => { });
      },
      changeTable(checked) {
        if (checked == "全部分站") {
          this.getpersonRealTimeList();
        } else {
          this.getpersonRealTimeList(checked);
        }
      },

      changePage(index) {
        var _start = (index - 1) * this.pageSize;
        var _end = index * this.pageSize;
        this.tableData = this.personRealTimeData.slice(_start, _end);
      },
      searchData(value) {
        // console.log(value);
        this.getpersonRealTimeList(null, value);
        // console.log(this.tableData);
      },
      rowClick(row) {
        // console.log(row.STATION_NAME);
        this.$axios("api/persorientatio/Installationsite/" + row.STATION_NAME)
          .then(res => {
            this.personId = res.data.data;
            // console.log(this.personId.id)
            // console.log(3*100000+this.personId.id)
            var getByIdEntity = this.viewer.entities.getById(
              3 * 100000 + this.personId.id
            ); //tableType*100000
            // console.log(getByIdEntity)
            this.viewer.trackedEntity = getByIdEntity;
          })
          .catch(error => { });
      },
      openModal(row) {
        this.showDialog = true;
        this.xxxData = row.STAFF_NAME;
        // console.log(this.xxxData);
      },
    },
    components: {
      historicalTrackData
    }
  };
</script>