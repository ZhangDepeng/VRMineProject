<style scoped>
</style>
<template>
  <div id = "toolbar">
    <Tabs size="small" >
      <TabPane label="标绘">
        <ButtonGroup>
            <Button style="width: 60px;" size="large" icon="ios-pin" title="标记地点" @click="toggleClick('addMarker')"></Button>
            <Button style="width: 60px;" size="large" icon="ios-pulse" title="绘线" @click="toggleClick('addPolyline')"></Button>
            <Button style="width: 60px;" size="large" icon="ios-grid" title="绘多边形" @click="toggleClick('addPolygon')"></Button>
            <Button style="width: 60px;" size="large" icon="md-sync" title="清除" @click="toggleClick('remove')"></Button>
        </ButtonGroup>
      </TabPane>
      <TabPane label="基本量测">
        <ButtonGroup>
            <Button style="width: 60px;" size="large" icon="ios-pin" title="距离量测" ></Button>
            <Button style="width: 60px;" size="large" icon="ios-pulse" title="面积量测"></Button>
            <Button style="width: 60px;" size="large" icon="ios-grid" title="高度量测"></Button>
            <Button style="width: 60px;" size="large" icon="md-sync" title="清除"></Button>
        </ButtonGroup>
      </TabPane>
    </Tabs>
  </div>
</template>

<script>
export default {
  name:"markerPanel",
  data(){
    return {}
  },
  components:{},
  props:{},
  computed:{},
  mounted(){},
  methods:{
    toggleClick(event){
        this[event]()
      },
      addPolyline(){
        this.plCollection.add(this.polylineNode)
      },
      addPolygon(){
        this.pgCollection.add(this.polygonNode)
      },
      addMarker(){
        createCursor(this.viewer,'点击地图添加标记')
        this.$refs.marker.isDrawing=true
      },
      remove(){
        this.plCollection.remove()
        this.pgCollection.remove()
        this.$refs.marker.removeAll()
      },
      export(){
      }
  },

};
</script>

