#!/bin/bash
kafka-topics --zookeeper csye7374-zookeeper:2181 --create --if-not-exists --partitions 1 --replication-factor 3 --topic csye7374