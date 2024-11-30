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
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car_paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Payment Page</p>
						<% 
						 String str=(String)session.getAttribute("success");
						
						if(str!=null){
							%>
							<p class="text-center text-danger fs-5"><%= str %></p>
							<% 
							session.removeAttribute("success");
						}
						 %>
						
						<form action="../event/payment" method="post">
						<div class="mb-3">
								<label class="form-label">Card no</label> <input
									name="card_no" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">CVV no</label> <input
									name="cvv_no" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Name on Card</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Pay</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>