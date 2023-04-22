import './App.css';
import React, {Component} from "react";
import {Routes, Route} from 'react-router-dom'
import { BrowserRouter } from 'react-router-dom';
import Authors from "../Authors/authors";
import EShopService from "../../repository/eshopRepository";
import Categories from "../Categories/categories";
import Books from "../Books/BookList/books";

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
                            <Route path={"/books"} element={<Books books={this.state.books}/>}/>
                            <Route path={"/"} element={<Books books={this.state.books}/>}/>

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
}

export default App;
