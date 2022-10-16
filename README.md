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

## 用 docker 启动容器
```
docker run --name=tomcat_docker -p 8082:8080 <IMAGE_ID>
```

## 在集群中启动 Pod
```
kubectl run tomcat --image=dockerchenmin/tomcat_image:v2 --image-pull-policy=IfNotPresent -o yaml > pod_tomcat.yaml
```

