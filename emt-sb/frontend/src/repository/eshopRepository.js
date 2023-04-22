import axios from '../custom-axios/axios';

const EShopService = {
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    fetchCategories: () => {
        return axios.get("/categories")
    },
    fetchBooks: () => {
        return axios.get("/books")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        })
    }

}

export default EShopService;