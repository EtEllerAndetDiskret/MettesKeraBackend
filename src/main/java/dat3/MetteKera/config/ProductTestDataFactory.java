package dat3.MetteKera.config;



import dat3.MetteKera.entity.Category;
import dat3.MetteKera.entity.Product;
import dat3.MetteKera.repository.CategoryRepository;
import dat3.MetteKera.repository.ProductRepository;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;

import java.util.*;

public class ProductTestDataFactory {
    CategoryRepository categoryRepository;
    ProductRepository productRepository;

    UserWithRolesRepository userWithRolesRepository;
    public ProductTestDataFactory(CategoryRepository repository, ProductRepository productRepository, UserWithRolesRepository userWithRolesRepository) {
        this.categoryRepository = repository;
        this.productRepository = productRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }

    public void generateTestProducts() {

        UserWithRoles testUser1 = new UserWithRoles("USER", "test666", "alex@alex.alex");
        UserWithRoles testUser2 = new UserWithRoles("ADMIN", "test666", "admin@admin.admin");
        List<UserWithRoles> users = new ArrayList<>(List.of(testUser1, testUser2));
        userWithRolesRepository.saveAll(users);

        Category gryder = new Category("Gryder");
        Category kander = new Category("Kander");
        Category kopper = new Category("Kopper");
        Category skåle = new Category("Skåle");
        List<Category> categories = new ArrayList<>(List.of(gryder, kander, kopper, skåle));

        categoryRepository.saveAll(categories);

        Product.ProductImage stegesoImage1 = new Product.ProductImage();
        Product.ProductImage stegesoImage2 = new Product.ProductImage();
        Product.ProductImage stegesoImage3 = new Product.ProductImage();
        Product.ProductImage stegesoImage4 = new Product.ProductImage();
        Product.ProductImage stegesoImage5 = new Product.ProductImage();
        List<Product.ProductImage> stegesoImages = new ArrayList<>(List.of(stegesoImage1, stegesoImage2, stegesoImage3, stegesoImage4, stegesoImage5));
        for (int i = 0; i < stegesoImages.size(); i++) {
            Product.ProductImage stegesoImage = stegesoImages.get(i);
            stegesoImage.setImageUrl(String.format("https://diskret.blob.core.windows.net/keramik/Gryder/Stegeso/%d.jpg", i+1));
        }

        Product.ProductImage lilleKandeImage1 = new Product.ProductImage();
        Product.ProductImage lilleKandeImage2 = new Product.ProductImage();
        Product.ProductImage lilleKandeImage3 = new Product.ProductImage();
        Product.ProductImage lilleKandeImage4 = new Product.ProductImage();
        Product.ProductImage lilleKandeImage5 = new Product.ProductImage();
        List<Product.ProductImage> lilleKandeImages = new ArrayList<>(List.of(lilleKandeImage1, lilleKandeImage2, lilleKandeImage3, lilleKandeImage4, lilleKandeImage5));
        for (int i = 0; i < lilleKandeImages.size(); i++) {
            Product.ProductImage lilleKandeImage = lilleKandeImages.get(i);
            lilleKandeImage.setImageUrl(String.format("https://diskret.blob.core.windows.net/keramik/Kander/Lille_kande/%d.jpg", i+1));
        }

        Product.ProductImage mælkeKandeImage1 = new Product.ProductImage();
        Product.ProductImage mælkeKandeImage2 = new Product.ProductImage();
        Product.ProductImage mælkeKandeImage3 = new Product.ProductImage();
        Product.ProductImage mælkeKandeImage4 = new Product.ProductImage();
        Product.ProductImage mælkeKandeImage5 = new Product.ProductImage();
        List<Product.ProductImage> mælkeKandeImages = new ArrayList<>(List.of(mælkeKandeImage1, mælkeKandeImage2, mælkeKandeImage3, mælkeKandeImage4, mælkeKandeImage5));
        for (int i = 0; i < mælkeKandeImages.size(); i++) {
            Product.ProductImage mælkeKandeImage = mælkeKandeImages.get(i);
            mælkeKandeImage.setImageUrl(String.format("https://diskret.blob.core.windows.net/keramik/Kander/Kartonkande/%d.jpg", i+1));
        }

        Product.ProductImage blåKopImage1 = new Product.ProductImage();
        Product.ProductImage blåKopImage2 = new Product.ProductImage();
        Product.ProductImage blåKopImage3 = new Product.ProductImage();
        Product.ProductImage blåKopImage4 = new Product.ProductImage();
        Product.ProductImage blåKopImage5 = new Product.ProductImage();
        List<Product.ProductImage> blåKopImages = new ArrayList<>(List.of(blåKopImage1, blåKopImage2, blåKopImage3, blåKopImage4, blåKopImage5));
        for (int i = 0; i < blåKopImages.size(); i++) {
            Product.ProductImage blåKopImage = blåKopImages.get(i);
            blåKopImage.setImageUrl(String.format("https://diskret.blob.core.windows.net/keramik/Kopper/Blue_kop/%d.jpg", i+1));
        }

        Product stegeso = new Product("Stegeso", "Dette er en stegeso :)", 500, 1, gryder, stegesoImages);
        Product lilleKande = new Product("Lille kande", "Dette er en lille kande", 250, 1, kander, lilleKandeImages);
        Product mælkeKande = new Product("Mælke kande", "Dette er en mælkekande :)", 700, 1, kander, mælkeKandeImages);
        Product blåKop = new Product("Blå kop", "Dette er en blå kop :)", 150, 5, kopper, blåKopImages);

        productRepository.saveAll(List.of(stegeso, lilleKande, mælkeKande, blåKop));

    }
}
