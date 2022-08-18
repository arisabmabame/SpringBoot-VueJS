<template>
  <div v-if="currentRegistration" class="edit-form">
    <h4>Registration</h4>
    <form>
      <div class="form-group">
        <label for="title">Full Name</label>
        <input type="text" class="form-control" id="title"
          v-model="currentRegistration.fullName"
        />
      </div>

      <div class="form-group">
        <label for="title">Short Name</label>
        <input type="text" class="form-control" id="title"
          v-model="currentRegistration.shortName"
        />
      </div>
            <div class="form-group">
        <label for="title">No. HandPhone</label>
        <input type="text" class="form-control" id="title"
          v-model="currentRegistration.noHandPhone"
        />
      </div>
            <div class="form-group">
        <label for="title">Address</label>
        <input type="text" class="form-control" id="title"
          v-model="currentRegistration.address"
        />
      </div>
    </form>

    <button class="btn btn-danger"
      :disabled="message !== ''"
      @click="deleteRegistration"
    > Delete
    </button> &nbsp;

    <button type="submit" class="btn btn-success"
    :disabled="message !== ''"
      @click="updateRegistration"
    >  Update
    </button>
    &nbsp;
    
    <router-link :to="'/registration'">
          <button @click="save" class="btn btn-primary">Back</button>
      </router-link>
      <br/> <br/>


      <div v-if="message !== ''" class="alert alert-success" role="alert">
           <p>{{ message }}</p>
      </div>
  </div>
  

  <div v-else>
    <br />
    <p>Registration Data is not found...</p>
  </div>
</template>

<script>
import RegistrationService from '@/services/RegistrationService';

export default {
  name: "Registration-Edit",
  data() {
    return {
      id: '',
      currentRegistration: null,
      message: ''
    };
  },
  methods: {
    getRegistration(id) {
      RegistrationService.get(id)
        .then(response => {
          this.currentRegistration = response.data;
          this.currentRegistration.id = this.id
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    updateRegistration() {
      RegistrationService.update(this.currentRegistration)
        .then(response => {
          console.log(response.data);
          this.message = 'The Registration was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteRegistration() {
      RegistrationService.delete(this.id)
        .then(response => {
          console.log(response.data);
          this.message = 'The Registration was deleted successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.id = this.$route.params.id
    this.getRegistration(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>