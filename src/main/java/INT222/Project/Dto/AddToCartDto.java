package INT222.Project.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AddToCartDto {
    private int cartId;
    private  int productId;
    private  int quantity;

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ",";
    }
}
