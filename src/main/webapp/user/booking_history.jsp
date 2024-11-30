<%@page import="com.org.dao.TicketDao"%>
<%@page import="com.org.dao.UserDao"%>
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
	<%@ include file="../components/user_navbar.jsp" %>
	
	<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
	<%
	
	//User user=(User)session.getAttribute("userObj");
	//UserDao user=new UserDao();
	int user_id=Integer.parseInt(request.getParameter("id"));
	//User u=user.fetchUserById(user_id);
	
	//Feedback f=dao.fetchFeedbackByUserId(user_id);
	%>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Booking History</p>
						<table class="table">
							<thead>
								<tr>
									<th>Ticket Id</th>
									<th>Event Date</th>
									<th>Event Time</th>
									<th>Ticket Type</th>
									<th>Ticket Price</th>
									<th>Ticket Count</th>
									<th>Total Price</th>
									
								</tr>
							</thead>
							<tbody>
							<%
							TicketDao dao=new TicketDao();
							List<Booking> booking=dao.fetchTicketByUserId(user_id);
							for(Booking b:booking){
								//if (fedback.getUser_id()==f.getUser_id())
									//continue;
								%>
								<tr>
								<td><%= b.getId() %></td>
								<td><%= b.getEvent_date() %></td>
								<td><%= b.getEvent_time() %></td>
								<td><%= b.getTicket_type() %></td>
								<td><%= b.getTicket_price() %></td>
								<td><%= b.getTicket_count() %></td>
								<td><%= b.getTotal_price() %></td>
								
						
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