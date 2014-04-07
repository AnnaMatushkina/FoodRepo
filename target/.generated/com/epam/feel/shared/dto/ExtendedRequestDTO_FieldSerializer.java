package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExtendedRequestDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getMenuName(com.epam.feel.shared.dto.ExtendedRequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.ExtendedRequestDTO::menuName;
  }-*/;
  
  private static native void setMenuName(com.epam.feel.shared.dto.ExtendedRequestDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.ExtendedRequestDTO::menuName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.ExtendedRequestDTO instance) throws SerializationException {
    setMenuName(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.RequestDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.ExtendedRequestDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.ExtendedRequestDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.ExtendedRequestDTO instance) throws SerializationException {
    streamWriter.writeString(getMenuName(instance));
    
    com.epam.feel.shared.dto.RequestDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.ExtendedRequestDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.ExtendedRequestDTO)object);
  }
  
}
