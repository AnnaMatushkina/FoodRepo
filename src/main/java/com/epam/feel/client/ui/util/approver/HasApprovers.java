package com.epam.feel.client.ui.util.approver;

/**
 * Interface to indicate approvement managers.
 * 
 * @author Michael_Silvanovich
 */
public interface HasApprovers {

    /**
     * Registers action approver
     * 
     * @param approver
     *            - action approver
     */
    void registerApprover(Approver approver);

    /**
     * Unregisters action approver
     * 
     * @param approver
     *            - action approver
     */
    void unregisterApprover(Approver approver);

    /**
     * Executes approvement procedure of action
     * 
     * @param action
     *            - action to be approved
     */
    void approveAction(ApproveableAction action);

}
