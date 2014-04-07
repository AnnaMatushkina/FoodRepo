package com.epam.feel.server;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	D:/CI/Eda/source/src/main/resources/com/epam/feel/server/EpamFeelMessages.properties'.
 */
public interface EpamFeelMessages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Заказ № {0} принят".
   * 
   * @return translated "Заказ № {0} принят"
   */
  @DefaultMessage("Заказ № {0} принят")
  @Key("acceptingRequest")
  String acceptingRequest(String arg0);

  /**
   * Translated "Группа заказов № {0} принята".
   * 
   * @return translated "Группа заказов № {0} принята"
   */
  @DefaultMessage("Группа заказов № {0} принята")
  @Key("acceptingRequestGroup")
  String acceptingRequestGroup(String arg0);

  /**
   * Translated "Заказ № {0} доставлен".
   * 
   * @return translated "Заказ № {0} доставлен"
   */
  @DefaultMessage("Заказ № {0} доставлен")
  @Key("complitingRequest")
  String complitingRequest(String arg0);

  /**
   * Translated "Создание группы заказов № {0}".
   * 
   * @return translated "Создание группы заказов № {0}"
   */
  @DefaultMessage("Создание группы заказов № {0}")
  @Key("creatingRequestGroup")
  String creatingRequestGroup(String arg0);

  /**
   * Translated "Заказ № {0} отменен".
   * 
   * @return translated "Заказ № {0} отменен"
   */
  @DefaultMessage("Заказ № {0} отменен")
  @Key("decliningRequest")
  String decliningRequest(String arg0);

  /**
   * Translated "Группа заказов № {0} доставлена".
   * 
   * @return translated "Группа заказов № {0} доставлена"
   */
  @DefaultMessage("Группа заказов № {0} доставлена")
  @Key("deliveringRequestGroup")
  String deliveringRequestGroup(String arg0);

  /**
   * Translated "Изменение заказа № {0}".
   * 
   * @return translated "Изменение заказа № {0}"
   */
  @DefaultMessage("Изменение заказа № {0}")
  @Key("editingRequest")
  String editingRequest(String arg0);

  /**
   * Translated "Создание заказа № {0}".
   * 
   * @return translated "Создание заказа № {0}"
   */
  @DefaultMessage("Создание заказа № {0}")
  @Key("makingRequest")
  String makingRequest(String arg0);

  /**
   * Translated "Меню № {0} \"{1}\" было закрыто".
   * 
   * @return translated "Меню № {0} \"{1}\" было закрыто"
   */
  @DefaultMessage("Меню № {0} \"{1}\" было закрыто")
  @Key("menuClosed")
  String menuClosed(String arg0,  String arg1);

  /**
   * Translated "Составлено меню № {0} \"{1}\" на следующий день".
   * 
   * @return translated "Составлено меню № {0} \"{1}\" на следующий день"
   */
  @DefaultMessage("Составлено меню № {0} \"{1}\" на следующий день")
  @Key("menuNextDay")
  String menuNextDay(String arg0,  String arg1);

  /**
   * Translated "Меню № {0} \"{1}\" было открыто".
   * 
   * @return translated "Меню № {0} \"{1}\" было открыто"
   */
  @DefaultMessage("Меню № {0} \"{1}\" было открыто")
  @Key("menuOpened")
  String menuOpened(String arg0,  String arg1);

  /**
   * Translated "Здравствуйте,\nВаш заказ № {0} от {1} изменен администратором в связи с {3}.\nОбщая стоимость заказа {2}.\nИтоговая сумма к оплате заказа {2}.\nСпасибо.".
   * 
   * @return translated "Здравствуйте,\nВаш заказ № {0} от {1} изменен администратором в связи с {3}.\nОбщая стоимость заказа {2}.\nИтоговая сумма к оплате заказа {2}.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте,\nВаш заказ № {0} от {1} изменен администратором в связи с {3}.\nОбщая стоимость заказа {2}.\nИтоговая сумма к оплате заказа {2}.\nСпасибо.")
  @Key("orderChanged")
  String orderChanged(String arg0,  String arg1,  String arg2,  String arg3);

  /**
   * Translated "Здравствуйте,\nВаш  заказ № {0} от {1} отклонен администратором в связи с {2}.\nСпасибо.".
   * 
   * @return translated "Здравствуйте,\nВаш  заказ № {0} от {1} отклонен администратором в связи с {2}.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте,\nВаш  заказ № {0} от {1} отклонен администратором в связи с {2}.\nСпасибо.")
  @Key("orderDeclined")
  String orderDeclined(String arg0,  String arg1,  String arg2);

  /**
   * Translated "Здравствуйте,\nВаш  заказ № {0} от {1} удален администратором в связи с {2}.\nСпасибо.".
   * 
   * @return translated "Здравствуйте,\nВаш  заказ № {0} от {1} удален администратором в связи с {2}.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте,\nВаш  заказ № {0} от {1} удален администратором в связи с {2}.\nСпасибо.")
  @Key("orderDeleted")
  String orderDeleted(String arg0,  String arg1,  String arg2);

  /**
   * Translated "Здравствуйте, \nВаш заказ № {0} от {1} доставлен, просьба забрать его в ближайшее время на ресепшене.\nСпасибо.".
   * 
   * @return translated "Здравствуйте, \nВаш заказ № {0} от {1} доставлен, просьба забрать его в ближайшее время на ресепшене.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте, \nВаш заказ № {0} от {1} доставлен, просьба забрать его в ближайшее время на ресепшене.\nСпасибо.")
  @Key("orderDelivered")
  String orderDelivered(String arg0,  String arg1);

  /**
   * Translated "Здравствуйте,\nИндивидуальные заказы от {0} были отклонены администратором в связи с {1}.\nВся сумма заказов будет возмещена.\nСпасибо.".
   * 
   * @return translated "Здравствуйте,\nИндивидуальные заказы от {0} были отклонены администратором в связи с {1}.\nВся сумма заказов будет возмещена.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте,\nИндивидуальные заказы от {0} были отклонены администратором в связи с {1}.\nВся сумма заказов будет возмещена.\nСпасибо.")
  @Key("orderGroupDeleted")
  String orderGroupDeleted(String arg0,  String arg1);

  /**
   * Translated "Здравствуйте,\nВаш заказ № {0} от {1} исполнен.\nСпасибо.".
   * 
   * @return translated "Здравствуйте,\nВаш заказ № {0} от {1} исполнен.\nСпасибо."
   */
  @DefaultMessage("Здравствуйте,\nВаш заказ № {0} от {1} исполнен.\nСпасибо.")
  @Key("orderPerformed")
  String orderPerformed(String arg0,  String arg1);

  /**
   * Translated "Заказ № {0} оплачен".
   * 
   * @return translated "Заказ № {0} оплачен"
   */
  @DefaultMessage("Заказ № {0} оплачен")
  @Key("paymentForRequest")
  String paymentForRequest(String arg0);

  /**
   * Translated "Удалено меню № {0} \"{1}\"".
   * 
   * @return translated "Удалено меню № {0} \"{1}\""
   */
  @DefaultMessage("Удалено меню № {0} \"{1}\"")
  @Key("removedMenu")
  String removedMenu(String arg0,  String arg1);

  /**
   * Translated "Заказ № {0} удалён".
   * 
   * @return translated "Заказ № {0} удалён"
   */
  @DefaultMessage("Заказ № {0} удалён")
  @Key("removingRequest")
  String removingRequest(String arg0);

  /**
   * Translated "Группа заказов № {0} удалена".
   * 
   * @return translated "Группа заказов № {0} удалена"
   */
  @DefaultMessage("Группа заказов № {0} удалена")
  @Key("removingRequestGroup")
  String removingRequestGroup(String arg0);

  /**
   * Translated "Сохранено/изменено меню № {0} \"{1}\"".
   * 
   * @return translated "Сохранено/изменено меню № {0} \"{1}\""
   */
  @DefaultMessage("Сохранено/изменено меню № {0} \"{1}\"")
  @Key("savedMenu")
  String savedMenu(String arg0,  String arg1);
}
