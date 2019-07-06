package DAO;

import ObjectModel.Rate;
import ObjectModel.Visit;
import Util.DataSource;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
            ps.setTime(5, visit.getTime());
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

    @Override
    public void delete(int id) {

    }

    public ArrayList<Visit> getVisits(){
        ArrayList<Visit> result = new ArrayList<>();
        String sql = "SELECT * FROM visit";
        RateDAOImpl rateDAO = new RateDAOImpl();

        try {
            ResultSet rs = DataSource.getConnection().createStatement().executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String doctorFullName = rs.getString("doctorFullName");
                String doctorJobTitle = rs.getString("doctorJobTitle");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                int rate_id = rs.getInt("rate_id");
                Visit visit = new Visit(id, doctorFullName, doctorJobTitle, time, date);
                visit.setRate(rateDAO.getRate(rate_id));
                result.add(visit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
