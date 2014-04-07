package com.epam.feel.client;

public class IEpamFeelStatusConstants_ implements com.epam.feel.client.IEpamFeelStatusConstants {
  
  public java.lang.String REQUEST_GROUP_CHANGED() {
    return "Изменение группы заказов";
  }
  
  public int getInt(java.lang.String arg0) {
    Integer target = (Integer) cache.get(arg0);
    if (target != null) {
      return target.intValue();
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.lang.String ACCEPTED() {
    return "Принято";
  }
  
  public java.lang.String CLIENT() {
    return "Пользователь";
  }
  
  public java.lang.String DRAFT() {
    return "Черновик";
  }
  
  public java.lang.String DELETED() {
    return "Удалено";
  }
  
  public boolean getBoolean(java.lang.String arg0) {
    Boolean target = (Boolean) cache.get(arg0);
    if (target != null) {
      return target.booleanValue();
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.lang.String BLOCKED() {
    return "Заблокировано";
  }
  
  public java.lang.String ADMIN() {
    return "Администратор";
  }
  
  public java.lang.String REQUEST_CHANGED() {
    return "Изменение заказа";
  }
  
  public java.lang.String DELIVERY() {
    return "Доставляется";
  }
  
  public java.lang.String PAID() {
    return "Оплачено";
  }
  
  public java.lang.String CANCEL() {
    return "Отменено";
  }
  
  public float getFloat(java.lang.String arg0) {
    Float target = (Float) cache.get(arg0);
    if (target != null) {
      return target.floatValue();
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.lang.String DECLINED() {
    return "Отклонено";
  }
  
  public java.lang.String AVAILABLE() {
    return "Доступно";
  }
  
  public java.lang.String IN_PROCESS() {
    return "В обработке";
  }
  
  public java.lang.String MENU_CHANGED() {
    return "Изменение меню";
  }
  
  public java.lang.String PERFORMED() {
    return "Выполнено";
  }
  
  public double getDouble(java.lang.String arg0) {
    Double target = (Double) cache.get(arg0);
    if (target != null) {
      return target.doubleValue();
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.lang.String getString(java.lang.String arg0) {
    java.lang.String target = (java.lang.String) cache.get(arg0);
    if (target != null) {
      return target;
    }
    if(arg0.equals("REQUEST_GROUP_CHANGED")) {
      String answer = REQUEST_GROUP_CHANGED();
      cache.put("REQUEST_GROUP_CHANGED",answer);
      return answer;
    }
    if(arg0.equals("ACCEPTED")) {
      String answer = ACCEPTED();
      cache.put("ACCEPTED",answer);
      return answer;
    }
    if(arg0.equals("CLIENT")) {
      String answer = CLIENT();
      cache.put("CLIENT",answer);
      return answer;
    }
    if(arg0.equals("DRAFT")) {
      String answer = DRAFT();
      cache.put("DRAFT",answer);
      return answer;
    }
    if(arg0.equals("DELETED")) {
      String answer = DELETED();
      cache.put("DELETED",answer);
      return answer;
    }
    if(arg0.equals("BLOCKED")) {
      String answer = BLOCKED();
      cache.put("BLOCKED",answer);
      return answer;
    }
    if(arg0.equals("ADMIN")) {
      String answer = ADMIN();
      cache.put("ADMIN",answer);
      return answer;
    }
    if(arg0.equals("REQUEST_CHANGED")) {
      String answer = REQUEST_CHANGED();
      cache.put("REQUEST_CHANGED",answer);
      return answer;
    }
    if(arg0.equals("DELIVERY")) {
      String answer = DELIVERY();
      cache.put("DELIVERY",answer);
      return answer;
    }
    if(arg0.equals("PAID")) {
      String answer = PAID();
      cache.put("PAID",answer);
      return answer;
    }
    if(arg0.equals("CANCEL")) {
      String answer = CANCEL();
      cache.put("CANCEL",answer);
      return answer;
    }
    if(arg0.equals("DECLINED")) {
      String answer = DECLINED();
      cache.put("DECLINED",answer);
      return answer;
    }
    if(arg0.equals("AVAILABLE")) {
      String answer = AVAILABLE();
      cache.put("AVAILABLE",answer);
      return answer;
    }
    if(arg0.equals("IN_PROCESS")) {
      String answer = IN_PROCESS();
      cache.put("IN_PROCESS",answer);
      return answer;
    }
    if(arg0.equals("MENU_CHANGED")) {
      String answer = MENU_CHANGED();
      cache.put("MENU_CHANGED",answer);
      return answer;
    }
    if(arg0.equals("PERFORMED")) {
      String answer = PERFORMED();
      cache.put("PERFORMED",answer);
      return answer;
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.util.Map<java.lang.String, java.lang.String> getMap(java.lang.String arg0) {
    java.util.Map<java.lang.String, java.lang.String> target = (java.util.Map<java.lang.String, java.lang.String>) cache.get(arg0);
    if (target != null) {
      return target;
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  
  public java.lang.String[] getStringArray(java.lang.String arg0) {
    java.lang.String[] target = (java.lang.String[]) cache.get(arg0);
    if (target != null) {
      return target;
    }
    throw new java.util.MissingResourceException("Cannot find constant '" +arg0 + "'; expecting a method name", "com.epam.feel.client.IEpamFeelStatusConstants", arg0);
  }
  java.util.Map cache = new java.util.HashMap();
}
