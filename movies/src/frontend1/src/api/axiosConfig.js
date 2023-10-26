import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8080",
  headers: { "ngrok-skip-browser-warning": "true" },
});

// https://f31e-49-36-168-178.ngrok.io (my baseURL) 
// http://localhost:8080