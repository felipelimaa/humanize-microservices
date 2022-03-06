# Realiza o download da imagem do gradle e realiza a instalação
FROM gradle:7.4.0-jdk11-alpine as build

# Aplica permissão para o grupo e usuário no determinado diretório
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle --no-daemon --console=plain test build

# Realiza o download da imagem do java
FROM adoptopenjdk/openjdk11-openj9:alpine

# Declarando que o processo não será executado como usuário ROOT
RUN addgroup -S userapi && adduser -S userapi -G userapi && mkdir /app && chown userapi.userapi /app

# Declarando o usuário que executará os comandos a partir dos próximos passos
USER userapi

# Realiza a cópia do jar
COPY --from=build /home/gradle/src/build/libs/*.jar /app/userapi.jar

# Expõe a porta 8000
EXPOSE 8000

# Executa o comando para rodar o jar
CMD ["java", "-jar", "/app/userapi.jar"]
