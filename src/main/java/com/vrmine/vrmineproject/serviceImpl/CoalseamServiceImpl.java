package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Coalseam;
import com.vrmine.vrmineproject.mapper.CoalseamMapper;
import com.vrmine.vrmineproject.service.CoalseamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:24
 */
@Service
public class CoalseamServiceImpl implements CoalseamService {

    @Autowired
    private CoalseamMapper coalseamMapper;

    @Override
    public List<Coalseam> findAll() {
        return coalseamMapper.findAll();
    }

}
