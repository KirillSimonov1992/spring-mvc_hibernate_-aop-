package com.simonov.kirill.mvc_hibernate_aop.dao;

import com.simonov.kirill.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> allEmployees = new ArrayList<>();

        allEmployees = session.createQuery("from Employee", Employee.class)
                              .getResultList();

        return allEmployees;
    }

    @Override
    public Employee getEmployee(int id) {
        return sessionFactory.getCurrentSession()
                             .get(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession()
                      .saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
//        sessionFactory.getCurrentSession()
//                      .delete(getEmployee(id));

        sessionFactory.getCurrentSession()
                      .createQuery("delete from Employee where id = :empId")
                      .setParameter("empId", id)
                      .executeUpdate();
    }


}
