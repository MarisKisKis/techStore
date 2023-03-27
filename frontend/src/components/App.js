import logo from './logo.svg';
import './App.css';
import ShopApp from "./ShopApp";
import {Component} from "react";

class App extends Component {
  render() {
    return (
        <div className="container">
          <ShopApp />
        </div>
    );
  }
}

export default App;
