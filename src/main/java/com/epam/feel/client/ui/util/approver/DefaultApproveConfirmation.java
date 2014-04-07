package com.epam.feel.client.ui.util.approver;

import com.epam.feel.client.ui.util.dialogs.DialogEvent;
import com.epam.feel.client.ui.util.dialogs.DialogEventHandler;
import com.epam.feel.client.ui.util.dialogs.MessageDialog;

/**
 * Default approve confirmation listener for {@link MessageDialog} implementing {@link DialogEventHandler}.
 * 
 * @see MessageDialog
 * @see DialogEventHandler
 * @author Michael_Silvanovich
 */
public class DefaultApproveConfirmation implements DialogEventHandler<MessageDialog> {

    private ApproveableAction action;

    @Override
    public void onPositiveButtonClick(DialogEvent<MessageDialog> event) {
        action.run(true);
    }

    @Override
    public void onNegativeButtonClick(DialogEvent<MessageDialog> event) {
        action.run(false);
    }

    public void setAction(ApproveableAction action) {
        this.action = action;
    }

}