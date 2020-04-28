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

    @Override /*修改人：pgl*/
    public List<Tunnel> findAll(String mineTable) {return tunnelMapper.findAll(mineTable);}
    @Override  /*修改人：pgl*/
    public List<Tunnel> findByName(String tunnelName) {return tunnelMapper.findByName(tunnelName);}
    @Override
    public List<Tunnel> findTunnelName() {return tunnelMapper.findTunnelName();}
}
