package DAO;

import ObjectModel.Rate;
import Util.DataSource;

import javax.xml.crypto.Data;
import java.sql.*;

public class RateDAOImpl implements  DAO{
    Connection connection = DataSource.getConnection();

    @Override
    public void insert(Object obj) {
        Rate rate = (Rate) obj;
        String sql = "INSERT INTO rate VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, getId());
            ps.setInt(2, rate.getRateDelay());
            ps.setInt(3, rate.getRateFriendly());
            ps.setString(4, rate.getComment());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public Rate getRate(int id){
        Rate result = null;
        String sql = "SELECT * FROM rate WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int rateDelay = rs.getInt("rateDelay");
                int rateFriendly = rs.getInt("rateFriendly");
                String comment = rs.getString("comment");
                result = new Rate(id, rateDelay, rateFriendly, comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int getId(){
        int result = 0;
        String sql = "SELECT COUNT(id) FROM rate";
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {

    }
}
