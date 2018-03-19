FROM java:8-jre
MAINTAINER Eladii Vadim <vadimeladii@gmail.com>
ADD ./build/libs/parking_monolith.jar /app/
CMD ["java", "-jar", "/app/parking_monolith.jar"]
EXPOSE 8888