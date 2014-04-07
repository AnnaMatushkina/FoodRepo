package com.epam.feel.server;

/**
 * Interface to represent the constants contained in resource bundle:
 * 	'D:/CI/Eda/source/src/main/resources/com/epam/feel/server/EpamFeelConstants.properties'.
 */
public interface EpamFeelConstants extends com.google.gwt.i18n.client.Constants {
  
  /**
   * Translated "Изменение заказа".
   * 
   * @return translated "Изменение заказа"
   */
  @DefaultStringValue("Изменение заказа")
  @Key("orderChangedEmailSubject")
  String orderChangedEmailSubject();

  /**
   * Translated "Отмена заказа".
   * 
   * @return translated "Отмена заказа"
   */
  @DefaultStringValue("Отмена заказа")
  @Key("orderDeclinedEmailSubject")
  String orderDeclinedEmailSubject();

  /**
   * Translated "Удаление заказа".
   * 
   * @return translated "Удаление заказа"
   */
  @DefaultStringValue("Удаление заказа")
  @Key("orderDeletedEmailSubject")
  String orderDeletedEmailSubject();

  /**
   * Translated "Доставка заказа".
   * 
   * @return translated "Доставка заказа"
   */
  @DefaultStringValue("Доставка заказа")
  @Key("orderDeliveredEmailSubject")
  String orderDeliveredEmailSubject();

  /**
   * Translated "Удаление группы заказов".
   * 
   * @return translated "Удаление группы заказов"
   */
  @DefaultStringValue("Удаление группы заказов")
  @Key("orderGroupDeletedEmailSubject")
  String orderGroupDeletedEmailSubject();
}
