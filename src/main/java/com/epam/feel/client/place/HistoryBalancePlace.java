package com.epam.feel.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class HistoryBalancePlace extends Place {

    private static final String VIEW_HISTORY_BALANCE_TOKEN = "balanceHistory";

    @Prefix (value = VIEW_HISTORY_BALANCE_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<HistoryBalancePlace> {
        private final Provider<HistoryBalancePlace> placeProvider;

        @Inject
        public Tokenizer(Provider<HistoryBalancePlace> placeProvider) {
            this.placeProvider = placeProvider;
        }

        @Override
        public HistoryBalancePlace getPlace(String token) {
            return placeProvider.get();
        }

        @Override
        public String getToken(HistoryBalancePlace place) {
            return VIEW_HISTORY_BALANCE_TOKEN;
        }
    }
}
