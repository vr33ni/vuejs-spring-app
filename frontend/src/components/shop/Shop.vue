<template>
    <div>
      <h1>Shop</h1>
      <nav>
        <ul>
          <li><router-link to="/shop/boards">Boards</router-link></li>
          <li><router-link to="/shop/wetsuits">Wetsuits</router-link></li>
          <li><router-link to="/shop/accessories">Accessories</router-link></li>
        </ul>
      </nav>
      <router-view></router-view>
    </div>
  </template>
  
  <script setup>
  </script>
  
  <style scoped>
  nav ul {
    list-style: none;
    padding: 0;
  }
  
  nav ul li {
    display: inline;
    margin-right: 10px;
  }
  
  nav ul li a {
    text-decoration: none;
    color: #000;
  }
  
  nav ul li a.router-link-active {
    font-weight: bold;
  }
  </style>
  