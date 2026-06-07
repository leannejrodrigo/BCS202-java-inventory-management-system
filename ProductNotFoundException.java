public class ProductNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "error: the product you are searching for does not exist.";
    }
}
