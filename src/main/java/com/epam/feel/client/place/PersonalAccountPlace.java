package com.epam.feel.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PersonalAccountPlace extends Place {
    private static final String VIEW_ACCOUNT_TOKEN = "personalAccount";

    @Prefix (value = VIEW_ACCOUNT_TOKEN)
    public static class Tokenizer implements PlaceTokenizer<PersonalAccountPlace> {
        private final Provider<PersonalAccountPlace> placeProvider;

        @Inject
        public Tokenizer(Provider<PersonalAccountPlace> placeProvider) {
            this.placeProvider = placeProvider;
        }

        @Override
        public PersonalAccountPlace getPlace(String token) {
            return placeProvider.get();
        }

        @Override
        public String getToken(PersonalAccountPlace place) {
            return VIEW_ACCOUNT_TOKEN;
        }
    }
}
