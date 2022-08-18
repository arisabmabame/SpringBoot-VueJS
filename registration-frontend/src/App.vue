
<template>
  <router-link to="/"/>
  <div id="app"><router-link to="/about"/>
    <nav  class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="nav-link">Profile</router-link> |
      <div class="navbar-nav mr-auto ">
        
        <li class="nav-item">
          <router-link to="/registration" class="nav-link">List</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/registration/add" class="nav-link">Registration</router-link>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  <br>
  
  </div>
  
</template>

<script>
export default {
  name: "app"
};
</script>