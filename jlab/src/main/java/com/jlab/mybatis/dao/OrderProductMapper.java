package com.jlab.mybatis.dao;

import com.jlab.mybatis.model.OrderProduct;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface OrderProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("prodcutId") Integer prodcutId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int insert(OrderProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    OrderProduct selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("prodcutId") Integer prodcutId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    List<OrderProduct> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ORDER_PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int updateByPrimaryKey(OrderProduct record);
}