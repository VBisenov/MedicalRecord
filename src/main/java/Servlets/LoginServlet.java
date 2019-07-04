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

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.isNew())
        {
            req.getRequestDispatcher("index.html").forward(req, resp);
        }

        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        ClientDAOImpl dao = new ClientDAOImpl();


        if (login != null && password != null) {
            Client client = dao.login(login, password);
            req.setAttribute("client",client);

            session.setAttribute("client", client);
            session.setAttribute("name", client.getName());
            session.setAttribute("phoneNumber", client.getPhone_number());

            System.out.println(client);

            if(client == null){
                req.getRequestDispatcher("/accessdenied").forward(req, resp);
            }
            else {
                req.getRequestDispatcher("/lk").forward(req, resp);
            }
        }

    }
}
