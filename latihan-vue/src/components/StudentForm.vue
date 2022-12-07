<template>
  <main class="container-fluid mt-5 mb-5" style="width: 70vw; height: 100vh">
    <form
      class="p-4 rounded border border-primary"
      @submit.prevent="inputStudent"
      v-show="!isSuccess"
    >
      <center>
        <h1 class="mt-4 mb-5">{{ `${formVal} Student` }}</h1>
      </center>
      <div class="form-row p-1">
        <div class="form-group col-md-6">
          <label>Student Name</label>
          <input
            v-model="studentData.nama"
            type="text"
            class="form-control"
            placeholder="Enter name"
            required
          />
        </div>
        <div class="form-group col-md-6">
          <label>Soft Skills</label>
          <input
            v-model="studentData.soft_skill"
            type="text"
            class="form-control"
            placeholder="Enter soft skills"
            required
          />
        </div>
      </div>
      <div class="form-row p-1">
        <div class="form-group col-md-3">
          <label>Student Age</label>
          <input
            v-model="studentData.umur"
            type="text"
            class="form-control"
            placeholder="Enter age"
            required
          />
        </div>
        <div class="form-group col-md-3">
          <label>Gender</label>
          <select
            class="form-control"
            v-model="studentData.jenis_kelamin"
            required
          >
            <option value="" disabled selected></option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
        </div>
        <div class="form-group col-md-6">
          <label>Hard Skills</label>
          <input
            v-model="studentData.hard_skill"
            type="text"
            class="form-control"
            placeholder="Enter hard skills"
            required
          />
        </div>
      </div>
      <div class="form-row p-1">
        <div class="form-group col-md-6">
          <label>Student Email</label>
          <input
            v-model="studentData.email"
            type="email"
            class="form-control"
            placeholder="Enter email"
            required
          />
        </div>
        <div class="form-group col-md-6">
          <label>Interest</label>
          <select class="form-control" v-model="studentData.interest" required>
            <option value="" disabled selected></option>
            <option value="Data Science">Data Science</option>
            <option value="Network">Network</option>
            <option value="Web Frontend">Web Frontend</option>
            <option value="Web Backend">Web Backend</option>
            <option value="Mobile Apps">Mobile Apps</option>
          </select>
        </div>
      </div>
      <div class="form-group col-md-12 p-1">
        <label>Self Description</label>
        <textarea
          v-model="studentData.deskripsi_diri"
          class="form-control"
          required
          cols="20"
          rows="5"
        ></textarea>
      </div>
      <button type="submit" class="btn btn-primary">
        {{ btnVal }}
      </button>
    </form>
    <Send :textValProps="textVal" v-show="isSuccess"></Send>
  </main>
</template>

<script>
import StudentService from "@/service/studentService";
import Send from "@/components/Send.vue";

export default {
  name: "form-component",
  data() {
    return {
      studentData: {
        deskripsi_diri: null,
        email: null,
        hard_skill: null,
        interest: null,
        jenis_kelamin: null,
        nama: null,
        soft_skill: null,
        umur: null,
      },
      isSuccess: false,
      formVal: "Add",
      btnVal: "Submit",
      textVal: "deleted",
    };
  },
  components: {
    Send,
  },
  methods: {
    inputStudent: function () {
      let data = this.studentData;

      if (this.btnVal == "Submit") {
        StudentService.addData(data)
          .then((response) => {
            console.log(response.data);
            this.isSuccess = true;
            this.textVal = "inputed";
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        StudentService.updateData(data.id, data)
          .then((response) => {
            console.log(response.data);
            this.isSuccess = true;
            this.textVal = "updated";
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
  },
  props: ["studentDataProp", "isSuccessProps"],
  watch: {
    studentDataProp(newVal) {
      this.studentData = newVal;
      this.btnVal = "Update";
      this.formVal = "Update";
    },
    isSuccessProps(newVal) {
      // console.log(newVal);
      this.isSuccess = newVal;
      console.log(this.isSuccess);
    },
  },
};
</script>

<style></style>
