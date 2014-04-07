package com.epam.feel.client.mvp;

import com.epam.feel.client.place.ApplicationPlace;
import com.epam.feel.client.place.ArchiveOrderViewPlace;
import com.epam.feel.client.place.HistoryBalancePlace;
import com.epam.feel.client.place.PersonalAccountPlace;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AppPlaceFactory {

    @Inject
    ApplicationPlace.Tokenizer applicationPlaceTokenizer;

    @Inject
    Provider<ApplicationPlace> applicationProviderPlace;

    @Inject
    PersonalAccountPlace.Tokenizer personalAccountPlaceTokenizer;

    @Inject
    Provider<PersonalAccountPlace> personalAccountProviderPlace;

    @Inject
    HistoryBalancePlace.Tokenizer balanceHistoryPlaceTokenizer;

    @Inject
    Provider<HistoryBalancePlace> balanceHistoryProviderPlace;

    @Inject
    ArchiveOrderViewPlace.Tokenizer archiveOrderViewPlaceTokenizer;

    @Inject
    Provider<ArchiveOrderViewPlace> archiveOrderViewProviderPlace;

    public ApplicationPlace.Tokenizer getApplicationPlaceTokenizer() {
        return applicationPlaceTokenizer;
    }

    public ApplicationPlace getApplicationProviderPlace() {
        return applicationProviderPlace.get();
    }

    public PersonalAccountPlace.Tokenizer getPersonalAccountPlaceTokenizer() {
        return personalAccountPlaceTokenizer;
    }

    public PersonalAccountPlace getPersonalAccountProviderPlace() {
        return personalAccountProviderPlace.get();
    }

    public HistoryBalancePlace.Tokenizer getBalanceHistoryPlaceTokenizer() {
        return balanceHistoryPlaceTokenizer;
    }

    public HistoryBalancePlace getBalanceHistoryProviderPlace() {
        return balanceHistoryProviderPlace.get();
    }

    public ArchiveOrderViewPlace.Tokenizer getArchiveOrderViewPlaceTokenizer() {
        return archiveOrderViewPlaceTokenizer;
    }

    public ArchiveOrderViewPlace getArchiveOrderViewProviderPlace() {
        return archiveOrderViewProviderPlace.get();
    }

}
