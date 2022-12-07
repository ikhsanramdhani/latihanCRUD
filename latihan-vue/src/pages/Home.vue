<template>
  <main>
    <Header></Header>
    <ButtonHeader></ButtonHeader>
    <Copyright></Copyright>
  </main>
</template>

<script>
import Header from "@/components/Header.vue";
import ButtonHeader from "@/components/ButtonHeader.vue";
import Copyright from "@/components/Copyright.vue";

export default {
  name: "home-pages",
  components: {
    Header,
    ButtonHeader,
    Copyright,
  },
};
</script>

<style></style>
