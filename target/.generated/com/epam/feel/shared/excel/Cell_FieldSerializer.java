package com.epam.feel.shared.excel;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Cell_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getColumn(com.epam.feel.shared.excel.Cell instance) /*-{
    return instance.@com.epam.feel.shared.excel.Cell::column;
  }-*/;
  
  private static native void setColumn(com.epam.feel.shared.excel.Cell instance, int value) 
  /*-{
    instance.@com.epam.feel.shared.excel.Cell::column = value;
  }-*/;
  
  private static native int getRow(com.epam.feel.shared.excel.Cell instance) /*-{
    return instance.@com.epam.feel.shared.excel.Cell::row;
  }-*/;
  
  private static native void setRow(com.epam.feel.shared.excel.Cell instance, int value) 
  /*-{
    instance.@com.epam.feel.shared.excel.Cell::row = value;
  }-*/;
  
  private static native java.lang.String getValue(com.epam.feel.shared.excel.Cell instance) /*-{
    return instance.@com.epam.feel.shared.excel.Cell::value;
  }-*/;
  
  private static native void setValue(com.epam.feel.shared.excel.Cell instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.excel.Cell::value = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.excel.Cell instance) throws SerializationException {
    setColumn(instance, streamReader.readInt());
    setRow(instance, streamReader.readInt());
    setValue(instance, streamReader.readString());
    
  }
  
  public static com.epam.feel.shared.excel.Cell instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.excel.Cell();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.excel.Cell instance) throws SerializationException {
    streamWriter.writeInt(getColumn(instance));
    streamWriter.writeInt(getRow(instance));
    streamWriter.writeString(getValue(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.excel.Cell_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.excel.Cell_FieldSerializer.deserialize(reader, (com.epam.feel.shared.excel.Cell)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.excel.Cell_FieldSerializer.serialize(writer, (com.epam.feel.shared.excel.Cell)object);
  }
  
}
