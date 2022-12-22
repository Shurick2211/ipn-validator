curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:8080/persons -d'{"id":1, "ipn":1000, "firstName":"DDD", "lastName":"SSS", "sex":"MALE"}'
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:8080/persons -d'{"id":2, "ipn":2000, "firstName":"asd", "lastName":"ert", "sex":"FEMALE"}'
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:8080/persons -d'{"id":3, "ipn":3000, "firstName":"wer", "lastName":"fgt", "sex":"MALE"}'
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:8080/persons -d'{"id":4, "ipn":4000, "firstName":"vbn", "lastName":"hky", "sex":"MALE"}'
echo -e
curl http://localhost:8080/persons
echo -e
curl -X PUT -H "Accept:application/json" -H "Content-type:application/json" http://localhost:8080/persons -d'{"id":1, "ipn":1000, "firstName":"UPDATE", "lastName":"DDD", "sex":"FEMALE"}'

curl http://localhost:8080/persons/1000
echo -e
curl -X DELETE http://localhost:8080/persons/2000
echo -e
curl http://localhost:8080/persons
echo -e
