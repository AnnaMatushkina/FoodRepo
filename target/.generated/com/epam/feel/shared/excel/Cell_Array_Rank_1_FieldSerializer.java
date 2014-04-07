package com.epam.feel.shared.excel;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Cell_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.excel.Cell[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.excel.Cell[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.epam.feel.shared.excel.Cell[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.excel.Cell[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.excel.Cell_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.excel.Cell_Array_Rank_1_FieldSerializer.deserialize(reader, (com.epam.feel.shared.excel.Cell[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.excel.Cell_Array_Rank_1_FieldSerializer.serialize(writer, (com.epam.feel.shared.excel.Cell[])object);
  }
  
}
