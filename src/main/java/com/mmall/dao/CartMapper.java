package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdProductId(@Param(value = "userId") Integer userId, @Param(value = "productId") Integer productId);

    List<Cart> selectCartByUserId(Integer userId);

    int selesctCartProductCheckedStatusByUserId(Integer userId);

    int deleteByUserIdByUserIdProductIds(@Param(value = "userId") Integer userId, @Param(value = "productIdList") List<String> productIdList);

    int checkedOrUncheckedAllProdcut(@Param(value = "userId") Integer userId,@Param(value = "checked") Integer checked,@Param(value = "productId") Integer productId);

    int selectCartProductCount(@Param(value = "userId") Integer userId);

    List<Cart> selectCheckedCartByUserId(Integer userId);
}