package com.jlab.mybatis.dao;

import com.jlab.persistence.mybatis.model.Product;
import java.util.List;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:25:52 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:25:52 EEST 2018
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:25:52 EEST 2018
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:25:52 EEST 2018
     */
    List<Product> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PRODUCT
     *
     * @mbg.generated Tue Apr 10 01:25:52 EEST 2018
     */
    int updateByPrimaryKey(Product record);
}