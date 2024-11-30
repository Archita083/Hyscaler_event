<%@page import="com.org.dao.TicketDao"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Booking"%>
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
	<%@ include file="../components/organizer_navbar.jsp" %>
	<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">View Bookings</p>
						
						
						<table class="table">
							<thead>
								<tr>
									<th>Booking id</th>
									<th>User id</th>
									<th>User name</th>
									<th>User email</th>
									<th>User mobile</th>
									<th>Event date</th>
									<th>Event time</th>
									<th>Ticket type</th>
									<th>Ticket price</th>
									<th>Ticket count</th>
									<th>Total price</th>
								</tr>
							</thead>
							<tbody>
							<%
							TicketDao dao=new TicketDao();
							List<Booking> ticket=dao.fetchAllBookings();
							for(Booking bo:ticket){
								%>
								<tr>
								<td><%= bo.getId()%></td>
								<td><%= bo.getUser_id()%></td>
								<td><%= bo.getUser_name()%></td>
								<td><%= bo.getUser_email()%></td>
								<td><%= bo.getUser_mobile()%></td>
								<td><%= bo.getEvent_date()%></td>
								<td><%= bo.getEvent_time()%></td>
								<td><%= bo.getTicket_type()%></td>
								<td><%= bo.getTicket_price()%></td>
								<td><%= bo.getTicket_count()%></td>
								<td><%= bo.getTotal_price()%></td>
								
								
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