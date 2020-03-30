package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Persorientatio;
import com.vrmine.vrmineproject.mapper.PersorientatioMapper;
import com.vrmine.vrmineproject.service.PersorientatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/10-21:02
 */
@Service
public class PersorientatioServiceImpl implements PersorientatioService {
    @Autowired
    private PersorientatioMapper persorientatioMapper;

    @Override
    public List<Persorientatio> findAll() {
        return persorientatioMapper.findAll();
    }

    @Override
    public Persorientatio findByname(String Name) {
        return persorientatioMapper.findByname(Name);
    }

    @Override
    public Persorientatio findByid(int ID) {
        return persorientatioMapper.findByid(ID);
    }

    @Override
    public int update(Persorientatio persorientatio) { return persorientatioMapper.update(persorientatio); }
}
