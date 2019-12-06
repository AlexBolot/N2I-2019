echo
echo "------------------------------------------------"
echo "Creating a new profile"
curl -d "{\"email\":\"theos.mariani@gmail.com\",\"firstName\":\"Theos\",\"name\":\"Mariani\",\"age\":22,\"ville\":\"Nice\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/profil/
echo
echo
echo "Login with my email"
curl -d "theos.mariani@gmail.com" -H "Content-Type: text/plain" -X POST http://localhost:8080/profil/login
echo
echo
echo "Accessing my profile"
curl -X GET http://localhost:8080/profil/theos.mariani@gmail.com
echo
echo
echo "Creating procedures"
curl -d "{\"status\":\"IN_PROGRESS\",\"ownerEmail\":\"theos.mariani@gmail.com\"}" -H "Content-Type: application/json" -X POST http://localhost:8082/procedure/
curl -d "{\"status\":\"IN_PROGRESS\",\"ownerEmail\":\"bolotalex06@gmail.com\"}" -H "Content-Type: application/json" -X POST http://localhost:8082/procedure/
echo
echo
echo "Getting all procedure"
curl -H "Content-Type: application/json" -X GET http://localhost:8082/procedure/
echo
echo
echo "Getting my procedures"
curl -H "Content-Type: application/json" -X GET http://localhost:8082/procedure/theos.mariani@gmail.com
echo
echo
echo "Finding matching profiles"
curl -H "Content-Type: application/json" -X GET http://localhost:8081/matching/theos.mariani@gmail.com
echo
echo "------------------------------------------------"
echo

docker-compose down
