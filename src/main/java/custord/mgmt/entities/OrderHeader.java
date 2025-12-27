package custord.mgmt.entities;
import java.sql.Date;

public class OrderHeader {

    private int orderId;
    private Date orderDate;
    private int customerId;
    private int shippingContactMechId;
    private int billingContactMechId;

    
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getShippingContactMechId() { return shippingContactMechId; }
    public void setShippingContactMechId(int shippingContactMechId) {
        this.shippingContactMechId = shippingContactMechId;
    }

    public int getBillingContactMechId() { return billingContactMechId; }
    public void setBillingContactMechId(int billingContactMechId) {
        this.billingContactMechId = billingContactMechId;
    }
}