package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClientDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native boolean getAdvised(com.epam.feel.shared.dto.ClientDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.ClientDTO::advised;
  }-*/;
  
  private static native void setAdvised(com.epam.feel.shared.dto.ClientDTO instance, boolean value) 
  /*-{
    instance.@com.epam.feel.shared.dto.ClientDTO::advised = value;
  }-*/;
  
  private static native java.lang.String getEmail(com.epam.feel.shared.dto.ClientDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.ClientDTO::email;
  }-*/;
  
  private static native void setEmail(com.epam.feel.shared.dto.ClientDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.ClientDTO::email = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.Role getRole(com.epam.feel.shared.dto.ClientDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.ClientDTO::role;
  }-*/;
  
  private static native void setRole(com.epam.feel.shared.dto.ClientDTO instance, com.epam.feel.shared.enums.Role value) 
  /*-{
    instance.@com.epam.feel.shared.dto.ClientDTO::role = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.ClientDTO instance) throws SerializationException {
    setAdvised(instance, streamReader.readBoolean());
    setEmail(instance, streamReader.readString());
    setRole(instance, (com.epam.feel.shared.enums.Role) streamReader.readObject());
    
    com.epam.feel.shared.dto.AccountDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.ClientDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.ClientDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.ClientDTO instance) throws SerializationException {
    streamWriter.writeBoolean(getAdvised(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeObject(getRole(instance));
    
    com.epam.feel.shared.dto.AccountDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.ClientDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ClientDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.ClientDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.ClientDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.ClientDTO)object);
  }
  
}
