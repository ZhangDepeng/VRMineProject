package com.vrmine.vrmineproject.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdp
 * @data 2019/12/18-19:58
 */
@FeignClient(name = "person-alarmList-api", url = "${cumtb-info.person-alarmList}")
public interface PersonAlarmListAPI {
    @GetMapping()
    ResponseEntity<String> getPersonAlarmList(
            @RequestParam("page") Integer page,
            @RequestParam("queryJson") String queryJson,
            @RequestParam("_search") String _search,
            @RequestParam("nd") String nd,
            @RequestParam("rows") Integer rows,
            @RequestParam("sidx") String sidx,
            @RequestParam("sord") String sord
    );
}
