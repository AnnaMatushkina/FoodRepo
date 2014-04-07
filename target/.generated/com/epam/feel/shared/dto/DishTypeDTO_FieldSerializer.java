package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DishTypeDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getText(com.epam.feel.shared.dto.DishTypeDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.DishTypeDTO::text;
  }-*/;
  
  private static native void setText(com.epam.feel.shared.dto.DishTypeDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.DishTypeDTO::text = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.DishTypeDTO instance) throws SerializationException {
    setText(instance, streamReader.readString());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.DishTypeDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.DishTypeDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.DishTypeDTO instance) throws SerializationException {
    streamWriter.writeString(getText(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.DishTypeDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.DishTypeDTO)object);
  }
  
}
