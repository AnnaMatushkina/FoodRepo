package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Double getAdvance(com.epam.feel.shared.dto.AccountDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.AccountDTO::advance;
  }-*/;
  
  private static native void setAdvance(com.epam.feel.shared.dto.AccountDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.AccountDTO::advance = value;
  }-*/;
  
  private static native java.lang.Double getBalance(com.epam.feel.shared.dto.AccountDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.AccountDTO::balance;
  }-*/;
  
  private static native void setBalance(com.epam.feel.shared.dto.AccountDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.AccountDTO::balance = value;
  }-*/;
  
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.AccountDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.AccountDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.AccountDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.AccountDTO::createDate = value;
  }-*/;
  
  private static native java.lang.String getName(com.epam.feel.shared.dto.AccountDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.AccountDTO::name;
  }-*/;
  
  private static native void setName(com.epam.feel.shared.dto.AccountDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.AccountDTO::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.AccountDTO instance) throws SerializationException {
    setAdvance(instance, (java.lang.Double) streamReader.readObject());
    setBalance(instance, (java.lang.Double) streamReader.readObject());
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setName(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.AccountDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.AccountDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.AccountDTO instance) throws SerializationException {
    streamWriter.writeObject(getAdvance(instance));
    streamWriter.writeObject(getBalance(instance));
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeString(getName(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.AccountDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.AccountDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.AccountDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.AccountDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.AccountDTO)object);
  }
  
}
