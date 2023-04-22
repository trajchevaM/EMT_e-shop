import React from "react";

const bookTerm = (props) => {
    return (
        <tr>
            <th>
                <tr>
                    <td scope={"col"}>{props.term.name}</td>
                    <td scope={"col"}>{props.term.category}</td>
                    <td scope={"col"}>{props.term.author}</td>
                    <td scope={"col"}>{props.term.availableCopies}</td>
                </tr>
            </th>
        </tr>
    )
}

export default bookTerm;