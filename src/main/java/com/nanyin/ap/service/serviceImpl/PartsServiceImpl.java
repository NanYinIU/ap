package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.PartsMapper;
import com.nanyin.ap.model.Parts;
import com.nanyin.ap.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nanyin
 * @time 下午3:28
 * @name PartsServiceImpl
 * @description
 */
@Service
public class PartsServiceImpl implements PartsService {
    @Autowired
    PartsMapper partsMapper;
    @Override
    public Parts findPartsById(int id) {
        return partsMapper.findPartsById(id);
    }
}
