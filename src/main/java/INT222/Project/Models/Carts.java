package INT222.Project.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartId")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Products products;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users users;

    public Carts(Products products, int quantity, Users users) {
        this.products = products;
        this.quantity = quantity;
        this.users = users;
    }
}
