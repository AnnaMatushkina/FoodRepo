package com.epam.feel.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RequestCantBeSavedException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.epam.feel.shared.exception.RequestCantBeSavedException.Type getType(com.epam.feel.shared.exception.RequestCantBeSavedException instance) /*-{
    return instance.@com.epam.feel.shared.exception.RequestCantBeSavedException::type;
  }-*/;
  
  private static native void setType(com.epam.feel.shared.exception.RequestCantBeSavedException instance, com.epam.feel.shared.exception.RequestCantBeSavedException.Type value) 
  /*-{
    instance.@com.epam.feel.shared.exception.RequestCantBeSavedException::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.exception.RequestCantBeSavedException instance) throws SerializationException {
    setType(instance, (com.epam.feel.shared.exception.RequestCantBeSavedException.Type) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.exception.RequestCantBeSavedException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.exception.RequestCantBeSavedException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.exception.RequestCantBeSavedException instance) throws SerializationException {
    streamWriter.writeObject(getType(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.Exception_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.exception.RequestCantBeSavedException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.exception.RequestCantBeSavedException_FieldSerializer.deserialize(reader, (com.epam.feel.shared.exception.RequestCantBeSavedException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.exception.RequestCantBeSavedException_FieldSerializer.serialize(writer, (com.epam.feel.shared.exception.RequestCantBeSavedException)object);
  }
  
}
