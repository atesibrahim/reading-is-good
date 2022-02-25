
## Information for Reading-is-Good Application.

##### This app has been developed as Rest Service with Spring Boot and love

Welcome on reading is good board

You will be find details about project bellow.

App will run on 8090 port.

When you are running to started this app on your pc;
data.sql will create customer, orders and book tables

Initially, some example data will be created on tables.

###App Tech Stack
Developed with java 11.

Springboot 2.6.3 version,

H2 database,

Lombok, Spring security was used.

#### data.sql:

INSERT INTO CUSTOMER (Id, Balance) VALUES (1, 8500);
INSERT INTO CUSTOMER (Id, Balance) VALUES (2, 6000);
INSERT INTO CUSTOMER (Id, Balance) VALUES (3, 8500);

INSERT INTO BOOK (Id, Price, Stock) VALUES (1, 85, 10);
INSERT INTO BOOK (id, Price, Stock) VALUES (2, 40, 60);
INSERT INTO BOOK (id, Price, Stock) VALUES (3, 80, 10);

INSERT INTO ORDERS (Id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (1, 2, '2022-02-24 12:27:19.882449', 1, 10, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (2, 2, '2022-02-23 12:27:19.882449', 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (3, 2, '2022-02-20 12:27:19.882449', 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (4, 2, '2022-01-24 12:27:19.882449', 2, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (5, 1, '2022-01-23 12:27:19.882449', 2, 100, 100);


###Docker build and run

docker build --tag=reading-is-good:1.0 .

docker run -p 8090:8090 reading-is-good:1.0 .

##Validation Messages;

####if you update book stock with negative number, then it will throw error as;
updateStock.stock: must be greater than or equal to 0

####If you inquire get by negative or zero id, then it will throw error;
updateStock.id: must be greater than 0

####If you add customer with negative balance, then it will throw error;
[customerDto.balance,balance]; arguments [];default message [balance]]; default message [must be greater than or equal to 0]

####If you add book with negative or zero price, then it will throw error;
[bookDto.price,price]; arguments []; default message [price]]; default message [must be greater than 0]

####If you add order with negative or zero orderAmount, then it will throw error;
[orderDto.orderAmount,orderAmount]; arguments []; default message [orderAmount]]; default message [must be greater than 0]]

####If you add order with negative or zero customerId, then it will throw error;
[orderDto.customerId,customerId]; arguments []; default message [customerId]]; default message [must be greater than 0]] ]

####If you add order with negative or zero customerId, then it will throw error;
[orderDto.bookId,bookId]; arguments []; default message [bookId]]; default message [must be greater than 0]] ]

####If you add order with negative or zero bookCount, then it will throw error;
[orderDto.bookCount,bookCount]; arguments []; default message [bookCount]]; default message [must be greater than 0]]

##Authentication and Important Notes!;
You won't be able to request without bearer token, so please get bearer token at first.
For getting token > http://localhost:8090/token

Then please choose Bearer Token authorization type on postman and paste your bearer token which you got from above url.

If you request without bearer token or with expired or with wrong bearer token you will be Unothorized and forbidden error

##Postman requests;
####Health Check;

GET : http://localhost:8090/health

####Get Token;

GET: http://localhost:8090/token

this will return bearer token as => Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFkaW5nS2V5IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY0NTc0MDA5OSwiZXhwIjoxNjQ1NzQwNjk5fQ.1DiynpaNqQ3xF9aMo22spimtfVC7Uh0IZ_GMvVzF9P-BvpJ38OC2sIQi-hLPkRW1FrxOGauHk33T2wmW18AsdA

##Important!

For your postmand requests please consider authorization, Unless you will get Unauthorized error.

Authorization type should be choose Bearer Token and paste your bearer token which you taken from getToken


####Get Customer Orders;

GET: http://localhost:8090/customers/2/orders

####Get Customer Monthly Statistics;

GET: http://localhost:8090/statistics/1

Add New Customer;

POST: http://localhost:8090/customers

Body should be like;
{
"balance": 120
}

####Add New Book;

POST: http://localhost:8090/books

Body should be like;
{
"price": 10.0,
"stock": 100
}

####Update Book Stock;

PUT: http://localhost:8090/books/1/stock?stock=10

Get Order By Id;

GET: http://localhost:8090/orders/1

List Orders By Date;

GET : http://localhost:8090/orders?startDate=2022-02-20&endDate=2022-02-22

####Add New Order;

POST: http://localhost:8090/orders

Body should be like;
{
"customerId": 2,
"bookId": 3,
"orderAmount": 50,
"bookCount": 20
}


Test Coverage Rate;

![img.png](img.png)

