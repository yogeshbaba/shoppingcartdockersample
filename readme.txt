gradle build
java -jar build/libs/Customer-0.0.1-SNAPSHOT.jar
docker build --build-arg JAR_FILE=build/libs/Customer-0.0.1-SNAPSHOT.jar -t practise/shoppingcart-customer-docker .
//compose
docker build -t practise/shoppingcart-customer-docker .
docker run -p 8080:8080 practise/shoppingcart-customer-docker

