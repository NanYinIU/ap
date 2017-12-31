package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierMapper {

    /**
     * 根据供应商名称查询所有的信息
     * @param name
     * @return
     */
    @Select("SELECT * FROM auto_parts.supplier WHERE supplierName=#{name}")
    Supplier findSupplierByName(String name);

    /**
     * 全部供应商的信息
     * @return
     */
    @Select("SELECT * FROM auto_parts.supplier")
    List<Supplier> findAllSupplier();

    @Select("SELECT * FROM auto_parts.supplier WHERE id=#{id}")
    Supplier findSupplierById(int id);
}