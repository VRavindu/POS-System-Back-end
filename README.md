# POS System

A Point of Sale (POS) system for managing customers, items, and orders using a backend built with Java Servlets and MySQL.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
    - [Customer API](#customer-api)
    - [Item API](#item-api)
    - [Order API](#order-api)

## Introduction

This project is a simple POS (Point of Sale) system that allows managing customers, items, and orders. It provides a RESTful API built with Java Servlets, and it uses MySQL as the database.

## Technologies Used

- Java EE (Servlets)
- MySQL
- Jakarta JSON-B
- Logback (for logging)
- Apache Tomcat

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/DmHirushan/PosSystem-using-Java
   

## API Documentation

## Customer API

POST /customer

Description: Creates a new customer in the system.
Request Body:
Content-Type: application/json

{
"id": "C001",
"name": "John Doe",
"address": "123 Main St",
"salary": 5000
}

Responses:
201 Created - Customer was created successfully.
400 Bad Request - Invalid request payload or customer data.

GET /customer

Description: Retrieves customers based on query parameters.
Query Parameters:
type=one&id=C001: Retrieves a single customer by ID.
type=all: Retrieves all customers.

Responses:
200 OK - Returns the customer(s) in JSON format.
404 Not Found - Customer not found. 


PUT /customer?id={customerId}
Description: Updates an existing customer.
Request Body:
Content-Type: application/json

{
"name": "Jane Doe",
"address": "456 Main St",
"salary": 6000
}

Responses:
200 OK - Customer updated successfully.
400 Bad Request - Invalid request or customer ID.

DELETE /customer?id={customerId}
Description: Deletes a customer by ID.
Responses:
204 No Content - Customer deleted successfully.
400 Bad Request - Invalid customer ID.


## Item API

POST /item
Description: Creates a new item in the system.
Request Body:
Content-Type: application/json

{
"code": "I001",
"itemName": "Laptop",
"qty": 10,
"unitPrice": 1500
}

Responses:
201 Created - Item was created successfully.
400 Bad Request - Invalid request payload or item data.

GET /item
Description: Retrieves items based on query parameters.
Query Parameters:
type=one&itemCode=I001: 
Retrieves a single item by code.
type=all: Retrieves all items.

Responses:

200 OK - Returns the item(s) in JSON format.
404 Not Found - Item not found.


PUT /item?itemCode={itemCode}

Description: Updates an existing item.

Request Body:

Content-Type: application/json

{
"itemName": "Laptop",
"qty": 5,
"unitPrice": 2000
}

Responses:

200 OK - Item updated successfully.

400 Bad Request - Invalid request or item code.




DELETE /item?itemCode={itemCode}.

Description: Deletes an item by code.

Responses:

204 No Content - Item deleted successfully.

400 Bad Request - Invalid item code.


## Order API

POST /placeorder

Description: Places a new order.

Request Body:
Content-Type: application/json

{
"orderId": "ORD001",
"date": "2024-08-09",
"customerId": "C001",
}

## OrderDetail API

POST

Description : Save Order Details

Request Body : Content-Type: application/json

[
    {
    "itemCode": "I001",
    "qty": 2,
    "unitPrice": 1500
    }
]

