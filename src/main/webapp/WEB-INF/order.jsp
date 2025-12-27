<!DOCTYPE html>
<html>
<head>
    <title>Create Order</title>
</head>
<body>

<h2>Create Order</h2>

<form action="../order" method="post">

    Customer ID:
    <input type="number" name="customerId" required /><br><br>

    Shipping Contact ID:
    <input type="number" name="shippingContactMechId" required /><br><br>

    Billing Contact ID:
    <input type="number" name="billingContactMechId" required /><br><br>

    <input type="submit" value="Create Order" />

</form>

</body>
</html>