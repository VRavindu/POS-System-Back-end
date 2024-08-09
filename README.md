Got it! Here's the content formatted for a `README.md` file on GitHub, without the code blocks for the Markdown syntax:

---

# POS System

A Point of Sale (POS) system for managing customers, items, and orders using Java Servlets and MySQL.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Documentation](#api-documentation)
  - [Customer API](#customer-api)
  - [Item API](#item-api)
  - [Order API](#order-api)
  - [OrderDetail API](#orderdetail-api)

## Introduction

This project implements a simple POS (Point of Sale) system that enables management of customers, items, and orders. It provides a RESTful API built with Java Servlets, leveraging MySQL as the underlying database.

## Technologies Used

- Java EE (Servlets)
- MySQL
- Jakarta JSON-B
- Logback (for logging)
- Apache Tomcat

## Setup Instructions

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/VRavindu/POS-System-Back-end
   cd PosSystem-Back-end
   ```

## API Documentation

Detailed documentation for the APIs provided by the POS system:

### Customer API

**POST /customer**

- **Description:** Creates a new customer in the system.
- **Request Body:** Content-Type: application/json

  ```json
  {
    "id": "C001",
    "name": "Vimukthi Ravindu",
    "address": "Neluwa",
    "salary": 25000
  }
  ```

- **Responses:**
  - `201 Created` - Customer was created successfully.
  - `400 Bad Request` - Invalid request payload or customer data.

**GET /customer**

- **Description:** Retrieves customers based on query parameters.
- **Query Parameters:**
  - `type=one&id=C001`: Retrieves a single customer by ID.
  - `type=all`: Retrieves all customers.

- **Responses:**
  - `200 OK` - Returns the customer(s) in JSON format.
  - `404 Not Found` - Customer not found.

**PUT /customer?id={customerId}**

- **Description:** Updates an existing customer.
- **Request Body:** Content-Type: application/json

  ```json
  {
    "name": "Kavindu Deshan",
    "address": "Galle",
    "salary": 15000
  }
  ```

- **Responses:**
  - `200 OK` - Customer updated successfully.
  - `400 Bad Request` - Invalid request or customer ID.

**DELETE /customer?id={customerId}**

- **Description:** Deletes a customer by ID.
- **Responses:**
  - `204 No Content` - Customer deleted successfully.
  - `400 Bad Request` - Invalid customer ID.

### Item API

**POST /item**

- **Description:** Creates a new item in the system.
- **Request Body:** Content-Type: application/json

  ```json
  {
    "code": "I001",
    "itemName": "Cake",
    "qty": 10,
    "unitPrice": 650
  }
  ```

- **Responses:**
  - `201 Created` - Item was created successfully.
  - `400 Bad Request` - Invalid request payload or item data.

**GET /item**

- **Description:** Retrieves items based on query parameters.
- **Query Parameters:**
  - `type=one&itemCode=I001`: Retrieves a single item by code.
  - `type=all`: Retrieves all items.

- **Responses:**
  - `200 OK` - Returns the item(s) in JSON format.
  - `404 Not Found` - Item not found.

**PUT /item?itemCode={itemCode}**

- **Description:** Updates an existing item.
- **Request Body:** Content-Type: application/json

  ```json
  {
    "itemName": "Biscute",
    "qty": 15,
    "unitPrice": 250
  }
  ```

- **Responses:**
  - `200 OK` - Item updated successfully.
  - `400 Bad Request` - Invalid request or item code.

**DELETE /item?itemCode={itemCode}**

- **Description:** Deletes an item by code.
- **Responses:**
  - `204 No Content` - Item deleted successfully.
  - `400 Bad Request` - Invalid item code.

### Order API

**POST /placeorder**

- **Description:** Places a new order.
- **Request Body:** Content-Type: application/json

  ```json
  {
    "orderId": "ORD001",
    "date": "2024-08-09",
    "customerId": "C001"
  }
  ```

- **Responses:**
  - `201 Created` - Order was placed successfully.

### OrderDetail API

**POST /orderdetail**

- **Description:** Saves order details.
- **Request Body:** Content-Type: application/json

  ```json
  [
    {
      "itemCode": "I001",
      "qty": 2,
      "unitPrice": 1500
    }
  ]
  ```

- **Responses:**
  - `201 Created` - Order details were saved successfully.

---
