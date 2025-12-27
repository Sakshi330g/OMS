<!DOCTYPE html>
<html>
<head>
    <title>Add Order Item</title>
</head>
<body>

<h2>Add Order Item</h2>

<form action="../orderItem" method="post">

    Order ID:
    <input type="number" name="orderId" required /><br><br>

    Product ID:
    <input type="number" name="productId" required /><br><br>

    Quantity:
    <input type="number" name="quantity" required /><br><br>

    Status:
    <input type="text" name="status" value="CREATED" /><br><br>

    <input type="submit" value="Add Item" />

</form>

</body>
</html>