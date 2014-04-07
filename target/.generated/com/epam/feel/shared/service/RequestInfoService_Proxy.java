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

public class RequestInfoService_Proxy extends RemoteServiceProxy implements com.epam.feel.shared.service.RequestInfoServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.epam.feel.shared.service.RequestInfoService";
  private static final String SERIALIZATION_POLICY ="E2F11A9BD732EB04C545094C420D921F";
  private static final com.epam.feel.shared.service.RequestInfoService_TypeSerializer SERIALIZER = new com.epam.feel.shared.service.RequestInfoService_TypeSerializer();
  
  public RequestInfoService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "springGwtServices/requestinfoservice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void acceptGroupRequests(java.lang.Long groupId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "acceptGroupRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(groupId);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void acceptRequest(java.lang.Long requestId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "acceptRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(requestId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void completeGroupRequests(java.lang.Long groupId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "completeGroupRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(groupId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void completeRequest(java.lang.Long requestId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "completeRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(requestId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteGroupRequests(java.lang.Long groupId, java.lang.String reason, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "deleteGroupRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(groupId);
      streamWriter.writeString(reason);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void deleteRequest(java.lang.Long id, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "deleteRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(id);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void editRequest(com.epam.feel.shared.dto.RequestDTO requestDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "editRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.RequestDTO/3610644213");
      streamWriter.writeObject(requestDTO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void editRequest(com.epam.feel.shared.dto.RequestDTO request, java.lang.String reason, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "editRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.epam.feel.shared.dto.RequestDTO/3610644213");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(request);
      streamWriter.writeString(reason);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void exportGroupToExcel(java.util.List cells, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "exportGroupToExcel");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.List");
      streamWriter.writeObject(cells);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActiveRequests(java.lang.Long clientId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getActiveRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(clientId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActiveRequestsByMenu(int startRow, int maxRows, java.lang.Long menuId, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getActiveRequestsByMenu");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 4);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(maxRows);
      streamWriter.writeObject(menuId);
      streamWriter.writeObject(orderList);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActiveRequestsByMenuCount(java.lang.Long menuId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getActiveRequestsByMenuCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(menuId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllGroupRequests(int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getAllGroupRequests");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(maxRows);
      streamWriter.writeObject(orderList);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllGroupRequestsCount(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getAllGroupRequestsCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestsByDishName(int startRow, int maxRows, java.lang.String dishName, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getRequestsByDishName");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 4);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(maxRows);
      streamWriter.writeString(dishName);
      streamWriter.writeObject(orderList);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestsByDishNameCount(java.lang.String dishName, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getRequestsByDishNameCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(dishName);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestsForUser(com.epam.feel.shared.dto.MenuDTO menuDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getRequestsForUser");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.MenuDTO/3560685466");
      streamWriter.writeObject(menuDTO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestsForUserDate(java.util.Date dateStart, java.util.Date dateEnd, int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getRequestsForUserDate");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 5);
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeObject(dateStart);
      streamWriter.writeObject(dateEnd);
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(maxRows);
      streamWriter.writeObject(orderList);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getRequestsForUserDateCount(java.util.Date dateStart, java.util.Date dateEnd, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getRequestsForUserDateCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeString("java.util.Date/3385151746");
      streamWriter.writeObject(dateStart);
      streamWriter.writeObject(dateEnd);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getStatusOfGroup(java.lang.Long requestId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "getStatusOfGroup");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(requestId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void makeRequest(com.epam.feel.shared.dto.RequestDTO requestDTO, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "makeRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.RequestDTO/3610644213");
      streamWriter.writeObject(requestDTO);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void makeRequestGroupByMenu(java.lang.Long menuId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "makeRequestGroupByMenu");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(menuId);
      helper.finish(callback, ResponseReader.BOOLEAN);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void payRequest(java.lang.Long requestId, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "payRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeObject(requestId);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void tryToDeclineRequest(java.lang.Long id, boolean force, java.lang.String reason, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "tryToDeclineRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeString("Z");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(id);
      streamWriter.writeBoolean(force);
      streamWriter.writeString(reason);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void tryToDeleteRequest(java.lang.Long id, boolean force, java.lang.String reason, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("RequestInfoService_Proxy", "tryToDeleteRequest");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("java.lang.Long/4227064769");
      streamWriter.writeString("Z");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeObject(id);
      streamWriter.writeBoolean(force);
      streamWriter.writeString(reason);
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
