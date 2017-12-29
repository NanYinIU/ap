package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Parts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PartsMapper {
    /**
     * 根据零件id查询零件所有信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM auto_parts.parts WHERE id=#{id}")
    Parts findPartsById(int id);
}