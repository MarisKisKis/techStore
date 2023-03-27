import React from "react";
import {Component} from "react";
import axios from 'axios'

class ItemList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            items: [],
            message: null
        }
        this.refreshItems = this.refreshItems.bind(this)
    }

    componentDidMount() {
        this.refreshItems();
    }

    refreshItems() {
        axios.get("http://localhost:8080/items")
            .then(
                response => {
                    console.log(response);
                    this.setState({ courses: response.data })
                }
            )
    }
    render() {
        return (
            <div className="container">
                <h3>All Items</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.items.map(
                                item =>
                                    <tr key={item.id}>
                                        <td>{item.id}</td>
                                        <td>{item.name}</td>
                                        <td>{item.description}</td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ItemList