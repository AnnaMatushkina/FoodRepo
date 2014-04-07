package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class OperationDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.OperationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.OperationDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.OperationDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.OperationDTO::createDate = value;
  }-*/;
  
  private static native java.lang.String getText(com.epam.feel.shared.dto.OperationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.OperationDTO::text;
  }-*/;
  
  private static native void setText(com.epam.feel.shared.dto.OperationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.OperationDTO::text = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.OperationType getType(com.epam.feel.shared.dto.OperationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.OperationDTO::type;
  }-*/;
  
  private static native void setType(com.epam.feel.shared.dto.OperationDTO instance, com.epam.feel.shared.enums.OperationType value) 
  /*-{
    instance.@com.epam.feel.shared.dto.OperationDTO::type = value;
  }-*/;
  
  private static native java.lang.String getUserName(com.epam.feel.shared.dto.OperationDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.OperationDTO::userName;
  }-*/;
  
  private static native void setUserName(com.epam.feel.shared.dto.OperationDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.OperationDTO::userName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.OperationDTO instance) throws SerializationException {
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setText(instance, streamReader.readString());
    setType(instance, (com.epam.feel.shared.enums.OperationType) streamReader.readObject());
    setUserName(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.OperationDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.OperationDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.OperationDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeString(getText(instance));
    streamWriter.writeObject(getType(instance));
    streamWriter.writeString(getUserName(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.OperationDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.OperationDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.OperationDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.OperationDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.OperationDTO)object);
  }
  
}
