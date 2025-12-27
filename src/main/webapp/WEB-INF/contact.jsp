<!DOCTYPE html>
<html>
<head>
    <title>Add Contact</title>
</head>
<body>

<h2>Add Customer Contact (Address)</h2>

<form action="../contact" method="post">

    Customer ID:
    <input type="number" name="customerId" required /><br><br>

    Street Address:
    <input type="text" name="streetAddress" required /><br><br>

    City:
    <input type="text" name="city" required /><br><br>

    State:
    <input type="text" name="state" required /><br><br>

    Postal Code:
    <input type="text" name="postalCode" required /><br><br>

    Phone:
    <input type="text" name="phoneNumber" /><br><br>

    Email:
    <input type="email" name="email" /><br><br>

    <input type="submit" value="Save Contact" />

</form>

</body>
</html>