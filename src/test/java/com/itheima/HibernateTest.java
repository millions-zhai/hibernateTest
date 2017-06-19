package com.itheima;
import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;


/**
 * Created by millions on 2017/6/12.
 */
public class HibernateTest {

    @Test
    public void test() {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();


        Customer customer=new Customer();
        customer.setName("张三");

        Order order1=new Order();
        order1.setMoney(100d);
        order1.setReceiverInfo("巴黎");

        Order order2=new Order();
        order2.setMoney(1000d);
        order2.setReceiverInfo("纽约");

        order1.setC(customer);
        order2.setC(customer);

        session.save(order1);
        session.save(order2);

        transaction.commit();
        session.close();
    }

    /**
     * 测试refresh 函数
     */
    @Test
    public void test_2(){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();


        List list = session.createQuery("from User").list();

        System.out.println(list);
        session.clear();
        List list2 = session.createQuery("from User").list();

        System.out.println(list2);
        transaction.commit();
        session.close();
    }

    @Test
    public void test_autoCommit(){
        Session session = HibernateUtil.getSession();

        User user=new User();
        user.setName("悄悄是别离的笙箫");
        session.save(user);

        int i=1/0;

        User user1=new User();
        user1.setName("撑着油纸伞~~~");
        session.save(user1);

        session.close();
    }

}
