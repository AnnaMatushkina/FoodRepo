package com.epam.feel.client.ui.util.dialogs;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import org.apache.commons.lang.StringUtils;
import com.epam.feel.client.ui.util.box.FixedLengthTextArea;
import com.epam.feel.shared.WebAppConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

/**
 * Message dialog with reason text area.
 * 
 * @author Michael_Silvanovich
 */
public class ReasonMessageBox extends AbstractDialog<ReasonMessageBox> {

    private static ReasonMessageBoxUiBinder uiBinder = GWT.create(ReasonMessageBoxUiBinder.class);

    interface ReasonMessageBoxUiBinder extends UiBinder<Widget, ReasonMessageBox> {}

    @UiField
    FixedLengthTextArea message;
    @UiField
    Button ok;
    @UiField
    Button cancel;

    public ReasonMessageBox() {
        setModal(true);
        setGlassEnabled(true);
        initUI();
    }

    private String reason;

    /**
     * Returns reason string inputted by user
     * 
     * @return - reason string inputted by user
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets reason
     * 
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    public HandlerRegistration addDialogEventHandler(DialogEventHandler<ReasonMessageBox> handler) {
        return addHandler(handler, DialogEvent.TYPE);
    }

    @Override
    void onInitUI() {
        setWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onPostInitUI() {
        super.onPostInitUI();
        message.setMaxLength(WebAppConstants.MAX_REASON_LENGTH);
    }

    @Override
    protected Button getPositiveButton() {
        return ok;
    }

    @Override
    protected Button getNegativeButton() {
        return cancel;
    }

    @Override
    protected void onPositiveButtonClicked() {
        if (message.getText().isEmpty()) {
            MessageDialog.alert(CONSTANTS.isEmptyReason());
        } else {
            reason = message.getText();
            message.setText(StringUtils.EMPTY);
            super.onPositiveButtonClicked();
        }
    }

    @Override
    protected void onNegativeButtonClicked() {
        reason = StringUtils.EMPTY;
        message.setText(StringUtils.EMPTY);
        super.onNegativeButtonClicked();
    }

    @Override
    protected boolean hasPositiveButton() {
        return true;
    }

    @Override
    protected boolean hasNegativeButton() {
        return true;
    }

}
