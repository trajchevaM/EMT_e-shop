import './App.css';
import React, {Component} from "react";
import Authors from "../Authors/authors";
import EShopService from "../../repository/eshopRepository";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: []
        }
    }
    render() {
        return(
            <div>
                <Authors authors={this.state.authors}/>
            </div>
        );
    }

    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    componentDidMount() {
        this.loadAuthors();
    }


}

export default App;
