# API Documentation

This document provides detailed information on the available API endpoints and their usage.

## Sellers API

### Get All Sellers

- **GET:** `/api/sellers`
- **Description:** `Get a list of all sellers.`

### Get Seller by ID

- **GET:** `/api/sellers/{id}`
- **Description:** `Get a seller by their unique ID.`

### Add a New Seller

- **POST:** `/api/sellers`
- **Description:** `Create a new seller. The request expects JSON input in the following format:`

```json
{
  "carShowroomDto": {
    "age": 30,
    "firstName": "John",
    "lastName": "Doe",
    "role": "MANAGER",
    "carShowroomDto": {
      "id": "1"
    }
  }
}
```

**Roles:** `Available roles are "MANAGER" and "SELLER".`

### Update Seller by ID

- **PATCH:** `/api/sellers/{id}?role=?&age=?`
- **Description:** `Update a seller's role and age by their unique ID.`

### Delete Seller by ID

- **DELETE:** `/api/sellers/{id}`
- **Description:** `Delete a seller by their unique ID.`

## Car Showroom API

### Create a New Car Showroom

- **POST:** `/api/car-showrooms`
- **Description:** `Create a new car showroom. The request expects JSON input in the following format:`

```json
{
  "name": "BMW car dealership"
}
```
### Get Car Showroom by id

- **GET:** `/api/car-showrooms/{id}`
  
## Orders API

### Get all orders

- **GET:** `/api/orders`
- **Description:** `Get a list of all orders.`
  
### Sale car and create new Order

- **POST:** `/api/orders/saleCar/{carId}/{sellerId}`
- **Description:** `Create a new order for the sale of a car. Replace {carId} and {sellerId} with the respective IDs.`
  
### Get order by id
- **GET:** `/api/orders/{id}`
- **Description:** `Get a car by their unique ID.`

## Revenue API

### Get revenue by date

- **GET:** `/api/car-showrooms/{idCarshowroom}/revenues/day/{date}`
- **Description:** `Indicate the date in the format: yyyy-MM-dd. For example: 2023-09-19.`
  
### Get revenue by week

- **GET:** `/api/car-showrooms/{idCarshowroom}/revenues/week/{date1}/{date2}`
- **Description:** `Receiving income from date1 to date2.`
  
### Get revenue by Month
- **GET:** `/api/car-showrooms/{idCarshowroom}/revenues/years/month/{year}/{month}`
- **Description:** `Indicate the month in the following formats: 1,2,3,4,5,6,7,8,9,10,11,12.`

## API for Cars

### Get All Cars

- **GET:** `/api/cars`
- **Description:** `Get a list of all cars.`

### Get Car by ID

- **GET:** `/api/cars/{id}`
- **Description:** `Get a car by its unique ID.`

### Create New Car

- **POST:** `/api/cars`
- **Description:** `Create a new car. The request expects JSON input in the following format:`

```json
{
  "mark": "BMW",
  "model": "M8",
  "year": "2023",
  "price": "1500000",
  "type": "SPORT_CAR",
  "carShowroomDto": {
    "id": "2"
  }
}
```
**Types:** `Available types are "PASSENGER_CAR","FREIGHTER_CAR","SPORT_CAR".`

