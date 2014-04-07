package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BaseDTO_FieldSerializer {
  private static native java.lang.Long getId(com.epam.feel.shared.dto.BaseDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.BaseDTO::id;
  }-*/;
  
  private static native void setId(com.epam.feel.shared.dto.BaseDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.epam.feel.shared.dto.BaseDTO::id = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.BaseDTO instance) throws SerializationException {
    setId(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.BaseDTO instance) throws SerializationException {
    streamWriter.writeObject(getId(instance));
    
  }
  
}
