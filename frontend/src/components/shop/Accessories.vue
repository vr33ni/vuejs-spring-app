<template>
    <div class="container">
      <h1>Accessories</h1>
      <div class="search-container">
        <div>
          <input v-model="searchQuery" placeholder="Search by name" />
        </div>
        <div>
          <input v-model="brandQuery" placeholder="Search by brand" />
        </div>
        <div>
        <label>
          <input type="checkbox" v-model="glovesChecked" /> Gloves
        </label>
        <label>
          <input type="checkbox" v-model="bootsChecked" /> Boots
        </label>
      </div>
      </div>
  
      <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
  
      <div class="list-container">
        <h2>In stock</h2>
        <ul class="accessories-list">
          <li v-for="item in filteredItems" :key="item.id">
            {{ item.name }} - {{ item.brand }} - {{ item.type }}
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
import { ref, onMounted, computed } from "vue";
import { useAccessoriesStore } from '../../store/accessories';

// Define the state
 const searchQuery = ref("");
const brandQuery = ref("");
const glovesChecked = ref(true);
const bootsChecked = ref(true);

const accessoriesStore = useAccessoriesStore();

const fetchItems = accessoriesStore.fetchItems;
const items = computed(() => accessoriesStore.items);
const errorMessage = computed(() => accessoriesStore.errorMessage);

const filteredItems = computed(() => {
  return items.value.filter(item => {
    const matchesSearch = 
      item.name.toLowerCase().startsWith(searchQuery.value.toLowerCase()) &&
      item.brand.toLowerCase().startsWith(brandQuery.value.toLowerCase());

    const isGlovesMatch = glovesChecked.value && item.type.toLowerCase().includes("gloves");
    const isBootsMatch = bootsChecked.value && item.type.toLowerCase().includes("boots");

     return matchesSearch && (isGlovesMatch || isBootsMatch);
  });
});

onMounted(fetchItems);

  </script>
  
  
  <style scoped>
  
  .container {
    width: 100%;  
    padding: 10px;
    text-align: left; 
  }
  
  .search-container {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
    text-align: left;
  }
  
  .search-container input {
    margin-right: 10px;
    flex-grow: 1;
  }
  
  .list-container {
    text-align: left;
  }
  
  .accessories-list {
    list-style-type: disc; 
    padding-left: 20px; 
  }
  
  .accessories-list li {
    margin-bottom: 5px;
  }
  </style>