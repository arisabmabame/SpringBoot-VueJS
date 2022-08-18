<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="title" aria-required="">Full Name</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="registration.fullName"
          name="title"
        />
      </div>
            <div class="form-group">
        <label for="description" aria-required="">Short Name</label>
        <input
          class="form-control"
          id="description"
          required
          v-model="registration.shortName"
          name="description"
        />
      </div>
      <div class="form-group" >
        <label for="no_hp" aria-required="">No HandPhone</label>
        <input
          type="int"
          class="form-control"
          id="no_hp"
          required
          v-model="registration.noHandPhone"
          name="no.hp"
        />
      </div>
      <div class="form-group">
        <label for="alamat" aria-required="">Address</label>
        <input
          type="text"
          class="form-control"
          id="alamat"
          required
          v-model="registration.address"
          name="alamat"
        />
      </div>

      <button @click="save" class="btn btn-success">Submit</button>
      &nbsp;
      <router-link :to="'/registration'">
          <button @click="save" class="btn btn-primary">Back</button>
      </router-link>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newRegistration">Registration</button>
       &nbsp;
      <router-link :to="'/registration'">
          <button @click="save" class="btn btn-primary">Back</button>
      </router-link>
    </div>
  </div> 
</template>

<script>
import RegistrationService from '@/services/RegistrationService';
export default {
  name: "Registration-add",
  data() {
    return {
      registration: {
        id: null,
        fullName: "",
        shortName: "",
        noHandPhone: "",
        address: ""
      },
      submitted: false
    };
  },
  methods: {
    save() {
      var data = {
        fullName: this.registration.fullName,
        shortName:  this.registration.shortName,
        noHandPhone: this.registration.noHandPhone,
        address: this.registration.address
      };
      RegistrationService.create(data)
        .then(response => {
          this.registration.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newRegistration() {
      this.submitted = false;
      this.registration = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>