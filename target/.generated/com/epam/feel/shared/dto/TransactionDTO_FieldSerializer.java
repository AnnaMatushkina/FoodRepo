package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TransactionDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.epam.feel.shared.dto.AccountDTO getAccount(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::account;
  }-*/;
  
  private static native void setAccount(com.epam.feel.shared.dto.TransactionDTO instance, com.epam.feel.shared.dto.AccountDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::account = value;
  }-*/;
  
  private static native java.lang.Double getAmount(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::amount;
  }-*/;
  
  private static native void setAmount(com.epam.feel.shared.dto.TransactionDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::amount = value;
  }-*/;
  
  private static native java.lang.Double getBalance(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::balance;
  }-*/;
  
  private static native void setBalance(com.epam.feel.shared.dto.TransactionDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::balance = value;
  }-*/;
  
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.TransactionDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::createDate = value;
  }-*/;
  
  private static native java.lang.String getOperatorName(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::operatorName;
  }-*/;
  
  private static native void setOperatorName(com.epam.feel.shared.dto.TransactionDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::operatorName = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.TransactionType getType(com.epam.feel.shared.dto.TransactionDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.TransactionDTO::type;
  }-*/;
  
  private static native void setType(com.epam.feel.shared.dto.TransactionDTO instance, com.epam.feel.shared.enums.TransactionType value) 
  /*-{
    instance.@com.epam.feel.shared.dto.TransactionDTO::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.TransactionDTO instance) throws SerializationException {
    setAccount(instance, (com.epam.feel.shared.dto.AccountDTO) streamReader.readObject());
    setAmount(instance, (java.lang.Double) streamReader.readObject());
    setBalance(instance, (java.lang.Double) streamReader.readObject());
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setOperatorName(instance, streamReader.readString());
    setType(instance, (com.epam.feel.shared.enums.TransactionType) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.TransactionDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.TransactionDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.TransactionDTO instance) throws SerializationException {
    streamWriter.writeObject(getAccount(instance));
    streamWriter.writeObject(getAmount(instance));
    streamWriter.writeObject(getBalance(instance));
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeString(getOperatorName(instance));
    streamWriter.writeObject(getType(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.TransactionDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.TransactionDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.TransactionDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.TransactionDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.TransactionDTO)object);
  }
  
}
