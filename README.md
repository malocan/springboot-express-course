# This is basic Springboot express course for beginners

  It will help you to create simple Spring Boot application using REST API 
  and review the work of common used annotations.

  Start your analisys from Controller class and go deeper into next layers.

  P.S.: Make sure that you build your application first with `mvn clean process-resourses` status should be SUCCESS.
  
  There are urls and requests for all controller methods:

## GET

URLs:

    http://localhost:8080/all

    http://localhost:8080/employee

```
{
    "id": 2,
    "name": "Andrei",
    "surname": "Malochka"
}
```
## PUT

URL:

    http://localhost:8080/5?email=LNMol@mail.ru&salary=23000

## POST

URL:

    http://localhost:8080/new

```
{
    "name": "John",
    "surname": "Doe",
    "email": "johndoe@gmail.com",
    "salary": 25000,
    "dateOfBirth": "1988-06-11"
}
```
## DELETE

URL:

    http://localhost:8080/5
