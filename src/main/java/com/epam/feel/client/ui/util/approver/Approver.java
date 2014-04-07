package com.epam.feel.client.ui.util.approver;

/**
 * Approver, to be used with approvement managers ({@link HasApprovers}, {@link ApproveManager}).
 * 
 * @author Michael_Silvanovich
 */
public interface Approver {

    /**
     * Approves action by calling {@link ApproveableAction#run(boolean)}
     * 
     * @see ApproveableAction
     * @param action
     *            - action to be approved
     */
    void approve(ApproveableAction action);

}
