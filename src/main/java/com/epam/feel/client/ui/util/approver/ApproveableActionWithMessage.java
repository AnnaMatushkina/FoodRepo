package com.epam.feel.client.ui.util.approver;

/**
 * Abstract class of ApproveableAction containing confirmation to be used to make approvement.
 * 
 * @author Michael_Silvanovich
 */
public abstract class ApproveableActionWithMessage implements ApproveableAction {

    private String confirmationMessage;

    public ApproveableActionWithMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    /**
     * Returns containing confirmation message
     * 
     * @return containing confirmation message
     */
    public String getConfirmationMessage() {
        return confirmationMessage;
    }

}
