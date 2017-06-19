package com.itheima;

import com.itheima.domain.Customer;
import com.itheima.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by millions on 2017/6/17.
 */
public class BatchTest {

    @Test
    public void test(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // 1.得到所有客户  3个客户，会发4个sql(1+3)  n+1
        // 怎么解决？ 把后面三个进行批量查询 batchsize=3
        List<Customer> list = session.createQuery("from Customer").list();

        // 2.得到客户的订单信息
        for (Customer c : list) {
            System.out.println(c.getOrders().size());
        }

        session.getTransaction().commit();
        session.close();
    }
}
