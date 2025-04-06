#!/bin/bash

BOOTSTRAP_SERVER=my-cluster-kafka-bootstrap:9092

# Create main topics (3 partitions, replication factor 3)
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic customer-account-state-change --partitions 3 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic create-account --partitions 3 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic create-billing-account --partitions 3 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic delete-account --partitions 3 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic customer-plan-activation --partitions 3 --replication-factor 3

# Create DLQ topics (1 partition, replication factor 3)
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic customer-account-state-change.DLQ --partitions 1 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic create-account.DLQ --partitions 1 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic create-billing-account.DLQ --partitions 1 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic delete-account.DLQ --partitions 1 --replication-factor 3
kafka-topics.sh --bootstrap-server $BOOTSTRAP_SERVER --create --topic customer-plan-activation.DLQ --partitions 1 --replication-factor 3
