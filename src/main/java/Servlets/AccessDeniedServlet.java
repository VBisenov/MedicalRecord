package Servlets;

import DAO.ClientDAOImpl;
import ObjectModel.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "accessdenied", urlPatterns = "/accessdenied")
public class AccessDeniedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getRequestDispatcher("accessdenied.jsp").forward(req, resp);
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        ClientDAOImpl dao = new ClientDAOImpl();
        Client client = dao.login(login, password);
        if (client == null) {
            req.getRequestDispatcher("/accessdenied").forward(req, resp);
        }
        else {
            session.setAttribute("client", client);
            session.setAttribute("name", client.getName());
            session.setAttribute("phoneNumber", client.getPhone_number());
            req.getRequestDispatcher("/lk").forward(req, resp);
        }
    }
}
