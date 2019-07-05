package DAO;

import ObjectModel.Client;

import Util.DataSource;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements DAO {
    Connection connection = DataSource.getConnection();

    @Override
    public void insert(Object obj) {
        Client client = (Client) obj;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO client values (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, getId());
            ps.setString(2, client.getName());
            ps.setString(3, client.getSurname());
            ps.setString(4, client.getFather_name());
            ps.setString(5, client.getAddress());
            ps.setString(6, client.getPhone_number());
            ps.setString(7, client.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    private int getId(){
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(id) FROM client");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        result++;
        return result;
    }


    public ArrayList<Client> getClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String SQL = "SELECT * FROM client";
        try {
            ResultSet rs = DataSource.getConnection().createStatement().executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surName = rs.getString("surname");
                String fatherName = rs.getString("fathername");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String password = rs.getString("password");

                Client client = new Client(id, name, surName, fatherName, address, phoneNumber, password);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client login(String login, String password){
        Client result = null;
        ArrayList<Client> clients = getClients();
        for (Client c: clients){
            if (c.getPhone_number().equals(login) && c.getPassword().equals(password)){
                result = c;
            }
        }
        return result;
    }
}
