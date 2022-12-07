<template>
  <main>
    <Header></Header>
    <BackButton></BackButton>
    <StudentForm
      :studentDataProp="studentData"
      v-show="isViewForm"
      :isSuccessProps="isDeleted"
    ></StudentForm>
    <Card
      @deleteEmit="
        isDeleted = true;
        isViewForm = true;
      "
      v-show="!isViewForm"
      @updateDataEmit="updateStudent"
    ></Card>
    <Copyright></Copyright>
  </main>
</template>

<script>
import Header from "@/components/Header.vue";
import BackButton from "@/components/BackButton.vue";
import StudentForm from "@/components/StudentForm.vue";
import Card from "@/components/Card.vue";
import Copyright from "@/components/Copyright.vue";

export default {
  name: "show-pages",
  components: {
    Header,
    BackButton,
    StudentForm,
    Card,
    Copyright,
  },
  data() {
    return {
      studentData: null,
      isViewForm: false,
      isDeleted: false,
    };
  },
  methods: {
    updateStudent(student) {
      this.studentData = student;
      this.isViewForm = true;
    },
  },
};
</script>

<style></style>
