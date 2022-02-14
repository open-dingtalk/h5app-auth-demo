#!/bin/bash
appName=$2
port=$3
appKey=$4
appSecret=$5
agentId=$6
corpId=$7
APP_NAME=${appName}.jar
usage() {
    echo "Usage:sh $0 [start|stop|restart|status]"
    exit 1
}
is_exist() {
    pid=`ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}' `
    #If there is no return 1, return 0
    if [ -z "${pid}" ]; then
      return 1
    else
      return 0
    fi
}

extract_jar() {
  if [ ! -d "backend/target/" ];then
    exit 1
  else
    mv backend/target/*.jar ./${APP_NAME}
    rm -rf backend/target/
  fi

}

start_pierced() {
  cd ../
  if [ ! -d "dingtalk-pierced-client/" ];then
    git clone https://github.com/open-dingtalk/dingtalk-pierced-client.git
    cd dingtalk-pierced-client/linux
    chmod 777 ./ding
    ./ding -config=./ding.cfg -subdomain=${appKey} $port
  else
    cd dingtalk-pierced-client/linux
    chmod 777 ./ding
    ./ding -config=./ding.cfg -subdomain=${appKey} $port
  fi

}

#npm_run_build() {
#  cd ../frontend
#  if [ ! -d "node_modules/" ];then
#    npm install
#    npm run build
#  else
#    npm run build
#  fi
#  cd ../backend
#}

maven_build_package(){
  mvn clean package
  if (( $? ))
  then
      echo "mvn package failed"
      exit 1
  else
      echo "mvn package success"
  fi
}

#Start method
start() {
   stop
#   echo ">>>> npm_run_build"
#   npm_run_build
   echo ">>>> maven_build_package"
   maven_build_package
   echo ">>>> extract_jar"
   extract_jar
   java -jar ${APP_NAME} --port=${port} --appKey=${appKey} --appSecret=${appSecret} --agentId=${agentId} --corpId=${corpId} >> Log.log 2>&1 &
   echo ">>>> start_pierced"
   start_pierced
}

stop() {
   is_exist
   if [ $? -eq "0" ]; then
     kill -9 $pid
     echo "${APP_NAME} already stop !"
   else
     echo "${APP_NAME} is not running"
   fi
   rm -rf Log.log
}


status() {
   is_exist
   if [ $? -eq "0" ]; then
     echo "${APP_NAME} is running. Pid is ${pid}"
   else
     echo "${APP_NAME} is not running."
   fi
}

restart() {
   stop
   start
}

# shellcheck disable=SC1073
case "$1" in
   "start")
     start
     ;;
   "stop")
     stop
     ;;
   "status")
     status
     ;;
   "restart")
     restart
     ;;
   *)
     usage
     ;;
esac
