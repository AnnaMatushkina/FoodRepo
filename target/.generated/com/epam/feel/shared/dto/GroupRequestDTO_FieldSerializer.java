package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GroupRequestDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.GroupRequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.GroupRequestDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.GroupRequestDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.GroupRequestDTO::createDate = value;
  }-*/;
  
  private static native java.util.List getRequests(com.epam.feel.shared.dto.GroupRequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.GroupRequestDTO::requests;
  }-*/;
  
  private static native void setRequests(com.epam.feel.shared.dto.GroupRequestDTO instance, java.util.List value) 
  /*-{
    instance.@com.epam.feel.shared.dto.GroupRequestDTO::requests = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.GroupStatus getStatus(com.epam.feel.shared.dto.GroupRequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.GroupRequestDTO::status;
  }-*/;
  
  private static native void setStatus(com.epam.feel.shared.dto.GroupRequestDTO instance, com.epam.feel.shared.enums.GroupStatus value) 
  /*-{
    instance.@com.epam.feel.shared.dto.GroupRequestDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.GroupRequestDTO instance) throws SerializationException {
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setRequests(instance, (java.util.List) streamReader.readObject());
    setStatus(instance, (com.epam.feel.shared.enums.GroupStatus) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.GroupRequestDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.GroupRequestDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.GroupRequestDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeObject(getRequests(instance));
    streamWriter.writeObject(getStatus(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.GroupRequestDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.GroupRequestDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.GroupRequestDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.GroupRequestDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.GroupRequestDTO)object);
  }
  
}
