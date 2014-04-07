package com.epam.feel.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * The styles used in application.
 * 
 * @author Anna_Gavrilina
 */
public interface EpamFeelResources extends ClientBundle {

    public static final EpamFeelResources INSTANCE = GWT.create(EpamFeelResources.class);

    public interface GlobalStyles extends CssResource {

        String header();

        String centerBox();

        String headerMainTable();

        String headerPersonalAccountLabel();

        String headerPersonalAccountNum();

        String headerPayment();

        String headerDecoratorPanel();

        String footerLabel();

        String footerAdminLinks();

        String footerLabelCopy();

        String footer();

        String tableMenuHeader();

        String tableMenuDishRow();

        String tableMenuDishType();

        String tableMenu();

        String noUnderlineAnchor();

        String rightText();

        String leftText();

        String boldDateLabel();

        String floatRight();

        String smallText();

        String smallTextSelected();

        String timeViewInput();

        String spinnerUpPressed();

        String spinnerDownPressed();

        String spinnerUpHover();

        String spinnerDownHover();

        String spinnerUpGrayed();

        String spinnerDownGrayed();

        String spinnerUpReleased();

        String spinnerDownReleased();

        String calendarImage();

        String rightSmallMargin();

        String labelWithField();

        String leftLargeMargin();

        String labelBetweenFields();

        String leftMediumMargin();

        String leftSmallMargin();

        String hint();

        String counterDishPadding();

        String delimeterLineHeader();

        String logout();

        String counter();

        String counterPlus();

        String counterMinus();

        String rightFloatImage();

        String leftFloatImage();

        String preMenuNameLabel();

        String highlighted();

        String highlightedRequired();

        String waitingGlass();

        String imgAdvice();
    }

    @Source (value = "global.css")
    @NotStrict
    GlobalStyles global();
}