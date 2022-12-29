curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/persons -d'{"id":1, "ipn":"2000000015", "firstName":"DDD", "lastName":"SSS", "sex":"MALE"}'
echo -e
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/persons -d'{"id":2, "ipn":"2000000021", "firstName":"asd", "lastName":"ert", "sex":"FEMALE"}'
echo -e
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/persons -d'{"id":3, "ipn":"2000000038", "firstName":"wer", "lastName":"fgt", "sex":"MALE"}'
echo -e
curl -X POST -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/persons -d'{"id":4, "ipn":"2000000050", "firstName":"vbn", "lastName":"hky", "sex":"MALE"}'
echo -e
curl http://localhost:5000/persons
echo -e
curl -X PUT -H "Accept:application/json" -H "Content-type:application/json" http://localhost:5000/persons -d'{"id":1, "ipn":"2000000015", "firstName":"UPDATE", "lastName":"DDD", "sex":"FEMALE"}'
echo -e
curl http://localhost:5000/persons/2000000015
echo -e
curl -X DELETE http://localhost:5000/persons/2000000050
echo -e
curl -X DELETE http://localhost:5000/persons/2000000050
echo -e
curl http://localhost:5000/persons
echo -e
