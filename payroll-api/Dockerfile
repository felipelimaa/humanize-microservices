# Realiza o download da imagem do gradle e realiza a instalação
FROM gradle:7.4.0-jdk11-alpine as build

# Aplica permissão para o grupo e usuário no determinado diretório
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle --no-daemon --console=plain test build

# Realiza o download da imagem do java
FROM adoptopenjdk/openjdk11-openj9:alpine

# Declarando que o processo não será executado como usuário ROOT
RUN addgroup -S payrollapi && adduser -S payrollapi -G payrollapi && mkdir /app && chown payrollapi.payrollapi /app

# Declarando o usuário que executará os comandos a partir dos próximos passos
USER payrollapi

# Realiza a cópia do jar
COPY --from=build /home/gradle/src/build/libs/*.jar /app/payrollapi.jar

# Expõe a porta 8200
EXPOSE 8200

# Executa o comando para rodar o jar
CMD ["java", "-jar", "/app/payrollapi.jar"]
