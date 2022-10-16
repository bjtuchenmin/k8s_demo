# k8s_demo
## 构建镜像
```
docker build -t dockerchenmin/tomcat_image:v2 .
```
## 推送镜像
```
docker login
docker push dockerchenmin/tomcat_image:v2
```
## 在集群中启动 Pod
```
kubectl run tomcat --image=dockerchenmin/tomcat_image:v2 --image-pull-policy=IfNotPresent -o yaml > pod_tomcat.yaml
```

