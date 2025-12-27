package custord.mgmt.controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custord.mgmt.dao.ContactMechDao;
import custord.mgmt.entities.ContactMech;

@WebServlet("/contact")
public class ContactMechController extends HttpServlet {

    private ContactMechDao contactDAO = new ContactMechDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));

        ContactMech cm = new ContactMech();
        cm.setCustomerId(customerId);
        cm.setStreetAddress(request.getParameter("streetAddress"));
        cm.setCity(request.getParameter("city"));
        cm.setState(request.getParameter("state"));
        cm.setPostalCode(request.getParameter("postalCode"));
        cm.setPhoneNumber(request.getParameter("phoneNumber"));
        cm.setEmail(request.getParameter("email"));

        contactDAO.addContactMech(cm);

        response.sendRedirect("contact?customerId=" + customerId);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        List<ContactMech> contacts = contactDAO.getContactsByCustomer(customerId);

        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("jsp/contact.jsp").forward(request, response);
    }
}
