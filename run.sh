#!/usr/bin/env bash

cd profil
mvn clean package
cd ../matching
mvn clean package
cd ../procedures
mvn clean package
cd ..

docker-compose up --build