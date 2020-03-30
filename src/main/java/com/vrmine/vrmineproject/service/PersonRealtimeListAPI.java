package com.vrmine.vrmineproject.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdp
 * @data 2019/12/18-20:03
 */
@FeignClient(name = "person-realTimeList-api", url = "${cumtb-info.person-realTimeList}")
public interface PersonRealtimeListAPI {
    @GetMapping()
    ResponseEntity<String> getPersonRealTimeList(
            @RequestParam("status") Integer status,
            @RequestParam("_search") String _search,
            @RequestParam("nd") String nd,
            @RequestParam("rows") Integer rows,
            @RequestParam("page") Integer page,
            @RequestParam("sidx") String sidx,
            @RequestParam("sord") String sord,
            @RequestParam("queryJson") String queryJson
    );
}
