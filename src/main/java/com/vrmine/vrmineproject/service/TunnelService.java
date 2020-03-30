package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Tunnel;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/6-21:51
 */
public interface TunnelService {
    public List<Tunnel> findAll();
    public List<Tunnel> findByName();
    public List<Tunnel> findTunnelName();
}
