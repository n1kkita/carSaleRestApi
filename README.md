-----------------------------------------------------------------------------------------------------------------------
API for Seller:

GET:   /api/sellers  <- get all sellers;

GET:   /api/sellers/{id} <- get seller by id;

POST:  /api/sellers <- add a new seller;

This request expects JSON input of this format

"carShowroomDto": {
          
  "age": 30,
 
  "firstName": "John",

  "lastName": "Doe",

  "role": "MANAGER",

  "carShowroomDto": {
   
  "id": "1",<-necessarily

  "name": "", <-optional

}

}

roles can be: "MANAGER","SELLER"


PATCH: /api/sellers/{{id}}?role=?&age=? <- update seller by id;

DELETE: /api/sellers/{{id}} <- delete seller by id;

-----------------------------------------------------------------------------------------------------------------------
API for Carshowroom:

POST: /api/car-showrooms <- create a new carshowroom

This request expects JSON input of this format

{

  "name": "BMW car dealership"

}

GET:  /api/car-showrooms/{id} <-get carshowroom by id

-----------------------------------------------------------------------------------------------------------------------
API for Orders:

GET:  /api/orders <- get all orders

POST: /api/orders/saleCar/{carId}/{sellerId} <- create new order

GET:  /api/orders/{id} <- get order by id

-----------------------------------------------------------------------------------------------------------------------
API for Revenue:

GET:  /api/car-showrooms/{idCarshowroom}/revenues/day/{date} <- get revenue by date

indicate the date in the format: yyyy-MM-dd

For example: 2023-09-19

GET:  /api/car-showrooms/{idCarshowroom}/revenues/week/{date1}/{date2}

GET /api/car-showrooms/{idCarshowroom}/revenues/years/month/{year}/{month}

indicate the month in the following formats: 1,2,3,4,5,6,7,8,9,10,11,12

-----------------------------------------------------------------------------------------------------------------------

API for Cars:

GET:  /api/cars <- get all cars

GET:  /api/cars/1 <- get car by id

POST: /api/cars <- create new car

This request expects JSON input of this format

{

  "mark": "BMW",

  "model": "M8",

  "year": "2023",

  "price": "1500000",

  "type": "SPORT_CAR",  type can be: "PASSENGER_CAR","FREIGHTER_CAR","SPORT_CAR"
  
  "carShowroomDto": {

  "id": "2"

}

}

PATCH:  /api/cars/{id}?newPrice=? <- update cost by car id

DELETE: /api/cars/{id} <- delete car by id

-----------------------------------------------------------------------------------------------------------------------