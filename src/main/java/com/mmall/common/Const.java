 /*
  * Copyright (C), 2015-2018
  * FileName: Const
  * Author:   Administrator
  * Date:     2018/3/8 0008 21:05
  * Description:
  */

 package com.mmall.common;

 import com.google.common.collect.Sets;

 import java.util.Set;

 /**
  * 〈一句话功能简述〉<br>
  * 〈〉
  *
  * @author Administrator
  * @create 2018/3/8 0008
  * @since 1.0.0
  */
 public class Const {
     public static final String CURRENT_USER = "currentUser";
     public static final String TOKEN_PREFIX = "token_";
     public static final String EMAIL = "email";
     public static final String USERNAME = "username";

     /**
      * redis--缓存时间30分钟
      */
     public interface RedisCacheExtime {
         int REDIS_SESSION_EXTIME = 60 * 30;
     }

     public interface ProductListOrderBy {
         Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
     }

     public interface Cart {
         // 选中状态
         int CHECKED = 1;
         // 未选中状态
         int UNCHECKED = 0;
         String LIMIT_MUM_FAIL = "LIMIT_MUM_FAIL";
         String LIMIT_MUM_SUCCESS = "LIMIT_MUM_SUCCESS";
     }

     public interface Role {
         // 普通用户
         int ROLE_CUSTOMER = 0;
         // admin

         int ROLE_ADMIN = 1;
     }

     public enum ProductStatusElm {
         ON_SALE(1, "在线");
         private String value;
         private int code;

         ProductStatusElm(int code, String value) {
             this.code = code;
             this.value = value;
         }


         public String getValue() {
             return value;
         }

         public void setValue(String value) {
             this.value = value;
         }

         public int getCode() {
             return code;
         }

         public void setCode(int code) {
             this.code = code;
         }
     }

     public enum OrderStatusEnum {
         CANCELED(0, "已取消"),
         NO_PAY(10, "未支付"),
         PAID(20, "已付款"),
         SHIPPED(40, "已发货"),
         ORDER_SUCCESS(50, "订单完成"),
         ORDER_CLOSE(60, "订单关闭");

         private String value;
         private int code;

         OrderStatusEnum(int code, String value) {
             this.code = code;
             this.value = value;
         }

         public String getValue() {
             return value;
         }

         public int getCode() {
             return code;
         }

         public static OrderStatusEnum codeOf(int code) {
             for (OrderStatusEnum orderStatusEnum : values()) {
                 if (orderStatusEnum.getCode() == code) {
                     return orderStatusEnum;
                 }
             }
             throw new RuntimeException("么有找到对应的枚举");
         }
     }

     public interface AlipayCallback {
         String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
         String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

         String RESPONSE_SUCCESS = "success";
         String RESPONSE_FAILED = "failed";
     }

     public enum PayPlatformEnum {
         ALIPAY(1, "支付宝");

         PayPlatformEnum(int code, String value) {
             this.code = code;
             this.value = value;
         }

         private String value;
         private int code;

         public String getValue() {
             return value;
         }

         public int getCode() {
             return code;
         }
     }

     public enum PaymentTypeEnum {
         ONLINE_PAY(1, "在线支付");

         PaymentTypeEnum(int code, String value) {
             this.code = code;
             this.value = value;
         }

         private String value;
         private int code;

         public String getValue() {
             return value;
         }

         public int getCode() {
             return code;
         }

         public static PaymentTypeEnum codeOf(int code) {
             for (PaymentTypeEnum paymentTypeEnum : values()) {
                 if (paymentTypeEnum.getCode() == code) {
                     return paymentTypeEnum;
                 }
             }
             throw new RuntimeException("么有找到对应的枚举");
         }
     }

 }