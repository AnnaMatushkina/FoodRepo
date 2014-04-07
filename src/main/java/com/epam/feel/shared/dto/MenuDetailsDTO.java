package com.epam.feel.shared.dto;

import java.io.Serializable;

/**
 * Represents menu details DTO across application.
 * 
 * @author Evgeny_Neustroev
 */
public class MenuDetailsDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -8743184366330988367L;

    private String dishName;
    private Double price;
    private Integer weight;
    private Integer maxCount;
    private String structure;
    private String url;
    private Long imageId;
    private Boolean isChiefChoice;
    private Boolean alive;

    private MenuDTO menu;
    private DishTypeDTO dishType;

    public MenuDetailsDTO() {
        super();
        this.alive = true;
    }

    public MenuDetailsDTO(Long id, String dishName, Boolean isChiefChoice, Boolean alive, Double price, Integer weight,
        Integer maxCount, String structure, String url, Long imageId, MenuDTO menu, DishTypeDTO dishType) {
        super(id);
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.maxCount = maxCount;
        this.structure = structure;
        this.url = url;
        this.imageId = imageId;
        this.menu = menu;
        this.dishType = dishType;
        this.isChiefChoice = isChiefChoice;
        this.alive = alive;
    }

    public Boolean getIsChiefChoice() {
        return isChiefChoice;
    }

    public void setIsChiefChoice(Boolean isChiefChoice) {
        this.isChiefChoice = isChiefChoice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public MenuDTO getMenu() {
        return menu;
    }

    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    public DishTypeDTO getDishType() {
        return dishType;
    }

    public void setDishType(DishTypeDTO dishType) {
        this.dishType = dishType;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(super.toString()).append("Dish name=").append(dishName)
            .append("; Dish type=").append(dishType).append("; Max count=").append(maxCount).append("; Price=")
            .append(price).append("; Image id=").append(imageId).append("; is alive? =").append(alive).append("]")
            .toString();
    }

    public MenuDetailsDTO clone(MenuDTO newMenu) {
        MenuDetailsDTO result = new MenuDetailsDTO(null, dishName == null ? null : new String(dishName), isChiefChoice,
            alive, price == null ? null : Double.valueOf(price), weight == null ? null : Integer.valueOf(weight),
            maxCount == null ? null : Integer.valueOf(maxCount), structure == null ? null : new String(structure),
            url == null ? null : new String(url), imageId == null ? null : new Long(imageId), newMenu, dishType);
        return result;
    }

    public static boolean hasSameContent(MenuDetailsDTO left, MenuDetailsDTO right) {
        if (!left.equals(right)) {
            return safeEquals(left.isChiefChoice, right.isChiefChoice) && safeEquals(left.dishName, right.dishName)
                && safeEquals(left.price, right.price) && safeEquals(left.weight, right.weight)
                && safeEquals(left.maxCount, right.maxCount) && safeEquals(left.url, right.url)
                && safeEquals(left.imageId, right.imageId) && safeEquals(left.dishType, right.dishType)
                && safeEquals(left.structure, right.structure);
        }
        return true;
    }

    private static boolean safeEquals(Object left, Object right) {
        return left != null ? left.equals(right) : left == right;
    }

}
