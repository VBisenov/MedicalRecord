package Servlets;

import DAO.ClientDAOImpl;
import DAO.VisitDAOImpl;
import ObjectModel.Client;
import ObjectModel.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "lk", urlPatterns = "/lk")
public class LKServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session.getAttribute("name") == null)
        {
            req.getRequestDispatcher("index.html").forward(req, resp);
        }

        VisitDAOImpl dao = new VisitDAOImpl();

        ArrayList<Visit> visits = dao.getVisits();
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        ArrayList<Visit> previousVisits = new ArrayList<>();
        ArrayList<Visit> nextVisits = new ArrayList<>();
        ArrayList<Visit> currentVisits = new ArrayList<>();

        for (Visit visit: visits){
            if (visit.getDate().toLocalDate().isBefore(currentDate)){
                previousVisits.add(visit);
            } else if (visit.getDate().toLocalDate().isAfter(currentDate)){
                nextVisits.add(visit);
            } else {
                currentVisits.add(visit);
            }
        }

        session.setAttribute("currentVisits", currentVisits);
        session.setAttribute("previousVisits", previousVisits);
        session.setAttribute("nextVisits", nextVisits);

        Client client = (Client) session.getAttribute("client");

        System.out.println("qq"+client);
        System.out.println("lk");

        req.getRequestDispatcher("lk.jsp").forward(req, resp);
    }
}
