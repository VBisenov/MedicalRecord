package DAO;

import ObjectModel.Client;
import ObjectModel.Visit;
import Util.DataSource;

import java.sql.*;
import java.util.ArrayList;

public class VisitDAOImpl implements DAO {
    Connection connection =  DataSource.getConnection();
    @Override
    public void insert(Object obj) {
        Visit visit = (Visit) obj;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT into visit values (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, getId());
            ps.setString(2, visit.getDoctorFullName());
            ps.setString(3, visit.getDoctorJobTitle());
            ps.setDate(4, visit.getDate());
            ps.setString(5, visit.getTime());
            ps.setInt(6,1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getId(){
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(id) FROM visit");
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

    public ArrayList<Visit> getVisits() {
        ArrayList<Visit> visits = new ArrayList<>();
        String SQL = "SELECT * FROM visit";
        try {
            ResultSet rs = DataSource.getConnection().createStatement().executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("id");
                String doctorFullName = rs.getString("doctorFullName");
                String doctorJobTitle = rs.getString("doctorJobTitle");
                Date date = Date.valueOf(rs.getString("date"));
                String time = rs.getString("time");
                int rateId = rs.getInt("rate_id");

                Visit visit = new Visit(id, doctorFullName, doctorJobTitle, time, date);
                visits.add(visit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visits;
    }

    @Override
    public void delete(int id) {

    }
}
