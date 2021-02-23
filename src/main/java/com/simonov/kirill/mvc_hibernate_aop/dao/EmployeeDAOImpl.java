package com.simonov.kirill.mvc_hibernate_aop.dao;

import com.simonov.kirill.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
                                             .getResultList();
        return allEmployees;
    }
}
