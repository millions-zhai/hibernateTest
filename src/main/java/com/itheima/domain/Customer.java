package com.itheima.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; // 主键
	private String name; // 姓名

	// 描述客户可以有多个订单
	/*
	 * targetEntity相当于<one-to-many class="">
	 * mappedBy相当于inverse=true
	 */
	@OneToMany(targetEntity=Order.class,mappedBy="c")
	@BatchSize(size = 3)
	private Set<Order> orders = new HashSet<Order>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", orders=" + orders +
				'}';
	}
}
