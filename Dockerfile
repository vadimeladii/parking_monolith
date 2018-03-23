FROM java:9-jre
MAINTAINER Eladii Vadim <vadimeladii@gmail.com>
ADD ./build/libs/parking_monolith-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/parking_monolith-0.0.1-SNAPSHOT.jar"]