package Servlets;

import ObjectModel.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lk", urlPatterns = "/lk")
public class LKServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getAttribute("client");


        req.setAttribute("name", client.getName());
        req.setAttribute("phoneNumber", client.getPhone_number());
        req.getRequestDispatcher("lk.jsp").forward(req, resp);
    }
}
