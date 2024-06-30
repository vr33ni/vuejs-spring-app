import { defineStore } from 'pinia';
import http from '../http-common';

interface Surfboard {
  id: number;
  name: string;
  brand: string;
  type: string;
}

export const useBoardStore = defineStore({
  id: 'surfboard',
  state: () => ({
    items: [] as Surfboard[],
    errorMessage: ""
  }),
  actions: {
    async fetchItems() {
      try {
        const response = await http.get<Surfboard[]>("/items/boards");
        this.items = response.data;
      } catch (error) {
        this.errorMessage = "Error fetching items";
        console.error("Error fetching items:", error);
      }
    }
  }
});
