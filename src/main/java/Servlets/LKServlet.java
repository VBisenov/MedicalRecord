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
import java.util.ArrayList;
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
        System.out.println("lk");

        VisitDAOImpl visitDAO = new VisitDAOImpl();
        ArrayList<Visit> visits = visitDAO.getVisits();

        session.setAttribute("visits", visits);


        req.getRequestDispatcher("lk.jsp").forward(req, resp);
    }
}
