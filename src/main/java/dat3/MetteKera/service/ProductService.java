package dat3.MetteKera.service;

import dat3.MetteKera.dto.ProductRequest;
import dat3.MetteKera.dto.ProductResponse;
import dat3.MetteKera.entity.Category;
import dat3.MetteKera.entity.Product;
import dat3.MetteKera.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productResponses.add(getProduct(product.getId(), false));
        }
        return productResponses;
    }

    public List<ProductResponse> getAllProductsDetails() {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productResponses.add(getProduct(product.getId(), true));
        }
        return productResponses;

    }

    public ProductResponse getProduct(Integer id, boolean includeDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product with this id not found"));
        return new ProductResponse(product, includeDetails);
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Category category = categoryService.getCategory(productRequest.getCategory());
        Product product = ProductRequest.productFromProductRequest(productRequest);

        for (Product.ProductImage image : product.getImages()) {
            image.setProduct(product);
        }
        product.setCategory(category);
        category.addProduct(product);
        return new ProductResponse(productRepository.save(product), true);
    }
/*
    public Product getProductByName(String name) {
        return productRepository.findById().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

   /* public Product getProductByName(String name) {
       return productRepository.findById(name)Throw(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    }
*/
}
