package services;

import model.Product;
import java.io.IOException;
import java.util.List;

public interface ProductService {

    void addProduct() throws IOException;

    void removeProduct() throws IOException;

    void modifyProduct() throws IOException;

    void findProduct() throws IOException;

    List<Product> showAllProducts();

}
