<template>
  <div class="home">
    <TopNav/>
    <SearchFrame/>
    <RouterLink/>
  </div>
</template>

<script>
import TopNav from "@/components/home/TopNav.vue";
import SearchFrame from "@/components/home/SearchFrame.vue";
import RouterLink from "@/components/home/RouterLink.vue";

export default {
  name: 'HomeView',
  components: {
    TopNav,
    SearchFrame,
    RouterLink,
  }
}
</script>
