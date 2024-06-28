<template>
  <div>
    <h1>{{ msg }}</h1>
    <div>
      <input v-model="searchQuery" placeholder="Search by name" />
      <button @click="searchItems">Search</button>
    </div>
    <div>
      <input v-model="brandQuery" placeholder="Search by brand" />
      <button @click="searchByBrand">Search</button>
    </div>
    <div>
      <input v-model="typeQuery" placeholder="Search by type" />
      <button @click="searchByType">Search</button>
    </div>
    <div>
      <h2>Surfboards</h2>
      <ul>
        <li v-for="item in items" :key="item.id">
          {{ item.name }} - {{ item.brand }} - {{ item.type }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import http from "../http-common";

const props = defineProps({
  msg: String
});

const items = ref([]);
const searchQuery = ref('');
const brandQuery = ref('');
const typeQuery = ref('');

const fetchItems = async () => {
  try {
    const response = await http.get('/items');
    items.value = response.data;
  } catch (error) {
    console.error('Error fetching items:', error);
  }
};

const searchItems = async () => {
  try {
    const response = await http.get(`/items/search?name=${searchQuery.value}`);
    items.value = response.data;
  } catch (error) {
    console.error('Error searching items:', error);
  }
};

const searchByBrand = async () => {
  try {
    const response = await http.get(`/items/brand/${brandQuery.value}`);
    items.value = response.data;
  } catch (error) {
    console.error('Error searching by brand:', error);
  }
};

const searchByType = async () => {
  try {
    const response = await http.get(`/items/type/${typeQuery.value}`);
    items.value = response.data;
  } catch (error) {
    console.error('Error searching by type:', error);
  }
};

onMounted(fetchItems);
</script>

<style scoped>
/* Add your styles here */
</style>
