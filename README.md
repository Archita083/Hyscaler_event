# Welcome To The Event Management System
## Requirements:
An event management system should have features that help with planning, managing attendees, booking ticket, collect feedback about event, and more.
## Solution Design:
The event management system using the MVC architecture:
- M(model): Model is mainly the MySQL database where we store the data of this management system using mysql.
- V(view): View is mainly focus the frontend part of the management system using Jsp which is consist html in it's code.
- C(controller): Controller is mainly focus the backend part of the management system using Servlet, which is mainly consist of 3 packages i.e Controller,Dao and Dto packages.
- Here we design pages for user,organizer and for event.
## Technology involved:
- HTML
- CSS
- JAVASCRIPT
- SERVLET
- JSP
- MYSQL
## Assumption:
- Here we have:
- event user:External person who can place a request.
- event organizer:Internal employee to change status.
- Here we have two dashboard one is event user dashboard and another one is the event organizer dashboard.
- In event user dashboard the user can search event using keyword,book a ticket,view booking history,send feedback.
- In event organizer dashboard the organizer can create event, view bookings, view feedback.
