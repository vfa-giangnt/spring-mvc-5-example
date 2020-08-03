package gau.nau.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import gau.nau.spring.model.Customer;

public class CustomerDAO {
    
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        
        try {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("Insert success!");
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }/* finally {
            session.flush();
            session.close();
        }*/
    }
    
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.load(Customer.class, id);
        System.out.println("=> Customer: " + customer);
        
        return customer;
    }
    
    public void showAll() {
        Session session = sessionFactory.openSession();
        
        List<Customer> list = session.createQuery("FROM Customer").list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
    
    public void updateName(int id, String name) {
        Session session = sessionFactory.openSession();
        String sql = "UPDATE Customer u SET u.name = :newName WHERE u.id = :id";
        session.createQuery(sql).setString("newName", name).setInteger("id", id).executeUpdate();
    }
    
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.update(customer);
    }
    
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            
            System.out.println("Delete success!");
            
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void searchByName(String name) {
        Session session = sessionFactory.openSession();
        List<Customer> list = session.createQuery("FROM Customer WHERE name LIKE :name").setParameter("name", "%" + name + "%").list();
        
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
