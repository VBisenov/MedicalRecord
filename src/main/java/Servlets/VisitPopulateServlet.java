package Servlets;

import DAO.VisitDAOImpl;
import ObjectModel.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;

@WebServlet(name = "visitpopulate", urlPatterns = "/visitpopulate")
public class VisitPopulateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String hospitalName = req.getParameter("hospitalName");
        String speciality = req.getParameter("speciality");
        String doctorName = req.getParameter("doctorName");
        Date date = Date.valueOf(req.getParameter("date"));
        System.out.println(doctorName);
        String time = req.getParameter("time");

        Visit visit = new Visit(1, doctorName, speciality, time, date);

        VisitDAOImpl dao = new VisitDAOImpl();
        dao.insert(visit);
        System.out.println(hospitalName);
        req.getRequestDispatcher("/lk.jsp").forward(req, resp);
    }
}
