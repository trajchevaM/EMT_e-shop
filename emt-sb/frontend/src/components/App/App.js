import './App.css';
import React, {Component} from "react";
import {Routes, Route} from 'react-router-dom'
import { BrowserRouter } from 'react-router-dom';
import Authors from "../Authors/authors";
import EShopService from "../../repository/eshopRepository";
import Categories from "../Categories/categories";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/BookAdd/bookAdd";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            categories: [],
            books: []
        }
    }
    render() {
        return(
            <BrowserRouter>
                <Routes>
                    <Route path={"/authors"} element={<Authors authors={this.state.authors}/>}/>
                    <Route path={"/categories"} element={ <Categories categories={this.state.categories}/>}/>
                    <Route path={"/books/add"} element={<BookAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addProduct}/>}/>
                    <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook}/>}/>
                    <Route path={"/"} element={<Books books={this.state.books} onDelete={this.deleteBook}/>}/>
                </Routes>
            </BrowserRouter>
        );
    }

    componentDidMount() {
        this.loadAuthors();
        this.loadCategories();
        this.loadBooks();
    }

    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadBooks = () => {
        EShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addProduct = (name, category, authorId, availableCopies) => {
        EShopService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
