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
	<%@ include file="../components/navbar.jsp" %>
	<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car_paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Organizer Register</p>
						<form action="../organiser/register_organizer" method="post">
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Register</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>