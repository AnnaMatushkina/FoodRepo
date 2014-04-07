package com.epam.feel.client.mvp;

import com.epam.feel.client.activity.ApplicationActivity;
import com.epam.feel.client.activity.HistoryBalanceActivity;
import com.epam.feel.client.activity.PersonalAccountActivity;
import com.epam.feel.client.place.ApplicationPlace;
import com.epam.feel.client.place.HistoryBalancePlace;
import com.epam.feel.client.place.PersonalAccountPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MainActivityMapper implements ActivityMapper {

    private Provider<ApplicationActivity> applicationActivityProvider;
    private Provider<PersonalAccountActivity> personalAccountActivityProvider;
    private Provider<HistoryBalanceActivity> historyBalanceActivityProvider;

    @Inject
    public MainActivityMapper(Provider<ApplicationActivity> applicationActivityProvider,
        Provider<PersonalAccountActivity> personalAccountActivityProvider,
        Provider<HistoryBalanceActivity> historyBalanceActivityProvider) {
        super();
        this.applicationActivityProvider = applicationActivityProvider;
        this.personalAccountActivityProvider = personalAccountActivityProvider;
        this.historyBalanceActivityProvider = historyBalanceActivityProvider;
    }

    /**
     * Map each Place to its corresponding Activity.
     */
    @Override
    public Activity getActivity(Place place) {
        if (place instanceof ApplicationPlace) {
            return applicationActivityProvider.get();
        } else if (place instanceof PersonalAccountPlace) {
            return personalAccountActivityProvider.get();
        } else if (place instanceof HistoryBalancePlace) {
            return historyBalanceActivityProvider.get();
        }
        return null;
    }
}
