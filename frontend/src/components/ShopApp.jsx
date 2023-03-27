import React, { Component } from 'react';
import ItemList from "./ItemList";
import HomeComponent from "./HomeComponent";
import {
    BrowserRouter,
    Route, Router, Switch
} from 'react-router-dom';


class ShopApp extends Component {
    render() {
        return (
            <BrowserRouter>
            <>
            <h1>Shop Application</h1>
                <Switch>
                    <Route path="/" exact component={HomeComponent}/>
                    <Route path="/items" exact component={ItemList}/>
                    </Switch>
    </>
            </BrowserRouter>
        )
    }
}

export default ShopApp