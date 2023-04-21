import axios from '../custom-axios/axios';

const EShopService = {
    fetchAuthors: () => {
        return axios.get("/authors")
    }
}

export default EShopService;