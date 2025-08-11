#!/bin/zsh
docker stop greatming
docker rm -f greatming
docker rmi -f greatming:1.1.0
rm ./target/GreatMing-1.1.0.jar*
./mvnw clean install -DskipTests
docker build -t greatming:1.1.0 .
