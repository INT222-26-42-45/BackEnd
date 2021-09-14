package INT222.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private List<CartItemDto> cartItems;
    private double total;


}
