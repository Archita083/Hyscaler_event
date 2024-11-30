<%@page import="com.org.dao.EventDao"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Event"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
</head>
<body>
	<%@ include file="../components/user_navbar.jsp" %>
	<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Upcoming Events</p>
						
						
						<table class="table">
							<thead>
								<tr>
									<th>Event Id</th>
									<th>Event Title</th>
									<th>Description</th>
									<th>Event Date</th>
									<th>Event Time</th>
									<th>Location</th>
									<th>Ticket Price</th>
									<th>Tickets Available</th>
									<th>Ticket Type</th>
								</tr>
							</thead>
							<tbody>
							<%
							EventDao dao=new EventDao();
							List<Event> event=dao.fetchAllEvents();
							//Event evnt =(Event) session.getAttribute("userObj");
							for(Event e:event){
					
								%>
								<tr>
								<td><%= e.getId() %></td>
								<td><%= e.getEvent_title() %></td>
								<td><%= e.getDescription() %></td>
								<td><%= e.getEvent_date() %></td>
								<td><%= e.getEvent_time() %></td>
								<td><%= e.getLocation() %></td>
								<td><%= e.getTicket_price() %></td>
								<td><%= e.getTickets_available() %></td>
								<td><%= e.getTicket_type() %></td>
								
								
								<td><a class ="btn btn-primary" href="../event/book_event.jsp?id=<%= e.getId()%>">Book Event</a>
								<td><a class ="btn btn-primary" href="../user/send_feedback.jsp?event_id=<%= e.getId()%>">Send Feedback</a>
								
								</td>
								
								</tr>
							<%}
							%>
							</tbody>
						</table>

					</div>
				</div>


			</div>

		</div>
	</div> 

</body>
</html>