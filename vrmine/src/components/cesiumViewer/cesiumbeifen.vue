<template>
  <div id="cesiumContainer" class="fullSize"></div>
</template>

<script>
import Cesium from "cesium/Cesium.js"; //from 中 cesium 指向的是vue.config.js中 alias对象中的别名
import CesiumNavigation from "cesium-navigation-es6";
export default {
  render: mapcesium => mapcesium(cesiumContainer),
  mounted() {
    Cesium.Ion.defaultAccessToken =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkMTE1NzAzZi0wYjZjLTQ2NGUtYWU1MS1iOWJkNDA1Mzg3MTgiLCJpZCI6MTYyOTUsInNjb3BlcyI6WyJhc3IiLCJnYyJdLCJpYXQiOjE1NzAxMDI2ODl9.FXBVovN5TZRrwtehWu-ACOQS05yxGa1tRRtBgxP6M9g";

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

    //设置视角为中国
    var china = Cesium.Rectangle.fromDegrees(100, 10, 120, 70);
    Cesium.Camera.DEFAULT_VIEW_RECTANGLE = china;

    //加载viewer（Cesium.Viewer类）实现基本框架的加载
    var viewer = new Cesium.Viewer("cesiumContainer", {
      terrainProvider: worldTerrain,
      imageryProvider: guge,
      baseLayerPicker: false,
      navigationHelpButton: false,
      fullscreenButton: false,
      infoBox: false, // 是否显示点击要素之后显示的信息
      requestRenderMode: true, // 启用请求渲染模式
      scene3DOnly: false, // 每个几何实例将只能以3D渲染以节省GPU内存
      sceneMode: 3, // 初始场景模式 1 2D模式 2 2D循环模式 3 3D模式  Cesium.SceneMode
      fullscreenElement: document.body, // 全屏时渲染的HTML元素 暂时没发现用处
    });

    viewer.scene.debugShowFramesPerSecond = false;

    // //加载天地图影像
    // viewer.imageryLayers.addImageryProvider(
    //   new Cesium.WebMapTileServiceImageryProvider({
    //     url:
    //       "https://t0.tianditu.com/img_w/wmts?service=wmts&request=GetTile&version=1.0.0&LAYER=img&tileMatrixSet=w&TileMatrix={TileMatrix}&TileRow={TileRow}&TileCol={TileCol}&style=default&format=tiles&tk=609504e641593efa13d050f34b11255c",
    //     layer: "tdtBasicLayer",
    //     style: "default",
    //     format: "image/jpeg",
    //     tileMatrixSetID: "GoogleMapsCompatible",
    //     credit: new Cesium.Credit("天地图全球影像服务"),
    //     maximumLevel: 18,
    //     show: false
    //   })
    // );

    // //全球影像中文注记服务
    // viewer.imageryLayers.addImageryProvider(
    //   new Cesium.WebMapTileServiceImageryProvider({
    //     url:
    //       "https://t0.tianditu.com/cia_w/wmts?service=wmts&request=GetTile&version=1.0.0&LAYER=cia&tileMatrixSet=w&TileMatrix={TileMatrix}&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg&tk=93d1fdef41f93d2211deed6d22780c48",
    //     layer: "tdtAnnoLayer",
    //     style: "default",
    //     format: "image/jpeg",
    //     tileMatrixSetID: "GoogleMapsCompatible",
    //     show: false
    //   })
    // );

    // var scene = viewer.scene;
    // //位置
    // var position = Cesium.Cartesian3.fromDegrees(116.080591, 39.919141, 0);
    // var hpRoll = new Cesium.HeadingPitchRoll();
    // var fixedFrameTransforms = Cesium.Transforms.localFrameToFixedFrameGenerator(
    //   "north",
    //   "west"
    // );
    // //添加模型
    // var carPrimitive = scene.primitives.add(
    //   Cesium.Model.fromGltf({
    //     url: "model3D/CesiumBalloon/CesiumBalloon.glb",
    //     modelMatrix: Cesium.Transforms.headingPitchRollToFixedFrame(
    //       position,
    //       hpRoll,
    //       Cesium.Ellipsoid.WGS84,
    //       fixedFrameTransforms
    //     ),
    //     minimumPixelSize: 128,
    //      maximumScale : 2000
    //   })

    // );
    // console.log("hahah1");
    // viewer.camera.flyTo({
    //   destination: Cesium.Cartesian3.fromDegrees(116.080591, 39.919141, 10)
    // });

    var scene = viewer.scene;
    var model;

    var modelUrl = 'model3D/CesiumBalloon/model2.gltf';

    var height = 0.0;
    var heading = 0.0,
      pitch = 0.0,
      roll = 0.0;
    var hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);

    var origin = Cesium.Cartesian3.fromDegrees(113.245096,27.60272, height);
    var modelMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(
      origin,
      hpr
    );

    scene.primitives.removeAll(); // Remove previous model
    model = scene.primitives.add(
      Cesium.Model.fromGltf({
        url: modelUrl,
        modelMatrix: modelMatrix
      })
    );

    console.log("Model is loading...");

    model.readyPromise
      .then(function(model) {
        console.log("Model loading complete.");

        // Zoom to model
        var camera = viewer.camera;
        var controller = scene.screenSpaceCameraController;
        var r =
          2.0 * Math.max(model.boundingSphere.radius, camera.frustum.near);
        controller.minimumZoomDistance = r * 0.5;

        var center = Cesium.Matrix4.multiplyByPoint(
          model.modelMatrix,
          model.boundingSphere.center,
          new Cesium.Cartesian3()
        );
        var heading = Cesium.Math.toRadians(230.0);
        var pitch = Cesium.Math.toRadians(-20.0);
        camera.lookAt(
          center,
          new Cesium.HeadingPitchRange(heading, pitch, r * 2.0)
        );
      })
      .otherwise(function(error) {
        console.error(error);
      });

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

    //设置视角定位到某个地点
    viewer.camera.setView({
      //经纬度和高度
      destination: Cesium.Cartesian3.fromDegrees(113.245096,27.60272, 1500.0),
      orientation: {
        //左右摆头
        heading: Cesium.Math.toRadians(0.0),
        //上下抬头
        pitch: Cesium.Math.toRadians(-45),
        //球的倾斜角度
        roll: 0.0
      }
    });

    // 设置光照效果，默认false
    viewer.scene.globe.enableLighting = false;

    // 地形备选数据
    var ellipsoidProvider = new Cesium.EllipsoidTerrainProvider();

    var vrTheWorldProvider = new Cesium.VRTheWorldTerrainProvider({
      url: "http://www.vr-theworld.com/vr-theworld/tiles1.0.0/73/",
      credit: "Terrain data courtesy VT MÄK"
    });
  }
};
</script>

<style>
/* 加上scoped即表示只作用于该组件 */
@import url(../../../node_modules/cesium/Build/Cesium/Widgets/widgets.css);
.fullSize {
  top: 0;
  left: 0;
  border: none;
  height: 750px;
}
.cesium-viewer-animationContainer,  /* 左下角动画控件 */
.cesium-viewer-timelineContainer,   /* 时间线 */
.cesium-viewer-bottom               /* logo信息 */
 {
  display: none;
}
</style>
