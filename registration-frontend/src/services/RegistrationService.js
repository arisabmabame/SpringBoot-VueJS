import http from "../http-common";

class RegistrationService {
  getAll() {
    return http.get("/registrations");
  }

  get(id) {
    return http.get(`/registrations/${id}`);
  }

  findByName(name) {
    return http.get(`/registrations/find-by-name?name=${name}`);
  }

  create(data) {
    return http.post("/registrations", data);
  }

  update(data) {
    return http.put("/registrations", data);
  }

  delete(id) {
    return http.delete(`/registrations/${id}`);
  }
}

export default new RegistrationService();