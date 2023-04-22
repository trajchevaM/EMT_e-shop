import React from "react";

const bookTerm = (props) => {
    return (
        <tr>
                    <td>{props.term.name}</td>
                    <td>{props.term.category}</td>
                    <td>{props.term.author.name} {props.term.author.surname}</td>
                    <td>{props.term.availableCopies}</td>
                    <td className={"text-right"}>
                        <a title={"Delete"} className={"btn btn-danger"}
                           onClick={() => props.onDelete(props.term.id)}>
                            Delete
                        </a>
                    </td>
        </tr>
    )
}

export default bookTerm;