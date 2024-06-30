<template>
    <div class="container">
      <h1>Wetsuits</h1>
      <div class="search-container">
        <div>
          <input v-model="searchQuery" placeholder="Search by name" />
        </div>
        <div>
          <input v-model="brandQuery" placeholder="Search by brand" />
        </div>
        <div>
        <label>Thickness:</label>
        <div>
          <label>
            <input type="checkbox" value="4/3 mm" v-model="selectedThickness" /> 4/3 mm
          </label>
        </div>
        <div>
          <label>
            <input type="checkbox" value="5/4 mm" v-model="selectedThickness" /> 5/4 mm
          </label>
        </div>
        <div>
          <label>
            <input type="checkbox" value="5/4 mm hooded" v-model="selectedThickness" /> 5/4 mm hooded
          </label>
        </div>
      </div>
      </div>
  
      <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
  
      <div class="list-container">
        <h2>In stock</h2>
        <ul class="wetsuit-list">
          <li v-for="item in filteredItems" :key="item.id">
            {{ item.name }} - {{ item.brand }} - {{ item.thickness }}
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted, computed } from "vue";
  import { useWetsuitStore } from '../../store/wetsuits';
  
  // Define the state
   const searchQuery = ref("");
  const brandQuery = ref("");
  const selectedThickness = ref<string[]>([]);
  
  const wetsuitStore = useWetsuitStore();
  
  const fetchItems = wetsuitStore.fetchItems;
  const items = computed(() => wetsuitStore.items);
  const errorMessage = computed(() => wetsuitStore.errorMessage);
  
  const filteredItems = computed(() => {
  return items.value.filter(item => {
    const matchesName = item.name.toLowerCase().startsWith(searchQuery.value.toLowerCase());
    const matchesBrand = item.brand.toLowerCase().startsWith(brandQuery.value.toLowerCase());
    const matchesThickness = selectedThickness.value.length === 0 || selectedThickness.value.includes(item.thickness);
    return matchesName && matchesBrand && matchesThickness;
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
  
  .wetsuit-list {
    list-style-type: disc;
    padding-left: 20px; 
  }
  
  .wetsuit-list li {
    margin-bottom: 5px;
  }
  </style>