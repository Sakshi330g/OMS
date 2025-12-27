import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import custord.mgmt.dao.OrderHeaderDao;
import custord.mgmt.entities.OrderHeader;

@WebServlet("/order")
public class OrderController extends HttpServlet {

    private OrderHeaderDao orderDAO = new OrderHeaderDao();

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int shippingId = Integer.parseInt(request.getParameter("shippingContactMechId"));
        int billingId = Integer.parseInt(request.getParameter("billingContactMechId"));

        OrderHeader order = new OrderHeader();
        order.setOrderDate(new Date(System.currentTimeMillis()));
        order.setCustomerId(customerId);
        order.setShippingContactMechId(shippingId);
        order.setBillingContactMechId(billingId);

        int orderId = orderDAO.createOrder(order);

        response.sendRedirect("order?customerId=" + customerId);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));

        List<OrderHeader> orders = orderDAO.getOrdersByCustomer(customerId);
        request.setAttribute("orders", orders);

        request.getRequestDispatcher("order.jsp").forward(request, response);
    }
}