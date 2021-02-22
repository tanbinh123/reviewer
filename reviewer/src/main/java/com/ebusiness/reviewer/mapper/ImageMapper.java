package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImageMapper {

    int uploadImage(Image image);
}
