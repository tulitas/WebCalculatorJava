<html xmlns:th="http://www.thymeleaf.org">
<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 07-Jul-20
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hi</title>
</head>
<body>
<input type="text" th:field="*{a}"/>
<input type="text" th:field="*{b}"/>
<p>
    <input type="submit" class="button" name="add" value="+"/>
    <input type="submit" class="button" name="subtract" value="-"/>
    <input type="submit" class="button" name="multiply" value="*"/>
    <input type="submit" class="button" name="divide" value="/"/>
    <input type="submit" class="button" name="clearSimple" value="C"/>
</p>

<h1>Advanced:</h1>
<input type="text" th:field="*{c}"/>
<p>
    <input type="submit" class="button" name="fibonacci" value="fib"/>
    <input type="submit" class="button" name="factorial" value="!"/>
    <input type="submit" class="button" name="sqrt" value=&#8730 />
    <input type="submit" class="button" name="power" value="^"/>
    <input type="submit" class="button" name="clearAdvanced" value="C"/>
</p>
<h1><p th:text="'result: ' + ${result}"/></h1>
</body>
</html>
