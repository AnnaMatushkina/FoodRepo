package com.epam.feel.client.mvp;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Artem Tumasov (Artem_Tumasov@epam.com)
 */
public class ClientFactoryImpl implements ClientFactory {

    private final EventBus eventBus;
    private final PlaceController placeController;

    public ClientFactoryImpl(EventBus eventBus, PlaceController placeController) {
        this.eventBus = eventBus;
        this.placeController = placeController;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

}
