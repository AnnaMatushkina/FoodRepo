package com.epam.feel.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ApplicationPlace extends Place {
    private static final String VIEW_APP_TOKEN = "application";

    @Prefix (value = VIEW_APP_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<ApplicationPlace> {
        private final Provider<ApplicationPlace> placeProvider;

        @Inject
        public Tokenizer(Provider<ApplicationPlace> placeProvider) {
            this.placeProvider = placeProvider;
        }

        @Override
        public ApplicationPlace getPlace(String token) {
            return placeProvider.get();
        }

        @Override
        public String getToken(ApplicationPlace place) {
            return VIEW_APP_TOKEN;
        }
    }
}
