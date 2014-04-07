package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RequestDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.epam.feel.shared.dto.ClientDTO getClient(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::client;
  }-*/;
  
  private static native void setClient(com.epam.feel.shared.dto.RequestDTO instance, com.epam.feel.shared.dto.ClientDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::client = value;
  }-*/;
  
  private static native java.lang.Double getCost(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::cost;
  }-*/;
  
  private static native void setCost(com.epam.feel.shared.dto.RequestDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::cost = value;
  }-*/;
  
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.RequestDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::createDate = value;
  }-*/;
  
  private static native java.util.Date getDeliveryDate(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::deliveryDate;
  }-*/;
  
  private static native void setDeliveryDate(com.epam.feel.shared.dto.RequestDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::deliveryDate = value;
  }-*/;
  
  private static native java.util.List getRequestDetails(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::requestDetails;
  }-*/;
  
  private static native void setRequestDetails(com.epam.feel.shared.dto.RequestDTO instance, java.util.List value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::requestDetails = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.RequestStatus getStatus(com.epam.feel.shared.dto.RequestDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.RequestDTO::status;
  }-*/;
  
  private static native void setStatus(com.epam.feel.shared.dto.RequestDTO instance, com.epam.feel.shared.enums.RequestStatus value) 
  /*-{
    instance.@com.epam.feel.shared.dto.RequestDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.RequestDTO instance) throws SerializationException {
    setClient(instance, (com.epam.feel.shared.dto.ClientDTO) streamReader.readObject());
    setCost(instance, (java.lang.Double) streamReader.readObject());
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setDeliveryDate(instance, (java.util.Date) streamReader.readObject());
    setRequestDetails(instance, (java.util.List) streamReader.readObject());
    setStatus(instance, (com.epam.feel.shared.enums.RequestStatus) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.RequestDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.RequestDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.RequestDTO instance) throws SerializationException {
    streamWriter.writeObject(getClient(instance));
    streamWriter.writeObject(getCost(instance));
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeObject(getDeliveryDate(instance));
    streamWriter.writeObject(getRequestDetails(instance));
    streamWriter.writeObject(getStatus(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.RequestDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.RequestDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.RequestDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.RequestDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.RequestDTO)object);
  }
  
}
