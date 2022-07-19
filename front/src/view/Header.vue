<template>  
   <header class="py-3 mb-3 border-bottom">
    <div class="container-fluid d-grid gap-3 align-items-center" style="grid-template-columns: 10fr 1fr;">
        <ul class="nav justify-content-center">
            <li><a href="#" class="nav-link link-dark">Overview</a></li>
            <li><a href="#" class="nav-link link-dark">Inventory</a></li>
            <li><a href="#" class="nav-link link-dark">Customers</a></li>
            <li><a href="#" class="nav-link link-dark">Products</a></li>
        </ul>

      <div class="d-flex align-items-center">
        <div class="flex-shrink-0 dropdown">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2" style="">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><router-link class="dropdown-item" to="/logout">Sign out</router-link></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
</template>

<script>

export default {
    name: "header-view",
    components: { 
         
    },
    data() {
        return {};
    },
    computed: {
     
    }
    
}
</script>