run the java application by executing from the root folder: java -jar target/fetch-Currencies-0.0.1.jar

alternatively run by docker following the steps:

1. docker build --tag=test-server:latest .

2. docker run -p 8888:8080 test-server:latest

Application:

1. Finnish social security number verification:

   - use postman by making a post request to: http://localhost:8888/fssn/validate
   - place the JSON data in the body as the following example where d represent a digit and L represent a Capital letter:
     {
     "ssn":"dddddd-dddL",
     "country_code":"LL"
     }

2. Exchange amount :

   - use postman by making a post request to: localhost:8888/exchange_amount
   - place the JSON data in the body as the following example :
     {
     "from":"EUR",
     "to":"USD",
     "from_amount":2000
     }
