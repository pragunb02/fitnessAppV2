- config.yml

- @Produces(MediaType.APPLICATION_JSON)

- @Consumes(MediaType.APPLICATION_JSON))


-
curl -X GET 'http://localhost:8082/fitness/status/classId/12345?userId=12345'

-
curl -X POST 'http://localhost:8082/fitness/status/classes/123/users/121?waitlist=true&source=web' \
-H 'Content-Type:application/json' \
-d '{"preferredTime" : "23","notes":"fcgvbhjk"}'

-
{"bookingId":"f52a0f0e-7a4c-43c4-b339-73cb45a10c87","status":"Confirmed"}%                                                                  