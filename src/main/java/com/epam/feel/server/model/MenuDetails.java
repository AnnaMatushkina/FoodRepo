package com.epam.feel.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.google.common.base.Objects;

/**
 * Entity for Menu_Details> table.
 * 
 * @author Evgeny_Neustroev
 */
@Entity (name = "MenuDetails")
@Table (name = "menu_details")
public class MenuDetails extends BaseEntityImpl {

    public static final int UNESTIMATABLE_COUNT = -1;

    private static final long serialVersionUID = 1130063864561376232L;

    @Id
    @SequenceGenerator (name = "menu_details_gen", sequenceName = "menu_details_seq")
    @GeneratedValue (generator = "menu_details_gen", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;

    @Column (name = "chief_choice")
    private Boolean isChiefChoice;

    @Column (name = "alive")
    private Boolean alive;

    @OneToOne
    @JoinColumn (name = "dish_type_id")
    private DishType dishType;

    @Column (name = "dish_name")
    private String dishName;

    @Column (name = "price")
    private Double price;

    @Column (name = "weight")
    private Integer weight;

    @Column (name = "image_id")
    private Long imageId;

    @Column (name = "max_count")
    private Integer maxCount;

    @Column (name = "structure")
    private String structure;

    @Column (name = "url")
    private String url;

    public MenuDetails() {}

    public MenuDetails(Menu menu, Boolean isChiefChoice, Boolean alive, DishType dishType, String dishName,
        Double price, Integer weight, Integer maxCount, String structure, Long imageId, String url) {
        super();
        this.menu = menu;
        this.isChiefChoice = isChiefChoice;
        this.dishType = dishType;
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.maxCount = maxCount;
        this.structure = structure;
        this.imageId = imageId;
        this.url = url;
        this.alive = alive;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Menu details id", id).add("Dish menu ID", menu.getId())
            .add("Dish type", dishType).add("Dish name", dishName).add("Dish price", price).add("Dish weight", weight)
            .add("Dish max count", maxCount).add("Dish structure", structure).add("Image id", imageId)
            .add("Dish url", url).add("Is dish alive", alive).toString();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Boolean getIsChiefChoice() {
        return isChiefChoice;
    }

    public void setIsChiefChoice(Boolean isChiefChoice) {
        this.isChiefChoice = isChiefChoice;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
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

    public int getMaxCount() {
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

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

}
