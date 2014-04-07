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

public class HistoryInfoService_Proxy extends RemoteServiceProxy implements com.epam.feel.shared.service.HistoryInfoServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.epam.feel.shared.service.HistoryInfoService";
  private static final String SERIALIZATION_POLICY ="C994BE10E7B9E19FAD722F0AD4348975";
  private static final com.epam.feel.shared.service.HistoryInfoService_TypeSerializer SERIALIZER = new com.epam.feel.shared.service.HistoryInfoService_TypeSerializer();
  
  public HistoryInfoService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "springGwtServices/historyinfoservice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getAllNotifications(int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getAllNotifications");
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
  
  public void getAllNotificationsCount(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getAllNotificationsCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getAllTransactions(int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getAllTransactions");
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
  
  public void getAllTransactionsCount(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getAllTransactionsCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getOperationsByType(com.epam.feel.shared.enums.OperationType type, int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getOperationsByType");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 4);
      streamWriter.writeString("com.epam.feel.shared.enums.OperationType/2297181793");
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeObject(type);
      streamWriter.writeInt(startRow);
      streamWriter.writeInt(maxRows);
      streamWriter.writeObject(orderList);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getOperationsByTypeCount(com.epam.feel.shared.enums.OperationType type, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getOperationsByTypeCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.enums.OperationType/2297181793");
      streamWriter.writeObject(type);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getTransactionsOfCurrentClient(int startRow, int maxRows, java.util.Map orderList, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getTransactionsOfCurrentClient");
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
  
  public void getTransactionsOfCurrentClientCount(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "getTransactionsOfCurrentClientCount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveNotification(com.epam.feel.shared.dto.NotificationDTO notificaction, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "saveNotification");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.NotificationDTO/168820866");
      streamWriter.writeObject(notificaction);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveOperation(com.epam.feel.shared.dto.OperationDTO operation, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "saveOperation");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.OperationDTO/620779239");
      streamWriter.writeObject(operation);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void saveTransaction(com.epam.feel.shared.dto.TransactionDTO transaction, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("HistoryInfoService_Proxy", "saveTransaction");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.epam.feel.shared.dto.TransactionDTO/4098235000");
      streamWriter.writeObject(transaction);
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
