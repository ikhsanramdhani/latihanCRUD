import Home from "./pages/Home";
import Form from "./pages/Form";
import ShowStudent from "./pages/ShowStudent";

export default [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/add",
    component: Form,
  },
  {
    path: "/show",
    component: ShowStudent,
  },
];
