#!/usr/bin/env bash

cd profil
mvn clean package
cd ../matching
mvn clean package
cd ..

docker-compose run --rm start_dependencies
docker-compose up