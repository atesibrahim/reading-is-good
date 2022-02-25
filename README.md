
Welcome on reading is good board

This project developed with love :)

You will be find details about project bellow.

server run on 8090 port.

Developed with java 11.

H2 database was used.

Lombok, Spring security, JsonWebToken also was used.

Dockerfile:
for build and run

docker build --tag=reading-is-good-docker:1.0 .

docker run -p 8090:8090 reading-is-good-docker:1.0 .
or 
docker run -it --rm --name reading-is-good -p 8090:8090 reading-is-good-docker:1.0 .

validation messages;


if you update book stock with negative number, then it will throw error as;
updateStock.stock: must be greater than or equal to 0


If you inquire get by negative or zero id, then it will throw error;
updateStock.id: must be greater than 0

If you add customer with negative balance, then it will throw error;
[customerDto.balance,balance]; arguments [];default message [balance]]; default message [must be greater than or equal to 0]

If you add book with negative or zero price, then it will throw error;
[bookDto.price,price]; arguments []; default message [price]]; default message [must be greater than 0]

If you add order with negative or zero orderAmount, then it will throw error;
[orderDto.orderAmount,orderAmount]; arguments []; default message [orderAmount]]; default message [must be greater than 0]]

If you add order with negative or zero customerId, then it will throw error;
[orderDto.customerId,customerId]; arguments []; default message [customerId]]; default message [must be greater than 0]] ]

If you add order with negative or zero customerId, then it will throw error;
[orderDto.bookId,bookId]; arguments []; default message [bookId]]; default message [must be greater than 0]] ]

If you add order with negative or zero bookCount, then it will throw error;
[orderDto.bookCount,bookCount]; arguments []; default message [bookCount]]; default message [must be greater than 0]]

Authentication;
You won't be able to request without bearer token, so please get bearer token at first.
For getting token > http://localhost:8090/token

Then please choose Bearer Token authorization type on postman and paste your bearer token which you got from above url.

If you request without bearer token or with expired or with wrong bearer token you will be Unothorized and forbidden error


Postman requests;

Health Check;

GET : http://localhost:8090/health

Get Token;

GET: http://localhost:8090/token

this will return bearer token as => Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJyZWFkaW5nS2V5IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY0NTc0MDA5OSwiZXhwIjoxNjQ1NzQwNjk5fQ.1DiynpaNqQ3xF9aMo22spimtfVC7Uh0IZ_GMvVzF9P-BvpJ38OC2sIQi-hLPkRW1FrxOGauHk33T2wmW18AsdA

Get Customer Orders;

GET: http://localhost:8090/customers/2/orders

Get Customer Monthly Statistics;

GET: http://localhost:8090/statistics/1

Add New Customer;

POST: http://localhost:8090/customers

Body should be like;
{
"balance": 120
}

Add New Book;

POST: http://localhost:8090/books

Body should be like;
{
    "price": 10.0,
    "stock": 100
}

Update Book Stock;

PUT: http://localhost:8090/books/1/stock?stock=10

Get Order By Id;

GET: http://localhost:8090/orders/1

List Orders By Date;

GET : http://localhost:8090/orders?startDate=2022-02-20&endDate=2022-02-22

Add New Order;

POST: http://localhost:8090/orders

Body Should be like;
{
"customerId": 2,
"bookId": 3,
"orderAmount": 50,
"bookCount": 20
}


Test Coverage Rate;

![img.png](img.png)