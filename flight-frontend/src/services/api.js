import axios from 'axios';

const API_URL = 'http://localhost:8084/api/flights';

export const flightApi = {
  // Get all flights
  getAll: async () => {
    const response = await axios.get(API_URL);
    return response.data;
  },

  // Get flight by ID
  getById: async (id) => {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
  },

  // Get flights by carrier
  getByCarrier: async (carrier) => {
    const response = await axios.get(`${API_URL}/carrier/${carrier}`);
    return response.data;
  },

  // Get flights by route
  getByRoute: async (source, destination) => {
    const response = await axios.get(`${API_URL}/route`, {
      params: { source, destination }
    });
    return response.data;
  },

  // Add new flight
  add: async (flight) => {
    const response = await axios.post(`${API_URL}/add`, flight);
    return response.data;
  },

  // Delete flight
  delete: async (id) => {
    await axios.delete(`${API_URL}/${id}`);
  }
};
