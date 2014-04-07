package com.epam.feel.client.ui.util.approver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ApproveManager used to execute {@link ApproveableAction} in case of it is approved by all of registred
 * {@link Approver}.
 * 
 * @author Michael_Silvanovich
 */
public class ApproveManager implements HasApprovers {

    private List<Approver> approvers = new LinkedList<Approver>();

    @Override
    public void registerApprover(Approver approver) {
        if (approver != null && !approvers.contains(approver)) {
            approvers.add(approver);
        }
    }

    @Override
    public void unregisterApprover(Approver approver) {
        approvers.remove(approver);
    }

    @Override
    public void approveAction(final ApproveableAction viewChangeAction) {
        Iterator<Approver> iterator = approvers.iterator();
        approveAction(iterator, viewChangeAction);
    }

    private void approveAction(final Iterator<Approver> iterator, final ApproveableAction action) {
        if (iterator.hasNext()) {
            iterator.next().approve(new ApproveableActionDecorator(this, action, iterator));
        } else {
            action.run(true);
        }
    }

    private static class ApproveableActionDecorator implements ApproveableAction {

        private ApproveableAction action;
        private Iterator<Approver> iterator;
        private ApproveManager manager;

        public ApproveableActionDecorator(ApproveManager manager, ApproveableAction action, Iterator<Approver> iterator) {
            this.action = action;
            this.iterator = iterator;
            this.manager = manager;
        }

        @Override
        public void run(boolean approve) {
            if (approve) {
                manager.approveAction(iterator, action);
            }
        }

    }

}
