package com.vrmine.vrmineproject.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdp
 * @data 2019/12/18-16:22
 */
@FeignClient(name = "sensor-dataList-api", url = "${cumtb-info.sensor-dataList}")
public interface SensorDataListAPI {
    @GetMapping()
    ResponseEntity<String> getdataList(
            @RequestParam("_search") String _search,
            @RequestParam("nd") String nd,
            @RequestParam("rows") Integer rows,
            @RequestParam("page") Integer page,
            @RequestParam("sidx") String sidx,
            @RequestParam("sord") String sord,
            @RequestParam("queryJson") String queryJson
    );
}
