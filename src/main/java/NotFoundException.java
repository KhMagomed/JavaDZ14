public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Нет продукта с таким ID: " + id + ".");
    }
}
