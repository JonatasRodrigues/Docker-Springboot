FROM java:8
EXPOSE 8080

ADD /target/JavaSeniorJonatasRodrigues.jar JavaSeniorJonatasRodrigues.jar
ENTRYPOINT ["java","-jar","JavaSeniorJonatasRodrigues.jar"]