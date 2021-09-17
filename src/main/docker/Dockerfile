FROM openjdk:8-jdk-alpine

RUN echo -e "https://mirrors.aliyun.com/alpine/v3.6/main\n\
https://mirrors.aliyun.com/alpine/v3.6/community" > /etc/apk/repositories
RUN apk --update add curl bash openjdk8 tini git && \
      rm -rf /var/cache/apk/*

VOLUME /tmp
ADD muse-0.0.1.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "/sbin/tini -- java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]