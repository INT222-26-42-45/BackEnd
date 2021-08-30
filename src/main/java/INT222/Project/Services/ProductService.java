package INT222.Project.Services;

import INT222.Project.Models.Colors;
import INT222.Project.Models.Products;
import INT222.Project.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    //GetMapping
    public List<Products> allProducts(){
        return productRepository.findAll();
    }

    //GetMapping
    public Products showProduct(@PathVariable Integer productId){
        return productRepository.findById(productId).orElse(null);
    }

    //DeleteMapping
    public void deleteProduct(@PathVariable Integer productId) {
        productRepository.deleteProduct(productId);
        productRepository.deleteById(productId);
    }

    //PutMapping
    public Optional<Products> updateProduct(@PathVariable Integer productId, @RequestBody Products newProduct) {
        return productRepository.findById(productId).map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setProductDescription(newProduct.getProductDescription());
            product.setProductType(newProduct.getProductType());
            product.setProductSize(newProduct.getProductSize());
            product.setProductPrice(newProduct.getProductPrice());
            product.setProductDate(newProduct.getProductDate());
            product.setProductImg(newProduct.getProductImg());
            product.setBrands(newProduct.getBrands());
            product.setColors(newProduct.getColors());
            return productRepository.save(newProduct);
        });
    }

    //PostMapping
    public Products addProduct(@RequestBody Products newProducts){
        for(Colors c : newProducts.getColors()){
            newProducts.getColors().add(c);
        }
        return productRepository.save(newProducts);
    }

    public List<Products> findProduct(String productName){
        return productRepository.selectProduct(productName);
    }


}
