# 베이스 이미지 파일
FROM openjdk:8-jdk-alpine
# 컨테이너 내부로 파일 복사
COPY build/libs/selectshop-0.0.1-SNAPSHOT.jar app.jar
# 컨테이너 생성되면서 실행
ENTRYPOINT ["java","-jar","/app.jar"]