<%@ page import="java.util.List" %>
<%@ page import="com.tax.system.domain.Location" %>
<%@ page import="java.util.ArrayList" %>
<%
    List<Location> locations = new ArrayList<>();
    // Fetch list of locations from server and populate select boxes
    locations = (List<Location>) request.getAttribute("locations");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>407 Sample Toll Calculator</title>
    <link rel="stylesheet" type="text/css" href="style/index.css">
    <script src="script/index.js"></script>
    <h1 class="header">TOLL CALCULATOR</h1>
</head>
<body>
<div class="col30">
    <img class="image-container" src="407-ETR.png" alt="407 ETR shield"/>
</div>
<div class="col50">
    <label for="entry-location">Entry Locations:</label>
    <select id="entry-location">
        <option value="">Select locations</option>
        <% for(Location location : locations) { %>
        <option value="<%= location.getName() %>"><%= location.getName() %></option>
        <% } %>
    </select>
    <br>
    <br>
    <label for="exit-location">Exit Location:</label>
    <select id="exit-location">
        <option value="">Select location</option>
        <% for(Location location : locations) { %>
        <option value="<%= location.getName() %>"><%= location.getName() %></option>
        <% } %>
    </select>
    <br><br>
    <button id="calculate-btn">Calculate</button>
    <br><br>
    <div id="result" style="visibility: hidden">
        Total Distance: <span id="distance"></span>
        <br><br>
        Total Cost: $<span id="cost"></span>
    </div>
</div>
</body>
</html>
