package online.handsmade.shop.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @NotEmpty()
    @NotBlank
    @Size(min = 2)
    private String producer;
    @NotEmpty()
    @NotBlank
    @Size(min = 2,message = "It should be min 2 symbols")
    private String name;
    @DecimalMax(value = "1000000.0", message = "It's over max price")
    @DecimalMin(value="0.0", message = "It's under min price")
    @NotNull(message = "Enter price")
    private Double price;
    @NotEmpty(message = "Link must not be empty")
    @NotBlank
    @Size(min = 2,message = "min symbols-2")
    private String imageSource;
    @NotNull(message = "Enter quantity")
    @DecimalMin(value="0.0", message = "Should be bigger than zero")
    private Integer stock;
    private String category;

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Product(@NotEmpty(message = "Must no be empty") @NotBlank @Size(min = 2, message = "Min t") String producer, @NotEmpty(message = "Nazwa produktu nie może być pusta") @NotBlank @Size(min = 2, message = "Zbyt krótka nazwa produktu") String name, @DecimalMax(value = "1000000.0", message = "Zbyt duża cena") @DecimalMin(value = "0.0", message = "Cena nie może być niższa niż 0zł") @NotNull(message = "Proszę podać cene") Double price, @NotEmpty(message = "Link do zdjęcia nie może być pusty") @NotBlank @Size(min = 2, message = "Zbyt krótki link do zdjęcia") String imageSource, @NotNull(message = "Proszę podać ilość dostępnych produktów") @DecimalMin(value = "0.0", message = "Ilosc nie może być niższa niż 0") Integer stock, String category) {
        this.producer = producer;
        this.name = name;
        this.price = price;
        this.imageSource = imageSource;
        this.stock = stock;
        this.category = category;
    }

    public Product(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
