#!/bin/bash
# Create the target namespace if it doesn’t exist
kubectl create namespace kafka 2>/dev/null

# Add the Strimzi Helm repo and update
helm repo add strimzi https://strimzi.io/charts/
helm repo update

# Install the Strimzi Kafka Operator using our custom values file
helm install strimzi-kafka-operator strimzi/strimzi-kafka-operator \
  -f kafka-setup/helm/strimzi-values.yaml \
  --namespace kafka
