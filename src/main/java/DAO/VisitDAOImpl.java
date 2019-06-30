package DAO;

import ObjectModel.Visit;
import Util.DataSource;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public void delete(int id) {

    }
}
