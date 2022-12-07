<template>
  <div class="d-flex justify-content-center">
    <router-link
      to="/add"
      class="btn btn-primary font-weight-bold ml-3 mt-3"
      type="submit"
    >
      Add Data
    </router-link>
    <router-link
      to="/show"
      class="btn btn-success font-weight-bold ml-3 mt-3"
      type="submit"
    >
      Show Data
    </router-link>
  </div>
</template>

<script>
export default {
  name: "button-header-component",
};
</script>

<style></style>
