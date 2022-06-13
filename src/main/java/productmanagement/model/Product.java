package productmanagement.model;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, String price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
