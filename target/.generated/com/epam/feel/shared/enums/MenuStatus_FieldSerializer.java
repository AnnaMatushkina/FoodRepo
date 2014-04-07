package com.epam.feel.shared.enums;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MenuStatus_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.enums.MenuStatus instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.epam.feel.shared.enums.MenuStatus instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.epam.feel.shared.enums.MenuStatus[] values = com.epam.feel.shared.enums.MenuStatus.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.enums.MenuStatus instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.enums.MenuStatus_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.enums.MenuStatus_FieldSerializer.deserialize(reader, (com.epam.feel.shared.enums.MenuStatus)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.enums.MenuStatus_FieldSerializer.serialize(writer, (com.epam.feel.shared.enums.MenuStatus)object);
  }
  
}
