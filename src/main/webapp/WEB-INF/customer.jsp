<%@ page  language="java" contentType="text/html;charset=UTF-8" charset=ISO-8859-1
 pageEncoding="ISO-8859-1"
 %>
<%@ page import="java.util.*, custord.mgmt.entities.Customer" %>

<html>
<head>
    <title>Customer</title>
</head>
<body>

<h2>Add Customer</h2>
<form method="post" action="customer">
    First Name: <input type="text" name="firstName" required>
    Last Name: <input type="text" name="lastName" required>
    <button type="submit">Save</button>
</form>

<hr>

<h2>Customer List</h2>
<table border="1">
    <tr>
        <th>ID</th><th>First Name</th><th>Last Name</th>
    </tr>

    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
        if (customers != null) {
            for (Customer c : customers) {
    %>
    <tr>
        <td><%= c.getCustomerId() %></td>
        <td><%= c.getFirstName() %></td>
        <td><%= c.getLastName() %></td>
    </tr>
    <% }} %>
</table>

</body>
</html>