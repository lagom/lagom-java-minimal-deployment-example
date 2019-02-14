#!/bin/bash


eval $(minikube docker-env)

mvn clean package docker:build
kustomize build deployment/overlays/minikube | kubectl apply -f -

