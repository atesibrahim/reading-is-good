INSERT INTO CUSTOMER (Id, Balance) VALUES (1, 8500);
INSERT INTO CUSTOMER (Id, Balance) VALUES (2, 6000);
INSERT INTO CUSTOMER (Id, Balance) VALUES (3, 8500);

INSERT INTO BOOK (Id, Price, Stock) VALUES (1, 85, 10);
INSERT INTO BOOK (id, Price, Stock) VALUES (2, 40, 60);
INSERT INTO BOOK (id, Price, Stock) VALUES (3, 80, 10);

INSERT INTO ORDERS (Id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (1, 2, null, 1, 10, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (2, 2, null, 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (3, 2, null, 3, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (4, 2, null, 2, 23, 1500);
INSERT INTO ORDERS (id, Customer_Id, Order_Date, Book_Id, Book_Count, Order_Amount) VALUES (5, 1, null, 2, 100, 100);