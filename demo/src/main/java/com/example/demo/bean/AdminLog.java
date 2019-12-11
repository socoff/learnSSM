package com.example.demo.bean;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

// data注解用于自动生成getter和setter
@Data
public class AdminLog implements Serializable {

/*    `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_date` datetime NULL DEFAULT NULL,
  `admin_id` int(11) NULL DEFAULT NULL,
  `log_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        */

    private Integer logId;
    private Date logDate;
    private Integer adminId;
    private String logContent;
    private String logType;
    private String logIp;
}
