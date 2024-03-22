import axios from 'axios'

let service = axios.create({
    baseURL: "http://localhost:8081/",
    timeout: 3000,
});


//添加响应拦截器
service.interceptors.response.use(
    result => {
        return result.data;
    },
    error => {
        alert("服务异常");
        return error.data; // 返回一个包含错误信息的对象
    }
);
export default service;
