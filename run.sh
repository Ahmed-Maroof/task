mvn clean install -D skipTests
docker-compose down
docker-compose up --build --renew-anon-volumes
