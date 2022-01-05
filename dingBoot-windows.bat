@echo off
set appName=%1
set port=%2
set appKey=%3
set appSecret=%4
set agentId=%5
set corpId=%6

if not exist ../pierced (
    git clone https://github.com/open-dingtalk/pierced.git ../pierced
)

start cmd /k "mvn clean package && move backend\target\*.jar %appName%.jar && java -jar %appName%.jar --port=%port% --appKey=%appKey% --appSecret=%appSecret% --agentId=%agentId% --corpId=%corpId%s"
start cmd /k "cd ../pierced/windows_64 && ding -config=ding.cfg  -subdomain=%appKey% %port%"
