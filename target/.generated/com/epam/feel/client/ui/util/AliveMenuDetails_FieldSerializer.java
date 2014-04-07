package com.epam.feel.client.ui.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AliveMenuDetails_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getList(com.epam.feel.client.ui.util.AliveMenuDetails instance) /*-{
    return instance.@com.epam.feel.client.ui.util.AliveMenuDetails::list;
  }-*/;
  
  private static native void setList(com.epam.feel.client.ui.util.AliveMenuDetails instance, java.util.List value) 
  /*-{
    instance.@com.epam.feel.client.ui.util.AliveMenuDetails::list = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.client.ui.util.AliveMenuDetails instance) throws SerializationException {
    setList(instance, (java.util.List) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.client.ui.util.AliveMenuDetails instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.client.ui.util.AliveMenuDetails();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.client.ui.util.AliveMenuDetails instance) throws SerializationException {
    streamWriter.writeObject(getList(instance));
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer.deserialize(reader, (com.epam.feel.client.ui.util.AliveMenuDetails)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer.serialize(writer, (com.epam.feel.client.ui.util.AliveMenuDetails)object);
  }
  
}
