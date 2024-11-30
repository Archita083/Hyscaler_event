<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dao.EventDao"%>
<%@page import="com.org.dto.Event"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.car_paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="../components/user_navbar.jsp" %>
<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
<%
   	UserDao dao=new UserDao();
	int event_id=Integer.parseInt(request.getParameter("id"));
	//User u=dao.fetchUserById(id);
	EventDao e_dao=new EventDao();
	Event e=e_dao.fetchEventById(event_id);
	User u=(User)session.getAttribute("userObj");
%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car_paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Book Ticket for Event</p>
						<form action="../event/book_ticket" method="post">
						<div class="mb-3">
								<label class="form-label">User Id</label> <input
									name="user_id" type="number" class="form-control" value="<%=u.getId() %>"required>
							</div>
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="user_name" type="text" class="form-control" value="<%=u.getName() %>"required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input
									name="user_email" type="email" class="form-control" value="<%=u.getEmail() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="user_mobile" type="number" class="form-control" value="<%=u.getMobile() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Event Date</label> <input
									name="event_date" type="text" class="form-control" value="<%=e.getEvent_date() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Event Time</label> <input
									name="event_time" type="text" class="form-control" value="<%=e.getEvent_time() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Ticket Type</label> <input
									name="ticket_type" type="text" class="form-control" value="<%=e.getTicket_type() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Ticket Price</label> <input
									name="ticket_price" type="number" class="form-control" value="<%=e.getTicket_price() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Number of Tickets</label> <input
									name="ticket_count" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Total Price</label> <input
									name="total_price" type="number" class="form-control" required>
							</div>
						    
						    
						    <input name="id" type="hidden" value="<%=e.getId() %>">
						
							<button type="submit" class="btn bg-primary text-white col-md-12">Proceed to Payment</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>