<%@page import="com.org.dao.FeedbackDao"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Feedback"%>
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
						<p class="fs-3 text-center">View Feedback</p>
						<table class="table">
							<thead>
								<tr>
									<th>User Id</th>
									<th>User Name</th>
									<th>Description</th>
									<th>Event Date</th>
									<th>Event Time</th>
									<th>Feedback</th>
								</tr>
							</thead>
							<tbody>
							<%
							FeedbackDao dao=new FeedbackDao();
							List<Feedback> feedback=dao.fecthAllFeedback();
							for(Feedback f:feedback){
								//if (fedback.getUser_id()==f.getUser_id())
									//continue;
								%>
								<tr>
								<td><%= f.getUser_id() %></td>
								<td><%= f.getUser_name() %></td>
								<td><%= f.getDescription() %></td>
								<td><%= f.getEvent_date() %></td>
								<td><%= f.getEvent_time() %></td>
								<td><%= f.getFeedback() %></td>
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