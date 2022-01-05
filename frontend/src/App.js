import react ,{useEffect,useState} from 'react'
import './App.css';
import axios from 'axios';
import * as dd from 'dingtalk-jsapi';

//内网穿透工具介绍:
// https://developers.dingtalk.com/document/resourcedownload/http-intranet-penetration?pnamespace=app
// 替换成后端服务域名
const domain = "";
function App() {
  const [userInfo,setUserInfo] = useState({name:'',avatar:""})
  useEffect(()=>{
    dd.ready(function () {
      let corpId;
      fetch(domain + '/config')
        .then(res => res.json())
        .then((result) => {
          // alert(JSON.stringify(result));
          corpId = result.data.corpId;
          // dd.ready参数为回调函数，在 环境准备就绪时触发，jsapi的调用需要保证在该回调函数触发后调用，否则无效。
          dd.runtime.permission.requestAuthCode({
    
            corpId: corpId, //三方企业ID
            onSuccess: function(result) {
              axios.get(domain + "/login?authCode=" + result.code)
                .then(response => {
                  setUserInfo(response?.data?.data)
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
    });
  },[])

return <div className="App">
  <img src={userInfo.avatar||'https://img.alicdn.com/imgextra/i3/O1CN01Mpftes1gwqxuL0ZQE_!!6000000004207-2-tps-240-240.png'} className="avatar"/>
  <p>{userInfo.name} 登陆成功</p>
</div>
}



export default App;
