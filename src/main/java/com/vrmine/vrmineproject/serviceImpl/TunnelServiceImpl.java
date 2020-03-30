package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Tunnel;
import com.vrmine.vrmineproject.mapper.TunnelMapper;
import com.vrmine.vrmineproject.service.TunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/6-21:55
 */
@Service
public class TunnelServiceImpl implements TunnelService{
    @Autowired
    private TunnelMapper tunnelMapper;

    @Override
    public List<Tunnel> findAll() {return tunnelMapper.findAll();}
    @Override
    public List<Tunnel> findByName() {return tunnelMapper.findByName();}
    @Override
    public List<Tunnel> findTunnelName() {return tunnelMapper.findTunnelName();}
}
