package org.testTRBL.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Product {

    private Integer id;
    @NotBlank(message = "Parameter name is required")
    private String name;
    @NotBlank(message = "Parameter price is required")
    @Min(value = 0, message = "Valor minimo permitido 0")
    private Double price;
    @NotBlank(message = "Parameter stock is required")
    @Min(value = 0, message = "Valor minimo permitido 0")
    private Integer stock;

    public Product(Integer id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
