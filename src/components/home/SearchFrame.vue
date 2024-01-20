<script setup>

</script>

<template>
  <div class="form-container">
    <form @submit="onSearch">
      <div class="search-box">
        <input
            v-model="query"
            type="text"
            class="search-input"
            placeholder="输入关键字搜索"
        />
        <button class="search-button">
          <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-wyysousuo"></use>
          </svg>
        </button>
      </div>
    </form>
  </div>
  <div class="video-container">

  </div>

</template>
<script>
import {ref} from 'vue';

export default {
  setup() {
    console.log("setup")
    const query = ref('');

    function onSearch(e) {
      e.preventDefault();
      console.log('onSearch', query.value);
      // 这里可以编写你的搜索逻辑
    }

    return {
      query,
      onSearch
    };
  }
}
</script>
<style scoped lang="less">
.form-container {
  margin-top: 20px;
  display: flex;
  justify-content: center;

  .search-box {
    width: 100%;
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 0.5rem;

    .search-input {
      width: 500px;
      height: 60px;
      flex-grow: 1;
      border: none;
      outline: none;
      font-size: 24px;
    }

    .search-button {
      margin-left: 0.5rem;
      width: 60px; /* 设置图标的宽度 */
      height: 60px; /* 设置图标的高度 */
      border-radius: 10px;

      .icon {
        width: 80%; /* 让图标填充按钮的大小 */
        height: 80%;
      }

    }

  }

}


</style>
