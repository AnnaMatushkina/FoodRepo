package com.epam.feel.client.ui.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle_ru_InlineClientBundleGenerator implements com.epam.feel.client.ui.admin.ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle {
  private static ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle_ru_InlineClientBundleGenerator _instance0 = new ListGroupRequestView_ListGroupRequestViewUiBinderImpl_GenBundle_ru_InlineClientBundleGenerator();
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
