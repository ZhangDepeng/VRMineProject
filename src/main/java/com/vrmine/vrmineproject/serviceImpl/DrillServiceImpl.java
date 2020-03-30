package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Drill;
import com.vrmine.vrmineproject.mapper.DrillMapper;
import com.vrmine.vrmineproject.service.DrillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:25
 */
@Service
public class DrillServiceImpl implements DrillService {

    @Autowired
    private DrillMapper drillMapper;

    @Override
    public List<Drill> findAll() {
        return drillMapper.findAll();
    }

    @Override
    public Drill findByname(String drillName) {
        return drillMapper.findByname(drillName);
    }
}
