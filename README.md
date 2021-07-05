## h5app-auth-demo
> 钉钉用户免登，统一授权组件需要登陆[开发者后台](https://open-dev.dingtalk.com/)，在创建的应用中配置“应用首页地址“、添加“成员信息读取权限”
>
> **fronted**文件夹下是接入钉钉JSAPI获取authCode，之后使用npm run build打包，将打包好的静态资源放入backend子模块。
>
> **backend**子模块使用authCode获取access_token,之后使用access_token获取用户信息，然后使用用户id获取用户详情。

##### 配置应用首页地址

![img](https://img.alicdn.com/imgextra/i4/O1CN01QGY87t1lOZN65XHqR_!!6000000004809-2-tps-2870-1070.png)

##### 申请成员信息读取权限

![img](https://img.alicdn.com/imgextra/i2/O1CN01n0QZM321k7rcBwfsr_!!6000000007022-2-tps-2822-1080.png)



## Getting Started



### 克隆代码仓库到本地
git clone
```
https://github.com/open-dingtalk/h5app-auth-demo.git
```

### 修改后端服务域名&corpId

![img](https://img.alicdn.com/imgextra/i4/O1CN01if9tOf1uM7ne63QdC_!!6000000006022-2-tps-2590-1138.png)

### 使用命令行安装依赖&打包

```txt
cd fronted/
```

![img](https://img.alicdn.com/imgextra/i3/O1CN01ARrKz11tO7ummiqT0_!!6000000005891-2-tps-2874-620.png)

```txt
npm install
```

![img](https://img.alicdn.com/imgextra/i3/O1CN01gHUmkc217CCCwI1IL_!!6000000006937-2-tps-1952-1026.png)

```txt
npm run build
```

![img](https://img.alicdn.com/imgextra/i1/O1CN01RczhFR1wZ4DqhGF0z_!!6000000006321-2-tps-2226-1074.png)

### 将打包好的静态资源文件放入后端服务

![img](https://img.alicdn.com/imgextra/i1/O1CN01R4qEhc1K5nVhtlMrF_!!6000000001113-2-tps-1728-1128.png)

### 替换后端应用配置

![img](https://img.alicdn.com/imgextra/i2/O1CN01rAV4yz1eG8lt4NkSE_!!6000000003843-2-tps-2126-1050.png)

### 启动项目使用钉钉访问服务

![img](https://img.alicdn.com/imgextra/i3/O1CN01JF5vH91hRXTb17Z5d_!!6000000004274-2-tps-1082-1436.png)

![img](https://img.alicdn.com/imgextra/i2/O1CN01eIF9ym26jHD3GcTfl_!!6000000007697-2-tps-1002-1454.png)


### 参考文档

1. H5应用接入JSAPI，文档链接：https://developers.dingtalk.com/document/app/logon-free-process?spm=ding_open_doc.document.0.0.6dbdad29INJCRg#topic-2025319
2. 获取企业内部应用access_token，文档链接：https://developers.dingtalk.com/document/app/obtain-orgapp-token?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1936350
3. 获取用户userId，文档链接：https://developers.dingtalk.com/document/app/obtain-the-userid-of-a-user-by-using-the-log-free?spm=ding_open_doc.document.0.0.5b9077a26qJ9aI#topic-2010561
4. 获取用户详情，文档链接：https://developers.dingtalk.com/document/app/query-user-details?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1960047
