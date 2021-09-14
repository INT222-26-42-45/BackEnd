package INT222.Project.Dto;

import INT222.Project.Models.Carts;
import INT222.Project.Models.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CartItemDto {
    private int cartId;
    private int userId;
    private int quantity;
    private  Products products;

    public CartItemDto(Carts carts) {
        this.setCartId(carts.getCartId());
        this.setUserId(carts.getUsers().getUserId());
        this.setQuantity(carts.getQuantity());
        this.setProducts(carts.getProducts());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", productName=" + products.getProductName() +
                '}';
    }
}
