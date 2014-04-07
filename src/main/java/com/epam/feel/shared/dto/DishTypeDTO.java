package com.epam.feel.shared.dto;

import java.io.Serializable;

/**
 * Represents dish type DTO across application.
 * 
 * @author Evgeny_Neustroev
 */
public class DishTypeDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 4568699566267106892L;

    private String text;

    public DishTypeDTO() {
        super();
    }

    public DishTypeDTO(Long id, String text) {
        super(id);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("Dish type=").append(text).append("]")
            .toString();
    }
}
