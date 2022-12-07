<template>
  <div class="card-body border-color">
    <h5 class="card-title">Success!</h5>
    <p class="card-text">{{ `Student Data has been ${textValProps}!` }}</p>
    <router-link to="/" class="btn btn-primary text-light">Close</router-link>
  </div>
</template>

<script>
export default {
  name: "send-component",
  data() {
    return {
      textVal: "delete",
      currentPath: null,
    };
  },
  mounted() {
    this.currentPath = this.$route.path;
  },
  props: ["textValProps"],
};
</script>

<style scoped>
.border-color {
  border: 1px solid rgba(0, 0, 0, 0.4);
}
</style>
