FROM openjdk:17

LABEL mantainer="Roberto Picanço <robpicanco@gmail.com>"

ADD target/pagamento-acl.jar /home/app.jar

CMD /usr/bin/java $JAVA_OPTS -jar /home/app.jar