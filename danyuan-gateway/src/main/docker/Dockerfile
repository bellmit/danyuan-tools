FROM java:8
LABEL org.opencontainers.image.authors="514840279@qq.com" 
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY danyuan-getway-1.0.jar danyuan-getway-1.0.jar
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "danyuan-getway-1.0.jar" ]