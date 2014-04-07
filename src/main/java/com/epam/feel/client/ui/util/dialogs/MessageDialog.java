package com.epam.feel.client.ui.util.dialogs;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Modal dialog with caption and one or two buttons MessageDialog.confirm("Really delete?", new
 * CloseHandler<PopupPanel>().
 * 
 * @author Evgeny_Kincharov
 */
public class MessageDialog extends AbstractDialog<MessageDialog> {

    private static final int DIALOG_TYPE_MESSAGE = 0;
    private static final int DIALOG_TYPE_CONFIRM = 1;

    private static final int SPACING = 8;
    private static final String WIDTH_BUTTON = "80px";
    private static final String PANEL_SIZE = "100%";

    private int dialogType;
    private String message;

    Button ok;
    Button cancel;

    /**
     * Show modal message with button OK.
     * <p>
     * For example:
     * </p>
     * 
     * <pre>
     * MessageDialog.alert(&quot;Hello world&quot;)
     * </pre>
     * 
     * @param message
     *            - message to show
     */
    public static void alert(String message) {
        alert(message, null);
    }

    public static void alert(String message, CloseHandler<PopupPanel> closeHandler) {
        MessageDialog db = new MessageDialog(message, DIALOG_TYPE_MESSAGE);
        if (closeHandler != null) {
            db.addCloseHandler(closeHandler);
        }
        db.show();
    }

    /**
     * Show modal question to user
     * 
     * @param message
     *            - question
     * @param handler
     *            - callback that recives control after closing dialog
     *            <p>
     *            For example:
     *            <p>
     * 
     *            <pre>
     * MessageDialog.confirm(&quot;Really delete?&quot;, new CloseHandler&lt;PopupPanel&gt;() {
     * 
     *     &#064;Override
     *     public void onClose(CloseEvent&lt;PopupPanel&gt; event) {
     *         if (((MessageDialog) event.getTarget()).getModalResult() == MessageDialog.MODAL_RESULT_OK) {
     *             doSomethingIfPressedOK();
     *         } else {
     *             doSomethingIfPressedCancel();
     *         }
     *     }
     * });
     * </pre>
     */
    public static void confirm(String message, DialogEventHandler<MessageDialog> handler) {
        MessageDialog db = new MessageDialog(message, DIALOG_TYPE_CONFIRM);
        db.addDialogEventHandler(handler);
        db.show();
    }

    private static String getCaptionByType(int dialogType) {
        String result;
        switch (dialogType) {
            case DIALOG_TYPE_MESSAGE:
                result = CONSTANTS.dialogMessageCaption();
                break;
            case DIALOG_TYPE_CONFIRM:
                result = CONSTANTS.dialogConfirmCaption();
                break;
            default:
                result = CONSTANTS.undefinedDialogType();
        }
        return result;
    }

    private MessageDialog(String message, int dialogType) {
        this.message = message;
        this.dialogType = dialogType;
        initUI();
    }

    @Override
    void onInitUI() {
        setModal(true);
        setAutoHideEnabled(false);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setText(getCaptionByType(dialogType));
        VerticalPanel vp = new VerticalPanel();
        vp.setSpacing(SPACING);
        Label messageLabel = new Label(message);
        vp.add(messageLabel);
        HorizontalPanel hp = new HorizontalPanel();
        ok = createButton(
            hp,
            CONSTANTS.ok(),
            (dialogType == DIALOG_TYPE_CONFIRM) ? HasHorizontalAlignment.ALIGN_RIGHT : HasHorizontalAlignment.ALIGN_CENTER);
        if (dialogType == DIALOG_TYPE_CONFIRM) {
            cancel = createButton(hp, CONSTANTS.cancel(), HasHorizontalAlignment.ALIGN_LEFT);
        }
        vp.add(hp);
        add(vp);
        vp.setSize(PANEL_SIZE, PANEL_SIZE);
        hp.setSize(PANEL_SIZE, PANEL_SIZE);
        center();
    }

    private Button createButton(HorizontalPanel panel, String caption,
        HasHorizontalAlignment.HorizontalAlignmentConstant align) {
        Button button = new Button(caption);
        panel.add(button);
        button.setWidth(WIDTH_BUTTON);
        panel.setCellHorizontalAlignment(button, align);
        return button;
    }

    @Override
    protected Button getPositiveButton() {
        return ok;
    }

    @Override
    protected boolean hasPositiveButton() {
        return true;
    }

    @Override
    protected boolean hasNegativeButton() {
        return dialogType == DIALOG_TYPE_CONFIRM;
    }

    @Override
    protected Button getNegativeButton() {
        return cancel;
    }
}
