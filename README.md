# patrick-projeto-api-restfull-com-JavaSpringBoot

# dockeriazando a aplicação
1) Gerar o jar do projeto: mvn clean package -DskipTests (-DskipTests build final em producao nao usar esse argumento)
2) Na mesma pasta que estiver o arquivo docker-compose, executar o comando: docker compose up -d --build
