package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Workingsurface;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:21
 */
public interface WorkingsurfaceService {
    public List<Workingsurface> findAll();
    public Workingsurface findByname(String workingsurfaceName);
}
