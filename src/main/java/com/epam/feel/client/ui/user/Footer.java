package com.epam.feel.client.ui.user;

import static com.epam.feel.client.IEpamFeelConstants.CONSTANTS;
import java.util.Date;
import java.util.List;
import com.epam.feel.client.EpamFeelResources;
import com.epam.feel.client.IEpamFeelMessages;
import com.epam.feel.client.view.IFooterView;
import com.epam.feel.shared.WebAppConstants;
import com.epam.feel.shared.dto.ClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Footer layout view implementation.
 * 
 * @author Anna_Gavrilina
 */
public class Footer extends Composite implements IFooterView {

    private static FooterViewUiBinder uiBinder = GWT.create(FooterViewUiBinder.class);

    interface FooterViewUiBinder extends UiBinder<Widget, Footer> {}

    private static final String RIGHT_MARGIN = EpamFeelResources.INSTANCE.global().rightSmallMargin();

    private static final String MAIL_TO = "mailto:";

    private static final String MAIL_SUBJECT = "?subject=";

    private static final String APP_START_YEAR = "2012";

    private IFooterPresenter presenter;

    @UiField
    HorizontalPanel adminsPanel;
    @UiField
    Label copyright;

    public Footer() {
        initWidget(uiBinder.createAndBindUi(this));
        generateCopyright();
    }

    @Override
    public void setPresenter(IFooterPresenter footerPresenter) {
        this.presenter = footerPresenter;
        refreshAdministrators();
    }

    private void refreshAdministrators() {
        presenter.getAdministrators(getAdminsCallback);
    }

    private AsyncCallback<List<ClientDTO>> getAdminsCallback = new AsyncCallback<List<ClientDTO>>() {
        @Override
        public void onFailure(Throwable throwable) {
            GWT.log("FooterView.getAdminsCallback (err)", throwable);
        }

        @Override
        public void onSuccess(List<ClientDTO> clientDTOs) {
            generateLinkAdministrators(clientDTOs);
        }
    };

    private void generateLinkAdministrators(List<ClientDTO> clientDTOs) {
        adminsPanel.clear();
        for (ClientDTO client : clientDTOs) {
            String email = client.getEmail();
            String href = MAIL_TO + email + MAIL_SUBJECT + CONSTANTS.defaultSubject();
            Anchor link = new Anchor();
            link.setHref(href);
            link.setText(email);
            link.setStyleName(RIGHT_MARGIN);
            adminsPanel.add(link);
        }
    }

    private void generateCopyright() {
        String currentYear = WebAppConstants.YEAR_DATE_FORMATTER.format(new Date());
        String year = APP_START_YEAR;
        if (!APP_START_YEAR.equals(currentYear)) {
            year += " - " + currentYear;
        }
        copyright.setText(IEpamFeelMessages.MESSAGES.copyRightLabel(year));
    }
}
