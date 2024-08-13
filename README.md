# This is basic Springboot express course

  It will help you to create simple springboot application using rest api.
  
  These urls and requests for all controller methods:

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
