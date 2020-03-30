package com.vrmine.vrmineproject.serviceImpl;

import com.vrmine.vrmineproject.entity.Workingsurface;
import com.vrmine.vrmineproject.mapper.WorkingsurfaceMapper;
import com.vrmine.vrmineproject.service.WorkingsurfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zdp
 * @data 2019/12/14-22:25
 */
@Service
public class WorkingsurfaceServiceImpl implements WorkingsurfaceService {
    @Autowired
    private WorkingsurfaceMapper workingsurfaceMapper;

    @Override
    public List<Workingsurface> findAll() {
        return workingsurfaceMapper.findAll();
    }

    @Override
    public Workingsurface findByname(String workingSurfaceName) {
        return workingsurfaceMapper.findByname(workingSurfaceName);
    }
}
