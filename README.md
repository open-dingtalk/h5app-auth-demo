# 钉钉用户免登Demo

## 1. 功能介绍

“应用免登录”是指当用户点击一个应用时，无需单独手动输入钉钉用户名和密码，应用程序可自动获取当前用户的钉钉身份，通过钉钉的身份登录应用。

## 2. 项目结构

> **fronted**：前端模块，使用react构建，主要功能有：接入钉钉JSAPI获取authCode、展示免登用户信息。
>
> **backend**：后端模块，使用springboot构建，主要功能有：使用authCode获取access_token、使用access_token获取用户信息、使用用户id获取用户详情等。

以下为目录结构与部分核心代码文件：

```
.
├── README.md     ----- 说明文档
├── backend
│   ├── dingBoot-linux.sh     ----- 启动脚本（linux）
│   ├── dingBoot-mac.sh    ----- 启动脚本（mac）
│   ├── dingBoot-windows.bat     ----- 启动脚本（windows）
│   ├── lib     ----- 开发SDK包
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── aliyun
│           │           └── dingtalk
│           │               ├── Application.java     ----- 启动类
│           │               ├── config
│           │               │   └── AppConfig.java     ----- 应用配置类
│           │               ├── constant
│           │               │   └── UrlConstant.java     ----- 接口API
│           │               ├── controller
│           │               │   ├── DingTalkConfig.java     ----- 获取配置接口 
│           │               │   └── DingTalkUserController.java     ----- 核心业务接口
│           │               └── service
│           │                   └── DingTalkUserService.java     ----- 核心业务代码
│           └── resources
│               └── application.properties     ----- 应用配置文件
├── fronted
│   └── src
│       └── App.js     ----- 前端展示页面和交互代码
└── pom.xml
```

## 3. 开发环境准备

1. 需要有一个钉钉注册企业，如果没有可以创建：https://oa.dingtalk.com/register_new.htm#/

2. 成为钉钉开发者，参考文档：https://developers.dingtalk.com/document/app/become-a-dingtalk-developer

3. 登录钉钉开放平台后台创建一个H5应用： https://open-dev.dingtalk.com/#/index

4. 配置应用：

  ① 配置开发管理，参考文档：https://developers.dingtalk.com/document/app/configure-orgapp

  **此处配置“应用首页地址”需公网地址，若无公网ip，可使用钉钉内网穿透工具：** https://developers.dingtalk.com/document/resourcedownload/http-intranet-penetration

  ![img](https://img.alicdn.com/imgextra/i4/O1CN01QGY87t1lOZN65XHqR_!!6000000004809-2-tps-2870-1070.png)

  ② 配置相关权限，参考文档：https://developers.dingtalk.com/document/app/address-book-permissions

  本demo使用接口权限："成员信息读权限"

![img](https://img.alicdn.com/imgextra/i2/O1CN01n0QZM321k7rcBwfsr_!!6000000007022-2-tps-2822-1080.png)

## 4. 启动项目

### 4.1 脚本启动（推荐）

脚本启动，只需执行一条命令即可启动项目，方便快速体验。

#### 4.1.1 脚本说明

① 脚本启动前置条件：

- 安装配置了java开发环境（jdk、maven）
- 安装配置了git工具

② 脚本类型如下：

```shell
dingBoot-linux.sh     # linux版本
dingBoot-mac.sh       # mac版本
dingBoot-windows.bat  # windows版本
```

#### 4.1.2 下载项目

```shell
git clone https://github.com/open-dingtalk/h5app-auth-demo.git
```

#### 4.1.3 启动脚本

执行时将命令中示例参数替换为**应用参数**，在后端项目（脚本同级目录）下运行命令。

① **脚本运行命令：**

- **执行linux脚本**

```shell
./dingBoot-linux.sh start {项目名} {端口号} {appKey} {appSecret} {agentId} {corpId}
```

- **mac系统（使用终端运行，mac m1芯片暂不支持）**

```shell
./dingBoot-mac.sh start {项目名} {端口号} {appKey} {appSecret} {agentId} {corpId}
```

- **windows系统 使用cmd命令行启动**

```shell
./dingBoot-windows.bat {项目名} {端口号} {appKey} {appSecret} {agentId} {corpId}
```

- **示例（linux脚本执行）**

```sh
 ./dingBoot-linux.sh start h5-demo 8080 ding1jmkwa4o19bxxxx ua2qNVhleIx14ld6xgoZqtg84EE94sbizRvCimfXrIqYCeyj7b8QvqYxxx 122549400 ding9f50b15bccd1000
```

② **参数获取方法：**

- 获取corpId——开发者后台首页：https://open-dev.dingtalk.com/#/index ![](https://img.alicdn.com/imgextra/i2/O1CN01amtWue1l5nAYRc2hd_!!6000000004768-2-tps-1414-321.png)

- 进入应用开发-企业内部开发-点击进入应用-基础信息-获取appKey、appSecret、agentId ![](https://img.alicdn.com/imgextra/i3/O1CN01Rpfg001aSjEIczA85_!!6000000003329-2-tps-905-464.png)

#### 4.1.4 启动后配置

① **配置访问地址**

启动完成会自动生成临时域名，配置方法：进入开发者后台->进入应用->开发管理->应用首页地址和PC端首页地址

- 生成的域名： ![](https://img.alicdn.com/imgextra/i3/O1CN01lN8Myr1XIFJmlDSWf_!!6000000002900-2-tps-898-510.png)

- 配置地址： ![](https://img.alicdn.com/imgextra/i1/O1CN01IWleEp1Kw0hX9suby_!!6000000001227-2-tps-1408-489.png)

② **发布应用**

配置好地址后进入“版本管理与发布页面”，发布应用，发布后即可在PC钉钉或移动钉钉工作台访问应用

- 发布应用： ![](https://img.alicdn.com/imgextra/i4/O1CN01DTtp4E1qAtfDeGORj_!!6000000005456-2-tps-1414-479.png)

### 4.2 手动启动（与脚本启动二选一）

#### 4.2.1 下载项目

```shell
git clone https://github.com/open-dingtalk/h5app-auth-demo.git
```

#### 4.2.2 配置应用参数

获取到以下参数，修改后端application.properties

```yaml
app:
  app_key: *****
  app_secret: *****
  agent_id: *****
  corp_id: *****
```

参数获取方法：登录开发者后台

- 获取corpId——开发者后台首页：https://open-dev.dingtalk.com/#/index ![](https://img.alicdn.com/imgextra/i2/O1CN01amtWue1l5nAYRc2hd_!!6000000004768-2-tps-1414-321.png)

- 进入应用开发-企业内部开发-点击进入应用-基础信息-获取appKey、appSecret、agentId ![](https://img.alicdn.com/imgextra/i3/O1CN01Rpfg001aSjEIczA85_!!6000000003329-2-tps-905-464.png)

#### 4.2.3 修改前端页面

**打开项目，命令行中执行以下命令，编译打包生成build文件**（如果不修改页面，则可跳过此步骤）

```shell
cd front-end
npm install
npm run build
```

**将打包好的静态资源文件放入后端**（如果不修改页面，则可跳过此步骤）

![image-20210706173224172](https://img.alicdn.com/imgextra/i2/O1CN01QLp1Qw1TCVrPddfjZ_!!6000000002346-2-tps-322-521.png)

#### 4.2.4 启动项目

- 启动SpringBoot（运行启动类Application.java）

- 启动内网穿透工具，配置应用访问链接并发布应用（参考上方“脚本启动” -> “启动后配置”）

- 移动端/PC端钉钉点击工作台，找到应用，进入应用体验demo

## 5. 页面展示

<img src="https://img.alicdn.com/imgextra/i3/O1CN01WrpXL51uYUWJIdv3v_!!6000000006049-2-tps-720-1158.png" alt="img" style="zoom:50%;" />


## 6. 参考文档

1. H5应用接入JSAPI，文档链接：https://developers.dingtalk.com/document/app/logon-free-process?spm=ding_open_doc.document.0.0.6dbdad29INJCRg#topic-2025319
2. 获取企业内部应用access_token，文档链接：https://developers.dingtalk.com/document/app/obtain-orgapp-token?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1936350
3. 获取用户userId，文档链接：https://developers.dingtalk.com/document/app/obtain-the-userid-of-a-user-by-using-the-log-free?spm=ding_open_doc.document.0.0.5b9077a26qJ9aI#topic-2010561
4. 获取用户详情，文档链接：https://developers.dingtalk.com/document/app/query-user-details?spm=ding_open_doc.document.0.0.938247e54bE13v#topic-1960047
