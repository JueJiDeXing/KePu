<script setup>

</script>

<template>
  <div class="page-home">
    <div class="form-container">
      <form @submit="onSearch">
        <div class="search-box">
          <div class="search-drop">
            <span class="search-tab-text">ss</span>
            <span class="dropdown-arrow">v</span>
          </div>
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
        <span class="video-title">{{ path.split('/').pop() }}</span>
        <video :src="path" controls class="video-content"></video>
      </div>
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
    videos.paths = getVideoInfo(videoList["Default"], "", "/videos/Default/", true);//初始放Default的
    console.log("videos.path=", videos.paths);

    function onSearch(event) {
      event.preventDefault();
      console.log("search");
      const keyword = query.value;
      console.log("videoList=", videoList);
      videos.paths = getVideoInfo(videoList, keyword);
      console.log("videos.path=", videos.paths);
    }

    //videoList:json对象  keyword:查找的关键词  只查找分类名
    function getVideoInfoTemp(videoList, keyword, path = '/videos/', isIn = false, split = '/') {
      let res = [];
      for (const category in videoList) {//遍历子对象
        if (!Object.prototype.hasOwnProperty.call(videoList, category) || category === 'default') continue;

        if (isIn && category === 'videos') {//是搜索的分类下的videos,全部加入
          let v = Object.assign([], videoList[category]);
          for (let i = 0; i < v.length; i++) v[i] = path + v[i];//在前面添加路径
          res = res.concat(v);
          continue;
        }
        if (category === 'videos') return;//不是搜索的分类下的videos,匹配视频名称关键词

        let subVideos = null;
        if ((isIn && typeof videoList[category] === 'object') || category.indexOf(keyword) !== -1) {//在分类下的对象,或者该分类匹配到关键词
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, true);
        } else if (typeof videoList[category] === 'object') {//不在匹配下的分类,递归查询
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, false);
        }
        if (subVideos && subVideos.length) res = res.concat(subVideos);
      }
      return res;
    }

    //videoList:json对象  keyword:查找的关键词  分类和视频都能找
    function getVideoInfo(videoList, keyword, path = '/videos/', isIn = false, split = '/') {
      let res = [];
      for (const category in videoList) {//遍历子对象
        if (!Object.prototype.hasOwnProperty.call(videoList, category) || category === 'default') continue;

        if (isIn && category === 'videos') {//是搜索的分类下的videos,全部加入
          let v = Object.assign([], videoList[category]);
          for (let i = 0; i < v.length; i++) v[i] = path + v[i];//在前面添加路径
          res = res.concat(v);
          continue;
        }
        if (category === 'videos') {//不是搜索的分类下的videos,匹配视频名称关键词
          for (const video of videoList[category]) {
            if (video.indexOf(keyword) !== -1) {//有匹配的关键词
              res.push(path + video);
            }
          }
        }
        let subVideos = null;
        if ((isIn && typeof videoList[category] === 'object') || category.indexOf(keyword) !== -1) {//在分类下的对象,或者该分类匹配到关键词
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, true);
        } else if (typeof videoList[category] === 'object') {//不在匹配下的分类,递归查询
          subVideos = getVideoInfo(videoList[category], keyword, path + category + split, false);
        }
        if (subVideos && subVideos.length) res = res.concat(subVideos);
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
.page-home {
  background-color: black;
  position: relative;
  min-height: 1000px;


  .form-container {
    padding: 80px;
    display: flex;
    justify-content: center;
    background: rgba(255, 255, 255, .09);
    z-index: -1;

    .search-box {
      width: 100%;
      display: flex;
      align-items: center;
      border: 1px solid #ccc;
      border-radius: 50px;
      padding: 0.5rem;

      .search-drop {
        position: relative;
        z-index: 99;
        width: 123px;
        height: 48px;
        border-radius: 40px;
        font-size: 14px;
        align-self: center;
        background: #4A54FF linear-gradient(315deg, #6772FF 0, #00F9E5 100%) center center;
        background-size: 104% 104%;

        .search-tab-text {
          display: block;
          height: 48px;
          line-height: 48px;
          text-align: center;
          cursor: pointer;
        }

        .dropdown-arrow {
          position: absolute;
          right: 13px;
          top: 0;
          font-size: 18px;
          color: #ccc;
          transition: transform .3s, top .3s;
        }
      }

      .search-input {
        width: 1200px;
        height: 80px;
        flex-grow: 1;
        outline: none;
        position: relative;
        animation: home-fade .6s ease-in-out 1;
        line-height: 50px;
        border: none;
        background: rgba(255, 255, 255, .09);
        display: flex;
        align-items: center;
        color: #fff;
        box-sizing: border-box;
        text-align: left;
        padding: 0 4px;
        font-size: 24px !important;
        transition: border .4s, background .4s;
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
    column-count: 3; /* 设置瀑布流列数为3，可以根据需求进行调整 */
    column-gap: 10px; /* 设置列间距，可以根据需求进行调整 */

    .video-item {
      break-inside: avoid; /* 防止视频被分割到不同列中 */
      margin-bottom: 10px; /* 设置视频项之间的垂直间距，可以根据需求进行调整 */

      .video-content {
        margin: 20px;
        height: 300px;
        width: 300px;
      }

      .video-title {
        color: white;
        background: rgba(255, 255, 255, .09);

      }
    }
  }

  @media only screen and (max-width: 768px) {
    .video-container {
      column-count: 1; /* 在小屏幕上，设置列数为1，即变为单列布局 */
    }
  }
}

</style>
