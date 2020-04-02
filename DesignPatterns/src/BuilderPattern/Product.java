/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuilderPattern;

/**
 *
 * @author windows
 */
public class Product {

    private String id;
    private String retailer_id;
    private String name;
    private String description = null;
    private Float weight = null;
    private Float length = null;
    private Float width = null;
    private Float height = null;
    private Float price;
    private Float discount = Float.valueOf(0);

    public Product(){
        
    }
    
    public Product(Builder builder) {
        this.id = builder.id;
        this.retailer_id = builder.retailer_id;
        this.name = builder.name;
        this.description = builder.description;
        this.weight = builder.weight;
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
        this.price = builder.price;
        this.discount = builder.discount;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", retailer_id=" + retailer_id + ", name=" + name + ", description=" + description + ", weight=" + weight + ", length=" + length + ", width=" + width + ", height=" + height + ", price=" + price + ", discount=" + discount + '}';
    }
    
    

    static class Builder {
        private String id;
        private String retailer_id;
        private String name;
        private String description = null;
        private Float weight = null;
        private Float length = null;
        private Float width = null;
        private Float height = null;
        private Float price;
        private Float discount = Float.valueOf(0);

        public Builder(String id, String retailer_id, String name, Float price) {
            this.id = id;
            this.name = name;
            this.retailer_id = retailer_id;
            this.price = price;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setWeight(Float weight) {
            this.weight = weight;
            return this;
        }

        public Builder setLength(Float length) {
            this.length = length;
            return this;
        }

        public Builder setWidth(Float width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(Float height) {
            this.height = height;
            return this;
        }

        public Builder setDiscount(Float discount) {
            this.discount = discount;
            return this;
        }

        public Product build() {
            Product product = new Product(this);
            return product;
        }

    }
}
