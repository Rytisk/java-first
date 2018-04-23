package com.jlab.mybatis.dao;

import com.jlab.mybatis.model.Order;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PORDER
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PORDER
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PORDER
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PORDER
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    List<Order> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PORDER
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int updateByPrimaryKey(Order record);
}