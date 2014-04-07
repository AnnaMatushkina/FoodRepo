package com.epam.feel.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ArchiveOrderViewPlace extends Place {
    private static final String VIEW_ARCHIVE_ORDERS_TOKEN = "archiveOrder";

    @Prefix (value = VIEW_ARCHIVE_ORDERS_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<ArchiveOrderViewPlace> {
        private final Provider<ArchiveOrderViewPlace> placeProvider;

        @Inject
        public Tokenizer(Provider<ArchiveOrderViewPlace> placeProvider) {
            this.placeProvider = placeProvider;
        }

        @Override
        public ArchiveOrderViewPlace getPlace(String token) {
            return placeProvider.get();
        }

        @Override
        public String getToken(ArchiveOrderViewPlace place) {
            return VIEW_ARCHIVE_ORDERS_TOKEN;
        }
    }
}
