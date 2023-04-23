import './App.css';
import React, {Component} from "react";
import {Routes, Route} from 'react-router-dom'
import { BrowserRouter } from 'react-router-dom';
import Authors from "../Authors/authors";
import EShopService from "../../repository/eshopRepository";
import Categories from "../Categories/categories";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";
import Header from "../Header/header";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            categories: [],
            books: [],
            selectedBook: {}
        }
    }
    render() {
        return(
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route path={"/authors"} element={<Authors authors={this.state.authors}/>}/>
                    <Route path={"/categories"} element={ <Categories categories={this.state.categories}/>}/>
                    <Route path={"/books/add"} element={<BookAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addProduct}/>}/>
                    <Route path={"/books/edit/:id"} element={<BookEdit categories={this.state.categories} authors={this.state.authors} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                    <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onMarkAsTaken={this.markAsTaken}/>}/>
                    <Route path={"/"} element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onMarkAsTaken={this.markAsTaken}/>}/>
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
    getBook = (id) => {
        EShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            });
    }
    editBook = (id, name, category, authorId, availableCopies) => {
        EShopService.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    markAsTaken = (id) => {
        EShopService.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
