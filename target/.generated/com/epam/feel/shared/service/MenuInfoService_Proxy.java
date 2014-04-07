package com.epam.feel.shared.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class MenuInfoService_Proxy extends RemoteServiceProxy implements com.epam.feel.shared.service.MenuInfoServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.epam.feel.shared.service.MenuInfoService";
  private static final String SERIALIZATION_POLICY ="8223D41B22F3E5D69243812C71B20E66";
  private static final com.epam.feel.shared.service.MenuInfoService_TypeSerializer SERIALIZER = new com.epam.feel.shared.service.MenuInfoService_TypeSerializer();
  
  public MenuInfoService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "springGwtServices/menuinfoservice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void checkRequestTime(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "checkRequestTime");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void generateMenuToNextDay(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "generateMenuToNextDay");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActualMenus(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "getActualMenus");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllDishTypes(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "getAllDishTypes");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getLastMenus(java.util.Date start, java.util.Date end, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "getLastMenus");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeObject(start);
      streamWriter.writeObject(end);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getLastMenusOrHavingRequests(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "getLastMenusOrHavingRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestedDishesCount(java.lang.Long menuDetailsId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "getRequestedDishesCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(menuDetailsId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void removeMenu(java.lang.Long menuId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "removeMenu");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(menuId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveImage(java.lang.String fieldName, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "saveImage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(fieldName);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveMenu(com.epam.feel.shared.dto.MenuDTO menuDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "saveMenu");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.MenuDTO/3560685466");
      streamWriter.writeObject(menuDTO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void setStatusMenu(com.epam.feel.shared.dto.MenuDTO menuDTO, boolean isOpen, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("MenuInfoService_Proxy", "setStatusMenu");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.epam.feel.shared.dto.MenuDTO/3560685466");
      streamWriter.writeString("Z");
      streamWriter.writeObject(menuDTO);
      streamWriter.writeBoolean(isOpen);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
