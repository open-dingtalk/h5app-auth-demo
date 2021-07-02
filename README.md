## h5app-auth-demo
> 钉钉用户免登，统一授权组件需要登陆[开发者后台](https://open-dev.dingtalk.com/)，在创建的应用中配置“应用首页地址“、添加“成员信息读取权限”
>
> **fronted**文件夹下是接入钉钉JSAPI获取authCode，之后使用npm run build打包，将打包好的静态资源放入backend子模块。
>
> **backend**子模块使用authCode获取access_token,之后使用access_token获取用户信息，然后使用用户id获取用户详情。

##### 配置应用首页地址

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/f5f909b8a6ff41fc891f95f6846872b82460.png)

##### 申请成员信息读取权限

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/e1b9fd6eb9154fa2bc77037b02fa083c2460.png)



## Getting Started



### 克隆代码仓库到本地
git clone
```
https://github.com/open-dingtalk/h5app-auth-demo.git
```

### 修改后端服务域名&corpId

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/80ce9fe092ef4036a2f8ff7efb865be02460.png)

### 使用命令行安装依赖&打包

```txt
cd fronted/
```

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/b6da3926e6034773a8a756a6e233a5ee2460.png)

```txt
npm install
```

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/9a213f36537e4bf8b0c609f0a6d737db2460.png)

```txt
npm run build
```

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/a14c377d571a47088f80a7a55183d6132460.png)

### 将打包好的静态资源文件放入后端服务

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/714875c9b4294970b07004542047fc672460.png)

### 替换后端应用配置

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/ed1634c14c5d4aa79cd415e89f74c4162460.png)

### 启动项目使用钉钉访问服务

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/8b7dd238057b4d0a920903214dfbf86e2460.png)

![img](https://alidocs.oss-cn-zhangjiakou.aliyuncs.com/a/RNErEm4k2S2KW0jV/d5fdf50833e54727bd51c21fc91c15cb2460.png)


### 参考文档

1. H5应用接入JSAPI，文档链接：https://developers.dingtalk.com/document/app/logon-free-process?spm=ding_open_doc.document.0.0.6dbdad29INJCRg#topic-2025319
2. 获取企业内部应用access_token，文档链接：https://developers.dingtalk.com/document/app/obtain-orgapp-token?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1936350
3. 获取用户userId，文档链接：https://developers.dingtalk.com/document/app/obtain-the-userid-of-a-user-by-using-the-log-free?spm=ding_open_doc.document.0.0.5b9077a26qJ9aI#topic-2010561
4. 获取用户详情，文档链接：https://developers.dingtalk.com/document/app/query-user-details?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1960047
