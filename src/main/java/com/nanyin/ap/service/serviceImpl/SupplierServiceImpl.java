package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.SupplierMapper;
import com.nanyin.ap.model.Supplier;
import com.nanyin.ap.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nanyin
 * @time 下午4:54
 * @name SupplierServiceImpl
 * @description
 */
@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    SupplierMapper supplierMapper;
    @Override
    public Supplier findSupplierByName(String name) {
        return supplierMapper.findSupplierByName(name);
    }

    @Override
    public List<Supplier> findAllSupplier() {
        return supplierMapper.findAllSupplier();
    }

    @Override
    public Supplier findSupplierById(int id) {
        return supplierMapper.findSupplierById(id);
    }
}
