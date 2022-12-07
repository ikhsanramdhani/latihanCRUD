<template>
  <main>
    <Header></Header>
    <BackButton></BackButton>
    <StudentForm></StudentForm>
    <Copyright></Copyright>
  </main>
</template>

<script>
import Header from "@/components/Header.vue";
import BackButton from "@/components/BackButton.vue";
import StudentForm from "@/components/StudentForm.vue";
import Copyright from "@/components/Copyright.vue";

export default {
  name: "form-pages",
  components: {
    Header,
    BackButton,
    StudentForm,
    Copyright,
  },
};
</script>

<style></style>
