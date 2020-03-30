package com.vrmine.vrmineproject.service;

import com.vrmine.vrmineproject.entity.Admin;
import com.vrmine.vrmineproject.entity.Persorientatio;
import java.util.List;

/**
 * @author zdp
 * @data 2019/12/10-20:59
 */
public interface PersorientatioService {
    public List<Persorientatio> findAll();
    public Persorientatio findByname(String Name);
    public Persorientatio findByid(int ID);
    public int update(Persorientatio persorientatio);
}