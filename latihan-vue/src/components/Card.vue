<template>
  <main class="row w-100 p-3">
    <div class="col-sm-4 mt-3" v-for="item in studentData" :key="item.id">
      <div class="card" style="border: 1px solid black">
        <div class="card-body">
          <h5 class="card-title">
            {{ `${item.nama}, ${item.umur} years old` }}
          </h5>
          <p class="card-text">{{ item.deskripsi_diri }}</p>
          <ul class="list-group mb-3">
            <li class="list-group">
              {{ `Email&emsp;&emsp;&ensp;&nbsp;: ${item.email}` }}
            </li>
            <li class="list-group">
              {{ `Soft Skills&ensp;&nbsp;: ${item.soft_skill}` }}
            </li>
            <li class="list-group">
              {{ `Hard Skills&nbsp;: ${item.hard_skill}` }}
            </li>
            <li class="list-group">
              {{ `Interest&ensp;&emsp;&nbsp;: ${item.interest}` }}
            </li>
          </ul>
          <div class="d-flex">
            <a
              @click="$emit('updateDataEmit', item)"
              class="btn btn-primary mr-2"
              >Update</a
            >
            <a @click="deleteStudent(item.id)" class="btn btn-danger">Delete</a>
            <img
              v-if="item.jenis_kelamin == 'Male'"
              src="@/assets/male.png"
              alt="Male-icon"
              class="text-right ml-auto"
              style="min-width: 2vw; height: 5vh"
            />
            <img
              v-else
              src="@/assets/female.png"
              alt="Female-icon"
              class="text-right ml-auto"
              style="min-width: 2vw; height: 5vh"
            />
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import StudentService from "@/service/studentService";

export default {
  name: "card-component",
  data() {
    return {
      studentData: null,
    };
  },
  methods: {
    getStudent() {
      StudentService.getData()
        .then((response) => {
          this.studentData = response.data;
          console.log(this.studentData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteStudent(id) {
      let scope = this;
      if (confirm("Are you sure want to delete?")) {
        StudentService.deleteData(id)
          .then((response) => {
            console.log(response.data);
            scope.$emit("deleteEmit");
          })
          .catch((e) => {
            console.log(e);
          });
        // location.reload();
      } else {
        alert("Delete canceled!");
      }
    },
  },
  mounted() {
    this.getStudent();
  },
};
</script>

<style></style>
