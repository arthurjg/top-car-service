kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/secrets.yaml    
kubectl apply -f k8s/deployment-db.yaml
kubectl apply -f k8s/service-db.yaml
kubectl apply -f k8s/deployment-app.yaml
kubectl apply -f k8s/service-app.yaml
kubectl apply -f k8s/hpa.yaml