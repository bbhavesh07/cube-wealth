docker pull mysql:8

docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=cubewealth -d mysql:8

docker pull rabbitmq:3-management

docker run -p 15672:15672 --name rabbitmq rabbitmq:3-management

mvn clean install

docker build . -t cube-wealth

docker run -p 9090:9090 --name cube-wealth --link mysql-standalone:mysql --link rabbitmq:rabbitmq -d cube-wealth
