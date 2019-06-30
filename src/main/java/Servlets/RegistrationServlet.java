package Servlets;

import DAO.ClientDAOImpl;
import ObjectModel.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reg", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
       // resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String fatherName = req.getParameter("fatherName");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String pass = req.getParameter("pass");
        String passRepeat = req.getParameter("passRepeat");
        System.out.println("pass = "+pass+" pass repeat = "+passRepeat);

        if (pass.equals(passRepeat)){

            Client client = new Client(1, name, surName, fatherName, address, phoneNumber, pass);
            System.out.println(client.getName());
            ClientDAOImpl dao = new ClientDAOImpl();
            dao.insert(client);
            System.out.println(name);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/lk.jsp").forward(req, resp);
    }
}
