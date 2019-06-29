package DAO;

import ObjectModel.Client;

public class test {
    public static void main(String[] args) {
        Client client = new Client(1, "Henry", "H","Olegovich","st.qw", "9835235", "12424");
        ClientDAOImpl dao = new ClientDAOImpl();
        dao.insert(client);
    }
}
