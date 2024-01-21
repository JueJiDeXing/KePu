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
    <div v-for="path in videos.paths" :key="path" class="video-item">
      <video :src="path" controls></video>
      <p>{{ path.split('/').pop() }}</p>
    </div>
  </div>

</template>
<script>
import {reactive, ref} from "vue";
import * as videoList from '../../../public/videos/videoList.json';

export default {
  setup() {
    const query = ref("");
    const videos = reactive({
      paths: [] // 视频路径数组
    });
    getVideoInfo(videoList, "", "/videos/Default/", true);//初始放Default的

    function onSearch(event) {
      event.preventDefault();
      console.log("search");
      const keyword = query.value;
      console.log("videoList=", videoList);
      videos.paths = [];//先清空
      videos.paths = getVideoInfo(videoList, keyword);
      console.log("videos.path=", videos.paths);
    }

    function getVideoInfo(videoList, keyword, path = '/videos/', isIn = false, split = '/') {
      let res = [];
      for (const category in videoList) {
        if (!Object.prototype.hasOwnProperty.call(videoList, category) || category === 'default') continue;
        if (isIn && category === 'videos') {
          res = res.concat(path + videoList[category]);
          continue;
        }
        let subVideos = null;
        if (isIn && typeof videoList[category] === 'object') {
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, true);
          res = res.concat(subVideos);
          continue;
        }
        // isIn==false
        if (category === 'videos') continue;
        if (category === keyword) {
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, true);
        } else if (typeof videoList[category] === 'object') {
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, false);
        }
        res = res.concat(subVideos);
      }
      return res;
    }

    return {
      query,
      videos,
      onSearch
    };
  }
};
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

.video-container {
  margin: auto;
  width: 80%;
  display: flex;
}

video {
  margin: 20px;
  height: 400px;
  width: 400px;
}

</style>
