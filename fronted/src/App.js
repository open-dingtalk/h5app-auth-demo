import './App.css';
import axios from 'axios';
import * as dd from 'dingtalk-jsapi';

//内网穿透工具介绍:
// https://developers.dingtalk.com/document/resourcedownload/http-intranet-penetration?pnamespace=app
// 替换成后端服务域名
const domain = "http://localhost:8080";
function App() {

}

dd.ready(function() {
  // dd.ready参数为回调函数，在环境准备就绪时触发，jsapi的调用需要保证在该回调函数触发后调用，否则无效。
  dd.runtime.permission.requestAuthCode({
    corpId: "ding9f50b15bccd16741", //三方企业ID
    onSuccess: function(result) {
      alert(JSON.stringify(result));
      axios.get(domain + "/login?authCode=" + result.code)
          .then(response => {
            alert(JSON.stringify(response))
            // console.log(response)
          })
          .catch(error => {
            alert(JSON.stringify(error))
            // console.log(error.message)
          })

    },
    onFail : function(err) {
      alert(JSON.stringify(err))
    }
  });
});

export default App;
