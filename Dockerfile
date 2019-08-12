FROM ubuntu:latest

RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y

ADD ./target/classes/data_fullstack.csv data_fullstack.csv

ADD ./target/review-search-application-0.1.0.jar review-dataSearch.jar

EXPOSE 8080

CMD java -jar review-dataSearch.jar data_fullstack.csv
