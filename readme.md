run the java application by executing from the root folder: java -jar target/fssn-exchangerate-0.0.1.jar

alternatively run by docker following the steps:

1.  docker build --tag=fssnrate:latest .

2. docker run -p8887:8080 fssnrate:latest 

Or 
 
you can run it by SpringToolSuite4.

Errors are shown in the log.

Application:

1. Finnish social security number verification:

   - use postman to make a post request to: http://localhost:8888/fssn/validate
   - place the JSON data in the body as the following example where d represent a digit and L represent a Capital letter:
     {
     "ssn":"dddddd-dddL",
     "country_code":"LL"
     }

2. Exchange amount :

   - use postman to make a post request to: localhost:8888/exchange_amount
   - place the JSON data in the body as the following example :
     {
     "from":"EUR",
     "to":"USD",
     "from_amount":2000
     }

Please note that if the app returns this JSON  "message": "You cannot consume this service" you need to update the apiKey variable in ExchangeRateResponse class with a valid one
