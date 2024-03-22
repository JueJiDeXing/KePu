<template>
  <div class="home">
    <temp/>
    <!--<TopNav/>-->
    <!--<SearchFrame/>-->
    <!--<RouterLink/>-->
  </div>
</template>

<script>
import TopNav from "@/components/home/TopNav.vue";
import SearchFrame from "@/components/home/SearchFrame.vue";
import RouterLink from "@/components/home/RouterLink.vue";
import temp from "@/components/home/temp.vue";
export default {
  name: 'HomeView',
  components: {
    temp,
    TopNav,
    SearchFrame,
    RouterLink,
  }
}
</script>
