<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<form:form method="POST" modelAttribute="account">
	email: <form:input path="email" />
	password: <form:input path="password" />
	<button id="register">Sign Up</button>
</form:form>