package ru.gb.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.patterns.data.CustomerIdentityMap;
import ru.gb.patterns.data.CustomerMapper;
import ru.gb.patterns.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test_db", "sa", "");
            CustomerMapper mapper = new CustomerMapper(connection);
            mapper.create("address", "phone");
            Customer customer = mapper.findById(1L);
            CustomerIdentityMap.addCustomer(customer);

            System.out.println(CustomerIdentityMap.contains(customer));


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
