package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Drill;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:20
 */
public interface DrillService {
    public List<Drill> findAll();
    public Drill findByname(String drillName);
}
