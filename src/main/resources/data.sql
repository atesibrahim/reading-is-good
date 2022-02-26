INSERT INTO CUSTOMER (Id, Balance) VALUES (1, 18500);
INSERT INTO CUSTOMER (Id, Balance) VALUES (2, 16000);
INSERT INTO CUSTOMER (Id, Balance) VALUES (3, 18500);
INSERT INTO CUSTOMER (Id, Balance) VALUES (4, 18500);

INSERT INTO BOOK (Id, Price, Stock) VALUES (1, 85, 10);
INSERT INTO BOOK (id, Price, Stock) VALUES (2, 40, 60);
INSERT INTO BOOK (id, Price, Stock) VALUES (3, 80, 10);
INSERT INTO BOOK (id, Price, Stock) VALUES (4, 8, 100);

INSERT INTO ORDERS (Id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (1, 2, '2022-02-24 12:27:19.882449', 1, 10, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (2, 2, '2022-02-23 12:27:19.882449', 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (3, 2, '2022-02-20 12:27:19.882449', 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (4, 2, '2022-01-24 12:27:19.882449', 2, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (5, 1, '2022-01-23 12:27:19.882449', 2, 100, 100);