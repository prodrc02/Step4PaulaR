<%@ include file="/WEB-INF/views/include.jsp" %>

<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    
    <h2>Account: <c:out value="${model.account.accountDescription}"/> </h2>
    <h3>Movements after applying interest: </h3>
    <p>[<c:out value="${model.account.dateMov1}"/>]	<b>Social insurance:</b>		-400&#8364	-------- <b><i><c:out value="${model.account.movementBalance1}"/>&#8364</i></b></p>
    <p>[<c:out value="${model.account.dateMov2}"/>]	<b>Shopping supermarket:</b>	-200&#8364	-------- <b><i><c:out value="${model.account.movementBalance2}"/>&#8364</i></b></p>
    <p>[<c:out value="${model.account.dateMov3}"/>]	<b>Salary:</b>			153.65&#8364	-------- <b><i><c:out value="${model.account.movementBalance3}"/>&#8364</i></b></p>
    <p>[<c:out value="${model.account.dateMov4}"/>]	<b>Receipt community:</b>		-123.87&#8364	-------- <b><i><c:out value="${model.account.movementBalance4}"/>&#8364</i></b></p>
    <p>[<c:out value="${model.account.dateMov5}"/>]	<b>Check income:</b>			20000&#8364	-------- <b><i><c:out value="${model.account.movementBalance5}"/>&#8364</i></b></p>
   	<p>[<c:out value="${model.now}"/>] <b>Generated interests:</b>	<c:out value="${model.account.amountToIncrease}"/>&#8364 -------- 	<b><i><c:out value="${model.account.movementWithIncrease}"/>&#8364</i></b></p>
    <br>
    <a href="<c:url value="applyinterest.htm"/>">Interest calculator</a>
    
  </body>
</html>