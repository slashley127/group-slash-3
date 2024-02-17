import axios from 'axios';

const apiUrl = 'http://localhost:8080/api';

const getAllItems = async () => {
    try {
        const response = await axios.get(`${apiUrl}/items`);
        return response.data;
    } catch (error) {
        console.error('Error fetching items:', error);
        throw error;
    }
}
const createItem = async (newItem) => {
    try {
        const response = await axios.post(`${apiUrl}/items`, newItem);
        return response.data;
    } catch (error) {
        console.error('Error creating item:', error);
        throw error;
    }
}

export { getAllItems, createItem };
const updateItem = async (itemId, updatedItem) => {
    try {
        const response = await axios.put(`${apiUrl}/items/${itemId}`, updatedItem);
        return response.data;
    } catch (error) {
        console.error('Error updating item:', error);
        throw error;
    }
}

export { getAllItems, createItem, updateItem };
const deleteItem = async (itemId) => {
    try {
        const response = await axios.delete(`${apiUrl}/items/${itemId}`);
        return response.data;
    } catch (error) {
        console.error('Error deleting item:', error);
        throw error;
    }
}

export { getAllItems, createItem, updateItem, deleteItem };