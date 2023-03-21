import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Content from './components/Content';

class App extends Component {
    state = {
        item: []
    };

    async componentDidMount() {
        const response = await fetch('/items');
        const body = await response.json();
        this.setState({item: body});
    }

    render() {
        const {item} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Items</h2>
                        {items.map(item =>
                            <div key={item.id}>
                                {item.name} ({item.description})
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }

    async remove(id) {
        await fetch(`/items/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedItems = [...this.state.items].filter(i => i.id !== id);
            this.setState({items: updatedItems});
        });
    }

    render() {
        const {items, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const ProductList = items.map(item => {
            return <tr key={item.id}>
                <td style={{whiteSpace: 'nowrap'}}>{item.name}</td>
                <td>{item.description}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/items/" + item.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(item.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/items/new">Add Item</Button>
                    </div>
                    <h3>Items</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Price</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {productList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );

    }
}
export default App;