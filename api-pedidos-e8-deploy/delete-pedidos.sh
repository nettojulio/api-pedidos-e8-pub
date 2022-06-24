kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/secret-pedidos.yaml --namespace=grupo-08-dev
kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/configmap-pedidos.yaml --namespace=grupo-08-dev
kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/loadbalancer-pedidos.yaml --namespace=grupo-08-dev
kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/clusterip-pedidos.yaml --namespace=grupo-08-dev
kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/deployment-pedidos.yaml --namespace=grupo-08-dev
kubectl delete -f /home/ubuntu/grupo08/api-pedidos-e8-deploy/hpa-pedidos.yaml --namespace=grupo-08-dev