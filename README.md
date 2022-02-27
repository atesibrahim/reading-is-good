
## Reading Is Good Application

##### This app has been developed as Restful APIs with Spring Boot 

Aim of Reading Is Good Applicaiton is to deliver books to the customers who are ordered.

### Contents 

- [Welcome](#welcome)
- [Application Tech Stack](#application-tech-stack)
- [Docker Build and Run](#docker-build-and-run)
- [Api Endpoints](#api-endpoints)
  - [Health Check](#health-check)
  - [Get Token](#get-token)
  - [Get Customer Orders](#get-customer-orders)
  - [Get Customer Monthly Statistics](#get-customer-monthly-statistics)
  - [Add New Customer](#add-new-customer)
  - [Add New Book](#add-new-book)
  - [Update Book Stock](#update-book-stock)
  - [Get Order By Id](#get-order-by-id)
  - [List Orders By Date](#list-orders-by-date)
  - [Add New Order](#add-new-order)
  - [Api Doc](#api-doc)
- [Initial Data Load to Tables](#initial-data-load-to-tables)
- [Validation Messages](#validation-messages)
- [Authentication and Important Notes!](#authentication-and-important-notes!)
- [Test Coverage Rate](#test-coverage-rate)



### Welcome

Welcome on reading is good board

You will be find details about project bellow.

App will run on 8090 port.

When you are running to started this app on your pc;
data.sql will create **CUSTOMER***, **ORDERS** and **BOOK** tables

Initially, some example data will be created on tables.


### Application Tech Stack

The application developed with 
- **java 11**
- **Springboot**
- **H2 database**
- **spring-boot-data-jpa**
- **Lombok**
- **spring-boot-starter-validation**
- **spring-boot-starter-test, mockito and junit5**
- **spring-boot-starter-security** 
- **springdoc-openapi-ui** 

***Version 2.6.3 was used for all dependencies related to spring!***

### Docker build and run

`docker build --tag=reading-is-good:1.0 .`

`docker run -p 8090:8090 reading-is-good:1.0 .`


### Api Endpoints

Postman collection is here 
[ReadingIsGood.postman_collection.json](https://github.com/atesibrahim/reading-is-good/tree/master/src/main/resources/postman-collection/ReadingIsGood.postman_collection.json)

You will be found postman collection under `resource/postman-collection`

***Not that: Please be aware of getting token at the first. Otherwise, you will get forbidden error without token*** 

*If the file does not open for any reason, please consider the requests below.*

#### Health Check

GET : http://localhost:8090/health

#### Get Token

GET: http://localhost:8090/token

This will return you a bearer token as => 
`Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFkaW5nS2V5IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY0NTc0MDA5OSwiZXhwIjoxNjQ1NzQwNjk5fQ.1DiynpaNqQ3xF9aMo22spimtfVC7Uh0IZ_GMvVzF9P-BvpJ38OC2sIQi-hLPkRW1FrxOGauHk33T2wmW18AsdA`

***Important!***

For your postmand requests please consider authorization, Unless you will get Unauthorized error.

`{
"timestamp": "2022-02-26T13:35:12.492+00:00",
"status": 401,
"error": "Unauthorized",
"path": "/orders"
}`

*Authorization type should be chosen Bearer Token and paste your bearer token which you taken from getToken*

#### Get Customer Orders

GET: http://localhost:8090/customers/2/orders

#### Get Customer Monthly Statistics

GET: http://localhost:8090/statistics/1


#### Add New Customer

POST: http://localhost:8090/customers

Body should be like;
{
"balance": 120
}

#### Add New Book

POST: http://localhost:8090/books

Body should be like;
{
"price": 10.0,
"stock": 100
}

#### Update Book Stock

PUT: http://localhost:8090/books/1/stock?stock=10

#### Get Order By Id

GET: http://localhost:8090/orders/1

#### List Orders By Date

GET : http://localhost:8090/orders?startDate=2022-02-20&endDate=2022-02-22

*if start date bigger than end date, you will get response as;*

`{
"apierror": {
"status": "BAD_REQUEST",
"timestamp": "25-02-2022 03:26:58",
"message": "StartDate Cannot Be Greater Than EndDate"
}
}`


#### Add New Order

POST: http://localhost:8090/orders

Request Body should be like;
`{
"customerId": 2,
"bookId": 3,
"orderAmount": 50,
"bookCount": 20
}
`
When you create order with order amount bigger than customer balance,
then you will be get error like;

`{
"apierror": {
"status": "BAD_REQUEST",
"timestamp": "25-02-2022 03:34:13",
"message": "Your balance is not sufficient"
}
}`


When you create order with book count bigger than book stock,
then you will be get error like;

`{
    "apierror": {
    "status": "BAD_REQUEST",
    "timestamp": "25-02-2022 03:36:23",
    "message": "The stock of books is not enough for your order"
    }
}`


### API Doc

GET : `http://localhost:8090/api`


### Initial Data Load to Tables

Following data added to data.sql file under resource folder. These data is added initially when the application run.

`INSERT INTO CUSTOMER (Id, Balance) VALUES (1, 8500);`

`INSERT INTO CUSTOMER (Id, Balance) VALUES (2, 6000);`

`INSERT INTO CUSTOMER (Id, Balance) VALUES (3, 8500);`

`INSERT INTO CUSTOMER (Id, Balance) VALUES (4, 18500);`

`INSERT INTO BOOK (Id, Price, Stock) VALUES (1, 85, 10);`

`INSERT INTO BOOK (id, Price, Stock) VALUES (2, 40, 60);`

`INSERT INTO BOOK (id, Price, Stock) VALUES (3, 80, 10);`

`INSERT INTO BOOK (id, Price, Stock) VALUES (4, 8, 100);`

`INSERT INTO ORDERS (Id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (1, 2, '2022-02-24 12:27:19.882449', 1, 10, 1500);`

`INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (2, 2, '2022-02-23 12:27:19.882449', 3, 23, 1500);`

`INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (3, 2, '2022-02-20 12:27:19.882449', 3, 23, 1500);`

`INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (4, 2, '2022-01-24 12:27:19.882449', 2, 23, 1500);`

`INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (5, 1, '2022-01-23 12:27:19.882449', 2, 100, 100);`

### Validation Messages

***If you update book stock with negative number, then it will throw error as;***
`updateStock.stock: must be greater than or equal to 0`

***If you inquire get by negative or zero id, then it will throw error***
`updateStock.id: must be greater than 0`

***If you add customer with negative balance, then it will throw error***
`[customerDto.balance,balance]; arguments [];default message [balance]]; default message [must be greater than or equal to 0]`

***If you add book with negative or zero price, then it will throw error***
`[bookDto.price,price]; arguments []; default message [price]]; default message [must be greater than 0]`

***If you add order with negative or zero orderAmount, then it will throw error***
`[orderDto.orderAmount,orderAmount]; arguments []; default message [orderAmount]]; default message [must be greater than 0]]`

***If you add order with negative or zero customerId, then it will throw error***
`[orderDto.customerId,customerId]; arguments []; default message [customerId]]; default message [must be greater than 0]] ]`

***If you add order with negative or zero customerId, then it will throw error***
`[orderDto.bookId,bookId]; arguments []; default message [bookId]]; default message [must be greater than 0]] ]`

***If you add order with negative or zero bookCount, then it will throw error***
`[orderDto.bookCount,bookCount]; arguments []; default message [bookCount]]; default message [must be greater than 0]]`

### Authentication and Important Notes!
You won't be able to request without bearer token, so please get bearer token at first.
For getting token > http://localhost:8090/token

Then please choose Bearer Token authorization type on postman and paste your bearer token which you got from above url.

If you request without bearer token or with expired or with wrong bearer token you will be Unauthorized and forbidden error

### Test Coverage Rate

There are 57 test cases. And Test coverage as following;
Total test coverage rate as is;

`readingisgood	100% (36/36)	92% (118/128)	94% (282/299)`

And details;

`configuration	100% (4/4)	78% (15/19)	80% (24/30)`

`controller	100% (6/6)	90% (10/11)	96% (29/30)`

`domain	100% (6/6)	100% (30/30)	100% (31/31)`

`dto	100% (8/8)	88% (32/36)	88% (32/36)`

`exception	100% (5/5)	90% (9/10)	90% (18/20)`

`repository	100% (0/0)	100% (0/0)	100% (0/0)`

`security	100% (1/1)	100% (4/4)	83% (20/24)`

`service	100% (4/4)	100% (15/15)	100% (115/115)`

`ReadingIsGoodApplication	100% (2/2)	100% (3/3)	100% (13/13)`
