import ProductCard from './ProductCard';
import { Product } from './types';

type Props = {
    products: Product[];
}

function ProductsList({products}: Props) {
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(p => (
                    <ProductCard key={p.id} product={p}/>
                ))}
            </div>
        </div>
    );

}

export default ProductsList;