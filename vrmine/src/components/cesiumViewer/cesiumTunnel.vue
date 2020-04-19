<template>
  <div id="cesiumContainer" class="fullSize">
    <div id="toolbar"></div>
  </div>
</template>
<script src = "public\Build\Cesium\Cesium.js"></script>
<script>
//import Cesium from "cesium/Cesium.js"; //from 中 cesium 指向的是vue.config.js中 alias对象中的别名
import CesiumNavigation from "cesium-navigation-es6";
import axios from "axios";
export default {
  render: mapcesium => mapcesium(cesiumContainer),
  
  mounted() {
    let that = this;
    Cesium.Ion.defaultAccessToken =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkMTE1NzAzZi0wYjZjLTQ2NGUtYWU1MS1iOWJkNDA1Mzg3MTgiLCJpZCI6MTYyOTUsInNjb3BlcyI6WyJhc3IiLCJnYyJdLCJpYXQiOjE1NzAxMDI2ODl9.FXBVovN5TZRrwtehWu-ACOQS05yxGa1tRRtBgxP6M9g";
    function underground(t, i) {
      this._viewer = t;
      var n = Cesium.defaultValue(i, {});
      (this._depth = Cesium.defaultValue(n.depth, 500)),
        (this._alpha = Cesium.defaultValue(n.alpha, 0.5)),
        (this.enable = Cesium.defaultValue(n.enable, !1));
    }
    underground.prototype._updateImageryLayersAlpha = function(e) {
      for (
        var t = this._viewer.imageryLayers._layers, i = 0, a = t.length;
        i < a;
        i++
      )
        t[i].alpha = e;
    };
    underground.prototype._historyOpts = function() {
      var e = {};
      (e.alpha = Cesium.clone(
        this._viewer.imageryLayers._layers[0] &&
          this._viewer.imageryLayers._layers[0].alpha
      )),
        (e.highDynamicRange = Cesium.clone(
          this._viewer.scene.highDynamicRange
        )),
        (e.skyShow = Cesium.clone(this._viewer.scene.skyAtmosphere.show)),
        (e.skyBoxShow = Cesium.clone(this._viewer.scene.skyBox.show)),
        (e.depthTest = Cesium.clone(
          this._viewer.scene.globe.depthTestAgainstTerrain
        )),
        this._viewer.scene.globe._surface &&
          this._viewer.scene.globe._surface._tileProvider &&
          this._viewer.scene.globe._surface._tileProvider._renderState &&
          (e.blending = Cesium.clone(
            this._viewer.scene.globe._surface._tileProvider._renderState
              .blending
          )),
        (this._oldViewOpts = e);
    };
    underground.prototype.activate = function() {
      if (!this._enable) {
        (this._enable = !0),
          this._historyOpts(),
          this._updateImageryLayersAlpha(this._alpha);
        var e = this._viewer;
        (Cesium.ExpandByMars.underEarth.cullFace = !1),
          (Cesium.ExpandByMars.underEarth.enable = !0),
          (Cesium.ExpandByMars.underEarth.enableDepth = this._depth),
          (Cesium.ExpandByMars.underEarth.enableSkirt = !0),
          (e.scene.globe.depthTestAgainstTerrain = !0),
          (e.scene.highDynamicRange = !1),
          (e.scene.skyAtmosphere.show = !1),
          (e.scene.skyBox.show = !1),
          e.scene.globe._surface._tileProvider &&
            e.scene.globe._surface._tileProvider._renderState &&
            e.scene.globe._surface._tileProvider._renderState
              .blending; /*&& (e.scene.globe._surface._tileProvider._renderState.blending.enabled = !0,
        e.scene.globe._surface._tileProvider._renderState.blending.equationRgb = Cesium.BlendEquation.ADD,
        e.scene.globe._surface._tileProvider._renderState.blending.equationAlpha = Cesium.BlendEquation.ADD,
        e.scene.globe._surface._tileProvider._renderState.blending.functionSourceAlpha = Cesium.BlendFunction.ONE,
        e.scene.globe._surface._tileProvider._renderState.blending.functionSourceRgb = Cesium.BlendFunction.ONE,
        e.scene.globe._surface._tileProvider._renderState.blending.functionDestinationAlpha = Cesium.BlendFunction.ZERO,
        e.scene.globe._surface._tileProvider._renderState.blending.functionDestinationRgb = Cesium.BlendFunction.ZERO)*/
      }
    };
    underground.prototype.disable = function() {
      if (this._enable) {
        (this._enable = !1),
          this._updateImageryLayersAlpha(this._oldViewOpts.alpha);
        var e = this._viewer;
        (Cesium.ExpandByMars.underEarth.cullFace = void 0),
          (Cesium.ExpandByMars.underEarth.enable = !1),
          (Cesium.ExpandByMars.underEarth.enableDepth = 0),
          (Cesium.ExpandByMars.underEarth.enableSkirt = !1),
          (e.scene.globe.depthTestAgainstTerrain = this._oldViewOpts.depthTest),
          (e.scene.skyBox.show = this._oldViewOpts.skyBoxShow),
          (e.scene.highDynamicRange = this._oldViewOpts.highDynamicRange),
          (e.scene.skyAtmosphere.show = this._oldViewOpts.skyShow); /*,
        void 0 != this._oldViewOpts.blending && (e.scene.globe._surface._tileProvider._renderState.blending = this._oldViewOpts.blending)*/
      }
    };
    underground.prototype.destroy = function() {
      delete this._viewer,
        delete this._alpha,
        delete this._depth,
        delete this._enable,
        delete this._oldViewOpts;
    };

    //加载地形数据
    var worldTerrain = Cesium.createWorldTerrain({
      //设置水面效果
      requestWaterMask: true,
      requestVertexNormals: true
    });

    //加载谷歌影像
    var guge = new Cesium.UrlTemplateImageryProvider({
      url: "http://mt1.google.cn/vt/lyrs=s&hl=zh-CN&x={x}&y={y}&z={z}&s=Gali",
      tilingScheme: new Cesium.WebMercatorTilingScheme(),
      minimumLevel: 1,
      maximumLevel: 20
    });

    // //设置视角为中国
    // var china = Cesium.Rectangle.fromDegrees(100, 10, 120, 70);
    // Cesium.Camera.DEFAULT_VIEW_RECTANGLE = china;

    //加载viewer（Cesium.Viewer类）实现基本框架的加载
    var viewer = new Cesium.Viewer("cesiumContainer", {
      baseLayerPicker: false
    });

    //英文转中文  
      if (viewer.sceneModePicker) {
        viewer.sceneModePicker.viewModel.tooltip3D = "三维";
        viewer.sceneModePicker.viewModel.tooltip2D = "二维";
        viewer.sceneModePicker.viewModel.tooltipColumbusView = "哥伦布视图";
      }
      if (viewer.navigationHelpButton) {
      viewer.navigationHelpButton.viewModel.tooltip = "操作指南";
      var clickHelper = viewer.navigationHelpButton.container.getElementsByClassName("cesium-click-navigation-help")[0];
      var touchHelper = viewer.navigationHelpButton.container.getElementsByClassName("cesium-touch-navigation-help")[0];

      var button = viewer.navigationHelpButton.container.getElementsByClassName("cesium-navigation-button-right")[0];
      button.innerHTML = button.innerHTML.replace(">Touch", ">手势");
      button = viewer.navigationHelpButton.container.getElementsByClassName("cesium-navigation-button-left")[0];
      button.innerHTML = button.innerHTML.replace(">Mouse", ">鼠标");

      var click_help_pan = clickHelper.getElementsByClassName("cesium-navigation-help-pan")[0];
      click_help_pan.innerHTML = "平移";
        var click_help_pan_details = click_help_pan.parentNode.getElementsByClassName("cesium-navigation-help-details")[0];
      click_help_pan_details.innerHTML = "按下左键 + 拖动";

        var click_help_zoom = clickHelper.getElementsByClassName("cesium-navigation-help-zoom")[0];
      click_help_zoom.innerHTML = "缩放";
      click_help_zoom.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "滑动鼠标滚轮\n或\n按下右键+拖动";
      click_help_zoom.parentNode.getElementsByClassName("cesium-navigation-help-details")[1].innerHTML = "";

      var click_help_rotate = clickHelper.getElementsByClassName("cesium-navigation-help-rotate")[0];
      click_help_rotate.innerHTML = "旋转";
      click_help_rotate.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "按住滚轮拖动\n或\n按住Ctrl+鼠标右键拖动";
      click_help_rotate.parentNode.getElementsByClassName("cesium-navigation-help-details")[1].innerHTML = "";
      //触屏操作
      var touch_help_pan = touchHelper.getElementsByClassName("cesium-navigation-help-pan")[0];
      touch_help_pan.innerHTML = "平移";
      touch_help_pan.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "单指拖动";

      var touch_help_zoom = touchHelper.getElementsByClassName("cesium-navigation-help-zoom")[0];
      touch_help_zoom.innerHTML = "缩放";
      touch_help_zoom.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "双指捏合";

      var touch_help_tilt = touchHelper.getElementsByClassName("cesium-navigation-help-rotate")[0];
      touch_help_tilt.innerHTML = "俯仰";
      touch_help_tilt.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "双指同向拖动";

      var touch_help_rotate = touchHelper.getElementsByClassName("cesium-navigation-help-tilt")[0];
      touch_help_rotate.innerHTML = "旋转";
      touch_help_rotate.parentNode.getElementsByClassName("cesium-navigation-help-details")[0].innerHTML = "双指反向拖动";
                }



    //地下模式
    var ug = new underground(viewer, {
      depth: 5000,
      alpha: 0.6
    });
    ug.activate();

    this.$emit("viewer", viewer);
    window.viewer = viewer; //量测工具组件要用

    viewer.scene.debugShowFramesPerSecond = false;
    // 设置光照效果，默认false
    viewer.scene.globe.enableLighting = false;

    var options = {};

    // 用于在使用重置导航重置地图视图时设置默认视图控制。接受的值是Cesium.Cartographic 和Cesium.Rectangle.
    options.defaultResetView = Cesium.Cartographic.fromDegrees(
      113.245096,
      27.60272,
      1500.0
    );
    // 用于启用或禁用罗盘。true是启用罗盘，false是禁用罗盘。默认值为true。如果将选项设置为false，则罗盘将不会添加到地图中。
    options.enableCompass = true;
    // 用于启用或禁用缩放控件。true是启用，false是禁用。默认值为true。如果将选项设置为false，则缩放控件 将不会添加到地图中。
    options.enableZoomControls = true;
    // 用于启用或禁用距离图例。true是启用，false是禁用。默认值为true。如果将选项设置为false，距离图例将不会添加到地图中。
    options.enableDistanceLegend = true;
    // 用于启用或禁用指南针外环。true是启用，false是禁用。默认值为true。如果将选项设置为false，则该环将可见但无效。
    options.enableCompassOuterRing = true;

    CesiumNavigation(viewer, options);

    // //设置视角定位到某个地点
    // viewer.camera.setView({
    //   //经纬度和高度
    //   destination: Cesium.Cartesian3.fromDegrees(113.245096, 27.60272, 0.0),
    //   orientation: {
    //     //左右摆头
    //     heading: Cesium.Math.toRadians(0.0),
    //     //上下抬头
    //     pitch: Cesium.Math.toRadians(0),
    //     //球的倾斜角度
    //     roll: 0.0
    //   }
    // });
    var selected = {
      feature: undefined,
      originalColor: new Cesium.Color()
    };
    var selectedEntity = new Cesium.Entity();

    var clickHandler = viewer.screenSpaceEventHandler.getInputAction(
      Cesium.ScreenSpaceEventType.LEFT_CLICK
    );
    var clickDoubleHandler = viewer.screenSpaceEventHandler.getInputAction(
      Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK
    );
    //定义双击事件
    viewer.screenSpaceEventHandler.setInputAction(function(movement) {
      if (Cesium.defined(selected.feature)) {
        selected.feature.color = selected.originalColor;
        selected.feature = undefined;
      }
      // console.log(movement);
      // console.log(movement.position);

      if (!Cesium.defined(viewer.scene.pick(movement.position))) {
        clickHandler(movement);
        return;
      }
      var pickedFeature = viewer.scene.pick(movement.position).id;
      // console.log(pickedFeature);
      if (!Cesium.defined(pickedFeature)) {
        clickDoubleHandler(movement);
        return;
      }
      // Select the feature if it's not already selected
      if (selected.feature === pickedFeature) {
        return;
      }
      viewer.zoomTo(pickedFeature);
    }, Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK);

    //定义单击模型描述事件
    viewer.screenSpaceEventHandler.setInputAction(function onLeftClick(
      movement
    ) {
      if (Cesium.defined(selected.feature)) {
        selected.feature.color = selected.originalColor;
        selected.feature = undefined;
      }
      // console.log(movement);
      // console.log(movement.position);

      if (!Cesium.defined(viewer.scene.pick(movement.position))) {
        clickHandler(movement);
        return;
      }
      var pickedFeature = viewer.scene.pick(movement.position).id;
      if (!Cesium.defined(pickedFeature)) {
        clickHandler(movement);
        return;
      }
      // Select the feature if it's not already selected
      if (selected.feature === pickedFeature) {
        return;
      }

      var featureName = pickedFeature.name;
      var featureId = pickedFeature.id;
      if (featureId.toString().startsWith("3")) {
        featureId = featureId - 3 * 100000;
        viewer.selectedEntity = selectedEntity;
        selectedEntity.description =
          '<table class="cesium-infoBox-defaultTable"><tbody>';
        //拼接table
        that.$axios("api/persorientatio/ID/" + featureId).then(res => {
          let personData = res.data.data;
          selectedEntity.description =
            selectedEntity.description +
            "<tr><th>序号</th><td>" +
            personData.id +
            "</td></tr>" +
            "<tr><th>分站名称</th><td>" +
            personData.name +
            "</td></tr>" +
            "<tr><th>安装位置</th><td>" +
            personData.installationsite +
            "</td></tr>" +
            "<tr><th>模型名称</th><td>" +
            personData.modelName +
            "</td></tr>";
        });
        that
          .$axios({
            url: "api/sensor&person-info/personRealTimeList-info",
            method: "get",
            params: {
              station: featureName
            }
          })
          .then(res => {
            var dataCount = res.data.rows.length;
            selectedEntity.description =
              selectedEntity.description +
              "<tr><th>分站人数</th><td>" +
              dataCount +
              "人";
            ("</td></tr>");
          });
      } else if (featureId.toString().startsWith("4")) {
        featureId = featureId - 4 * 100000;
        viewer.selectedEntity = selectedEntity;
        selectedEntity.description =
          '<table class="cesium-infoBox-defaultTable"><tbody>';
        that.$axios("api/sensor/sensorID/" + featureId).then(res => {
          let sensorTableData = res.data.data;
          selectedEntity.description =
            selectedEntity.description +
            "<tr><th>传感器ID</th><td>" +
            sensorTableData.sensorID +
            "</td></tr>" +
            "<tr><th>传感器名称</th><td>" +
            sensorTableData.sensorName +
            "</td></tr>" +
            "<tr><th>安装位置</th><td>" +
            sensorTableData.position +
            "</td></tr>" +
            "<tr><th>传感器类型</th><td>" +
            sensorTableData.equipmentName +
            "</td></tr>" +
            "<tr><th>模型名称</th><td>" +
            sensorTableData.modelName;
          ("</td></tr>");
        });
        that
          .$axios({
            url: "api/sensor&person-info/sensorCurrentList-info",
            method: "get",
            params: {
              SENSOR_ID: featureId
            }
          })
          .then(res => {
            let sensorLenght = res.data.rows.length;

            if (sensorLenght == 1) {
              let sensorData = res.data.rows;

              selectedEntity.description =
                selectedEntity.description +
                "<tr><th>当前值</th><td>" +
                sensorData[0].DATA_VALUE +
                sensorData[0].UNIT;
              ("</td></tr>");
            }
          });
      } else if (featureId.toString().startsWith("1")) {
        featureId = featureId - 1 * 100000;
        viewer.selectedEntity = selectedEntity;
        selectedEntity.description =
          '<table class="cesium-infoBox-defaultTable"><tbody>';
        that.$axios("api/equipment/equipmentID/" + featureId).then(res => {
          let equipmentTableData = res.data.data;
          selectedEntity.description =
            selectedEntity.description +
            "<tr><th width:50px>设备ID</th><td>" +
            equipmentTableData.equipmentID +
            "</td></tr>" +
            "<tr><th>设备名称</th><td>" +
            equipmentTableData.equipmentName +
            "</td></tr>" +
            "<tr><th>安装位置</th><td>" +
            equipmentTableData.position +
            "</td></tr>" +
            "<tr><th>设备类型</th><td>" +
            equipmentTableData.equipmentType +
            "</td></tr>" +
            "<tr><th>模型名称</th><td>" +
            equipmentTableData.modelName +
            "</td></tr>" +
            "<tr><th>规格型号</th><td>" +
            equipmentTableData.type +
            "</td></tr>" +
            "<tr><th>制造厂家</th><td>" +
            equipmentTableData.manufacturer +
            "</td></tr>" +
            "<tr><th>出厂序号</th><td>" +
            equipmentTableData.equipmentNum +
            "</td></tr>" +
            "<tr><th>出厂日期</th><td>" +
            equipmentTableData.equipmentDate +
            "</td></tr>" +
            "<tr><th>技术参数</th><td>" +
            equipmentTableData.parameters +
            "</td></tr>";
        });
      }
    },
    Cesium.ScreenSpaceEventType.LEFT_CLICK);
  }
};
</script>

<style scoped>
/* 加上scoped即表示只作用于该组件 */
@import url(../../../node_modules/cesium/Build/Cesium/Widgets/widgets.css);

.fullSize {
  top: 0;
  left: 0;
  border: none;
  height: 750px;
}
</style>
