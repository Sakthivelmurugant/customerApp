package com.sapient.customerApp.service;

import com.sapient.customerApp.model.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {

    static List<Customer> allCustomers = new ArrayList();
    static {
        Customer customer1 = new Customer(1, "Albert");
        Customer customer2 = new Customer(2, "Bala");
        Customer customer3 = new Customer(3, "Peter");
        Customer customer4 = new Customer(4, "Ram");
        allCustomers.add(customer1);
        allCustomers.add(customer2);
        allCustomers.add(customer3);
        allCustomers.add(customer4);
    }

//    private CustomerRepository customerRepository;
//
//    CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public List<Customer> getCustomers() {
        return allCustomers;
    }

    private List<Customer> getAllCustomers() {
        Customer customer1 = new Customer(1, "Albert");
        Customer customer2 = new Customer(2, "Bala");
        Customer customer3 = new Customer(3, "Peter");
        Customer customer4 = new Customer(4, "Ram");
        List<Customer> allCustomers = new ArrayList();
        allCustomers.add(customer1);
        allCustomers.add(customer2);
        allCustomers.add(customer3);
        allCustomers.add(customer4);
        return allCustomers;
    }

    public String deleteCustomer(int id) {
        int customerIndex = getCustomerIndex(id);
        allCustomers.remove(customerIndex);
        if(customerIndex == -1) {
            return "Customer not found";
        }
        return "Customer with id " + customerIndex + "deleted";
    }

    private int getCustomerIndex(int id) {
        int customerIndex = -1;
        for(int i = 0; i < allCustomers.toArray().length; i++) {
            if(allCustomers.get(i).getId() == id) {
                customerIndex = i;
            }
        }
        return customerIndex;
    }

    public Customer updateCustomer(Customer customer) {
        int customerIndex = getCustomerIndex(customer.getId());
        if(customerIndex == -1) {
            allCustomers.add(customer);
            return customer;
        } else {
            Customer customerFromDB = allCustomers.get(customerIndex);
            customerFromDB.setName(customer.getName());
            return customerFromDB;
        }
    }
}
