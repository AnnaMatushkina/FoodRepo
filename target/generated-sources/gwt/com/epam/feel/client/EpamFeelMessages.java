package com.epam.feel.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	D:/CI/Eda/source/src/main/resources/com/epam/feel/client/EpamFeelMessages.properties'.
 */
public interface EpamFeelMessages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Успешно выведено {0} руб.".
   * 
   * @return translated "Успешно выведено {0} руб."
   */
  @DefaultMessage("Успешно выведено {0} руб.")
  @Key("balanceOutputted")
  String balanceOutputted(String arg0);

  /**
   * Translated "Вы не можете сделать доступное кол-во блюд меньше, чем {0}.".
   * 
   * @return translated "Вы не можете сделать доступное кол-во блюд меньше, чем {0}."
   */
  @DefaultMessage("Вы не можете сделать доступное кол-во блюд меньше, чем {0}.")
  @Key("cantChangeDishesCount")
  String cantChangeDishesCount(String arg0);

  /**
   * Translated "Заказ № {0} {1} находится в группе заказов. \nПри внесении изменений в заказ группа будет расформирована. Продолжить?".
   * 
   * @return translated "Заказ № {0} {1} находится в группе заказов. \nПри внесении изменений в заказ группа будет расформирована. Продолжить?"
   */
  @DefaultMessage("Заказ № {0} {1} находится в группе заказов. \nПри внесении изменений в заказ группа будет расформирована. Продолжить?")
  @Key("changeRequestAndDellGroupConfirmation")
  String changeRequestAndDellGroupConfirmation(String arg0,  String arg1);

  /**
   * Translated "Вы действительно хотите изменить индивидуальный заказ № {0} {1}?".
   * 
   * @return translated "Вы действительно хотите изменить индивидуальный заказ № {0} {1}?"
   */
  @DefaultMessage("Вы действительно хотите изменить индивидуальный заказ № {0} {1}?")
  @Key("changeRequestConfirmation")
  String changeRequestConfirmation(String arg0,  String arg1);

  /**
   * Translated "Вы действительно хотите закрыть индивидуальный заказ № {0} {1}?".
   * 
   * @return translated "Вы действительно хотите закрыть индивидуальный заказ № {0} {1}?"
   */
  @DefaultMessage("Вы действительно хотите закрыть индивидуальный заказ № {0} {1}?")
  @Key("closeRequestConfirmation")
  String closeRequestConfirmation(String arg0,  String arg1);

  /**
   * Translated "© {0}. EPAM Systems ".
   * 
   * @return translated "© {0}. EPAM Systems "
   */
  @DefaultMessage("© {0}. EPAM Systems ")
  @Key("copyRightLabel")
  String copyRightLabel(String arg0);

  /**
   * Translated "Заказ № {0} {1} находится в группе заказов. При отклонении заказа группа будет расформирована. Продолжить?".
   * 
   * @return translated "Заказ № {0} {1} находится в группе заказов. При отклонении заказа группа будет расформирована. Продолжить?"
   */
  @DefaultMessage("Заказ № {0} {1} находится в группе заказов. При отклонении заказа группа будет расформирована. Продолжить?")
  @Key("declineRequestAndDellGroupConfirmation")
  String declineRequestAndDellGroupConfirmation(String arg0,  String arg1);

  /**
   * Translated "Вы действительно хотите отклонить индивидуальный заказ № {0} {1}?".
   * 
   * @return translated "Вы действительно хотите отклонить индивидуальный заказ № {0} {1}?"
   */
  @DefaultMessage("Вы действительно хотите отклонить индивидуальный заказ № {0} {1}?")
  @Key("declineRequestConfirmation")
  String declineRequestConfirmation(String arg0,  String arg1);

  /**
   * Translated "Вы действительно хотите удалить группу заказов № {0}?".
   * 
   * @return translated "Вы действительно хотите удалить группу заказов № {0}?"
   */
  @DefaultMessage("Вы действительно хотите удалить группу заказов № {0}?")
  @Key("deleteGroupRequestConfirmation")
  String deleteGroupRequestConfirmation(String arg0);

  /**
   * Translated "Вы действительно хотите удалить индивидуальный заказ № {0} {1}?".
   * 
   * @return translated "Вы действительно хотите удалить индивидуальный заказ № {0} {1}?"
   */
  @DefaultMessage("Вы действительно хотите удалить индивидуальный заказ № {0} {1}?")
  @Key("deleteRequestConfirmation")
  String deleteRequestConfirmation(String arg0,  String arg1);

  /**
   * Translated "Заказ № {0} {1} находится в группе заказов. \nПри удалении заказа группа будет расформирована. Продолжить?".
   * 
   * @return translated "Заказ № {0} {1} находится в группе заказов. \nПри удалении заказа группа будет расформирована. Продолжить?"
   */
  @DefaultMessage("Заказ № {0} {1} находится в группе заказов. \nПри удалении заказа группа будет расформирована. Продолжить?")
  @Key("deleteRequestFromGroupConfirmation")
  String deleteRequestFromGroupConfirmation(String arg0,  String arg1);

  /**
   * Translated "Недостаточно средств для оплаты текущего заказа № {0} пользователя {1}".
   * 
   * @return translated "Недостаточно средств для оплаты текущего заказа № {0} пользователя {1}"
   */
  @DefaultMessage("Недостаточно средств для оплаты текущего заказа № {0} пользователя {1}")
  @Key("insufficientFunds")
  String insufficientFunds(String arg0,  String arg1);

  /**
   * Translated "Недостаточно средств для принятия заказа № {0} пользователя {1}".
   * 
   * @return translated "Недостаточно средств для принятия заказа № {0} пользователя {1}"
   */
  @DefaultMessage("Недостаточно средств для принятия заказа № {0} пользователя {1}")
  @Key("insufficientFundsForAccept")
  String insufficientFundsForAccept(String arg0,  String arg1);

  /**
   * Translated "Оплатить текущий заказ № {0} пользователя {1}?".
   * 
   * @return translated "Оплатить текущий заказ № {0} пользователя {1}?"
   */
  @DefaultMessage("Оплатить текущий заказ № {0} пользователя {1}?")
  @Key("payConfirmation")
  String payConfirmation(String arg0,  String arg1);

  /**
   * Translated "К оплате: {0}".
   * 
   * @return translated "К оплате: {0}"
   */
  @DefaultMessage("К оплате: {0}")
  @Key("payable")
  String payable(String arg0);

  /**
   * Translated "Вы уверены, что хотите возвратить {0} р. на лицевой счет?".
   * 
   * @return translated "Вы уверены, что хотите возвратить {0} р. на лицевой счет?"
   */
  @DefaultMessage("Вы уверены, что хотите возвратить {0} р. на лицевой счет?")
  @Key("paybackConfirmation")
  String paybackConfirmation(String arg0);

  /**
   * Translated "Лицевой счет {0}: ".
   * 
   * @return translated "Лицевой счет {0}: "
   */
  @DefaultMessage("Лицевой счет {0}: ")
  @Key("personalAccountLabel")
  String personalAccountLabel(String arg0);

  /**
   * Translated "Останутся без обеда {0} человек. Вы уверены?".
   * 
   * @return translated "Останутся без обеда {0} человек. Вы уверены?"
   */
  @DefaultMessage("Останутся без обеда {0} человек. Вы уверены?")
  @Key("rejectionOfFoodConfirmation")
  String rejectionOfFoodConfirmation(String arg0);

  /**
   * Translated "Вы уверены, что хотите внести {0} р. на лицевой счет № {1} пользователя {2}?".
   * 
   * @return translated "Вы уверены, что хотите внести {0} р. на лицевой счет № {1} пользователя {2}?"
   */
  @DefaultMessage("Вы уверены, что хотите внести {0} р. на лицевой счет № {1} пользователя {2}?")
  @Key("replenishConfirmation")
  String replenishConfirmation(String arg0,  String arg1,  String arg2);

  /**
   * Translated "Группа заказов № {0} от {1}".
   * 
   * @return translated "Группа заказов № {0} от {1}"
   */
  @DefaultMessage("Группа заказов № {0} от {1}")
  @Key("requestGroupView")
  String requestGroupView(String arg0,  String arg1);

  /**
   * Translated "Ваш заказ не может быть выполнен, так как блюдо \"{0}\" по цене {1} имеется в недостаточном количестве ({2}).".
   * 
   * @return translated "Ваш заказ не может быть выполнен, так как блюдо \"{0}\" по цене {1} имеется в недостаточном количестве ({2})."
   */
  @DefaultMessage("Ваш заказ не может быть выполнен, так как блюдо \"{0}\" по цене {1} имеется в недостаточном количестве ({2}).")
  @Key("requestedDishIsNotAvailable")
  String requestedDishIsNotAvailable(String arg0,  String arg1,  String arg2);

  /**
   * Translated "Невозможно удалить выбранный пункт меню, так как на него имеются заказы (суммарно: {0}).".
   * 
   * @return translated "Невозможно удалить выбранный пункт меню, так как на него имеются заказы (суммарно: {0})."
   */
  @DefaultMessage("Невозможно удалить выбранный пункт меню, так как на него имеются заказы (суммарно: {0}).")
  @Key("unableToDeleteMenuItem")
  String unableToDeleteMenuItem(String arg0);
}
