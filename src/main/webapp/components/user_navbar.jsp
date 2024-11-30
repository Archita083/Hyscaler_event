<%@page import="com.org.dto.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="../user/user_homepage.jsp">Event Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      	<form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search.." aria-label="Search">
        <a class="nav-link active" aria-current="page" href="../event/search_event.jsp" target="_blank">Search</a>
        </form>
        <% User user1=(User)session.getAttribute("userObj"); %>
         
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../user/update_user.jsp?id=<%=user1.getId()%>">My Details</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../event/upcoming_events.jsp">Upcoming Events</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../user/booking_history.jsp?id=<%=user1.getId()%>">Booking History</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_logout">Logout</a>
        </li>
        
        
      </ul>
     
    </div>
  </div>
</nav>