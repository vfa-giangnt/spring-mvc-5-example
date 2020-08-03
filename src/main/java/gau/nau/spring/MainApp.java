package gau.nau.spring;

import gau.nau.spring.dao.CustomerDAO;
import gau.nau.spring.model.Customer;

public class MainApp {
    public static void main(String[] args) {
        insertCustomer();
//        searchCustomerByName();
        showAll();
//        findById(2);
//        deleteCustomer(1);
    }
    
    private static void deleteCustomer(int id) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.delete(id);
    }
    
    private static void findById(int id) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.findById(id);
    }
    
    private static void showAll() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.showAll();
    }
    
    private static void searchCustomerByName() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.searchByName("T");
    }
    
    private static void insertCustomer() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.save(new Customer("GiangNT", "Vietnam"));
        customerDAO.save(new Customer("NhiPT", "America"));
        customerDAO.save(new Customer("UyenTB", "Africa"));
        customerDAO.save(new Customer("TrongVN", "Brazil"));
        customerDAO.save(new Customer("TuanTA", "China"));
        customerDAO.save(new Customer("ThangNT", "Lao"));
        customerDAO.save(new Customer("LinhNTK", "Cambodia"));
    }
}
