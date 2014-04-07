package com.epam.feel.client.ui.user;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle_ru_StaticClientBundleGenerator implements com.epam.feel.client.ui.user.PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle {
  private static PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle_ru_StaticClientBundleGenerator _instance0 = new PersonalHistoryBalanceView_PersonalHistoryBalanceViewUiBinderImpl_GenBundle_ru_StaticClientBundleGenerator();
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
    }
    return null;
  }-*/;
}
