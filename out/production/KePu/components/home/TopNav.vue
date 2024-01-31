<template>
  <nav class="top-nav">
    <div class="logo-container">
      <img src="../../崇拜.jpg" alt="Logo">
      <h1>科普短视频平台</h1>
    </div>
    <ul class="nav-links">
      <li><a href="#">Home</a></li>
      <li><a href="#">About</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact</a></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'TopNav'
}
</script>

<style>
.top-nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  top: 0;
  width: 100%;
  background-color: #f1f1f1;
  position: relative;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  z-index: 999999;
}

.logo-container {
  display: flex;
  align-items: center;
}

.logo-container img {
  width: 40px;
  height: 40px;
  margin-right: 10px;
}

.nav-links {
  list-style: none;
  display: flex;
}

.nav-links li {
  margin-left: 20px;
}

.nav-links li a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
}

.nav-links li a:hover {
  color: #007bff;
}
</style>
