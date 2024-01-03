package dat3.MetteKera.config;


import dat3.MetteKera.repository.CategoryRepository;
import dat3.MetteKera.repository.ProductRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {

    ProductRepository productRepository;
   CategoryRepository categoryRepository;

   UserWithRolesRepository userWithRolesRepository;

    public DeveloperData(ProductRepository productRepository, CategoryRepository categoryRepository, UserWithRolesRepository userWithRolesRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userWithRolesRepository = userWithRolesRepository;

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ProductTestDataFactory factory = new ProductTestDataFactory(categoryRepository, productRepository,
                userWithRolesRepository);
        factory.generateTestProducts();

    }
}
