package com.epam.feel.server.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import com.google.common.base.Objects;

/**
 * Entity for Dish_Type table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "DishType")
@Table (name = "dish_type")
@Cacheable
@NamedQueries ({@NamedQuery (name = DishType.QUERY_FIND_ALL, query = "FROM DishType")})
public class DishType extends BaseEntityImpl {

    private static final long serialVersionUID = -5780306559144920031L;

    public static final String QUERY_FIND_ALL = "findAllDishTypes";

    @Id
    private Long id;

    @Column (name = "text")
    private String text;

    public DishType() {}

    public DishType(Long id, String text) {
        super();
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Dish type id", id).add("Dish type text", text).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
