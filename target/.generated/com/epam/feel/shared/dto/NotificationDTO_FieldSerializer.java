package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NotificationDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.NotificationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.NotificationDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.NotificationDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.NotificationDTO::createDate = value;
  }-*/;
  
  private static native java.lang.String getEmail(com.epam.feel.shared.dto.NotificationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.NotificationDTO::email;
  }-*/;
  
  private static native void setEmail(com.epam.feel.shared.dto.NotificationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.NotificationDTO::email = value;
  }-*/;
  
  private static native java.lang.String getSender(com.epam.feel.shared.dto.NotificationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.NotificationDTO::sender;
  }-*/;
  
  private static native void setSender(com.epam.feel.shared.dto.NotificationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.NotificationDTO::sender = value;
  }-*/;
  
  private static native java.lang.String getText(com.epam.feel.shared.dto.NotificationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.NotificationDTO::text;
  }-*/;
  
  private static native void setText(com.epam.feel.shared.dto.NotificationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.NotificationDTO::text = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.NotificationDTO instance) throws SerializationException {
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setEmail(instance, streamReader.readString());
    setSender(instance, streamReader.readString());
    setText(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.NotificationDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.NotificationDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.NotificationDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getSender(instance));
    streamWriter.writeString(getText(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.NotificationDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.NotificationDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.NotificationDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.NotificationDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.NotificationDTO)object);
  }
  
}
