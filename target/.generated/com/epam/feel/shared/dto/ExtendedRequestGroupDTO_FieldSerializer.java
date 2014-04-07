package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExtendedRequestGroupDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getMenuName(com.epam.feel.shared.dto.ExtendedRequestGroupDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.ExtendedRequestGroupDTO::menuName;
  }-*/;
  
  private static native void setMenuName(com.epam.feel.shared.dto.ExtendedRequestGroupDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.ExtendedRequestGroupDTO::menuName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.ExtendedRequestGroupDTO instance) throws SerializationException {
    setMenuName(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.GroupRequestDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.ExtendedRequestGroupDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.ExtendedRequestGroupDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.ExtendedRequestGroupDTO instance) throws SerializationException {
    streamWriter.writeString(getMenuName(instance));
    
    com.epam.feel.shared.dto.GroupRequestDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.ExtendedRequestGroupDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ExtendedRequestGroupDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.ExtendedRequestGroupDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ExtendedRequestGroupDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.ExtendedRequestGroupDTO)object);
  }
  
}
