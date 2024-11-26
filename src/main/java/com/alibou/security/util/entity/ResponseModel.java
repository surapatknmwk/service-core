package com.alibou.security.util.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
    private String messsage;
    private String code;
    private Object data;
    private String status;

    public ResponseModel(String messsage,Object data){
        this.messsage = messsage;
        this.data = data;
        this.code = "200";
        this.status = "success";
    }
}
