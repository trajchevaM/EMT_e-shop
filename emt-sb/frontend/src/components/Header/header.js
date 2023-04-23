import React from 'react';

const Header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className={"container"}>
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <a className="navbar-brand p-sm-2" href="/books">Book Application</a>
                        </li>
                    </ul>
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item active">
                            <a className="nav-link" href="/books">Books</a>
                        </li>
                        <li className="nav-item active">
                            <a className="nav-link" href="/categories">Categories</a>
                        </li>
                        <li className="nav-item active">
                            <a className="nav-link" href="/authors">Authors</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    );
}

export default Header;