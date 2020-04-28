package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Mine;
import com.vrmine.vrmineproject.mapper.MineMapper;
import com.vrmine.vrmineproject.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PGL
 * @data 2020/4/16 18:45
 **/
@Service
public class MineServiceImpl implements MineService {
    @Autowired
    private MineMapper mineMapper;

    @Override
    public List<Mine> findAll() {
        return mineMapper.findAll();
    }
}
