<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Customer Registration Form</title>

    <style>
        .error {
            color: red
        }
    </style>
</head>

<body>
<h1> Spring MVC 5 - Form Validation Example</h1>
<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>

<form:form action="processForm" modelAttribute="customer">

    First name:
    <form:input path="firstname"/>

    <br><br> Last name (*):
    <form:input path="lastname"/>
    <form:errors path="lastname" cssClass="error"/>

    <br><br> Free passes (*):
    <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>

    <br><br> Email (*):
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>

    <br><br> Postal Code:
    <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>

</body>

</html>