<script setup>
import {ref} from 'vue';
import {adminLogin} from "@/request/api/adminLogin";
import router from "@/router";

const username = ref('');
const password = ref('');
const onSubmit = async function () {
  try {
    console.log("submit:", username.value, password.value);
    const result = await adminLogin({username: username.value, password: password.value});
    console.log("res:", result);
    if (result.code === 200) {
      console.log("登录成功");
      await router.push('/admin/home')
    } else {
      alert("用户名或密码错误");
    }
  } catch (e) {
    console.log(e);
  }
};

</script>

<template>
  <div class="login-form">
    <h1>登录</h1>
    <br>
    <van-form @submit="onSubmit">
      <van-cell-group inset>
        <van-field
            v-model="username"
            name="用户名"
            label="用户名"
            placeholder="用户名"
            :rules="[{ required: true, message: '请填写用户名' }]"
            size="large"
        />
        <van-field
            v-model="password"
            type="password"
            name="密码"
            label="密码"
            placeholder="密码"
            :rules="[{ required: true, message: '请填写密码' }]"
            size="large"
        />
      </van-cell-group>
      <div style="margin: 20px;">
        <van-button round block type="primary" native-type="submit" >
          提交
        </van-button>
      </div>
    </van-form>
  </div>
</template>
<style lang="less">
html, body {
  height: 100%;
  margin: 0;
}

.login-form {
  width: 500px;
  height: 100%;
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;

  van-form {
    margin-top: 10px;
  }
}
</style>
