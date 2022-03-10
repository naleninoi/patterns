package ru.gb.patterns.data;

import ru.gb.patterns.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {
    private final Connection connection;

    public CustomerMapper(Connection connection) {
        this.connection = connection;
    }

    public Customer findById(Long customerId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT ID, ADDRESS, PHONE FROM CUSTOMERS WHERE ID = ?");
        statement.setLong(1, customerId);
        try (statement; ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong(1));
                customer.setAddress(resultSet.getString(2));
                customer.setPhone(resultSet.getString(3));
                return customer;
            }
        }
        throw new RecordNotFoundException("Can't find record with id: " + customerId);
    }

    public void create(String address, String phone) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO CUSTOMERS (ADDRESS, PHONE) VALUES (?, ?)");
        statement.setString(1, address);
        statement.setString(2, phone);
        statement.executeUpdate();
    }

    public void update(Long customerId, String address, String phone) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE CUSTOMERS SET (ADDRESS, PHONE) = (?, ?) WHERE id = ?");
        statement.setString(1, address);
        statement.setString(2, phone);
        statement.setLong(3, customerId);
        statement.executeUpdate();
    }

    public void deleteById(Long customerId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM CUSTOMERS WHERE ID = ?");
        statement.setLong(1, customerId);
        statement.executeUpdate();
    }

}
