# k8s_demo
## 应用架构与集群结构
前端：NGINX

后端：Tomcat

集群：`minikube start --vm`

## 后端构建
初始化一个 Spring Boot 应用（添加 Spring Web 依赖），添加一个 Controller 拦截请求，方法返回服务端 IP 和时间。
使用 Maven 打成 jar 包，编写 `Dockerfile`，执行以下命令构建并推送镜像：
```
docker build -t dockerchenmin/tomcat_image:v2 .
docker login
docker push dockerchenmin/tomcat_image:v2
```
编写 `deploy_tomcat.yaml` 和 `service_tomcat.yaml` 创建（管理）Pod 并暴露服务，service 的名字定为 `tomcathost`。

## 前端构建
编写 `Dockerfile_nginx` 和配置文件 `nginx.conf`，并在配置文件中用 `tomcathost`（后端的 service 名称）作为转发的域名，然后构建并推送镜像。

编写 `deploy_nginx.yaml` 和 `service_nginx.yaml` 创建（管理）Pod 并暴露服务，由于需要在宿主机访问（即在集群外访问），service 的类型选择为 `NodePort`。

## 访问
执行 `minikube ip` 或 `kubectl get no -o wide` 查看节点 IP 为 172.16.124.10。

浏览器访问：`http://172.16.124.10:30006/getserverinfo`

## 备注
### 在集群中启动 Pod
```
kubectl run tomcat --image=dockerchenmin/tomcat_image:v2 --image-pull-policy=IfNotPresent -o yaml > pod_tomcat.yaml
```

### 启动 Pod 后进行端口转发
```
kubectl port-forward tomcat 8083:8080
```

## 参考
https://bbs.huaweicloud.com/blogs/351713

