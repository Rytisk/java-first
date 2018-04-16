package com.jlab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query="select p from Product as p")
})
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COST")
    private Integer cost;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
