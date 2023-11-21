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
    private String imageSourceOne;

    @NotEmpty(message = "Link must not be empty")
    @NotBlank
    @Size(min = 2,message = "min symbols-2")
    private String imageSourceTwo;

    @NotEmpty(message = "Link must not be empty")
    @NotBlank
    @Size(min = 2,message = "min symbols-2")
    private String imageSourceThree;
    @NotNull(message = "Enter quantity")
    @DecimalMin(value="0.0", message = "Should be bigger than zero")
    private Integer stock;
    private String category;




    public Product(@NotEmpty(message = "Must no be empty") @NotBlank @Size(min = 2, message = "Min 2") String producer, @NotEmpty(message = "Product name cannot be empty") @NotBlank @Size(min = 2, message = "Product name is too short") String name, @DecimalMax(value = "1000000.0", message = "Price is too high") @DecimalMin(value = "0.0", message = "The price cannot be lower than 0 lv") @NotNull(message = "Please give price") Double price, @NotEmpty(message = "The link to the photo cannot be empty") @NotBlank @Size(min = 2, message = "The link to photo is too short") String imageSourceOne, @NotBlank @Size(min = 2, message = "The link to photo is too short") String imageSourceTwo, @NotBlank @Size(min = 2, message = "The link to photo is too short") String imageSourceThree, @NotNull(message = "Please enter the number of products available") @DecimalMin(value = "0.0", message = "The quantity cannot be lower than 0") Integer stock, String category) {
        this.producer = producer;
        this.name = name;
        this.price = price;
        this.imageSourceOne = imageSourceOne;
        this.imageSourceTwo = imageSourceTwo;
        this.imageSourceThree = imageSourceThree;
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

    public String getImageSourceOne() {
        return imageSourceOne;
    }

    public void setImageSourceOne(String imageSourceOne) {
        this.imageSourceOne = imageSourceOne;
    }

    public String getImageSourceTwo() {
        return imageSourceTwo;
    }

    public void setImageSourceTwo(String imageSourceTwo) {
        this.imageSourceTwo = imageSourceTwo;
    }

    public String getImageSourceThree() {
        return imageSourceThree;
    }

    public void setImageSourceThree(String imageSourceThree) {
        this.imageSourceThree = imageSourceThree;
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
