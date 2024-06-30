import { defineStore } from 'pinia';
import http from '../http-common';

interface Accessory {
  id: number;
  name: string;
  brand: string;
  type: string;
}

export const useAccessoriesStore = defineStore({
  id: 'accessory',
  state: () => ({
    items: [] as Accessory[],
    errorMessage: ""
  }),
  actions: {
    async fetchItems() {
      try {
        const response = await http.get<Accessory[]>("/items/accessories");
        this.items = response.data;
      } catch (error) {
        this.errorMessage = "Error fetching items";
        console.error("Error fetching items:", error);
      }
    }
  }
});
