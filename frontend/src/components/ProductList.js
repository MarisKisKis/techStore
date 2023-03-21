import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ProductList extends Component {

    constructor(props) {
        super(props);
        this.state = {item: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/items')
            .then(response => response.json())
            .then(data => this.setState({item: data}));
    }
}
export default ProductList;