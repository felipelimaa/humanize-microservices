# Projeto Humanize Microservices
O projeto Humanize Microservices tem como objetivo simular, de forma simples, através de um mono-repo a estruturação de microserviços de APIs para folha de pagamento de funcionários.

### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- OpenJDK 11 (https://adoptopenjdk.net/)
- Docker (https://docs.docker.com/engine/install/)
- Docker Compose (https://docs.docker.com/compose/install/)

### Features
**v1**
- [X] Criar a API para lidar com os usuários/funcionários (user-api)
- [X] Criar a API para lidar com os pagamentos a funcionários (payroll-api)
- [X] Criar serviço do Eureka Server para permitir o registro dos microserviços (eureka-server)
- [X] Registrar as APIs (user-api/payroll-api) no Eureka Server
- [X] Conectar __payroll-api__ ao __user-api__ utilizando o ```@FeignClient```
- [X] Criar __api-gateway__ para realizar o balanceamento de carga
- [X] Criar ```Dockerfile``` para os quatro repositórios
- [X] Criar ```docker-compose``` para startar os quatro repositórios de uma única vez

## Desenvolvimento
O projeto é executado através do _Spring Boot_ como framework backend.

Para execução do projeto, abra na sua IDE desejada ou, caso deseje executar o ambiente baseado no código, acesse cada um dos repositórios e execute o seguinte comando:

```
./gradlew bootRun
```

Através de uma IDE, é possível executar a classe: 
- **Eureka Server:** `EurekaServerApplication.groovy`
- **API Gateway:** `ApiGatewayApplication.groovy`
- **User API:** `UserApiApplication.groovy`
- **Payroll API:** `PayrollApiApplication.groovy`

## Execução do projeto completo (build and deploy)
O projeto contempla um arquivo global `docker-compose.yaml` e um arquivo unitário `Dockerfile` para cada projeto, composto com o processo de build e execução do projeto (multi-stage).

Caso deseje executar o projeto completo, com a build e ambiente de execução, na pasta raiz do projeto, execute o seguinte comando:

```
docker-compose up -d 
```
