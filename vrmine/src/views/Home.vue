<style scoped>
  .layout {
    border: 1px solid #d7dde4;
    padding: 5;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
  }
  .layout-logo {
    width: 200px;
    height: 50px;
    color: #fff;
    font-size: 20px;
    line-height: 30px;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav {
    width: 1000px;
    margin: 0 auto;
    margin-right: 120px;
  }
  .adminset {
    margin-right: 30px;
  }
  .ivu-layout-header {
    padding: 0 !important;
  }
  </style>
  <template>
    <div class="layout">
      <Layout>
        <Header :style="{background: '#2d8cf0'}">
          <Menu theme="primary" mode="horizontal" active-name="1">
            <div class="layout-logo">智慧型煤炭矿山系统</div>
            <div class="layout-nav">
              <Submenu name="1">
                <template slot="title">
                  <Icon type="md-contact" />人员定位
                </template>
                <MenuGroup title="人员定位">
                  <Button size="large" style="border:none;" long @click="showModal = true">全部分站</Button>
                    <Modal
                        v-model="showModal"
                        title="人员定位"
                        draggable
                        scrollable
                        footer-hide
                        width= 1000px
                      >
                      <personPosition :viewer="viewer" v-if="showModal"/>
                    </Modal>
                  <Button size="large" style="border:none;" long @click="showHistoricalData = true">历史数据查询</Button>
                    <Modal
                        v-model="showHistoricalData"
                        title="历史数据查询"
                        draggable
                        scrollable
                        footer-hide
                        width= 1000px
                      >
                      <historicalData :viewer="viewer" v-if="showHistoricalData"/>
                    </Modal>
                  <Button size="large" style="border:none;" long @click="showPersonAlarm = true">人员定位报警</Button>
                    <Modal
                        v-model="showPersonAlarm"
                        title="人员定位报警"
                        draggable
                        scrollable
                        footer-hide
                        width= 1000px
                      >
                      <personAlarm v-if="showPersonAlarm"/>
                    </Modal>
                  </MenuGroup>
              </Submenu>
              <Submenu name="2">
                <template slot="title">
                  <Icon type="ios-camera" />监测监控
                </template>
                <MenuGroup title="监测监控">
                  <Button size="samll" 
                  style="text-align:left;border:none;" 
                  long  
                  @click="showCurrent = true">
                  实时监测数据</Button>
                  <Modal width="900px" height="500px" v-model="showCurrent" title="实时监测数据" draggable  scrollable >
                    <showmoniData />                  
                  </Modal>
                
                  <Button
                  size="samll"
                  style="text-align:left;border:none;"
                  long
                  @click="showAlarm = true"
                  >实时报警数据</Button>
                  <Modal
                  width="600px"
                  v-model="showAlarm"
                  title="实时报警数据"
                  draggable 
                  scrollable                                                                               
                  >
                    <showbaojingData />              
                  </Modal>

               <Dropdown placement="bottom-start">
                 <DropdownItem >
                    分类监测数据
                    <Icon type="ios-arrow-forward"></Icon>
                 </DropdownItem>
                <DropdownMenu slot="list">                
                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showET = true"
                    >二氧化碳</Button>
                    <Modal
                    width="600px"
                    v-model="showET"
                    title="分类监测数据"
                    draggable 
                    scrollable                                                               
                    >
                      <showfenleiData :Type="co2"/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showF = true"
                    >风速</Button>
                    <Modal
                    width="600px"
                    v-model="showF"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                            
                    >
                      <showfenleiData :Type='fengsu'/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showFY = true"
                    >负压</Button>
                    <Modal
                    width="600px"
                    v-model="showFY"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                            
                    >
                      <showfenleiData :Type='fuya'/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showJW = true"
                    >甲烷</Button>
                    <Modal
                    width="600px"
                    v-model="showJW"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                            
                    >
                      <showfenleiData :Type='jiawan'/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showSW = true"
                    >水位</Button>
                    <Modal
                    width="600px"
                    v-model="showSW"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                             
                    >
                      <showfenleiData :Type='shuiwei'/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showWD = true"
                    >温度</Button>
                    <Modal
                    width="600px"
                    v-model="showWD"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                            
                    >
                      <showfenleiData :Type='wendu'/>                    
                    </Modal>

                    <Button
                    size="samll"
                    style="text-align:left;border:none;"
                    long
                    @click="showYT = true"
                    >一氧化碳</Button>
                    <Modal
                    width="600px"
                    v-model="showYT"
                    title="分类监测数据"
                    draggable 
                    scrollable 
                    footer-hide                                            
                    >
                      <showfenleiData :Type="co"/>                    
                    </Modal>
                </DropdownMenu>
                </Dropdown> 
                </MenuGroup>
              </Submenu>
              <Submenu name="3">
                <template slot="title">
                  <Icon type="md-body" />应急救援
                </template>
                <MenuGroup title="应急救援">
                  <MenuItem name="3-1">历史事故回访</MenuItem>
                  <MenuItem name="3-2">救援方案管理</MenuItem>
                  <MenuItem name="3-3">巷道淹没分析</MenuItem>
                  <MenuItem name="3-4">事故模拟</MenuItem>
                  <MenuItem name="3-5">钻探救援分析</MenuItem>
                </MenuGroup>
              </Submenu>
              <Submenu name="4">
                <template slot="title">
                  <Icon type="logo-codepen" />设备管理
                </template>
                <MenuGroup title="设备管理">
                  <Button size="large" style="border:none;" long @click="showEuipmentModal = true">机电设备管理</Button>
                    <Modal
                        v-model="showEuipmentModal"
                        title="机电设备管理"
                        draggable
                        scrollable
                        footer-hide
                        width= 800px
                        :z-index="1"
                      >
                      <euipmentModal :viewer="viewer" v-if="showEuipmentModal"/>
                    </Modal>
                  <Button size="large" style="border:none;" long @click="showPhoneModal = true">井下电话管理</Button>
                    <Modal
                        v-model="showPhoneModal"
                        title="井下电话管理"
                        draggable
                        scrollable
                        footer-hide
                        width= 800px
                      >
                      <phoneModal :viewer="viewer" v-if="showPhoneModal"/>
                    </Modal>
                  </MenuGroup>
  
              </Submenu>
              <Submenu name="5">
                <template slot="title">
                  <Icon type="ios-send-outline" />避灾路径
                </template>
                <MenuGroup title="避灾路径">
                  <MenuItem name="5-1">最短路径分析</MenuItem>
                </MenuGroup>
              </Submenu>
              <Submenu name="6">
                <template slot="title">
                  <Icon type="ios-cog-outline" />工具
                </template>
                <MenuGroup title="工具">
                  <MenuItem name="6-1">浏览录制</MenuItem>
                  <MenuItem name="6-2">井下通风系统</MenuItem>
                  <Button
                  size="large"
                  style="text-align:left;border:none;"
                  long
                  @click="measureTool = true"
                  >量测工具</Button>
                  <Modal
                  width="400px"
                  v-model="measureTool"
                  title="量测工具"
                  draggable 
                  scrollable 
                  footer-hide                                             
                  >
                  <measurePanel />                  
                  </Modal>         
                  <MenuItem name="6-7">坐标转换</MenuItem>
                  <MenuItem name="6-8">属性查询</MenuItem>
                  <Button
                  size="large"
                  style="text-align:left;border:none;"
                  long
                  @click="namequery = true"
                  >名称查询</Button>
                  <Modal
                  width="400px"
                  v-model="namequery"
                  title="名称查询"
                  draggable 
                  scrollable 
                  footer-hide                                             
                  >
                  <nameQuery />                  
                  </Modal>
                  <Button
                  size="large"
                  style="text-align:left;border:none;"
                  long
                  @click="coorquery = true"
                  >坐标查询</Button>
                  <Modal
                  width="400px"
                  v-model="coorquery"
                  title="坐标查询"
                  draggable 
                  scrollable 
                  footer-hide                                             
                  >
                  <coordinateQuery />                  
                  </Modal>
                  <MenuItem name="6-11">网站链接</MenuItem>
                  <MenuItem name="6-12">煤层等高线10米</MenuItem>
                  <MenuItem name="6-13">煤层等高线20米</MenuItem>
                </MenuGroup>
              </Submenu>
              <Submenu name="7">
                <template slot="title">
                  <Icon type="ios-book-outline" />系统帮助
                </template>
                <MenuGroup title="系统帮助">
                  <MenuItem name="7-1">快捷方式</MenuItem>
                  <MenuItem name="7-2"><span @click="openHelpView()">帮助</span></MenuItem>
                </MenuGroup>
              </Submenu>
            </div>
            <div class="adminSet">
              <Submenu name="8">
                <template slot="title">
                  <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
                </template>
                <MenuGroup title="管理员">
                  <Button size="large" style="text-align:left;border:none;" long @click="showManage = true">账户中心</Button>
                  <Modal width="600px" v-model="showManage" title="账户中心" draggable scrollable footer-hide >
                    <showManage/>
                  </Modal>
                  <MenuItem class="exit" to="/">退出</MenuItem>
                </MenuGroup>
              </Submenu>
            </div>
          </Menu>
        </Header>
        <Layout >
          <router-view></router-view>
          <Sider hide-trigger :style="{minWidth:'250px',maxWidth:'250px',width:'250px',background: '#fff'}">
            图层管理页面（todo）
            <layerManger :viewer="viewer" />
          </Sider>
          <Layout :style="{padding: '5px 5px 5px'}">
            <Content id="mapcontent" :style="{maxHeight: '750px', background: '#fff'} ">
              <cesiumContainer @viewer="showViewer" />
            </Content>
          </Layout>
        </Layout>
        <Layout :style="{padding: '5px 5px 5px' }">
          <Content :style="{padding: '5px', minHeight: '100px', background: '#fff'}">输出窗口</Content>
        </Layout>
        <span style="font-family:arial;text-align:center;">Copyright &copy;2019 519</span>
      </Layout>
    </div>
  </template>
  

  <script>
  import showManage from "../views/admin/manager.vue";
  import cesiumContainer from "../components/cesiumViewer/cesiumTunnel.vue";
  import personPosition from "../components/person/personPosition.vue";
  import personAlarm from "../components/person/personAlarm.vue";
  import historicalData from "../components/person/historicalData.vue";
  import euipmentModal from "../components/Equipment/Euipment.vue";
  import phoneModal from "../components/Equipment/phone.vue";
  import measurePanel from "../components/tools/measurePanel.vue";
  import showmoniData from "../components/monitorData/moniData.vue";
  import showfenleiData from "../components/monitorData/fenleiData.vue";
  import showbaojingData from "../components/monitorData/alarmData.vue";
  import coordinateQuery from "../components/tools/coordinateQuery.vue";
  import nameQuery from "../components/tools/nameQuery.vue";
  import layerManger from "./layermanger.vue";
  // import cesiumContainer from "../components/cesiumViewer/czml.vue";
  export default {
   
    data() {
      return {
        showManage: false,
        showModal: false,
        showPersonAlarm: false,
        showHistoricalData: false,
        showEuipmentModal: false,
        showPhoneModal :false,
        showCurrent: false,
        showAlarm: false,
        showET: false,
        showF: false,
        showFY: false,
        showJW: false,
        showSW: false,
        showWD: false,
        showYT: false,      
        measureTool: false,
        namequery:false,
        coorquery:false,        
        viewer: null,
        Type:'',
        co2:"CO2",
        fengsu:"风速",
        fuya:"负压",
        jiawan:"甲烷",
        shuiwei:"水位",
        wendu:"温度",
        co:"CO",
        authorized:"",
        mineid:"",
        iseditable:"",
        
       

      };
    },
    components: {
      showManage,
      cesiumContainer,
      personPosition,
      personAlarm,
      historicalData,
      euipmentModal,
      phoneModal,
      showmoniData,
      showbaojingData,
      showfenleiData,
      measurePanel,    
      coordinateQuery,
      nameQuery,
      layerManger
    },
    mounted:{
      
    },
    created(){
      
        //获取用户参数，通过判断参数来进行用户认证
    //  this.authorized = this.$utils.getUrlKey("authorized");
     // if (this.authorized==null) {//缺失参数，拒绝访问
   //       alert("缺失参数");    
    //      this.$router.replace({path: "/404"});
   //   } else if(this.authorized=="user"||"admin"){  //参数正确，继而获取其他参数
    //      this.mineid = this.$utils.getUrlKey("mineid");
      //    this.iseditable = this.$utils.getUrlKey("iseditable");         
     //   }else{//参数错误，拒绝访问
     //     alert("参数错误");    
     //     this.$router.replace({path: "/404"});
      //  }                       
    },

    methods: {
      
      measureCancel() {
        this.$Message.info("退出");
      },
  
    
      showViewer(viewer) {
        this.viewer = viewer;
        
      },
      openHelpView() {
        let routeUrl = this.$router.resolve({ path: "/help" })
        window.open(routeUrl.href, '_blank');
    }
    }
  };
  </script>
  