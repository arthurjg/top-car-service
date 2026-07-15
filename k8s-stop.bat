kubectl delete hpa top-car-service-hpa
kubectl delete service top-car-service-svc
kubectl delete service top-car-app-db-svc
kubectl delete deployment app-deployment
kubectl delete deployment db-deployment
kubectl delete secrets app-db-credentials
kubectl delete configmap app-settings