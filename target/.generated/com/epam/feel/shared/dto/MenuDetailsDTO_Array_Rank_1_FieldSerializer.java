package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MenuDetailsDTO_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.MenuDetailsDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.MenuDetailsDTO[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.epam.feel.shared.dto.MenuDetailsDTO[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.MenuDetailsDTO[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.MenuDetailsDTO[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.MenuDetailsDTO[])object);
  }
  
}
