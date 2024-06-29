<template>
  <div class="container">
    <h1>{{ msg }}</h1>
    <div class="search-container">
      <input v-model="searchQuery" placeholder="Search by name" />
      <button @click="searchItems">Search</button>
    </div>
    <div class="search-container">
      <input v-model="brandQuery" placeholder="Search by brand" />
      <button @click="searchByBrand">Search</button>
    </div>
    <div class="search-container">
      <input v-model="typeQuery" placeholder="Search by type" />
      <button @click="searchByType">Search</button>
    </div>
    <div class="list-container">
      <h2>Surfboards</h2>
      <ul class="surfboard-list">
        <li v-for="item in items" :key="item.id">
          {{ item.name }} - {{ item.brand }} - {{ item.type }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import http from "../http-common";

interface Surfboard {
  id: number;
  name: string;
  brand: string;
  type: string;
}

// Define the props
const props = defineProps<{ msg: string }>();

// Define the state
const items = ref<Surfboard[]>([]);
const searchQuery = ref("");
const brandQuery = ref("");
const typeQuery = ref("");

const fetchItems = async () => {
  try {
    const response = await http.get<Surfboard[]>("/items");
    items.value = response.data;
  } catch (error) {
    console.error("Error fetching items:", error);
  }
};

const searchItems = async () => {
  try {
    const response = await http.get<Surfboard[]>(
      `/items/search?name=${searchQuery.value}`
    );
    items.value = response.data;
  } catch (error) {
    console.error("Error searching items:", error);
  }
};

const searchByBrand = async () => {
  try {
    const response = await http.get<Surfboard[]>(
      `/items/brand/${brandQuery.value}`
    );
    items.value = response.data;
  } catch (error) {
    console.error("Error searching by brand:", error);
  }
};

const searchByType = async () => {
  try {
    const response = await http.get<Surfboard[]>(
      `/items/type/${typeQuery.value}`
    );
    items.value = response.data;
  } catch (error) {
    console.error("Error searching by type:", error);
  }
};

onMounted(fetchItems);
</script>


<style scoped>

.search-container {
  text-align: left;
}

.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: left; /* Ensure the container's text is aligned left */
}

.search-container {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.search-container input {
  margin-right: 10px;
  flex-grow: 1;
}

.list-container {
  text-align: left;
}

.surfboard-list {
  list-style-type: disc; /* Ensure default list style is used */
  padding-left: 20px; /* Add padding to ensure bullets are visible */
}

.surfboard-list li {
  margin-bottom: 5px;
}
</style>