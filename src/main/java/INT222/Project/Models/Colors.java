package INT222.Project.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Colors")
@JsonIgnoreProperties(value = "products")
//@SQLInsert(sql = "INSERT IGNORE INTO Colors(ColorId, ColorName) VALUES(?,?)")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ColorId")
    private int colorId;


    @Column(name = "ColorName")
    private String colorName;

}
