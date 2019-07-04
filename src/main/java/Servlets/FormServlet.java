package Servlets;

import ObjectModel.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "form", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.isNew())
        {
            req.getRequestDispatcher("index.html").forward(req, resp);
        }

        String name = (String) req.getParameter("name");

        System.out.println(name);
        req.setAttribute("name", name);
        req.getRequestDispatcher("/forms.jsp").forward(req, resp);
    }
}
