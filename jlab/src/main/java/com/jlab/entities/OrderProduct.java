package com.jlab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "ORDER_PRODUCT")
@AssociationOverrides({
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "PRODCUT_ID")),
        @AssociationOverride(name = "pk.order",
                joinColumns = @JoinColumn(name = "ORDER_ID")) })
@Getter
@Setter
public class OrderProduct implements java.io.Serializable {

    @EmbeddedId
    private OrderProductId pk = new OrderProductId();

    @Column(name="QUANTITY")
    private int quantity;

    public OrderProduct() {
    }

    @Transient
    public Order getOrder() {
        return getPk().getOrder();
    }

    public void setOrder(Order order) {
        getPk().setOrder(order);
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }

    public void setProduct(Product product) {
        getPk().setProduct(product);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OrderProduct that = (OrderProduct) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
