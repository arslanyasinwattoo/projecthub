package com.bnu.springdemo.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnu.springdemo.dao.GenericDAO;
import com.bnu.springdemo.entity.Customer;
import com.bnu.springdemo.entity.SalesOrder;

@Service
public class CustomerService {

	@Autowired
	private GenericDAO genericDAO;

	public List<Customer> findCustomersByName(String name) throws Exception {
		Customer example = new Customer();
		example.setName(name);

		return genericDAO.findByExample(example);
	}

	@Transactional
	public List<SalesOrder> getOrdersWithinPeriod(Date startDate, Date endDate)
			throws Exception {

		return genericDAO.findByNamedQuery("getOrdersWithinPeriod", startDate,
				endDate);
	}

	@Transactional
	public List<SalesOrder> getOrdersWithDetails() throws Exception {
		return genericDAO.findByNamedQuery("getOrdersWithDetails");
	}

	public List<Customer> getCustomersDynamically(String keyword, boolean searchByName) throws Exception {

		Criteria criteria = genericDAO.createCriteria(Customer.class);
		Criteria ordersCriteria = criteria.createCriteria("salesOrders");
		criteria.setFetchMode("salesOrders", FetchMode.EAGER);
		
		if (searchByName) {
			criteria.add(Restrictions.eq("name", keyword));
			criteria.addOrder(Order.asc("name"));
		} else {
			criteria.add(Restrictions.eq("address", keyword));
			criteria.addOrder(Order.desc("name"));
		}
		
		return (List<Customer>) criteria.list();
	}

}
