package com.nanyin.ap.service;

import com.nanyin.ap.model.Supplier;

import java.util.List;

/**
 * @author nanyin
 * @time 下午4:54
 * @name SupplierService
 * @description
 */
public interface SupplierService {
    Supplier findSupplierByName(String name);

    List<Supplier> findAllSupplier();

    Supplier findSupplierById(int id);

    
}
