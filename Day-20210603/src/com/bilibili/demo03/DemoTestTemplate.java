package com.bilibili.demo03;

import com.bilibili.demo02.User;
import com.bilibili.util.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DemoTestTemplate {
    public static void main(String[] args) {

        //  Template:
        //      int update();
        //      Map queryForMap();  封装一条数据的键值对到 Map 集合
        //      List queryForList();    将每一条数据封装为 Map 集合再添加到 List 集合中
        //      JavaBean:
        //          接口RowMapper(实现类BeanPropertyRowMapper)
        //          query(sql, new RowMapper(推荐使用实现类:BeanPropertyRowMapper)<E>(E.class));
        //      Type queryForObject(sql, T.class);

        String sql = "SELECT  * FROM users";
        JdbcTemplate tmp = new JdbcTemplate(DruidUtil.getPools());
        List<User> list = tmp.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
        String sql1 = "SELECT COUNT(Phone) FROM users";
        Long cnt = tmp.queryForObject(sql1, Long.class);
        System.out.println(cnt);
    }
}
