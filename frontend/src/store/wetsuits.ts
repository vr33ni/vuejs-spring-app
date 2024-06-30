import { defineStore } from 'pinia';
import http from '../http-common';

interface Wetsuit {
  id: number;
  name: string;
  brand: string;
  thickness: string;
}

export const useWetsuitStore = defineStore({
  id: 'wetsuit',
  state: () => ({
    items: [] as Wetsuit[],
    errorMessage: ""
  }),
  actions: {
    async fetchItems() {
      try {
        const response = await http.get<Wetsuit[]>("/items/wetsuits");
        this.items = response.data;
      } catch (error) {
        this.errorMessage = "Error fetching items";
        console.error("Error fetching items:", error);
      }
    }
  }
});
