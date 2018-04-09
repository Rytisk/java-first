package com.jlab.mybatis.dao;

import com.jlab.mybatis.model.OrderProduct;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface OrderProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:40:21 EEST 2018
     */
    int insert(OrderProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:40:21 EEST 2018
     */
    List<OrderProduct> selectAll();
}