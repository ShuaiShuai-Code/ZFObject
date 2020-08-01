＃最初接口代码，后续会持续更新，作者是安卓开发者，后端开发是小白，喜欢的可以关注，由浅入深的认识后端，做一个项目没问题，代码有问题也欢迎指正

```
    @Resource
    JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public BaseResp login(String id) {
        if (StringUtils.isEmpty(id)) {
            return new BaseResp(400, "参数错误");
        }
        String sql = "SELECT * from zf_user WHERE user_id= ?";
        List<zf_user> user = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(zf_user.class));
        if (null == user || user.size() == 0) {
            return new BaseResp(400, "无数据");
        }
        return new BaseResp(200, "success", user.get(0));
    }
//请求接口查询出单个数据库数据
/*
{
    "code": 200,
    "msg": "success",
    "data": {
        "user_id": "1",
        "user_name": "张飞",
        "user_nickname": "张翼德",
        "user_pass": "123456",
        "user_sex": "1",
        "user_age": "18",
        "user_lable": "3",
        "is_supporter": "1",
        "user_address": "涿郡屠夫",
        "submission_date": "2020-07-28",
        "user_tel": "12345678888",
        "user_email": "1@163.com",
        "order_id": null
    }
}
*/


```
//请求接口获取列表
```
  @Resource
    JdbcTemplate jdbcTemplate;

    @GetMapping("/orderList")
    public BaseResp orderList() {
        String sql = "SELECT * from zf_order";
        List<zf_order> orderList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(zf_order.class));
        return new BaseResp(200, "success", orderList);
    }
//得到数据

{
    "code": 200,
    "msg": "success",
    "data": [
        {
            "id": "1",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "键盘键盘，厂家代销",
            "order_money": "99",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "2",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "幼儿图书，厂家代销",
            "order_money": "89",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "3",
            "user_id": "2",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "健身体验卡，厂家代销",
            "order_money": "2880",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "4",
            "user_id": "2",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "游泳卡，厂家代销",
            "order_money": "298",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "5",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "电瓶车，雅迪，厂家代销",
            "order_money": "1989",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "6",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "蜂蜜抓买，厂家代销",
            "order_money": "198",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "7",
            "user_id": "3",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "皮革厂，钱包皮带，厂家代销",
            "order_money": "10",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "8",
            "user_id": "3",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "0-3岁幼儿奶粉，厂家代销",
            "order_money": "198",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "9",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "皮鞋，鞋油，厂家代销",
            "order_money": "98",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        },
        {
            "id": "10",
            "user_id": "1",
            "order_no": "202007311117",
            "order_status": "1",
            "order_title": "鼠标垫，厂家代销",
            "order_money": "9.9",
            "desco_money": null,
            "order_rebate": null,
            "order_descoed_money": null,
            "courier_id": null,
            "courier_num": null
        }
    ]
}
```








