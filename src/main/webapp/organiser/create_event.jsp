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
	<%@ include file="../components/organizer_navbar.jsp" %>
	<div class="col-md-12">
                            
            <img data-url="wp7488230" src="https://wallpapercave.com/wp/wp7488230.jpg" slug="corporate-event-wallpapers" class="wpimg" width="100%" >
        </div>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car_paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Create New Event</p>
						<form action="../organiser/create_event" method="post">
						<div class="mb-3">
								<label class="form-label">Event Title</label>
								 			<select name="event_title" class="form-control">
											<optgroup>
   											<option value="match">Live Match</option>
    										<option value="concert">Live Concert</option>
  											</optgroup>
  											</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label> <input
									name="description" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Event Date</label> <input
									name="date" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Event Time</label> <input
									name="time" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Location</label> <input
									name="location" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Ticket Price</label> <input
									name="price" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Tickets Available</label> <input
									name="count" type="number" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Privacy Settings</label>
								 			<select name="privacy" class="form-control">
											<optgroup>
   											<option value="public">Public</option>
  											</optgroup>
  											</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Ticket Types</label>
								 			<select name="ticket_types" class="form-control">
											<optgroup>
   											<option value="general">General</option>
    										<option value="vip">VIP</option>
  											</optgroup>
  											</select>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Create Event</button>
							
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>