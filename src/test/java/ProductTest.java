import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void testRemoveId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 50_000);
        Product product2 = new Product(55, "Пылесос", 30_000);
        Product product3 = new Product(14, "Телевизор", 90_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(5));
    }

    @Test
    public void testRemoveId2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 50_000);
        Product product2 = new Product(55, "Пылесос", 30_000);
        Product product3 = new Product(14, "Телевизор", 90_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(55);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
