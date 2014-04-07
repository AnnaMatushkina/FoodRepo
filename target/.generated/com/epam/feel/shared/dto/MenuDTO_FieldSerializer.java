package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MenuDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getCreateDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::createDate;
  }-*/;
  
  private static native void setCreateDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::createDate = value;
  }-*/;
  
  private static native java.util.Date getDeliveryEndDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::deliveryEndDate;
  }-*/;
  
  private static native void setDeliveryEndDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::deliveryEndDate = value;
  }-*/;
  
  private static native java.util.Date getDeliveryStartDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::deliveryStartDate;
  }-*/;
  
  private static native void setDeliveryStartDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::deliveryStartDate = value;
  }-*/;
  
  private static native java.util.List getMenuDetails(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::menuDetails;
  }-*/;
  
  private static native void setMenuDetails(com.epam.feel.shared.dto.MenuDTO instance, java.util.List value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::menuDetails = value;
  }-*/;
  
  private static native java.lang.String getMenuName(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::menuName;
  }-*/;
  
  private static native void setMenuName(com.epam.feel.shared.dto.MenuDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::menuName = value;
  }-*/;
  
  private static native java.util.Date getMenuOnDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::menuOnDate;
  }-*/;
  
  private static native void setMenuOnDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::menuOnDate = value;
  }-*/;
  
  private static native java.util.Date getReceiptEndDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::receiptEndDate;
  }-*/;
  
  private static native void setReceiptEndDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::receiptEndDate = value;
  }-*/;
  
  private static native java.util.Date getReceiptStartDate(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::receiptStartDate;
  }-*/;
  
  private static native void setReceiptStartDate(com.epam.feel.shared.dto.MenuDTO instance, java.util.Date value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::receiptStartDate = value;
  }-*/;
  
  private static native com.epam.feel.shared.enums.MenuStatus getStatus(com.epam.feel.shared.dto.MenuDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDTO::status;
  }-*/;
  
  private static native void setStatus(com.epam.feel.shared.dto.MenuDTO instance, com.epam.feel.shared.enums.MenuStatus value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDTO::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.MenuDTO instance) throws SerializationException {
    setCreateDate(instance, (java.util.Date) streamReader.readObject());
    setDeliveryEndDate(instance, (java.util.Date) streamReader.readObject());
    setDeliveryStartDate(instance, (java.util.Date) streamReader.readObject());
    setMenuDetails(instance, (java.util.List) streamReader.readObject());
    setMenuName(instance, streamReader.readString());
    setMenuOnDate(instance, (java.util.Date) streamReader.readObject());
    setReceiptEndDate(instance, (java.util.Date) streamReader.readObject());
    setReceiptStartDate(instance, (java.util.Date) streamReader.readObject());
    setStatus(instance, (com.epam.feel.shared.enums.MenuStatus) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.MenuDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.MenuDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.MenuDTO instance) throws SerializationException {
    streamWriter.writeObject(getCreateDate(instance));
    streamWriter.writeObject(getDeliveryEndDate(instance));
    streamWriter.writeObject(getDeliveryStartDate(instance));
    streamWriter.writeObject(getMenuDetails(instance));
    streamWriter.writeString(getMenuName(instance));
    streamWriter.writeObject(getMenuOnDate(instance));
    streamWriter.writeObject(getReceiptEndDate(instance));
    streamWriter.writeObject(getReceiptStartDate(instance));
    streamWriter.writeObject(getStatus(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.MenuDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.MenuDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.MenuDTO)object);
  }
  
}
