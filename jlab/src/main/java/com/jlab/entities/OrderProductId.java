package com.jlab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class OrderProductId implements java.io.Serializable {

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProductId that = (OrderProductId) o;

        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

}
