package com.epam.feel.client.mvp;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import com.epam.feel.client.mvp.AppPlaceHistoryMapper;
import com.epam.feel.client.mvp.AppPlaceFactory;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class AppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<AppPlaceFactory> implements AppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof com.epam.feel.client.place.ApplicationPlace) {
      com.epam.feel.client.place.ApplicationPlace place = (com.epam.feel.client.place.ApplicationPlace) newPlace;
      return new PrefixAndToken("application", factory.getApplicationPlaceTokenizer().getToken(place));
    }
    if (newPlace instanceof com.epam.feel.client.place.ArchiveOrderViewPlace) {
      com.epam.feel.client.place.ArchiveOrderViewPlace place = (com.epam.feel.client.place.ArchiveOrderViewPlace) newPlace;
      return new PrefixAndToken("archiveOrder", factory.getArchiveOrderViewPlaceTokenizer().getToken(place));
    }
    if (newPlace instanceof com.epam.feel.client.place.HistoryBalancePlace) {
      com.epam.feel.client.place.HistoryBalancePlace place = (com.epam.feel.client.place.HistoryBalancePlace) newPlace;
      return new PrefixAndToken("balanceHistory", factory.getBalanceHistoryPlaceTokenizer().getToken(place));
    }
    if (newPlace instanceof com.epam.feel.client.place.PersonalAccountPlace) {
      com.epam.feel.client.place.PersonalAccountPlace place = (com.epam.feel.client.place.PersonalAccountPlace) newPlace;
      return new PrefixAndToken("personalAccount", factory.getPersonalAccountPlaceTokenizer().getToken(place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("archiveOrder".equals(prefix)) {
      return factory.getArchiveOrderViewPlaceTokenizer();
    }
    if ("balanceHistory".equals(prefix)) {
      return factory.getBalanceHistoryPlaceTokenizer();
    }
    if ("application".equals(prefix)) {
      return factory.getApplicationPlaceTokenizer();
    }
    if ("personalAccount".equals(prefix)) {
      return factory.getPersonalAccountPlaceTokenizer();
    }
    return null;
  }

}
