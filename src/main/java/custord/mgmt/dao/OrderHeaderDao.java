import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import custord.mgmt.entities.OrderHeader;
import custord.mgmt.utils.DBConnection;

public class OrderHeaderDao {

    private Connection connection = DBConnection.getConnection();

    
    public int createOrder(OrderHeader order) {

        String sql = "INSERT INTO Order_Header " +
                     "(order_date, customer_id, shipping_contact_mech_id, billing_contact_mech_id) " +
                     "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                     connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, order.getOrderDate());
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getShippingContactMechId());
            ps.setInt(4, order.getBillingContactMechId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

   
    public List<OrderHeader> getOrdersByCustomer(int customerId) {

        List<OrderHeader> orders = new ArrayList<>();
        String sql = "SELECT * FROM Order_Header WHERE customer_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderHeader order = new OrderHeader();
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setShippingContactMechId(rs.getInt("shipping_contact_mech_id"));
                order.setBillingContactMechId(rs.getInt("billing_contact_mech_id"));
                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}