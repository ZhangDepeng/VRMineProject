package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Tunnel;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/6-21:51
 */
public interface TunnelService {
    public List<Tunnel> findAll(String mineTable);/*修改人：pgl*/
    public List<Tunnel> findByName(String tunnelName);/*修改人：pgl*/
    public List<Tunnel> findTunnelName();
}
