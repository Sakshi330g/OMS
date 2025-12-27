package custord.mgmt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import custord.mgmt.entities.ContactMech;
import custord.mgmt.utils.DBConnection;

public class ContactMechDao {

    private Connection connection = DBConnection.getConnection();

    
    public int addContactMech(ContactMech cm) {

        String sql = "INSERT INTO Contact_Mech " +
                "(customer_id, street_address, city, state, postal_code, phone_number, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                     connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, cm.getCustomerId());
            ps.setString(2, cm.getStreetAddress());
            ps.setString(3, cm.getCity());
            ps.setString(4, cm.getState());
            ps.setString(5, cm.getPostalCode());
            ps.setString(6, cm.getPhoneNumber());
            ps.setString(7, cm.getEmail());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // contact_mech_id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    
    public List<ContactMech> getContactsByCustomer(int customerId) {
        List<ContactMech> list = new ArrayList<>();
        String sql = "SELECT * FROM Contact_Mech WHERE customer_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ContactMech cm = new ContactMech();
                cm.setContactMechId(rs.getInt("contact_mech_id"));
                cm.setCustomerId(rs.getInt("customer_id"));
                cm.setStreetAddress(rs.getString("street_address"));
                cm.setCity(rs.getString("city"));
                cm.setState(rs.getString("state"));
                cm.setPostalCode(rs.getString("postal_code"));
                cm.setPhoneNumber(rs.getString("phone_number"));
                cm.setEmail(rs.getString("email"));
                list.add(cm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}