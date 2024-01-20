<template>
  <div class="home">
    <SearchFrame/>
  </div>
</template>

<script>
// @ is an alias(别名) to /src
import SearchFrame from "@/components/home/SearchFrame.vue";

export default {
  name: 'HomeView',
  components: {
    SearchFrame,
  }
}
</script>
