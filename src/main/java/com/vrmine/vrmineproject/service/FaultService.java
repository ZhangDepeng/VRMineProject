package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Fault;
import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:21
 */
public interface FaultService {

    public List<Fault> findAll();
    public Fault findByname(String faultName);
}
