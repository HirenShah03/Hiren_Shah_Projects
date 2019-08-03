FROM solsson/kafka:0.11.0.0
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["./bin/kafka-topics.sh --zookeeper csye7374-zookeeper:2181 --create --if-not-exists --partitions 1 --replication-factor 3 --topic csye7374"]
