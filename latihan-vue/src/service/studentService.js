import Http from "../http-common";

class studentService {
  addData(data) {
    return Http.post("/student/add", data);
  }

  getData() {
    return Http.get("/student/getData");
  }

  updateData(id, data) {
    return Http.put(`/student/edit/${id}`, data);
  }

  deleteData(id) {
    return Http.delete(`/student/delete/${id}`);
  }
}

export default new studentService();
