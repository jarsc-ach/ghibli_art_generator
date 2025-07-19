import axios from 'axios';

const API_BASE = 'http://localhost:8080/api/v1'; // adjust if backend runs on different port

// Text to Image API
export const generateFromText = async (prompt, style) => {
  const response = await axios.post(
    `${API_BASE}/generate-from-text`,
    { prompt, style },
    { responseType: 'arraybuffer' } // image bytes
  );

  return URL.createObjectURL(new Blob([response.data], { type: 'image/png' }));
};

// Image to Image API
export const generateFromImage = async (file, prompt) => {
  const formData = new FormData();
  formData.append('image', file);
  formData.append('prompt', prompt);

  const response = await axios.post(`${API_BASE}/generate`, formData, {
    headers: { 'Content-Type': 'multipart/form-data' },
    responseType: 'arraybuffer',
  });

  return URL.createObjectURL(new Blob([response.data], { type: 'image/png' }));
};
