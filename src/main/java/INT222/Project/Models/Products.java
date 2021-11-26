package INT222.Project.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
@JsonIgnoreProperties(value = "Carts")
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;

    @ManyToOne
    @JoinColumn(name = "ColorId")
    private Colors colors;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "ProductDescription")
    private String productDescription;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "ProductSize")
    private String productSize;

    @Column(name = "ProductPrice")
    private Double productPrice;

    @Column(name = "ProductDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productDate;

    @Column(name = "ProductImg")
    private String productImg;

    @ManyToOne
    @JoinColumn(name = "BrandId")
    private Brands brands;










}
