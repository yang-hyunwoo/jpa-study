package jpql;

import javax.persistence.*;

@Entity
@Table(name ="ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private Adderss adderss;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Adderss getAdderss() {
        return adderss;
    }

    public void setAdderss(Adderss adderss) {
        this.adderss = adderss;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
