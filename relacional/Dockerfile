#Etapa de construção
#FROM maven:3.4.3-openjdk-21 AS build
#FROM ubuntu:latest AS build
FROM openjdk:21-jdk-slim AS build
RUN apt-get update && apt-get-install -y maven  && apt-get clean && rm -rf/var/lib/apt/lists/*


#Definir o diretório dentro do container para aplicação
WORKDIR /relacional

#Copiar o pom.xml para o container
COPY po.xml .
COPY src ./src

#Executar o maven para compliar o projeto e gerar o arquivo JAR File. 
RUN mvn clean package -DskipTests

#Etapa de Execucao
FROM openjdk:21-slim

#Definir o diretorio de trabalho para a aplicacao
WORKDIR /relacional

#Copiar p JAR construido na etapa anterior
COPY --from=build /relacional/target/*.jar relacional.jar

#Defininr a porta que sera utilizada na aplicacao
EXPOSE 8284

#Comando para executar a aplicacao
ENTRYPOINT [ "java", "-jar", relacional.jar ]