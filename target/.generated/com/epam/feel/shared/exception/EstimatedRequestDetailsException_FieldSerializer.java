package com.epam.feel.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EstimatedRequestDetailsException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Integer getAvailableCount(com.epam.feel.shared.exception.EstimatedRequestDetailsException instance) /*-{
    return instance.@com.epam.feel.shared.exception.EstimatedRequestDetailsException::availableCount;
  }-*/;
  
  private static native void setAvailableCount(com.epam.feel.shared.exception.EstimatedRequestDetailsException instance, java.lang.Integer value) 
  /*-{
    instance.@com.epam.feel.shared.exception.EstimatedRequestDetailsException::availableCount = value;
  }-*/;
  
  private static native com.epam.feel.shared.dto.MenuDetailsDTO getDetails(com.epam.feel.shared.exception.EstimatedRequestDetailsException instance) /*-{
    return instance.@com.epam.feel.shared.exception.EstimatedRequestDetailsException::details;
  }-*/;
  
  private static native void setDetails(com.epam.feel.shared.exception.EstimatedRequestDetailsException instance, com.epam.feel.shared.dto.MenuDetailsDTO value) 
  /*-{
    instance.@com.epam.feel.shared.exception.EstimatedRequestDetailsException::details = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.exception.EstimatedRequestDetailsException instance) throws SerializationException {
    setAvailableCount(instance, (java.lang.Integer) streamReader.readObject());
    setDetails(instance, (com.epam.feel.shared.dto.MenuDetailsDTO) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.exception.EstimatedRequestDetailsException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.exception.EstimatedRequestDetailsException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.exception.EstimatedRequestDetailsException instance) throws SerializationException {
    streamWriter.writeObject(getAvailableCount(instance));
    streamWriter.writeObject(getDetails(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.exception.EstimatedRequestDetailsException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.exception.EstimatedRequestDetailsException_FieldSerializer.deserialize(reader, (com.epam.feel.shared.exception.EstimatedRequestDetailsException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.exception.EstimatedRequestDetailsException_FieldSerializer.serialize(writer, (com.epam.feel.shared.exception.EstimatedRequestDetailsException)object);
  }
  
}
