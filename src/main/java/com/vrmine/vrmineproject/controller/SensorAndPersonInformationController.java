package com.vrmine.vrmineproject.controller;

import com.vrmine.vrmineproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zdp
 * @data 2019/12/17-11:58
 */
@RestController
@RequestMapping("/sensor&person-info")
public class SensorAndPersonInformationController {
    @Autowired
    SensorCurrentListAPI sensorCurrentListAPI;

    @Autowired
    SensorDataListAPI sensorDataListAPI;

    @Autowired
    SensorAlarmListAPI sensorAlarmListAPI;

    @Autowired
    PersonAlarmListAPI personAlarmListAPI;

    @Autowired
    PersonDataListAPI personDataListAPI;

    @Autowired
    PersonMonitorListAPI personMonitorListAPI;

    @Autowired
    PersonRealtimeListAPI personRealtimeListAPI;

    @GetMapping(value = "/sensorCurrentList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getSensorCurrentList(
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1567750807513") String nd,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "sidx", defaultValue = "SENSOR_NAME") String sidx,
            @RequestParam(name = "sord", defaultValue = "asc") String sord,
            @RequestParam(name = "MINE_ID",defaultValue = "430481010327",value = "MINE_ID") String MINE_ID,
            @RequestParam(name = "MEASURE_ID",defaultValue = "",value = "MEASURE_ID") String MEASURE_ID,
            @RequestParam(name = "start_TIME",defaultValue = "",value = "start_TIME") String start_TIME,
            @RequestParam(name = "end_TIME",defaultValue = "",value = "end_TIME") String end_TIME)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("MINE_ID", MINE_ID);
        queryJson.put("MEASURE_ID", MEASURE_ID);
        queryJson.put("start_TIME", start_TIME);
        queryJson.put("end_TIME", end_TIME);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> htmlStr = sensorCurrentListAPI.getSensorCurrentList(_search,nd,rows,page,sidx,sord,jsonObject.toString());
        System.out.println("单煤矿实时监测数据"+localDateTime);
        return htmlStr;
    }



    @GetMapping(value = "/sensorDataList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getdataList(
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1567582847839") String nd,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "sidx", defaultValue = "TIME") String sidx,
            @RequestParam(name = "sord", defaultValue = "desc") String sord,
            @RequestParam(name = "MINE_ID",defaultValue = "430481010327",value = "MINE_ID") String MINE_ID,
            @RequestParam(name = "MEASURE_ID",defaultValue = "",value = "MEASURE_ID") String MEASURE_ID,
            @RequestParam(name = "start_TIME",defaultValue = "2019-12-26",value = "start_TIME") String start_TIME,
            @RequestParam(name = "end_TIME",defaultValue = "2020-1-06",value = "end_TIME") String end_TIME)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("MINE_ID", MINE_ID);
        queryJson.put("MEASURE_ID", MEASURE_ID);
        queryJson.put("start_TIME", start_TIME);
        queryJson.put("end_TIME", end_TIME);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> htmlStr = sensorDataListAPI.getdataList(_search,nd,rows,page,sidx,sord,jsonObject.toString());
        System.out.println("单传感器日监测数据"+localDateTime);
        return htmlStr;
    }


    @GetMapping(value = "/sensorAlarmList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getSensorAlarmList(
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1567753546863") String nd,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "sidx", defaultValue = "START_TIME") String sidx,
            @RequestParam(name = "sord", defaultValue = "desc") String sord,
            @RequestParam(name = "start_TIME",defaultValue = "2019-10-06",value = "start_TIME") String start_TIME,
            @RequestParam(name = "end_TIME",defaultValue = "2020-1-06",value = "end_TIME") String end_TIME,
            @RequestParam(name = "MINE_ID",defaultValue = "430481010327",value = "MINE_ID") String MINE_ID,
            @RequestParam(name = "MEASURE_TYPE",defaultValue = "",value = "MEASURE_TYPE") String MEASURE_TYPE)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("start_TIME", start_TIME);
        queryJson.put("end_TIME", end_TIME);
        queryJson.put("MINE_ID", MINE_ID);
        queryJson.put("MEASURE_TYPE", MEASURE_TYPE);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> htmlStr = sensorAlarmListAPI.getSensorAlarmList(_search,nd,rows,page,sidx,sord,jsonObject.toString());
        System.out.println("单煤矿实时报警数据"+localDateTime);
        return htmlStr;
    }

    @GetMapping(value = "/personAlarmList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getPersonAlarmList(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "queryJson", defaultValue = "{\"mine\":\"430481010327\",\"start\":\"2019-12-20\",\"end\":\"2019-12-27\"}") String queryJson,
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1567666939530") String nd,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "sidx", defaultValue = "MINE_ID ASC,STAFF_ID ASC,START_TIME") String sidx,
            @RequestParam(name = "sord", defaultValue = "desc") String sord){
        LocalDateTime localDateTime = LocalDateTime.now();
        ResponseEntity<String> htmlStr = personAlarmListAPI.getPersonAlarmList(page,queryJson,_search,nd,rows,sidx,sord);
        System.out.println("人员定位单煤矿实时报警数据"+localDateTime);
        return htmlStr;
    }

    @GetMapping(value = "/personDataList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getPersonDataList(
            @RequestParam(name = "status", defaultValue = "1") Integer status,
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1567666514261") String nd,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "sidx", defaultValue = "MINE_ID ASC,IN_TIME desc,STAFF_ID") String sidx,
            @RequestParam(name = "sord", defaultValue = "asc") String sord,
            @RequestParam(name = "mine",defaultValue = "430481010327",value = "mine") String mine,
            @RequestParam(name = "start",defaultValue = "2019-12-20",value = "start") String start,
            @RequestParam(name = "end",defaultValue = "2019-12-27",value = "end") String end,
            @RequestParam(name = "name",defaultValue = "",value = "name") String name
    ){
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("mine", mine);
        queryJson.put("start", start);
        queryJson.put("end", end);
        queryJson.put("name", name);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> htmlStr = personDataListAPI.getPersonDataList(status,_search,nd,rows,page,sidx,sord,jsonObject.toString());
        System.out.println("人员定位单煤矿井下人员查询列表"+localDateTime);
        return htmlStr;
    }

    @GetMapping(value = "/personMonitorList-info",produces = { "application/json;charset=UTF-8" })
    ResponseEntity<String> getPersonMonitorList(
            @RequestParam(name = "mine",defaultValue = "430481010327",value = "mine") String mine,
            @RequestParam(name = "start",defaultValue = "2019-12-20",value = "start") String start,
            @RequestParam(name = "end",defaultValue = "2019-12-27",value = "end") String end,
            @RequestParam(name = "name",defaultValue = "",value = "name") String name,
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "nd", defaultValue = "1569403104246") String nd,
            @RequestParam(name = "rows", defaultValue = "1000 ") String rows,
            @RequestParam(name = "page", defaultValue = "1") String page,
            @RequestParam(name = "sidx", defaultValue = "IN_TIME DESC NULLS LAST,PERSONNEL_STATUS") String sidx,
            @RequestParam(name = "sord", defaultValue = "desc") String sord,
            @RequestParam(name = "status", defaultValue = "0") String status
    ){
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("mine", mine);
        queryJson.put("start", start);
        queryJson.put("end", end);
        queryJson.put("name", name);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> htmlStr = personMonitorListAPI.getPersonMonitorList(jsonObject.toString(),_search,nd,rows,page,sidx,sord,status);
        System.out.println("人员定位单个人员活动历史列表"+localDateTime);
        return htmlStr;
    }

    @RequestMapping(value = "/personRealTimeList-info", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    ResponseEntity<String> getPersonRealTimeList(
            @RequestParam(name = "status", defaultValue = "0") Integer status,
            @RequestParam(name = "_search", defaultValue = "false") String _search,
            @RequestParam(name = "rows", defaultValue = "300") Integer rows,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "sidx", defaultValue = "MINE_ID ASC,IN_TIME desc,STAFF_ID") String sidx,
            @RequestParam(name = "sord", defaultValue = "asc") String sord,
            @RequestParam(name = "name", defaultValue = "",value = "name") String name,
            @RequestParam(name = "mine", defaultValue = "430481010327",value = "mine") String mine,
            @RequestParam(name = "station", defaultValue = "", value = "station") String station) {

        LocalDateTime localDateTime = LocalDateTime.now();
        long times = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String randomNum = String.valueOf(times);

        Map<String, String> randomNd =new HashMap<String, String>();
        randomNd.put("nd",randomNum);
        JSONObject realNd = JSONObject.fromObject(randomNd);
        System.out.println(realNd);
        Map<String, String> queryJson = new HashMap<String, String>();
        queryJson.put("name", name);
        queryJson.put("mine", mine);
        queryJson.put("station", station);
        JSONObject jsonObject = JSONObject.fromObject(queryJson);
        ResponseEntity<String> responseEntity = personRealtimeListAPI.getPersonRealTimeList(status, _search, realNd.toString(), rows, page, sidx, sord, jsonObject.toString());
        System.out.println("单煤矿井下人员实时数据"+"---"+localDateTime+"---"+randomNum);
        return responseEntity;
    }
}
