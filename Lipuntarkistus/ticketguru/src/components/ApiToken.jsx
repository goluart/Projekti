import axios from 'axios';

// luodaan http pyyntöjä varten axiosilla token bearer, jolloin viittaus api riittää
const api = axios.create({
    baseURL: 'https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api',
});

api.interceptors.request.use(config => {
    config.headers.Authorization = `Bearer ${token}`; // axios interceptorsin avulla asetetaan header authorization bearer ja välitetty token muuttuja SignIn.jsx
    return config;
});

export default api;