package com.epam.feel.client;

public class IEpamFeelMessages_ implements com.epam.feel.client.IEpamFeelMessages {
  
  public java.lang.String closeRequestConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Вы действительно хотите закрыть индивидуальный заказ № " + arg0 + " " + arg1 + "?";
  }
  
  public java.lang.String deleteRequestConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Вы действительно хотите удалить индивидуальный заказ № " + arg0 + " " + arg1 + "?";
  }
  
  public java.lang.String paybackConfirmation(java.lang.String arg0) {
    return "Вы уверены, что хотите возвратить " + arg0 + " р. на лицевой счет?";
  }
  
  public java.lang.String requestedDishIsNotAvailable(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2) {
    return "Ваш заказ не может быть выполнен, так как блюдо \"" + arg0 + "\" по цене " + arg1 + " имеется в недостаточном количестве (" + arg2 + ").";
  }
  
  public java.lang.String declineRequestAndDellGroupConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Заказ № " + arg0 + " " + arg1 + " находится в группе заказов. При отклонении заказа группа будет расформирована. Продолжить?";
  }
  
  public java.lang.String declineRequestConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Вы действительно хотите отклонить индивидуальный заказ № " + arg0 + " " + arg1 + "?";
  }
  
  public java.lang.String balanceOutputted(java.lang.String arg0) {
    return "Успешно выведено " + arg0 + " руб.";
  }
  
  public java.lang.String insufficientFundsForAccept(java.lang.String arg0,java.lang.String arg1) {
    return "Недостаточно средств для принятия заказа № " + arg0 + " пользователя " + arg1;
  }
  
  public java.lang.String replenishConfirmation(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2) {
    return "Вы уверены, что хотите внести " + arg0 + " р. на лицевой счет № " + arg1 + " пользователя " + arg2 + "?";
  }
  
  public java.lang.String cantChangeDishesCount(java.lang.String arg0) {
    return "Вы не можете сделать доступное кол-во блюд меньше, чем " + arg0 + ".";
  }
  
  public java.lang.String deleteGroupRequestConfirmation(java.lang.String arg0) {
    return "Вы действительно хотите удалить группу заказов № " + arg0 + "?";
  }
  
  public java.lang.String insufficientFunds(java.lang.String arg0,java.lang.String arg1) {
    return "Недостаточно средств для оплаты текущего заказа № " + arg0 + " пользователя " + arg1;
  }
  
  public java.lang.String requestGroupView(java.lang.String arg0,java.lang.String arg1) {
    return "Группа заказов № " + arg0 + " от " + arg1;
  }
  
  public java.lang.String deleteRequestFromGroupConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Заказ № " + arg0 + " " + arg1 + " находится в группе заказов. \nПри удалении заказа группа будет расформирована. Продолжить?";
  }
  
  public java.lang.String changeRequestAndDellGroupConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Заказ № " + arg0 + " " + arg1 + " находится в группе заказов. \nПри внесении изменений в заказ группа будет расформирована. Продолжить?";
  }
  
  public java.lang.String rejectionOfFoodConfirmation(java.lang.String arg0) {
    return "Останутся без обеда " + arg0 + " человек. Вы уверены?";
  }
  
  public java.lang.String unableToDeleteMenuItem(java.lang.String arg0) {
    return "Невозможно удалить выбранный пункт меню, так как на него имеются заказы (суммарно: " + arg0 + ").";
  }
  
  public java.lang.String payConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Оплатить текущий заказ № " + arg0 + " пользователя " + arg1 + "?";
  }
  
  public java.lang.String payable(java.lang.String arg0) {
    return "К оплате: " + arg0;
  }
  
  public java.lang.String copyRightLabel(java.lang.String arg0) {
    return "© " + arg0 + ". EPAM Systems ";
  }
  
  public java.lang.String personalAccountLabel(java.lang.String arg0) {
    return "Лицевой счет " + arg0 + ": ";
  }
  
  public java.lang.String changeRequestConfirmation(java.lang.String arg0,java.lang.String arg1) {
    return "Вы действительно хотите изменить индивидуальный заказ № " + arg0 + " " + arg1 + "?";
  }
}
