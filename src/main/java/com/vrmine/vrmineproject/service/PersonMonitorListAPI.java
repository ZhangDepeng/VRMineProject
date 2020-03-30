package com.vrmine.vrmineproject.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zdp
 * @data 2019/12/18-20:04
 */
@FeignClient(name = "person-monitorList-api", url = "${cumtb-info.person-monitorList}")
public interface PersonMonitorListAPI {
    @GetMapping()
    ResponseEntity<String> getPersonMonitorList(
            @RequestParam("queryJson") String queryJson,
            @RequestParam("_search") String _search,
            @RequestParam("nd") String nd,
            @RequestParam("rows") String rows,
            @RequestParam("page") String page,
            @RequestParam("sidx") String sidx,
            @RequestParam("sord") String sord,
            @RequestParam("status") String status

    );
}
