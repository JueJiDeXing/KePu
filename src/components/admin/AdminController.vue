<!--<script setup>-->

<!--import {onMounted, ref} from 'vue'-->
<!--import * as layer from "element-plus/es/components/message/src/method";-->

<!--const breadcrumbsList = ref([]);// 存放头部导航数据-->
<!--const fileAndFolderList = ref([]); // 存放文件夹和文件数据-->
<!--const flieId = ref('');-->
<!--const-->
<!--// 全选框的显隐-->
<!--function isShowAllSelect() {-->
<!--  return fileAndFolderList.every(item => {-->
<!--    return item.FileFormat === 'AAA'-->
<!--  })-->
<!--}-->

<!--onMounted(() => {-->
<!--  getTableData('00000000-0000-0000-0000-000000000000')-->
<!--});-->

<!--function getTableData(ID) {-->
<!--  //发起请求-->
<!--}-->

<!--// 返回上一级-->
<!--function backBtn() {-->
<!--  if (breadcrumbsList.value.length === 1) {-->
<!--    breadcrumbsList.value = []-->
<!--    getTableData('00000000-0000-0000-0000-000000000000')-->
<!--  } else if (breadcrumbsList.length > 1) {-->
<!--    breadcrumbsList.pop()-->
<!--    getTableData(this.breadcrumbsList[this.breadcrumbsList.length - 1].Value)-->
<!--  }-->
<!--}-->

<!--// 点击全部文件-->
<!--function handleAllFolderBtn() {-->
<!--  breadcrumbsList.value = []-->
<!--  getTableData('00000000-0000-0000-0000-000000000000')-->
<!--}-->

<!--// 点击头部面包屑-->
<!--function handleBreadcrumbsItem(item, index) {-->
<!--  breadcrumbsList.value = breadcrumbsList.value.splice(0, index + 1)-->
<!--  getTableData(item.Value)-->
<!--}-->

<!--// 点击全选框-->
<!--function allSelectBtn() {-->
<!--  let chill = document.getElementById('all')-->
<!--  let chilles = document.getElementsByName('single')-->
<!--  if (chill.checked) {-->
<!--    fileAndFolderList && fileAndFolderList.forEach(item => {-->
<!--      if (item.FileFormat && item.FileFormat !== 'AAA') {-->
<!--        item.isSelected = true-->
<!--      }-->
<!--    })-->
<!--    for (let i = 0; i < chilles.length; i++) {-->
<!--      chilles[i].checked = true-->
<!--    }-->
<!--  } else {-->
<!--    fileAndFolderList && fileAndFolderList.forEach(item => {-->
<!--      if (item.FileFormat && item.FileFormat !== 'AAA') {-->
<!--        item.isSelected = false-->
<!--      }-->
<!--    })-->
<!--    for (let i = 0; i < chilles.length; i++) {-->
<!--      chilles[i].checked = false-->
<!--    }-->
<!--  }-->
<!--}-->

<!--// 鼠标经过 li-->
<!--function fileMouseEnter(item) {-->
<!--  flieId.value = item.Value || item.ID-->
<!--}-->

<!--// 鼠标离开 li-->
<!--function fileMouseLeave() {-->
<!--  flieId.value = '';-->
<!--}-->

<!--// 双击文件夹进入下一级-->
<!--function handleBreakdown(item) {-->
<!--  if (item.FileFormat && item.FileFormat === 'AAA') {-->
<!--    // console.log(item, '这是双击')-->
<!--    breadcrumbsList.push(item)-->
<!--    getTableData(item.Value)-->
<!--  }-->
<!--}-->

<!--// 点击文件是下载-->
<!--function downloadBtn(item) {-->
<!--  if (item.FileFormat && item.FileFormat !== 'AAA') {-->
<!--    // console.log('这是单击下载')-->
<!--  }-->
<!--}-->

<!--// 鼠标右键事件-->
<!--function fileMouseDown(item, e) {-->
<!--  e.target.oncontextmenu = function (e) {-->
<!--    e.preventDefault() // 阻止鼠标右键默认事件-->
<!--    console.log(item, 'zzzzz')-->
<!--  }-->
<!--}-->

<!--// 点击单选框-->
<!--function singleSelect(item, e) {-->
<!--  item.isSelected = e.target.checked-->
<!--  this.flieId = item.Value || item.ID-->
<!--  let chill = document.getElementById('all')-->
<!--  let chillesNum = document.getElementsByName('single').length-->
<!--  let selectedNum = document.querySelectorAll('input[name="single"]:checked').length-->
<!--  if (chillesNum === selectedNum) {-->
<!--    chill.checked = true-->
<!--  } else {-->
<!--    chill.checked = false-->
<!--  }-->
<!--}-->

<!--// 鼠标离开 编辑和删除区域，-->
<!--function operateMouseLeave(item) {-->
<!--  item.isShowOpetate = false-->
<!--}-->

<!--function editBtn(item) {-->
<!--  // console.log(item, '这是编辑')-->
<!--  alert('这是编辑')-->
<!--}-->

<!--function deleteBtn(item) {-->
<!--  layer.confirm('是否确认删除这条数据？', {-->
<!--    btn: ['确定', '取消'],-->
<!--    title: '确认信息'-->
<!--  }, function () {-->
<!--    layer.closeAll('dialog')-->
<!--    // console.log(item, '这是删除')-->
<!--    alert('这是删除')-->
<!--  })-->
<!--}-->
<!--</script>-->

<template>
  <!--<div class="all_files">-->
  <!--  &lt;!&ndash; 头部导航 &ndash;&gt;-->
  <!--  <div class="nav">-->
  <!--    <div class="back"-->
  <!--         v-if="breadcrumbsList && breadcrumbsList.length > 0"-->
  <!--         v-on:click="backBtn">-->
  <!--      <img src="@/assets/崇拜.jpg" alt="返回">-->
  <!--      <span style="margin-right: 20px;">返回上一级</span>-->
  <!--    </div>-->
  <!--    <span class="delimiter"-->
  <!--          v-if="breadcrumbsList && breadcrumbsList.length > 0"> | </span>-->
  <!--    <div class="breadcrumb_all">-->
  <!--        <span v-on:click="handleAllFolderBtn"-->
  <!--              :class="{'red_color': (breadcrumbsList && breadcrumbsList.length > 0), 'size_bold': breadcrumbsList.length === 0}">全部文件</span>-->
  <!--      <span class="arrow_right"-->
  <!--            v-if="(breadcrumbsList && breadcrumbsList.length > 0)"> > </span>-->
  <!--    </div>-->
  <!--    <div class="breadcrumb_item">-->
  <!--      <ul>-->
  <!--        <li v-for="(item, idx) in breadcrumbsList" :key="item.Value" v-on:click="handleBreadcrumbsItem(item, idx)">-->
  <!--            <span class="bc_name" :style="{'color': (idx !== breadcrumbsList.length - 1) ? '#E52E22' : '#333'}">{{-->
  <!--                item.Text-->
  <!--              }}</span>-->
  <!--          <span class="arrow_right" v-if="idx !== breadcrumbsList.length - 1"> > </span>-->
  <!--        </li>-->
  <!--      </ul>-->
  <!--    </div>-->
  <!--  </div>-->
  <!--  &lt;!&ndash; 文件图表 &ndash;&gt;-->
  <!--  <div class="table_files">-->
  <!--    <div class="table_top" v-if="!isShowAllSelect">-->
  <!--      <label>-->
  <!--        <input name="allCheckbox" type="checkbox" value="" id="all" v-on:click="allSelectBtn"><span>全选</span>-->
  <!--      </label>-->
  <!--    </div>-->
  <!--    <ul>-->
  <!--      <li v-for="item in fileAndFolderList" :key="item.Value || item.ID" :title="item.Text || item.WorkTitle"-->
  <!--          :class="{'selected_bgc': (flieId === item.Value) || (flieId === item.ID) || item.isSelected}"-->
  <!--          v-on:mouseenter="fileMouseEnter(item)" v-on:mouseleave="fileMouseLeave"-->
  <!--          v-on:mousedown="fileMouseDown(item, $event)"-->
  <!--          v-on:dblclick="handleBreakdown(item)" v-on:click="downloadBtn(item)" id="testId">-->
  <!--        <div class="single_checkbox">-->
  <!--          <div v-if="item.FileFormat && item.FileFormat !== 'AAA'">-->
  <!--            <label for="" v-show="(flieId === item.Value) || (flieId === item.ID) || item.isSelected">-->
  <!--              <input name="single" type="checkbox" value="" v-on:click.stop="singleSelect(item, $event)">-->
  <!--            </label>-->
  <!--            <div v-show="(flieId === item.Value) || (flieId === item.ID) || item.isSelected" class="operate_box"-->
  <!--                 v-on:mouseleave="operateMouseLeave(item)">-->
  <!--              <div class="point_box" v-on:click.stop="item.isShowOpetate = true">-->
  <!--                <img src="./images/椭圆.png" alt="">-->
  <!--              </div>-->
  <!--              <div class="edit_and_delete" v-if="item.isShowOpetate">-->
  <!--                <div class="edit_box" v-on:click="editBtn(item)">-->
  <!--                  <img src="./images/编辑.png" alt="">编辑-->
  <!--                </div>-->
  <!--                <div class="delete_box" v-on:click="deleteBtn(item)">-->
  <!--                  <img src="./images/删除.png" alt="">删除-->
  <!--                </div>-->
  <!--              </div>-->
  <!--            </div>-->
  <!--          </div>-->
  <!--        </div>-->
  <!--        <img :src="item.imageUrl" alt="" class="format_img">-->
  <!--        <img src="./images/已公开.png" alt="" class="public_img" v-if="item.PublishStatus === 11">-->
  <!--        <div class="flies_title">{{ item.Text || item.WorkTitle }}</div>-->
  <!--      </li>-->
  <!--    </ul>-->
  <!--  </div>-->
  <!--</div>-->
</template>

<!--<style lang="less">-->
<!--/* 把我们所有标签的内外边距清零 */-->
<!--* {-->
<!--  margin: 0;-->
<!--  padding: 0;-->
<!--  /* css3盒子模型 */-->
<!--  box-sizing: border-box;-->
<!--}-->

<!--/* 去掉li 的小圆点 */-->
<!--li {-->
<!--  list-style: none;-->
<!--}-->

<!--.hover_pointer {-->
<!--  /* 当我们鼠标经过button 按钮的时候，鼠标变成小手 */-->
<!--  cursor: pointer;-->
<!--}-->

<!--a {-->
<!--  color: #000;-->
<!--  text-decoration: none;-->
<!--}-->

<!--a:hover {-->
<!--  color: #F0AD4E;-->
<!--}-->

<!--body {-->
<!--  /* CSS3 抗锯齿形 让文字显示的更加清晰 */-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  background-color: #fff;-->
<!--  font: 12px/1.5 Microsoft YaHei, Heiti SC, tahoma, arial, Hiragino Sans GB, "\5B8B\4F53", sans-serif;-->
<!--  color: #666-->
<!--}-->

<!--.none {-->
<!--  display: none;-->
<!--}-->

<!--/* 清除浮动 */-->
<!--.clearfix:after {-->
<!--  visibility: hidden;-->
<!--  clear: both;-->
<!--  display: block;-->
<!--  content: ".";-->
<!--  height: 0;-->
<!--}-->

<!--.clearfix {-->
<!--  *zoom: 1;-->
<!--}-->

<!--.fl {-->
<!--  float: left;-->
<!--}-->

<!--.fr {-->
<!--  float: right;-->
<!--}-->

<!--body {-->
<!--  background-color: #f6f6f6;-->
<!--}-->

<!--/* 从这里开始 */-->
<!--.nav {-->
<!--  display: flex;-->
<!--  flex-wrap: nowrap;-->
<!--  padding: 5px;-->
<!--  background-color: #FFFFFF;-->
<!--  font-size: 14px;-->
<!--  font-family: Microsoft YaHei;-->
<!--  font-weight: 400;-->
<!--  color: #333333;-->
<!--}-->

<!--.back {-->
<!--  color: #E52E22;-->
<!--  cursor: pointer;-->
<!--}-->

<!--.back > img {-->
<!--  vertical-align: text-bottom;-->
<!--}-->

<!--.back .delimiter {-->
<!--  color: #666;-->
<!--}-->

<!--.red_color {-->
<!--  color: #E52E22;-->
<!--}-->

<!--.breadcrumb_all > span.size_bold {-->
<!--  font-weight: bold;-->
<!--  padding-left: 0;-->
<!--}-->

<!--.breadcrumb_all > :nth-child(1) {-->
<!--  padding-left: 20px;-->
<!--  cursor: pointer;-->
<!--}-->

<!--.bc_name {-->
<!--  cursor: pointer;-->
<!--}-->

<!--.arrow_right {-->
<!--  padding: 0 10px;-->
<!--}-->

<!--.breadcrumb_item > ul {-->
<!--  display: flex;-->
<!--}-->

<!--.table_files {-->
<!--  /* min-height: 788px; */-->
<!--  background-color: #FFFFFF;-->
<!--}-->

<!--.table_top {-->
<!--  padding-left: 15px;-->
<!--  height: 38px;-->
<!--  line-height: 38px;-->
<!--  font-size: 14px;-->
<!--  font-family: Microsoft YaHei;-->
<!--  font-weight: 400;-->
<!--  color: #333333;-->
<!--  background-color: #F5F5F5;-->
<!--  box-shadow: 0px -1px 0px 0px #E8E8E8;-->
<!--}-->

<!--.table_top > label > span {-->
<!--  padding-left: 10px;-->
<!--}-->

<!--.table_files > ul {-->
<!--  display: flex;-->
<!--  flex-wrap: wrap;-->
<!--}-->

<!--.table_files > ul > li {-->
<!--  margin: 5px;-->
<!--  width: calc(10% - 10px);-->
<!--  min-width: 118px;-->
<!--  text-align: center;-->
<!--  position: relative;-->
<!--}-->

<!--.table_files > ul > li.selected_bgc {-->
<!--  background-color: #E0F6FF;-->
<!--}-->

<!--.table_files > ul > li > .format_img {-->
<!--  width: 56px;-->
<!--  height: 56px;-->
<!--}-->

<!--.table_files > ul > li > .public_img {-->
<!--  width: 48px;-->
<!--  height: 17px;-->
<!--  position: absolute;-->
<!--  top: 76px;-->
<!--  left: 35px;-->
<!--}-->

<!--.single_checkbox {-->
<!--  margin: 10px;-->
<!--  height: 20px;-->
<!--  line-height: 20px;-->
<!--}-->

<!--.single_checkbox > div {-->
<!--  display: flex;-->
<!--  justify-content: space-between;-->
<!--}-->

<!--.operate_box:hover {-->
<!--  background-color: #fff;-->
<!--}-->

<!--.point_box {-->
<!--  width: 20px;-->
<!--  height: 20px;-->
<!--  line-height: 20px;-->
<!--  text-align: center;-->
<!--  cursor: pointer;-->
<!--}-->

<!--.edit_and_delete {-->
<!--  position: absolute;-->
<!--  top: 21px;-->
<!--  right: 9px;-->
<!--  width: 67px;-->
<!--  height: 65px;-->
<!--  line-height: 32px;-->
<!--  background: #FFFFFF;-->
<!--  box-shadow: 3px 3px 9px 0px rgba(0, 0, 0, 0.39);-->
<!--  border-radius: 4px;-->
<!--  padding-left: 4px;-->
<!--  padding-right: 4px;-->
<!--  z-index: 1;-->
<!--}-->

<!--.edit_box {-->
<!--  border-bottom: 1px solid #EAEAEA;-->
<!--}-->

<!--.edit_box,-->
<!--.delete_box {-->
<!--  cursor: pointer;-->
<!--}-->

<!--.edit_box > img,-->
<!--.delete_box > img {-->
<!--  padding-right: 7px;-->
<!--  vertical-align: middle;-->
<!--}-->

<!--.flies_title {-->
<!--  margin: 4px 0 20px;-->
<!--  width: 100%;-->
<!--  padding: 0px 15px;-->
<!--  font-size: 14px;-->
<!--  font-family: PingFang SC;-->
<!--  font-weight: 400;-->
<!--  color: #333333;-->
<!--  display: -webkit-box;-->
<!--  -webkit-box-orient: vertical;-->
<!--  -webkit-line-clamp: 2;-->
<!--  overflow: hidden;-->
<!--  word-break: break-all;-->
<!--}-->
<!--</style>-->
<script></script>
