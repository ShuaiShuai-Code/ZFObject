package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class zf_order {
    private String id;
    private String user_id;
    private String order_no;
    private String order_status;
    private String order_title;
    private String order_money;
    private String desco_money;
    private String order_rebate;
    private String order_descoed_money;
    private String courier_id;
    private String courier_num;


}
