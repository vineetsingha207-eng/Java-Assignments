
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Information</h2>

    <%
        String name = request.getParameter("name");
        String prn = request.getParameter("prn");
        String course = request.getParameter("course");
        String semester = request.getParameter("semester");
    %>

    Name: <%= name %><br><br>
    PRN: <%= prn %><br><br>
    Course: <%= course %><br><br>
    Semester: <%= semester %><br><br>

    <a href="student.jsp">Go Back</a>
</body>
</html>
