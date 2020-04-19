<style scoped>
  .demo-split {
    height: 550px;
    width: 100%;
    border: 1px solid #dcdee2;
  }

  .demo-split-pane {
    padding: 20px;
    height: 100%;
  }

</style>

<template>
  <div class="demo-split">
    <Split v-model="split1" class="demo-split-pane">
      <div slot="left" class="demo-split-pane">
        <div v-for="checkb in checkData" :key="checkb.id">
          <Button size="large" style="border:none;" @click="changeTable(checkb.value)">{{checkb.value}}</Button>
        </div>
      </div>

      <div slot="right" class="demo-split-pane">
        <Table height="500" :data="equipmentData" :columns="columns1" align="center" border highlight-row
          @on-row-dblclick="rowClick">
          <template slot-scope="{ row }" slot="operating">
            <Button type="primary" style="margin-right: 5px" @click="openModal(row)">详情</Button>
          </template>
        </Table>
        <Modal v-model="showDialog" :z-index="111111" title="设备详情" draggable width="500px">
          <eachEuipment v-if="showDialog" :xxxData="xxxData"></eachEuipment>
          <div slot="footer"></div>
        </Modal>
      </div>
    </Split>
  </div>
</template>
<script src="public\Build\Cesium\Cesium.js"></script>
<script>
  // import Cesium from "cesium/Cesium.js";
  import eachEuipment from "./eachEuipment.vue"
  export default {
    data() {
      return {
        split1: 0.2,
        equipmentData: [],
        showDialog: false,
        xxxData: null,
        mineid:"",
        iseditable:"",
        checkData: [
          {
            id: "1",
            value: "机电设备列表"
          },
          {
            id: "2",
            value: "水泵"
          },
          {
            id: "3",
            value: "提升机"
          },
          {
            id: "4",
            value: "电动机"
          },
          {
            id: "5",
            value: "齿轮箱"
          },
          {
            id: "6",
            value: "电力变压器"
          },
          {
            id: "7",
            value: "干式变压器"
          },
          {
            id: "8",
            value: "开关柜"
          },
          {
            id: "9",
            value: "切换柜"
          },
          {
            id: "10",
            value: "润滑站"
          },
          {
            id: "11",
            value: "通风机"
          },
          {
            id: "12",
            value: "稳压器"
          },
          {
            id: "13",
            value: "压缩机"
          },
          {
            id: "14",
            value: "液压泵"
          }
        ],
        checked: false,
        columns1: [
          {
            title: "ID",
            key: "equipmentID"
          },
          {
            title: "名称",
            key: "equipmentName"
          },
          {
            title: "所属设备组名称",
            key: "equipmentType"
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
            title: "操作",
            slot: "operating"
          }
        ]
      };
    },
    components: {
      eachEuipment
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
      this.getEquipment();
    },
    created(){
      //获取用户参数
       this.iseditable=this.$parent.$parent.$parent.$parent.$parent.$parent.$parent.$parent.iseditable;
       this.mineid=this.$parent.$parent.$parent.$parent.$parent.$parent.$parent.$parent.mineid;
       
    },
    methods: {
      getEquipment: function () {
        this.$axios("api/equipment")
          .then(res => {
            this.equipmentData = res.data.data;
            // this.dataCount = res.data.data.length;
            // if (this.dataCount < this.pageSize) {
            //   this.tableData = this.equipmentData;
            // } else {
            //   this.tableData = this.equipmentData.slice(0, this.pageSize);
            // };
          })
          .catch(error => { });
      },
      getEquipmentType: function (equipmentType) {
        this.$axios("api/equipment/" + equipmentType)
          .then(res => {
            this.equipmentData = res.data.data;
          })
          .catch(error => { });
      },
      changeTable(check) {
        if (check == "机电设备列表") {
          this.getEquipment();
        } else {
          this.getEquipmentType(check);
        }
      },
      openModal(row) {
        this.showDialog = true;
        this.xxxData = row.equipmentID;
        // console.log(this.xxxData);
      },
      rowClick(row) {
        //  console.log(row.equipmentID);
        var getByIdEntity = this.viewer.entities.getById(1 * 100000 + row.equipmentID);//tableType*100000
        // console.log(getByIdEntity)
        this.viewer.zoomTo(getByIdEntity);
      }
    }
  };
</script>