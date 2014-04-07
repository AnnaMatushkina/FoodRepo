package com.epam.feel.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MenuDetailsDTO_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Boolean getAlive(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::alive;
  }-*/;
  
  private static native void setAlive(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::alive = value;
  }-*/;
  
  private static native java.lang.String getDishName(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::dishName;
  }-*/;
  
  private static native void setDishName(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::dishName = value;
  }-*/;
  
  private static native com.epam.feel.shared.dto.DishTypeDTO getDishType(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::dishType;
  }-*/;
  
  private static native void setDishType(com.epam.feel.shared.dto.MenuDetailsDTO instance, com.epam.feel.shared.dto.DishTypeDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::dishType = value;
  }-*/;
  
  private static native java.lang.Long getImageId(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::imageId;
  }-*/;
  
  private static native void setImageId(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Long value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::imageId = value;
  }-*/;
  
  private static native java.lang.Boolean getIsChiefChoice(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::isChiefChoice;
  }-*/;
  
  private static native void setIsChiefChoice(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Boolean value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::isChiefChoice = value;
  }-*/;
  
  private static native java.lang.Integer getMaxCount(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::maxCount;
  }-*/;
  
  private static native void setMaxCount(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Integer value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::maxCount = value;
  }-*/;
  
  private static native com.epam.feel.shared.dto.MenuDTO getMenu(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::menu;
  }-*/;
  
  private static native void setMenu(com.epam.feel.shared.dto.MenuDetailsDTO instance, com.epam.feel.shared.dto.MenuDTO value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::menu = value;
  }-*/;
  
  private static native java.lang.Double getPrice(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::price;
  }-*/;
  
  private static native void setPrice(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Double value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::price = value;
  }-*/;
  
  private static native java.lang.String getStructure(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::structure;
  }-*/;
  
  private static native void setStructure(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::structure = value;
  }-*/;
  
  private static native java.lang.String getUrl(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::url;
  }-*/;
  
  private static native void setUrl(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.String value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::url = value;
  }-*/;
  
  private static native java.lang.Integer getWeight(com.epam.feel.shared.dto.MenuDetailsDTO instance) /*-{
    return instance.@com.epam.feel.shared.dto.MenuDetailsDTO::weight;
  }-*/;
  
  private static native void setWeight(com.epam.feel.shared.dto.MenuDetailsDTO instance, java.lang.Integer value) 
  /*-{
    instance.@com.epam.feel.shared.dto.MenuDetailsDTO::weight = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.epam.feel.shared.dto.MenuDetailsDTO instance) throws SerializationException {
    setAlive(instance, (java.lang.Boolean) streamReader.readObject());
    setDishName(instance, streamReader.readString());
    setDishType(instance, (com.epam.feel.shared.dto.DishTypeDTO) streamReader.readObject());
    setImageId(instance, (java.lang.Long) streamReader.readObject());
    setIsChiefChoice(instance, (java.lang.Boolean) streamReader.readObject());
    setMaxCount(instance, (java.lang.Integer) streamReader.readObject());
    setMenu(instance, (com.epam.feel.shared.dto.MenuDTO) streamReader.readObject());
    setPrice(instance, (java.lang.Double) streamReader.readObject());
    setStructure(instance, streamReader.readString());
    setUrl(instance, streamReader.readString());
    setWeight(instance, (java.lang.Integer) streamReader.readObject());
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.epam.feel.shared.dto.MenuDetailsDTO instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.epam.feel.shared.dto.MenuDetailsDTO();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.epam.feel.shared.dto.MenuDetailsDTO instance) throws SerializationException {
    streamWriter.writeObject(getAlive(instance));
    streamWriter.writeString(getDishName(instance));
    streamWriter.writeObject(getDishType(instance));
    streamWriter.writeObject(getImageId(instance));
    streamWriter.writeObject(getIsChiefChoice(instance));
    streamWriter.writeObject(getMaxCount(instance));
    streamWriter.writeObject(getMenu(instance));
    streamWriter.writeObject(getPrice(instance));
    streamWriter.writeString(getStructure(instance));
    streamWriter.writeString(getUrl(instance));
    streamWriter.writeObject(getWeight(instance));
    
    com.epam.feel.shared.dto.BaseDTO_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer.deserialize(reader, (com.epam.feel.shared.dto.MenuDetailsDTO)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer.serialize(writer, (com.epam.feel.shared.dto.MenuDetailsDTO)object);
  }
  
}
