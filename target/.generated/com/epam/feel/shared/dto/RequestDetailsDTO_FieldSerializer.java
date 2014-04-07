package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RequestDetailsDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getCount(com.epam.feel.shared.dto.RequestDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDetailsDTO::count;
  }-*/;
  
  private static native void setCount(com.epam.feel.shared.dto.RequestDetailsDTO instance, int value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDetailsDTO::count = value;
  }-*/;
  
  private static native com.epam.feel.shared.dto.MenuDetailsDTO getMenuDetails(com.epam.feel.shared.dto.RequestDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDetailsDTO::menuDetails;
  }-*/;
  
  private static native void setMenuDetails(com.epam.feel.shared.dto.RequestDetailsDTO instance, com.epam.feel.shared.dto.MenuDetailsDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDetailsDTO::menuDetails = value;
  }-*/;
  
  private static native com.epam.feel.shared.dto.RequestDTO getRequest(com.epam.feel.shared.dto.RequestDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDetailsDTO::request;
  }-*/;
  
  private static native void setRequest(com.epam.feel.shared.dto.RequestDetailsDTO instance, com.epam.feel.shared.dto.RequestDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDetailsDTO::request = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.RequestDetailsDTO instance) throws SerializationException {
    setCount(instance, streamReader.readInt());
    setMenuDetails(instance, (com.epam.feel.shared.dto.MenuDetailsDTO) streamReader.readObject());
    setRequest(instance, (com.epam.feel.shared.dto.RequestDTO) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.RequestDetailsDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.RequestDetailsDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.RequestDetailsDTO instance) throws SerializationException {
    streamWriter.writeInt(getCount(instance));
    streamWriter.writeObject(getMenuDetails(instance));
    streamWriter.writeObject(getRequest(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.RequestDetailsDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.RequestDetailsDTO)object);
  }
  
}
