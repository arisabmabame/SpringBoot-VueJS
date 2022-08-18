<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by Name"
          v-model="fullName"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchfullName"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Data Registered Successfully</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(data, index) in registrations"
          :key="index"
          @click="setActive(data, index)"
        >
          {{ data.fullName }}
        </li>
      </ul>

     
    </div>
    <div class="col-md-6">
      <div v-if="currentData">
        <h4>Registrations</h4>
        <div>
          <label><strong>Full Name:</strong></label> {{ currentData.fullName }}
        </div>
        <div>
          <label><strong>Short Name:</strong></label> {{ currentData.shortName }}
        </div>
        <div>
          <label><strong>No Handphone:</strong></label> {{ currentData.noHandPhone }}
        </div>
        <div>
          <label><strong>Address:</strong></label> {{ currentData.address }}
        </div>

        <router-link :to="'/registration/update/'+currentData.id">
            <button @click="save" class="btn btn-primary">Update</button>
        </router-link>
      </div>
      <div v-else>
        <br />
        <p>Select the data you want to see</p>
      </div>
    </div>
  </div>
</template>

<script>
import RegistrationService from '@/services/RegistrationService';
export default {
  name: "List-data",
  data() {
    return {
      registrations: {
        fullName: "",
        shortName: "",
        noHandPhone: "",
        address: ""
      },
      currentData: null,
      currentIndex: -1,
      title: ""
    };
  },
  methods: {
    retrieve() {
      RegistrationService.getAll()
        .then(response => {
          this.registrations = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieve();
      this.currentData = null;
      this.currentIndex = -1;
    },
    setActive(data, index) {
      this.currentData = data;
      this.currentIndex = data ? index : -1;
    },
   
    
    searchfullName() {
      RegistrationService.findByName(this.fullName)
        .then(response => {
          this.registrations = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieve();
  },
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>