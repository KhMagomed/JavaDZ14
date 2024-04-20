public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product product) {
        int id = product.getId();
        Product product1 = findById(id);
        if (product1 != null) {
            throw new AlreadyExistsException(id);
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }


    public void add(Product product) {
        products = addToArray(product);
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void removeById(int id) {
        Product product1 = findById(id);
        if (product1 == null) {
            throw new NotFoundException(id);
        }


        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}