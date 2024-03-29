package com.jlab.mybatis.dao;

import com.jlab.mybatis.model.Product;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    List<Product> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Mon Apr 23 18:03:59 EEST 2018
     */
    int updateByPrimaryKey(Product record);
}