package com.epam.feel.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RequestHasGroupException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.exception.RequestHasGroupException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.exception.RequestHasGroupException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.exception.RequestHasGroupException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.exception.RequestHasGroupException instance) throws SerializationException {
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.exception.RequestHasGroupException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.exception.RequestHasGroupException_FieldSerializer.deserialize(reader, (com.epam.feel.shared.exception.RequestHasGroupException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.exception.RequestHasGroupException_FieldSerializer.serialize(writer, (com.epam.feel.shared.exception.RequestHasGroupException)object);
  }
  
}
