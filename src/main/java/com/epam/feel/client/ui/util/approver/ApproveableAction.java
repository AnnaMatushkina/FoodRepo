package com.epam.feel.client.ui.util.approver;

/**
 * Represents approvable action, made to be used with {@link ApproveManager}.
 * 
 * @author Michael_Silvanovich
 */
public interface ApproveableAction {

    /**
     * Runs action in according to specified approvement
     * 
     * @param approve
     *            true if approved, false - in other case
     */
    void run(boolean approve);

}
