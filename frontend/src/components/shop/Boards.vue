<template>
  <div class="container">
    <h1>Boards</h1>
    <div class="search-container">
      <div>
        <input v-model="searchQuery" placeholder="Search by name" />
      </div>
      <div>
        <input v-model="brandQuery" placeholder="Search by brand" />
      </div>
      <div>
        <input v-model="typeQuery" placeholder="Search by type" />
      </div>
    </div>

    <div v-if="errorMessage" class="error">{{ errorMessage }}</div>

    <div class="list-container">
      <h2>In stock</h2>
      <ul class="surfboard-list">
        <li v-for="item in filteredItems" :key="item.id">
          {{ item.name }} - {{ item.brand }} - {{ item.type }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from "vue";
import { useBoardStore } from '../../store/boards';

// Define the state
 const searchQuery = ref("");
const brandQuery = ref("");
const typeQuery = ref("");
 
const surfboardStore = useBoardStore();

const fetchItems = surfboardStore.fetchItems;
const items = computed(() => surfboardStore.items);
const errorMessage = computed(() => surfboardStore.errorMessage);

const filteredItems = computed(() => {
  return items.value.filter(item => {
    return (
      item.name.toLowerCase().startsWith(searchQuery.value.toLowerCase()) &&
      item.brand.toLowerCase().startsWith(brandQuery.value.toLowerCase()) &&
      item.type.toLowerCase().startsWith(typeQuery.value.toLowerCase())
    );
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

.surfboard-list {
  list-style-type: disc; 
  padding-left: 20px; 
}

.surfboard-list li {
  margin-bottom: 5px;
}
</style>