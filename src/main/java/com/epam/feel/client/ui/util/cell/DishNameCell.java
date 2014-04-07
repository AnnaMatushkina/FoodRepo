package com.epam.feel.client.ui.util.cell;

import com.epam.feel.shared.dto.MenuDetailsDTO;
import com.epam.feel.shared.service.ServiceUtils;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Custom dish name cell.
 * 
 * @author Michael_Silvanovich
 */
public class DishNameCell extends Composite {

    private static DishNameCellUiBinder uiBinder = GWT.create(DishNameCellUiBinder.class);

    @UiField
    Label dishConsistency;

    @UiField
    Image image;
    @UiField
    Image cookie;
    @UiField
    SimplePanel nameContainer;

    interface DishNameCellUiBinder extends UiBinder<Widget, DishNameCell> {}

    public DishNameCell() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * Sets dish to be represented by
     * 
     * @param dish
     *            dish to be represented by
     */
    public void setDish(MenuDetailsDTO dish) {
        String url = dish.getUrl();
        String dishName = dish.getDishName();

        nameContainer.clear();

        Widget widget;

        if ((url == null) || (url.isEmpty())) {
            Label label = new Label();
            label.setText(dishName);
            widget = label;

        } else {
            Anchor anchor = new Anchor();
            anchor.setHref(url);
            anchor.setTarget("_blank");
            anchor.setText(dishName);
            widget = anchor;
        }

        nameContainer.add(widget);

        dishConsistency.setText(dish.getStructure());
        final Long imageId = dish.getImageId();
        String imageUrl = imageId != null ? ServiceUtils.getImageUrlById(imageId) : null;
        if (imageUrl == null || imageUrl.isEmpty()) {
            image.setVisible(false);
        } else {
            image.setVisible(true);
            image.setUrl(imageUrl);
        }
        cookie.setVisible(dish.getIsChiefChoice());
    }

}
