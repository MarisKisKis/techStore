import {useState, useEffect} from 'react';
import Preloader from './Preloader';
import ShopCard from './ShopCard';

export default function ShopList(props) {
    const [items, setItems] = useState([]); // товары магазина
    const [loading, setLoading] = useState(true); // идет загрузка?

    useEffect(() => {
        fetch('/items')
            .then(response => response.json())
            .then(data => {
                data.items && setItems(data.items.slice(0, 24));
                setLoading(false);
            });
    }, []);

    return (
        <div className="items">
            {loading ? (
                <Preloader />
            ) : items.length ? (
                items.map(item => (
                    <ShopCard key={item.id} {...item} appendToCart={props.appendToCart} />
                ))
            ) : (
                <p>Не удалось загрузить список товаров</p>
            )}
        </div>
    )
}