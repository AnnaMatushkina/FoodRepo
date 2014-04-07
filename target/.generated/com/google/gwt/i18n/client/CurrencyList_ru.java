package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_ru extends com.google.gwt.i18n.client.CurrencyList_ {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("BYR", "BYR", 0);
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "BYR", "BYR", 0];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // Андоррская песета
    result.put("ADP", new CurrencyDataImpl("ADP", "ADP", 128));
    // Дирхам (ОАЭ)
    result.put("AED", new CurrencyDataImpl("AED", "DH", 2, "DH"));
    // Афгани (1927-2002)
    result.put("AFA", new CurrencyDataImpl("AFA", "AFA", 130));
    // Афгани
    result.put("AFN", new CurrencyDataImpl("AFN", "Af", 0));
    // Албанский лек
    result.put("ALL", new CurrencyDataImpl("ALL", "ALL", 0));
    // Армянский драм
    result.put("AMD", new CurrencyDataImpl("AMD", "AMD", 0));
    // Нидерландский антильский гульден
    result.put("ANG", new CurrencyDataImpl("ANG", "NAf.", 2));
    // Ангольская кванза
    result.put("AOA", new CurrencyDataImpl("AOA", "Kz", 2));
    // Ангольская кванза (1977-1990)
    result.put("AOK", new CurrencyDataImpl("AOK", "AOK", 130));
    // Ангольская новая кванза (1990-2000)
    result.put("AON", new CurrencyDataImpl("AON", "AON", 130));
    // Ангольская кванза реюстадо (1995-1999)
    result.put("AOR", new CurrencyDataImpl("AOR", "AOR", 130));
    // Аргентинский аустрал
    result.put("ARA", new CurrencyDataImpl("ARA", "₳", 130));
    // ARL
    result.put("ARL", new CurrencyDataImpl("ARL", "$L", 130));
    // ARM
    result.put("ARM", new CurrencyDataImpl("ARM", "m$n", 130));
    // Аргентинское песо (1983-1985)
    result.put("ARP", new CurrencyDataImpl("ARP", "ARP", 130));
    // Аргентинское песо
    result.put("ARS", new CurrencyDataImpl("ARS", "AR$", 2, "AR$"));
    // Австрийский шиллинг
    result.put("ATS", new CurrencyDataImpl("ATS", "ATS", 130));
    // Австралийский доллар
    result.put("AUD", new CurrencyDataImpl("AUD", "AU$", 2, "AU$"));
    // Арубанский гульден
    result.put("AWG", new CurrencyDataImpl("AWG", "Afl.", 2));
    // Старый азербайджанский манат
    result.put("AZM", new CurrencyDataImpl("AZM", "AZM", 130));
    // Азербайджанский манат
    result.put("AZN", new CurrencyDataImpl("AZN", "man.", 2));
    // Динар Боснии и Герцеговины
    result.put("BAD", new CurrencyDataImpl("BAD", "BAD", 130));
    // Конвертируемая марка Боснии и Герцеговины
    result.put("BAM", new CurrencyDataImpl("BAM", "KM", 2));
    // Барбадосский доллар
    result.put("BBD", new CurrencyDataImpl("BBD", "Bds$", 2));
    // Бангладешская така
    result.put("BDT", new CurrencyDataImpl("BDT", "Tk", 2, "Tk"));
    // Бельгийский франк (конвертируемый)
    result.put("BEC", new CurrencyDataImpl("BEC", "BEC", 2));
    // Бельгийский франк
    result.put("BEF", new CurrencyDataImpl("BEF", "BF", 130));
    // Бельгийский франк (финансовый)
    result.put("BEL", new CurrencyDataImpl("BEL", "BEL", 2));
    // Лев
    result.put("BGL", new CurrencyDataImpl("BGL", "BGL", 130));
    // Болгарский лев
    result.put("BGN", new CurrencyDataImpl("BGN", "BGN", 2));
    // Бахрейнский динар
    result.put("BHD", new CurrencyDataImpl("BHD", "BD", 3));
    // Бурундийский франк
    result.put("BIF", new CurrencyDataImpl("BIF", "FBu", 0));
    // Бермудский доллар
    result.put("BMD", new CurrencyDataImpl("BMD", "BD$", 2));
    // Брунейский доллар
    result.put("BND", new CurrencyDataImpl("BND", "BN$", 2));
    // Боливиано
    result.put("BOB", new CurrencyDataImpl("BOB", "Bs", 2));
    // Боливийское песо
    result.put("BOP", new CurrencyDataImpl("BOP", "$b.", 130));
    // Боливийский мвдол
    result.put("BOV", new CurrencyDataImpl("BOV", "BOV", 2));
    // Бразильский новый крузейро (1967-1986)
    result.put("BRB", new CurrencyDataImpl("BRB", "BRB", 130));
    // Бразильское крузадо
    result.put("BRC", new CurrencyDataImpl("BRC", "BRC", 130));
    // Бразильский крузейро (1990-1993)
    result.put("BRE", new CurrencyDataImpl("BRE", "BRE", 130));
    // Бразильский реал
    result.put("BRL", new CurrencyDataImpl("BRL", "R$", 2, "R$"));
    // Бразильское новое крузадо
    result.put("BRN", new CurrencyDataImpl("BRN", "BRN", 130));
    // Бразильский крузейро
    result.put("BRR", new CurrencyDataImpl("BRR", "BRR", 130));
    // Багамский доллар
    result.put("BSD", new CurrencyDataImpl("BSD", "BS$", 2));
    // Нгултрум
    result.put("BTN", new CurrencyDataImpl("BTN", "Nu.", 2));
    // Джа
    result.put("BUK", new CurrencyDataImpl("BUK", "BUK", 130));
    // Ботсванская пула
    result.put("BWP", new CurrencyDataImpl("BWP", "BWP", 2));
    // Белорусский рубль (1994-1999)
    result.put("BYB", new CurrencyDataImpl("BYB", "BYB", 130));
    // Белорусский рубль
    result.put("BYR", new CurrencyDataImpl("BYR", "BYR", 0));
    // Белизский доллар
    result.put("BZD", new CurrencyDataImpl("BZD", "BZ$", 2));
    // Канадский доллар
    result.put("CAD", new CurrencyDataImpl("CAD", "CA$", 2, "C$"));
    // Конголезский франк
    result.put("CDF", new CurrencyDataImpl("CDF", "CDF", 2));
    // WIR евро
    result.put("CHE", new CurrencyDataImpl("CHE", "CHE", 2));
    // Швейцарский франк
    result.put("CHF", new CurrencyDataImpl("CHF", "Fr.", 2, "CHF"));
    // WIR франк
    result.put("CHW", new CurrencyDataImpl("CHW", "CHW", 2));
    // CLE
    result.put("CLE", new CurrencyDataImpl("CLE", "Eº", 130));
    // Условная расчетная единица Чили
    result.put("CLF", new CurrencyDataImpl("CLF", "CLF", 0));
    // Чилийское песо
    result.put("CLP", new CurrencyDataImpl("CLP", "CL$", 0, "CL$"));
    // Юань Ренминби
    result.put("CNY", new CurrencyDataImpl("CNY", "CN¥", 2, "RMB¥"));
    // Колумбийское песо
    result.put("COP", new CurrencyDataImpl("COP", "CO$", 0, "COL$"));
    // Единица реальной стоимости Колумбии
    result.put("COU", new CurrencyDataImpl("COU", "COU", 2));
    // Костариканский колон
    result.put("CRC", new CurrencyDataImpl("CRC", "₡", 0, "CR₡"));
    // Старый Сербский динар
    result.put("CSD", new CurrencyDataImpl("CSD", "CSD", 130));
    // Чехословацкая твердая крона
    result.put("CSK", new CurrencyDataImpl("CSK", "CSK", 130));
    // CUC
    result.put("CUC", new CurrencyDataImpl("CUC", "CUC$", 2));
    // Кубинское песо
    result.put("CUP", new CurrencyDataImpl("CUP", "CU$", 2, "$MN"));
    // Эскудо Кабо-Верде
    result.put("CVE", new CurrencyDataImpl("CVE", "CV$", 2));
    // Кипрский фунт
    result.put("CYP", new CurrencyDataImpl("CYP", "CY£", 130));
    // Чешская крона
    result.put("CZK", new CurrencyDataImpl("CZK", "Kč", 2, "Kč"));
    // Восточногерманская марка
    result.put("DDM", new CurrencyDataImpl("DDM", "DDM", 130));
    // Немецкая марка
    result.put("DEM", new CurrencyDataImpl("DEM", "DM", 130));
    // Франк Джибути
    result.put("DJF", new CurrencyDataImpl("DJF", "Fdj", 0));
    // Датская крона
    result.put("DKK", new CurrencyDataImpl("DKK", "Dkr", 2, "kr"));
    // Доминиканское песо
    result.put("DOP", new CurrencyDataImpl("DOP", "RD$", 2, "RD$"));
    // Алжирский динар
    result.put("DZD", new CurrencyDataImpl("DZD", "DA", 2));
    // Эквадорский сукре
    result.put("ECS", new CurrencyDataImpl("ECS", "ECS", 130));
    // Постоянная единица стоимости Эквадора
    result.put("ECV", new CurrencyDataImpl("ECV", "ECV", 2));
    // Эстонская крона
    result.put("EEK", new CurrencyDataImpl("EEK", "Ekr", 2));
    // Египетский фунт
    result.put("EGP", new CurrencyDataImpl("EGP", "EG£", 2, "LE"));
    // EQE
    result.put("EQE", new CurrencyDataImpl("EQE", "EQE", 130));
    // Накфа
    result.put("ERN", new CurrencyDataImpl("ERN", "Nfk", 2));
    // Испанская песета (А)
    result.put("ESA", new CurrencyDataImpl("ESA", "ESA", 2));
    // Испанская песета (конвертируемая)
    result.put("ESB", new CurrencyDataImpl("ESB", "ESB", 2));
    // Испанская песета
    result.put("ESP", new CurrencyDataImpl("ESP", "Pts", 128));
    // Эфиопский быр
    result.put("ETB", new CurrencyDataImpl("ETB", "Br", 2));
    // Евро
    result.put("EUR", new CurrencyDataImpl("EUR", "€", 2, "€"));
    // Финская марка
    result.put("FIM", new CurrencyDataImpl("FIM", "mk", 130));
    // Доллар Фиджи
    result.put("FJD", new CurrencyDataImpl("FJD", "FJ$", 2));
    // Фунт Фолклендских островов
    result.put("FKP", new CurrencyDataImpl("FKP", "FK£", 2));
    // Французский франк
    result.put("FRF", new CurrencyDataImpl("FRF", "₣", 130));
    // Английский фунт стерлингов
    result.put("GBP", new CurrencyDataImpl("GBP", "£", 2, "GB£"));
    // Грузинский купон
    result.put("GEK", new CurrencyDataImpl("GEK", "GEK", 130));
    // Грузинский лари
    result.put("GEL", new CurrencyDataImpl("GEL", "GEL", 2));
    // Ганский седи
    result.put("GHC", new CurrencyDataImpl("GHC", "₵", 130));
    // Седи Ганы
    result.put("GHS", new CurrencyDataImpl("GHS", "GH₵", 2));
    // Гибралтарский фунт
    result.put("GIP", new CurrencyDataImpl("GIP", "GI£", 2));
    // Гамбийский даласи
    result.put("GMD", new CurrencyDataImpl("GMD", "GMD", 2));
    // Гвинейский франк
    result.put("GNF", new CurrencyDataImpl("GNF", "FG", 0));
    // Гвинейская сили
    result.put("GNS", new CurrencyDataImpl("GNS", "GNS", 130));
    // Эквеле экваториальной Гвинеи
    result.put("GQE", new CurrencyDataImpl("GQE", "GQE", 130));
    // Греческая драхма
    result.put("GRD", new CurrencyDataImpl("GRD", "₯", 130));
    // Гватемальский кетсаль
    result.put("GTQ", new CurrencyDataImpl("GTQ", "GTQ", 2));
    // Эскудо Португальской Гвинеи
    result.put("GWE", new CurrencyDataImpl("GWE", "GWE", 130));
    // Песо Гвинеи-Бисау
    result.put("GWP", new CurrencyDataImpl("GWP", "GWP", 2));
    // Гайанский доллар
    result.put("GYD", new CurrencyDataImpl("GYD", "GY$", 0));
    // Гонконгский доллар
    result.put("HKD", new CurrencyDataImpl("HKD", "HK$", 2, "HK$"));
    // Гондурасская лемпира
    result.put("HNL", new CurrencyDataImpl("HNL", "HNL", 2));
    // Хорватский динар
    result.put("HRD", new CurrencyDataImpl("HRD", "HRD", 130));
    // Хорватская куна
    result.put("HRK", new CurrencyDataImpl("HRK", "kn", 2));
    // Гаитянский гурд
    result.put("HTG", new CurrencyDataImpl("HTG", "HTG", 2));
    // Венгерский форинт
    result.put("HUF", new CurrencyDataImpl("HUF", "Ft", 0));
    // Индонезийская рупия
    result.put("IDR", new CurrencyDataImpl("IDR", "Rp", 0));
    // Ирландский фунт
    result.put("IEP", new CurrencyDataImpl("IEP", "IR£", 130));
    // Израильский фунт
    result.put("ILP", new CurrencyDataImpl("ILP", "I£", 130));
    // Новый израильский шекель
    result.put("ILS", new CurrencyDataImpl("ILS", "₪", 2, "IL₪"));
    // Индийская рупия
    result.put("INR", new CurrencyDataImpl("INR", "Rs", 2, "Rs"));
    // Иракский динар
    result.put("IQD", new CurrencyDataImpl("IQD", "IQD", 0));
    // Иранский риал
    result.put("IRR", new CurrencyDataImpl("IRR", "IRR", 0));
    // Исландская крона
    result.put("ISK", new CurrencyDataImpl("ISK", "Ikr", 0, "kr"));
    // Итальянская лира
    result.put("ITL", new CurrencyDataImpl("ITL", "IT₤", 128));
    // Ямайский доллар
    result.put("JMD", new CurrencyDataImpl("JMD", "J$", 2, "JA$"));
    // Иорданский динар
    result.put("JOD", new CurrencyDataImpl("JOD", "JD", 3));
    // Японская иена
    result.put("JPY", new CurrencyDataImpl("JPY", "JP¥", 0, "JP¥"));
    // Кенийский шиллинг
    result.put("KES", new CurrencyDataImpl("KES", "Ksh", 2));
    // Киргизский сом
    result.put("KGS", new CurrencyDataImpl("KGS", "KGS", 2));
    // Камбоджийский риель
    result.put("KHR", new CurrencyDataImpl("KHR", "KHR", 2));
    // Франк Коморских островов
    result.put("KMF", new CurrencyDataImpl("KMF", "CF", 0));
    // Северо-корейская вона
    result.put("KPW", new CurrencyDataImpl("KPW", "KPW", 0));
    // Вона Республики Кореи
    result.put("KRW", new CurrencyDataImpl("KRW", "₩", 0, "KR₩"));
    // Кувейтский динар
    result.put("KWD", new CurrencyDataImpl("KWD", "KD", 3));
    // Доллар Каймановых островов
    result.put("KYD", new CurrencyDataImpl("KYD", "KY$", 2));
    // Казахский тенге
    result.put("KZT", new CurrencyDataImpl("KZT", "KZT", 2));
    // Кип ЛНДР
    result.put("LAK", new CurrencyDataImpl("LAK", "₭", 0));
    // Ливанский фунт
    result.put("LBP", new CurrencyDataImpl("LBP", "LB£", 0));
    // Шри-Ланкийская рупия
    result.put("LKR", new CurrencyDataImpl("LKR", "SLRs", 2, "SLRs"));
    // Либерийский доллар
    result.put("LRD", new CurrencyDataImpl("LRD", "L$", 2));
    // Лоти
    result.put("LSL", new CurrencyDataImpl("LSL", "LSL", 2));
    // LSM
    result.put("LSM", new CurrencyDataImpl("LSM", "LSM", 130));
    // Литовский лит
    result.put("LTL", new CurrencyDataImpl("LTL", "Lt", 2));
    // Литовский талон
    result.put("LTT", new CurrencyDataImpl("LTT", "LTT", 130));
    // Конвертируемый франк Люксембурга
    result.put("LUC", new CurrencyDataImpl("LUC", "LUC", 2));
    // Люксембургский франк
    result.put("LUF", new CurrencyDataImpl("LUF", "LUF", 128));
    // Финансовый франк Люксембурга
    result.put("LUL", new CurrencyDataImpl("LUL", "LUL", 2));
    // Латвийский лат
    result.put("LVL", new CurrencyDataImpl("LVL", "Ls", 2));
    // Латвийский рубль
    result.put("LVR", new CurrencyDataImpl("LVR", "LVR", 130));
    // Ливийский динар
    result.put("LYD", new CurrencyDataImpl("LYD", "LD", 3));
    // Марокканский дирхам
    result.put("MAD", new CurrencyDataImpl("MAD", "MAD", 2));
    // Марокканский франк
    result.put("MAF", new CurrencyDataImpl("MAF", "MAF", 130));
    // Молдавский лей
    result.put("MDL", new CurrencyDataImpl("MDL", "MDL", 2));
    // Ариари
    result.put("MGA", new CurrencyDataImpl("MGA", "MGA", 0));
    // Малагасийский франк
    result.put("MGF", new CurrencyDataImpl("MGF", "MGF", 128));
    // Македонский динар
    result.put("MKD", new CurrencyDataImpl("MKD", "MKD", 2));
    // Малийский франк
    result.put("MLF", new CurrencyDataImpl("MLF", "MLF", 130));
    // Кьят
    result.put("MMK", new CurrencyDataImpl("MMK", "MMK", 0));
    // Монгольский тугрик
    result.put("MNT", new CurrencyDataImpl("MNT", "₮", 0, "MN₮"));
    // Патака
    result.put("MOP", new CurrencyDataImpl("MOP", "MOP$", 2));
    // Мавританская угия
    result.put("MRO", new CurrencyDataImpl("MRO", "UM", 0));
    // Мальтийская лира
    result.put("MTL", new CurrencyDataImpl("MTL", "Lm", 130));
    // Мальтийский фунт
    result.put("MTP", new CurrencyDataImpl("MTP", "MT£", 130));
    // Маврикийская рупия
    result.put("MUR", new CurrencyDataImpl("MUR", "MURs", 0));
    // Мальдивская руфия
    result.put("MVR", new CurrencyDataImpl("MVR", "MVR", 2));
    // Малавийская квача
    result.put("MWK", new CurrencyDataImpl("MWK", "MWK", 2));
    // Мексиканское новое песо
    result.put("MXN", new CurrencyDataImpl("MXN", "Mex$", 2, "Mex$"));
    // Мексиканское серебряное песо (1861-1992)
    result.put("MXP", new CurrencyDataImpl("MXP", "MX$", 130));
    // Мексиканская пересчетная единица (UDI)
    result.put("MXV", new CurrencyDataImpl("MXV", "MXV", 2));
    // Малайзийский ринггит
    result.put("MYR", new CurrencyDataImpl("MYR", "RM", 2, "RM"));
    // Мозамбикское эскудо
    result.put("MZE", new CurrencyDataImpl("MZE", "MZE", 130));
    // Старый мозамбикский метикал
    result.put("MZM", new CurrencyDataImpl("MZM", "Mt", 130));
    // Метикал
    result.put("MZN", new CurrencyDataImpl("MZN", "MTn", 2));
    // Доллар Намибии
    result.put("NAD", new CurrencyDataImpl("NAD", "N$", 2));
    // Нигерийская найра
    result.put("NGN", new CurrencyDataImpl("NGN", "₦", 2));
    // Никарагуанская кордоба
    result.put("NIC", new CurrencyDataImpl("NIC", "NIC", 130));
    // Золотая кордоба
    result.put("NIO", new CurrencyDataImpl("NIO", "C$", 2));
    // Нидерландский гульден
    result.put("NLG", new CurrencyDataImpl("NLG", "fl", 130));
    // Норвежская крона
    result.put("NOK", new CurrencyDataImpl("NOK", "Nkr", 2, "NOkr"));
    // Непальская рупия
    result.put("NPR", new CurrencyDataImpl("NPR", "NPRs", 2));
    // Новозеландский доллар
    result.put("NZD", new CurrencyDataImpl("NZD", "NZ$", 2));
    // Оманский риал
    result.put("OMR", new CurrencyDataImpl("OMR", "OMR", 3));
    // Панамское бальбоа
    result.put("PAB", new CurrencyDataImpl("PAB", "B/.", 2, "B/."));
    // Перуанское инти
    result.put("PEI", new CurrencyDataImpl("PEI", "I/.", 130));
    // Перуанский новый соль
    result.put("PEN", new CurrencyDataImpl("PEN", "S/.", 2, "S/."));
    // Перуанский соль
    result.put("PES", new CurrencyDataImpl("PES", "PES", 130));
    // Кина
    result.put("PGK", new CurrencyDataImpl("PGK", "PGK", 2));
    // Филиппинское песо
    result.put("PHP", new CurrencyDataImpl("PHP", "₱", 2, "PHP"));
    // Пакистанская рупия
    result.put("PKR", new CurrencyDataImpl("PKR", "PKRs", 0, "PKRs."));
    // Польский злотый
    result.put("PLN", new CurrencyDataImpl("PLN", "zł", 2));
    // Злотый
    result.put("PLZ", new CurrencyDataImpl("PLZ", "PLZ", 130));
    // Португальское эскудо
    result.put("PTE", new CurrencyDataImpl("PTE", "Esc", 130));
    // Парагвайский гуарани
    result.put("PYG", new CurrencyDataImpl("PYG", "₲", 0));
    // Катарский риал
    result.put("QAR", new CurrencyDataImpl("QAR", "QR", 2));
    // Родезийский доллар
    result.put("RHD", new CurrencyDataImpl("RHD", "RH$", 130));
    // Старый Румынский лей
    result.put("ROL", new CurrencyDataImpl("ROL", "ROL", 130));
    // Румынский лей
    result.put("RON", new CurrencyDataImpl("RON", "RON", 2));
    // Сербский динар
    result.put("RSD", new CurrencyDataImpl("RSD", "din.", 0));
    // Российский рубль
    result.put("RUB", new CurrencyDataImpl("RUB", "руб.", 2, "руб"));
    // Российский рубль (1991-1998)
    result.put("RUR", new CurrencyDataImpl("RUR", "р.", 130));
    // Франк Руанды
    result.put("RWF", new CurrencyDataImpl("RWF", "RWF", 0));
    // Саудовский риал
    result.put("SAR", new CurrencyDataImpl("SAR", "SR", 2, "SR"));
    // Доллар Соломоновых островов
    result.put("SBD", new CurrencyDataImpl("SBD", "SI$", 2));
    // Сейшельская рупия
    result.put("SCR", new CurrencyDataImpl("SCR", "SRe", 2));
    // Суданский динар
    result.put("SDD", new CurrencyDataImpl("SDD", "LSd", 130));
    // Суданский фунт
    result.put("SDG", new CurrencyDataImpl("SDG", "SDG", 2));
    // Старый суданский фунт
    result.put("SDP", new CurrencyDataImpl("SDP", "SDP", 130));
    // Шведская крона
    result.put("SEK", new CurrencyDataImpl("SEK", "Skr", 2, "kr"));
    // Сингапурский доллар
    result.put("SGD", new CurrencyDataImpl("SGD", "S$", 2, "S$"));
    // Фунт острова Святой Елены
    result.put("SHP", new CurrencyDataImpl("SHP", "SH£", 2));
    // Словенский толар
    result.put("SIT", new CurrencyDataImpl("SIT", "SIT", 130));
    // Словацкая крона
    result.put("SKK", new CurrencyDataImpl("SKK", "Sk", 130));
    // Леоне
    result.put("SLL", new CurrencyDataImpl("SLL", "Le", 0));
    // Сомалийский шиллинг
    result.put("SOS", new CurrencyDataImpl("SOS", "Ssh", 0));
    // Суринамский доллар
    result.put("SRD", new CurrencyDataImpl("SRD", "SR$", 2));
    // Суринамский гульден
    result.put("SRG", new CurrencyDataImpl("SRG", "Sf", 130));
    // Добра
    result.put("STD", new CurrencyDataImpl("STD", "Db", 0));
    // Рубль СССР
    result.put("SUR", new CurrencyDataImpl("SUR", "SUR", 130));
    // Сальвадорский колон
    result.put("SVC", new CurrencyDataImpl("SVC", "SV₡", 130));
    // Сирийский фунт
    result.put("SYP", new CurrencyDataImpl("SYP", "SY£", 0));
    // Свазилендский лилангени
    result.put("SZL", new CurrencyDataImpl("SZL", "SZL", 2));
    // Таиландский бат
    result.put("THB", new CurrencyDataImpl("THB", "฿", 2, "THB"));
    // Таджикский рубль
    result.put("TJR", new CurrencyDataImpl("TJR", "TJR", 130));
    // Таджикский сомони
    result.put("TJS", new CurrencyDataImpl("TJS", "TJS", 2));
    // Туркменский манат
    result.put("TMM", new CurrencyDataImpl("TMM", "TMM", 128));
    // Тунисский динар
    result.put("TND", new CurrencyDataImpl("TND", "DT", 3));
    // Паанга
    result.put("TOP", new CurrencyDataImpl("TOP", "T$", 2));
    // Тиморское эскудо
    result.put("TPE", new CurrencyDataImpl("TPE", "TPE", 130));
    // Турецкая лира
    result.put("TRL", new CurrencyDataImpl("TRL", "TRL", 128));
    // Новая турецкая лира
    result.put("TRY", new CurrencyDataImpl("TRY", "TL", 2, "YTL"));
    // Доллар Тринидада и Тобаго
    result.put("TTD", new CurrencyDataImpl("TTD", "TT$", 2));
    // Новый тайваньский доллар
    result.put("TWD", new CurrencyDataImpl("TWD", "NT$", 2, "NT$"));
    // Танзанийский шиллинг
    result.put("TZS", new CurrencyDataImpl("TZS", "TSh", 0));
    // Украинская гривна
    result.put("UAH", new CurrencyDataImpl("UAH", "₴", 2));
    // Карбованец (украинский)
    result.put("UAK", new CurrencyDataImpl("UAK", "UAK", 130));
    // Старый угандийский шиллинг
    result.put("UGS", new CurrencyDataImpl("UGS", "UGS", 130));
    // Угандийский шиллинг
    result.put("UGX", new CurrencyDataImpl("UGX", "USh", 0));
    // Доллар США
    result.put("USD", new CurrencyDataImpl("USD", "$", 2, "US$"));
    // Доллар США следующего дня
    result.put("USN", new CurrencyDataImpl("USN", "USN", 2));
    // Доллар США текущего дня
    result.put("USS", new CurrencyDataImpl("USS", "USS", 2));
    // Уругвайский песо (индекс инфляции)
    result.put("UYI", new CurrencyDataImpl("UYI", "UYI", 2));
    // Уругвайское старое песо (1975-1993)
    result.put("UYP", new CurrencyDataImpl("UYP", "UYP", 130));
    // Уругвайское песо
    result.put("UYU", new CurrencyDataImpl("UYU", "$U", 2, "UY$"));
    // Узбекский сум
    result.put("UZS", new CurrencyDataImpl("UZS", "UZS", 0));
    // Венесуэльский боливар
    result.put("VEB", new CurrencyDataImpl("VEB", "VEB", 130));
    // Венесуэльский боливар фуэрте
    result.put("VEF", new CurrencyDataImpl("VEF", "Bs.F.", 2));
    // Вьетнамский донг
    result.put("VND", new CurrencyDataImpl("VND", "₫", 24, "₫"));
    // Вату
    result.put("VUV", new CurrencyDataImpl("VUV", "VT", 0));
    // Тала
    result.put("WST", new CurrencyDataImpl("WST", "WS$", 2));
    // Франк КФА ВЕАС
    result.put("XAF", new CurrencyDataImpl("XAF", "FCFA", 0));
    // Серебро
    result.put("XAG", new CurrencyDataImpl("XAG", "XAG", 2));
    // Золото
    result.put("XAU", new CurrencyDataImpl("XAU", "XAU", 2));
    // Европейская составная единица
    result.put("XBA", new CurrencyDataImpl("XBA", "XBA", 2));
    // Европейская денежная единица
    result.put("XBB", new CurrencyDataImpl("XBB", "XBB", 2));
    // расчетная единица европейского валютного соглашения (XBC)
    result.put("XBC", new CurrencyDataImpl("XBC", "XBC", 2));
    // расчетная единица европейского валютного соглашения (XBD)
    result.put("XBD", new CurrencyDataImpl("XBD", "XBD", 2));
    // Восточно-карибский доллар
    result.put("XCD", new CurrencyDataImpl("XCD", "EC$", 2));
    // СДР (специальные права заимствования)
    result.put("XDR", new CurrencyDataImpl("XDR", "XDR", 2));
    // ЭКЮ (единица европейской валюты)
    result.put("XEU", new CurrencyDataImpl("XEU", "XEU", 2));
    // Французский золотой франк
    result.put("XFO", new CurrencyDataImpl("XFO", "XFO", 2));
    // Французский UIC-франк
    result.put("XFU", new CurrencyDataImpl("XFU", "XFU", 2));
    // Франк КФА ВСЕАО
    result.put("XOF", new CurrencyDataImpl("XOF", "CFA", 0));
    // Палладий
    result.put("XPD", new CurrencyDataImpl("XPD", "XPD", 2));
    // Франк КФП
    result.put("XPF", new CurrencyDataImpl("XPF", "CFPF", 0));
    // Платина
    result.put("XPT", new CurrencyDataImpl("XPT", "XPT", 2));
    // единица RINET-фондов
    result.put("XRE", new CurrencyDataImpl("XRE", "XRE", 2));
    // тестовый валютный код
    result.put("XTS", new CurrencyDataImpl("XTS", "XTS", 2));
    // Неизвестная или недействительная валюта
    result.put("XXX", new CurrencyDataImpl("XXX", "XXX", 2));
    // Йеменский динар
    result.put("YDD", new CurrencyDataImpl("YDD", "YDD", 130));
    // Йеменский риал
    result.put("YER", new CurrencyDataImpl("YER", "YR", 0, "YER"));
    // Югославский твердый динар
    result.put("YUD", new CurrencyDataImpl("YUD", "YUD", 130));
    // Югославский новый динар
    result.put("YUM", new CurrencyDataImpl("YUM", "YUM", 130));
    // Югославский динар
    result.put("YUN", new CurrencyDataImpl("YUN", "YUN", 130));
    // Южноафриканский рэнд (финансовый)
    result.put("ZAL", new CurrencyDataImpl("ZAL", "ZAL", 2));
    // Южноафриканский рэнд
    result.put("ZAR", new CurrencyDataImpl("ZAR", "R", 2, "ZAR"));
    // Квача (замбийская)
    result.put("ZMK", new CurrencyDataImpl("ZMK", "ZK", 0));
    // Новый заир
    result.put("ZRN", new CurrencyDataImpl("ZRN", "NZ", 130));
    // Заир
    result.put("ZRZ", new CurrencyDataImpl("ZRZ", "ZRZ", 130));
    // Доллар Зимбабве
    result.put("ZWD", new CurrencyDataImpl("ZWD", "Z$", 128));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // Андоррская песета
      "ADP": [ "ADP", "ADP", 128],
      // Дирхам (ОАЭ)
      "AED": [ "AED", "DH", 2, "DH"],
      // Афгани (1927-2002)
      "AFA": [ "AFA", "AFA", 130],
      // Афгани
      "AFN": [ "AFN", "Af", 0],
      // Албанский лек
      "ALL": [ "ALL", "ALL", 0],
      // Армянский драм
      "AMD": [ "AMD", "AMD", 0],
      // Нидерландский антильский гульден
      "ANG": [ "ANG", "NAf.", 2],
      // Ангольская кванза
      "AOA": [ "AOA", "Kz", 2],
      // Ангольская кванза (1977-1990)
      "AOK": [ "AOK", "AOK", 130],
      // Ангольская новая кванза (1990-2000)
      "AON": [ "AON", "AON", 130],
      // Ангольская кванза реюстадо (1995-1999)
      "AOR": [ "AOR", "AOR", 130],
      // Аргентинский аустрал
      "ARA": [ "ARA", "₳", 130],
      // ARL
      "ARL": [ "ARL", "$L", 130],
      // ARM
      "ARM": [ "ARM", "m$n", 130],
      // Аргентинское песо (1983-1985)
      "ARP": [ "ARP", "ARP", 130],
      // Аргентинское песо
      "ARS": [ "ARS", "AR$", 2, "AR$"],
      // Австрийский шиллинг
      "ATS": [ "ATS", "ATS", 130],
      // Австралийский доллар
      "AUD": [ "AUD", "AU$", 2, "AU$"],
      // Арубанский гульден
      "AWG": [ "AWG", "Afl.", 2],
      // Старый азербайджанский манат
      "AZM": [ "AZM", "AZM", 130],
      // Азербайджанский манат
      "AZN": [ "AZN", "man.", 2],
      // Динар Боснии и Герцеговины
      "BAD": [ "BAD", "BAD", 130],
      // Конвертируемая марка Боснии и Герцеговины
      "BAM": [ "BAM", "KM", 2],
      // Барбадосский доллар
      "BBD": [ "BBD", "Bds$", 2],
      // Бангладешская така
      "BDT": [ "BDT", "Tk", 2, "Tk"],
      // Бельгийский франк (конвертируемый)
      "BEC": [ "BEC", "BEC", 2],
      // Бельгийский франк
      "BEF": [ "BEF", "BF", 130],
      // Бельгийский франк (финансовый)
      "BEL": [ "BEL", "BEL", 2],
      // Лев
      "BGL": [ "BGL", "BGL", 130],
      // Болгарский лев
      "BGN": [ "BGN", "BGN", 2],
      // Бахрейнский динар
      "BHD": [ "BHD", "BD", 3],
      // Бурундийский франк
      "BIF": [ "BIF", "FBu", 0],
      // Бермудский доллар
      "BMD": [ "BMD", "BD$", 2],
      // Брунейский доллар
      "BND": [ "BND", "BN$", 2],
      // Боливиано
      "BOB": [ "BOB", "Bs", 2],
      // Боливийское песо
      "BOP": [ "BOP", "$b.", 130],
      // Боливийский мвдол
      "BOV": [ "BOV", "BOV", 2],
      // Бразильский новый крузейро (1967-1986)
      "BRB": [ "BRB", "BRB", 130],
      // Бразильское крузадо
      "BRC": [ "BRC", "BRC", 130],
      // Бразильский крузейро (1990-1993)
      "BRE": [ "BRE", "BRE", 130],
      // Бразильский реал
      "BRL": [ "BRL", "R$", 2, "R$"],
      // Бразильское новое крузадо
      "BRN": [ "BRN", "BRN", 130],
      // Бразильский крузейро
      "BRR": [ "BRR", "BRR", 130],
      // Багамский доллар
      "BSD": [ "BSD", "BS$", 2],
      // Нгултрум
      "BTN": [ "BTN", "Nu.", 2],
      // Джа
      "BUK": [ "BUK", "BUK", 130],
      // Ботсванская пула
      "BWP": [ "BWP", "BWP", 2],
      // Белорусский рубль (1994-1999)
      "BYB": [ "BYB", "BYB", 130],
      // Белорусский рубль
      "BYR": [ "BYR", "BYR", 0],
      // Белизский доллар
      "BZD": [ "BZD", "BZ$", 2],
      // Канадский доллар
      "CAD": [ "CAD", "CA$", 2, "C$"],
      // Конголезский франк
      "CDF": [ "CDF", "CDF", 2],
      // WIR евро
      "CHE": [ "CHE", "CHE", 2],
      // Швейцарский франк
      "CHF": [ "CHF", "Fr.", 2, "CHF"],
      // WIR франк
      "CHW": [ "CHW", "CHW", 2],
      // CLE
      "CLE": [ "CLE", "Eº", 130],
      // Условная расчетная единица Чили
      "CLF": [ "CLF", "CLF", 0],
      // Чилийское песо
      "CLP": [ "CLP", "CL$", 0, "CL$"],
      // Юань Ренминби
      "CNY": [ "CNY", "CN¥", 2, "RMB¥"],
      // Колумбийское песо
      "COP": [ "COP", "CO$", 0, "COL$"],
      // Единица реальной стоимости Колумбии
      "COU": [ "COU", "COU", 2],
      // Костариканский колон
      "CRC": [ "CRC", "₡", 0, "CR₡"],
      // Старый Сербский динар
      "CSD": [ "CSD", "CSD", 130],
      // Чехословацкая твердая крона
      "CSK": [ "CSK", "CSK", 130],
      // CUC
      "CUC": [ "CUC", "CUC$", 2],
      // Кубинское песо
      "CUP": [ "CUP", "CU$", 2, "$MN"],
      // Эскудо Кабо-Верде
      "CVE": [ "CVE", "CV$", 2],
      // Кипрский фунт
      "CYP": [ "CYP", "CY£", 130],
      // Чешская крона
      "CZK": [ "CZK", "Kč", 2, "Kč"],
      // Восточногерманская марка
      "DDM": [ "DDM", "DDM", 130],
      // Немецкая марка
      "DEM": [ "DEM", "DM", 130],
      // Франк Джибути
      "DJF": [ "DJF", "Fdj", 0],
      // Датская крона
      "DKK": [ "DKK", "Dkr", 2, "kr"],
      // Доминиканское песо
      "DOP": [ "DOP", "RD$", 2, "RD$"],
      // Алжирский динар
      "DZD": [ "DZD", "DA", 2],
      // Эквадорский сукре
      "ECS": [ "ECS", "ECS", 130],
      // Постоянная единица стоимости Эквадора
      "ECV": [ "ECV", "ECV", 2],
      // Эстонская крона
      "EEK": [ "EEK", "Ekr", 2],
      // Египетский фунт
      "EGP": [ "EGP", "EG£", 2, "LE"],
      // EQE
      "EQE": [ "EQE", "EQE", 130],
      // Накфа
      "ERN": [ "ERN", "Nfk", 2],
      // Испанская песета (А)
      "ESA": [ "ESA", "ESA", 2],
      // Испанская песета (конвертируемая)
      "ESB": [ "ESB", "ESB", 2],
      // Испанская песета
      "ESP": [ "ESP", "Pts", 128],
      // Эфиопский быр
      "ETB": [ "ETB", "Br", 2],
      // Евро
      "EUR": [ "EUR", "€", 2, "€"],
      // Финская марка
      "FIM": [ "FIM", "mk", 130],
      // Доллар Фиджи
      "FJD": [ "FJD", "FJ$", 2],
      // Фунт Фолклендских островов
      "FKP": [ "FKP", "FK£", 2],
      // Французский франк
      "FRF": [ "FRF", "₣", 130],
      // Английский фунт стерлингов
      "GBP": [ "GBP", "£", 2, "GB£"],
      // Грузинский купон
      "GEK": [ "GEK", "GEK", 130],
      // Грузинский лари
      "GEL": [ "GEL", "GEL", 2],
      // Ганский седи
      "GHC": [ "GHC", "₵", 130],
      // Седи Ганы
      "GHS": [ "GHS", "GH₵", 2],
      // Гибралтарский фунт
      "GIP": [ "GIP", "GI£", 2],
      // Гамбийский даласи
      "GMD": [ "GMD", "GMD", 2],
      // Гвинейский франк
      "GNF": [ "GNF", "FG", 0],
      // Гвинейская сили
      "GNS": [ "GNS", "GNS", 130],
      // Эквеле экваториальной Гвинеи
      "GQE": [ "GQE", "GQE", 130],
      // Греческая драхма
      "GRD": [ "GRD", "₯", 130],
      // Гватемальский кетсаль
      "GTQ": [ "GTQ", "GTQ", 2],
      // Эскудо Португальской Гвинеи
      "GWE": [ "GWE", "GWE", 130],
      // Песо Гвинеи-Бисау
      "GWP": [ "GWP", "GWP", 2],
      // Гайанский доллар
      "GYD": [ "GYD", "GY$", 0],
      // Гонконгский доллар
      "HKD": [ "HKD", "HK$", 2, "HK$"],
      // Гондурасская лемпира
      "HNL": [ "HNL", "HNL", 2],
      // Хорватский динар
      "HRD": [ "HRD", "HRD", 130],
      // Хорватская куна
      "HRK": [ "HRK", "kn", 2],
      // Гаитянский гурд
      "HTG": [ "HTG", "HTG", 2],
      // Венгерский форинт
      "HUF": [ "HUF", "Ft", 0],
      // Индонезийская рупия
      "IDR": [ "IDR", "Rp", 0],
      // Ирландский фунт
      "IEP": [ "IEP", "IR£", 130],
      // Израильский фунт
      "ILP": [ "ILP", "I£", 130],
      // Новый израильский шекель
      "ILS": [ "ILS", "₪", 2, "IL₪"],
      // Индийская рупия
      "INR": [ "INR", "Rs", 2, "Rs"],
      // Иракский динар
      "IQD": [ "IQD", "IQD", 0],
      // Иранский риал
      "IRR": [ "IRR", "IRR", 0],
      // Исландская крона
      "ISK": [ "ISK", "Ikr", 0, "kr"],
      // Итальянская лира
      "ITL": [ "ITL", "IT₤", 128],
      // Ямайский доллар
      "JMD": [ "JMD", "J$", 2, "JA$"],
      // Иорданский динар
      "JOD": [ "JOD", "JD", 3],
      // Японская иена
      "JPY": [ "JPY", "JP¥", 0, "JP¥"],
      // Кенийский шиллинг
      "KES": [ "KES", "Ksh", 2],
      // Киргизский сом
      "KGS": [ "KGS", "KGS", 2],
      // Камбоджийский риель
      "KHR": [ "KHR", "KHR", 2],
      // Франк Коморских островов
      "KMF": [ "KMF", "CF", 0],
      // Северо-корейская вона
      "KPW": [ "KPW", "KPW", 0],
      // Вона Республики Кореи
      "KRW": [ "KRW", "₩", 0, "KR₩"],
      // Кувейтский динар
      "KWD": [ "KWD", "KD", 3],
      // Доллар Каймановых островов
      "KYD": [ "KYD", "KY$", 2],
      // Казахский тенге
      "KZT": [ "KZT", "KZT", 2],
      // Кип ЛНДР
      "LAK": [ "LAK", "₭", 0],
      // Ливанский фунт
      "LBP": [ "LBP", "LB£", 0],
      // Шри-Ланкийская рупия
      "LKR": [ "LKR", "SLRs", 2, "SLRs"],
      // Либерийский доллар
      "LRD": [ "LRD", "L$", 2],
      // Лоти
      "LSL": [ "LSL", "LSL", 2],
      // LSM
      "LSM": [ "LSM", "LSM", 130],
      // Литовский лит
      "LTL": [ "LTL", "Lt", 2],
      // Литовский талон
      "LTT": [ "LTT", "LTT", 130],
      // Конвертируемый франк Люксембурга
      "LUC": [ "LUC", "LUC", 2],
      // Люксембургский франк
      "LUF": [ "LUF", "LUF", 128],
      // Финансовый франк Люксембурга
      "LUL": [ "LUL", "LUL", 2],
      // Латвийский лат
      "LVL": [ "LVL", "Ls", 2],
      // Латвийский рубль
      "LVR": [ "LVR", "LVR", 130],
      // Ливийский динар
      "LYD": [ "LYD", "LD", 3],
      // Марокканский дирхам
      "MAD": [ "MAD", "MAD", 2],
      // Марокканский франк
      "MAF": [ "MAF", "MAF", 130],
      // Молдавский лей
      "MDL": [ "MDL", "MDL", 2],
      // Ариари
      "MGA": [ "MGA", "MGA", 0],
      // Малагасийский франк
      "MGF": [ "MGF", "MGF", 128],
      // Македонский динар
      "MKD": [ "MKD", "MKD", 2],
      // Малийский франк
      "MLF": [ "MLF", "MLF", 130],
      // Кьят
      "MMK": [ "MMK", "MMK", 0],
      // Монгольский тугрик
      "MNT": [ "MNT", "₮", 0, "MN₮"],
      // Патака
      "MOP": [ "MOP", "MOP$", 2],
      // Мавританская угия
      "MRO": [ "MRO", "UM", 0],
      // Мальтийская лира
      "MTL": [ "MTL", "Lm", 130],
      // Мальтийский фунт
      "MTP": [ "MTP", "MT£", 130],
      // Маврикийская рупия
      "MUR": [ "MUR", "MURs", 0],
      // Мальдивская руфия
      "MVR": [ "MVR", "MVR", 2],
      // Малавийская квача
      "MWK": [ "MWK", "MWK", 2],
      // Мексиканское новое песо
      "MXN": [ "MXN", "Mex$", 2, "Mex$"],
      // Мексиканское серебряное песо (1861-1992)
      "MXP": [ "MXP", "MX$", 130],
      // Мексиканская пересчетная единица (UDI)
      "MXV": [ "MXV", "MXV", 2],
      // Малайзийский ринггит
      "MYR": [ "MYR", "RM", 2, "RM"],
      // Мозамбикское эскудо
      "MZE": [ "MZE", "MZE", 130],
      // Старый мозамбикский метикал
      "MZM": [ "MZM", "Mt", 130],
      // Метикал
      "MZN": [ "MZN", "MTn", 2],
      // Доллар Намибии
      "NAD": [ "NAD", "N$", 2],
      // Нигерийская найра
      "NGN": [ "NGN", "₦", 2],
      // Никарагуанская кордоба
      "NIC": [ "NIC", "NIC", 130],
      // Золотая кордоба
      "NIO": [ "NIO", "C$", 2],
      // Нидерландский гульден
      "NLG": [ "NLG", "fl", 130],
      // Норвежская крона
      "NOK": [ "NOK", "Nkr", 2, "NOkr"],
      // Непальская рупия
      "NPR": [ "NPR", "NPRs", 2],
      // Новозеландский доллар
      "NZD": [ "NZD", "NZ$", 2],
      // Оманский риал
      "OMR": [ "OMR", "OMR", 3],
      // Панамское бальбоа
      "PAB": [ "PAB", "B/.", 2, "B/."],
      // Перуанское инти
      "PEI": [ "PEI", "I/.", 130],
      // Перуанский новый соль
      "PEN": [ "PEN", "S/.", 2, "S/."],
      // Перуанский соль
      "PES": [ "PES", "PES", 130],
      // Кина
      "PGK": [ "PGK", "PGK", 2],
      // Филиппинское песо
      "PHP": [ "PHP", "₱", 2, "PHP"],
      // Пакистанская рупия
      "PKR": [ "PKR", "PKRs", 0, "PKRs."],
      // Польский злотый
      "PLN": [ "PLN", "zł", 2],
      // Злотый
      "PLZ": [ "PLZ", "PLZ", 130],
      // Португальское эскудо
      "PTE": [ "PTE", "Esc", 130],
      // Парагвайский гуарани
      "PYG": [ "PYG", "₲", 0],
      // Катарский риал
      "QAR": [ "QAR", "QR", 2],
      // Родезийский доллар
      "RHD": [ "RHD", "RH$", 130],
      // Старый Румынский лей
      "ROL": [ "ROL", "ROL", 130],
      // Румынский лей
      "RON": [ "RON", "RON", 2],
      // Сербский динар
      "RSD": [ "RSD", "din.", 0],
      // Российский рубль
      "RUB": [ "RUB", "руб.", 2, "руб"],
      // Российский рубль (1991-1998)
      "RUR": [ "RUR", "р.", 130],
      // Франк Руанды
      "RWF": [ "RWF", "RWF", 0],
      // Саудовский риал
      "SAR": [ "SAR", "SR", 2, "SR"],
      // Доллар Соломоновых островов
      "SBD": [ "SBD", "SI$", 2],
      // Сейшельская рупия
      "SCR": [ "SCR", "SRe", 2],
      // Суданский динар
      "SDD": [ "SDD", "LSd", 130],
      // Суданский фунт
      "SDG": [ "SDG", "SDG", 2],
      // Старый суданский фунт
      "SDP": [ "SDP", "SDP", 130],
      // Шведская крона
      "SEK": [ "SEK", "Skr", 2, "kr"],
      // Сингапурский доллар
      "SGD": [ "SGD", "S$", 2, "S$"],
      // Фунт острова Святой Елены
      "SHP": [ "SHP", "SH£", 2],
      // Словенский толар
      "SIT": [ "SIT", "SIT", 130],
      // Словацкая крона
      "SKK": [ "SKK", "Sk", 130],
      // Леоне
      "SLL": [ "SLL", "Le", 0],
      // Сомалийский шиллинг
      "SOS": [ "SOS", "Ssh", 0],
      // Суринамский доллар
      "SRD": [ "SRD", "SR$", 2],
      // Суринамский гульден
      "SRG": [ "SRG", "Sf", 130],
      // Добра
      "STD": [ "STD", "Db", 0],
      // Рубль СССР
      "SUR": [ "SUR", "SUR", 130],
      // Сальвадорский колон
      "SVC": [ "SVC", "SV₡", 130],
      // Сирийский фунт
      "SYP": [ "SYP", "SY£", 0],
      // Свазилендский лилангени
      "SZL": [ "SZL", "SZL", 2],
      // Таиландский бат
      "THB": [ "THB", "฿", 2, "THB"],
      // Таджикский рубль
      "TJR": [ "TJR", "TJR", 130],
      // Таджикский сомони
      "TJS": [ "TJS", "TJS", 2],
      // Туркменский манат
      "TMM": [ "TMM", "TMM", 128],
      // Тунисский динар
      "TND": [ "TND", "DT", 3],
      // Паанга
      "TOP": [ "TOP", "T$", 2],
      // Тиморское эскудо
      "TPE": [ "TPE", "TPE", 130],
      // Турецкая лира
      "TRL": [ "TRL", "TRL", 128],
      // Новая турецкая лира
      "TRY": [ "TRY", "TL", 2, "YTL"],
      // Доллар Тринидада и Тобаго
      "TTD": [ "TTD", "TT$", 2],
      // Новый тайваньский доллар
      "TWD": [ "TWD", "NT$", 2, "NT$"],
      // Танзанийский шиллинг
      "TZS": [ "TZS", "TSh", 0],
      // Украинская гривна
      "UAH": [ "UAH", "₴", 2],
      // Карбованец (украинский)
      "UAK": [ "UAK", "UAK", 130],
      // Старый угандийский шиллинг
      "UGS": [ "UGS", "UGS", 130],
      // Угандийский шиллинг
      "UGX": [ "UGX", "USh", 0],
      // Доллар США
      "USD": [ "USD", "$", 2, "US$"],
      // Доллар США следующего дня
      "USN": [ "USN", "USN", 2],
      // Доллар США текущего дня
      "USS": [ "USS", "USS", 2],
      // Уругвайский песо (индекс инфляции)
      "UYI": [ "UYI", "UYI", 2],
      // Уругвайское старое песо (1975-1993)
      "UYP": [ "UYP", "UYP", 130],
      // Уругвайское песо
      "UYU": [ "UYU", "$U", 2, "UY$"],
      // Узбекский сум
      "UZS": [ "UZS", "UZS", 0],
      // Венесуэльский боливар
      "VEB": [ "VEB", "VEB", 130],
      // Венесуэльский боливар фуэрте
      "VEF": [ "VEF", "Bs.F.", 2],
      // Вьетнамский донг
      "VND": [ "VND", "₫", 24, "₫"],
      // Вату
      "VUV": [ "VUV", "VT", 0],
      // Тала
      "WST": [ "WST", "WS$", 2],
      // Франк КФА ВЕАС
      "XAF": [ "XAF", "FCFA", 0],
      // Серебро
      "XAG": [ "XAG", "XAG", 2],
      // Золото
      "XAU": [ "XAU", "XAU", 2],
      // Европейская составная единица
      "XBA": [ "XBA", "XBA", 2],
      // Европейская денежная единица
      "XBB": [ "XBB", "XBB", 2],
      // расчетная единица европейского валютного соглашения (XBC)
      "XBC": [ "XBC", "XBC", 2],
      // расчетная единица европейского валютного соглашения (XBD)
      "XBD": [ "XBD", "XBD", 2],
      // Восточно-карибский доллар
      "XCD": [ "XCD", "EC$", 2],
      // СДР (специальные права заимствования)
      "XDR": [ "XDR", "XDR", 2],
      // ЭКЮ (единица европейской валюты)
      "XEU": [ "XEU", "XEU", 2],
      // Французский золотой франк
      "XFO": [ "XFO", "XFO", 2],
      // Французский UIC-франк
      "XFU": [ "XFU", "XFU", 2],
      // Франк КФА ВСЕАО
      "XOF": [ "XOF", "CFA", 0],
      // Палладий
      "XPD": [ "XPD", "XPD", 2],
      // Франк КФП
      "XPF": [ "XPF", "CFPF", 0],
      // Платина
      "XPT": [ "XPT", "XPT", 2],
      // единица RINET-фондов
      "XRE": [ "XRE", "XRE", 2],
      // тестовый валютный код
      "XTS": [ "XTS", "XTS", 2],
      // Неизвестная или недействительная валюта
      "XXX": [ "XXX", "XXX", 2],
      // Йеменский динар
      "YDD": [ "YDD", "YDD", 130],
      // Йеменский риал
      "YER": [ "YER", "YR", 0, "YER"],
      // Югославский твердый динар
      "YUD": [ "YUD", "YUD", 130],
      // Югославский новый динар
      "YUM": [ "YUM", "YUM", 130],
      // Югославский динар
      "YUN": [ "YUN", "YUN", 130],
      // Южноафриканский рэнд (финансовый)
      "ZAL": [ "ZAL", "ZAL", 2],
      // Южноафриканский рэнд
      "ZAR": [ "ZAR", "R", 2, "ZAR"],
      // Квача (замбийская)
      "ZMK": [ "ZMK", "ZK", 0],
      // Новый заир
      "ZRN": [ "ZRN", "NZ", 130],
      // Заир
      "ZRZ": [ "ZRZ", "ZRZ", 130],
      // Доллар Зимбабве
      "ZWD": [ "ZWD", "Z$", 128],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("ADP", "Андоррская песета");
    result.put("AED", "Дирхам (ОАЭ)");
    result.put("AFA", "Афгани (1927-2002)");
    result.put("AFN", "Афгани");
    result.put("ALL", "Албанский лек");
    result.put("AMD", "Армянский драм");
    result.put("ANG", "Нидерландский антильский гульден");
    result.put("AOA", "Ангольская кванза");
    result.put("AOK", "Ангольская кванза (1977-1990)");
    result.put("AON", "Ангольская новая кванза (1990-2000)");
    result.put("AOR", "Ангольская кванза реюстадо (1995-1999)");
    result.put("ARA", "Аргентинский аустрал");
    result.put("ARP", "Аргентинское песо (1983-1985)");
    result.put("ARS", "Аргентинское песо");
    result.put("ATS", "Австрийский шиллинг");
    result.put("AUD", "Австралийский доллар");
    result.put("AWG", "Арубанский гульден");
    result.put("AZM", "Старый азербайджанский манат");
    result.put("AZN", "Азербайджанский манат");
    result.put("BAD", "Динар Боснии и Герцеговины");
    result.put("BAM", "Конвертируемая марка Боснии и Герцеговины");
    result.put("BBD", "Барбадосский доллар");
    result.put("BDT", "Бангладешская така");
    result.put("BEC", "Бельгийский франк (конвертируемый)");
    result.put("BEF", "Бельгийский франк");
    result.put("BEL", "Бельгийский франк (финансовый)");
    result.put("BGL", "Лев");
    result.put("BGN", "Болгарский лев");
    result.put("BHD", "Бахрейнский динар");
    result.put("BIF", "Бурундийский франк");
    result.put("BMD", "Бермудский доллар");
    result.put("BND", "Брунейский доллар");
    result.put("BOB", "Боливиано");
    result.put("BOP", "Боливийское песо");
    result.put("BOV", "Боливийский мвдол");
    result.put("BRB", "Бразильский новый крузейро (1967-1986)");
    result.put("BRC", "Бразильское крузадо");
    result.put("BRE", "Бразильский крузейро (1990-1993)");
    result.put("BRL", "Бразильский реал");
    result.put("BRN", "Бразильское новое крузадо");
    result.put("BRR", "Бразильский крузейро");
    result.put("BSD", "Багамский доллар");
    result.put("BTN", "Нгултрум");
    result.put("BUK", "Джа");
    result.put("BWP", "Ботсванская пула");
    result.put("BYB", "Белорусский рубль (1994-1999)");
    result.put("BYR", "Белорусский рубль");
    result.put("BZD", "Белизский доллар");
    result.put("CAD", "Канадский доллар");
    result.put("CDF", "Конголезский франк");
    result.put("CHE", "WIR евро");
    result.put("CHF", "Швейцарский франк");
    result.put("CHW", "WIR франк");
    result.put("CLF", "Условная расчетная единица Чили");
    result.put("CLP", "Чилийское песо");
    result.put("CNY", "Юань Ренминби");
    result.put("COP", "Колумбийское песо");
    result.put("COU", "Единица реальной стоимости Колумбии");
    result.put("CRC", "Костариканский колон");
    result.put("CSD", "Старый Сербский динар");
    result.put("CSK", "Чехословацкая твердая крона");
    result.put("CUP", "Кубинское песо");
    result.put("CVE", "Эскудо Кабо-Верде");
    result.put("CYP", "Кипрский фунт");
    result.put("CZK", "Чешская крона");
    result.put("DDM", "Восточногерманская марка");
    result.put("DEM", "Немецкая марка");
    result.put("DJF", "Франк Джибути");
    result.put("DKK", "Датская крона");
    result.put("DOP", "Доминиканское песо");
    result.put("DZD", "Алжирский динар");
    result.put("ECS", "Эквадорский сукре");
    result.put("ECV", "Постоянная единица стоимости Эквадора");
    result.put("EEK", "Эстонская крона");
    result.put("EGP", "Египетский фунт");
    result.put("ERN", "Накфа");
    result.put("ESA", "Испанская песета (А)");
    result.put("ESB", "Испанская песета (конвертируемая)");
    result.put("ESP", "Испанская песета");
    result.put("ETB", "Эфиопский быр");
    result.put("EUR", "Евро");
    result.put("FIM", "Финская марка");
    result.put("FJD", "Доллар Фиджи");
    result.put("FKP", "Фунт Фолклендских островов");
    result.put("FRF", "Французский франк");
    result.put("GBP", "Английский фунт стерлингов");
    result.put("GEK", "Грузинский купон");
    result.put("GEL", "Грузинский лари");
    result.put("GHC", "Ганский седи");
    result.put("GHS", "Седи Ганы");
    result.put("GIP", "Гибралтарский фунт");
    result.put("GMD", "Гамбийский даласи");
    result.put("GNF", "Гвинейский франк");
    result.put("GNS", "Гвинейская сили");
    result.put("GQE", "Эквеле экваториальной Гвинеи");
    result.put("GRD", "Греческая драхма");
    result.put("GTQ", "Гватемальский кетсаль");
    result.put("GWE", "Эскудо Португальской Гвинеи");
    result.put("GWP", "Песо Гвинеи-Бисау");
    result.put("GYD", "Гайанский доллар");
    result.put("HKD", "Гонконгский доллар");
    result.put("HNL", "Гондурасская лемпира");
    result.put("HRD", "Хорватский динар");
    result.put("HRK", "Хорватская куна");
    result.put("HTG", "Гаитянский гурд");
    result.put("HUF", "Венгерский форинт");
    result.put("IDR", "Индонезийская рупия");
    result.put("IEP", "Ирландский фунт");
    result.put("ILP", "Израильский фунт");
    result.put("ILS", "Новый израильский шекель");
    result.put("INR", "Индийская рупия");
    result.put("IQD", "Иракский динар");
    result.put("IRR", "Иранский риал");
    result.put("ISK", "Исландская крона");
    result.put("ITL", "Итальянская лира");
    result.put("JMD", "Ямайский доллар");
    result.put("JOD", "Иорданский динар");
    result.put("JPY", "Японская иена");
    result.put("KES", "Кенийский шиллинг");
    result.put("KGS", "Киргизский сом");
    result.put("KHR", "Камбоджийский риель");
    result.put("KMF", "Франк Коморских островов");
    result.put("KPW", "Северо-корейская вона");
    result.put("KRW", "Вона Республики Кореи");
    result.put("KWD", "Кувейтский динар");
    result.put("KYD", "Доллар Каймановых островов");
    result.put("KZT", "Казахский тенге");
    result.put("LAK", "Кип ЛНДР");
    result.put("LBP", "Ливанский фунт");
    result.put("LKR", "Шри-Ланкийская рупия");
    result.put("LRD", "Либерийский доллар");
    result.put("LSL", "Лоти");
    result.put("LTL", "Литовский лит");
    result.put("LTT", "Литовский талон");
    result.put("LUC", "Конвертируемый франк Люксембурга");
    result.put("LUF", "Люксембургский франк");
    result.put("LUL", "Финансовый франк Люксембурга");
    result.put("LVL", "Латвийский лат");
    result.put("LVR", "Латвийский рубль");
    result.put("LYD", "Ливийский динар");
    result.put("MAD", "Марокканский дирхам");
    result.put("MAF", "Марокканский франк");
    result.put("MDL", "Молдавский лей");
    result.put("MGA", "Ариари");
    result.put("MGF", "Малагасийский франк");
    result.put("MKD", "Македонский динар");
    result.put("MLF", "Малийский франк");
    result.put("MMK", "Кьят");
    result.put("MNT", "Монгольский тугрик");
    result.put("MOP", "Патака");
    result.put("MRO", "Мавританская угия");
    result.put("MTL", "Мальтийская лира");
    result.put("MTP", "Мальтийский фунт");
    result.put("MUR", "Маврикийская рупия");
    result.put("MVR", "Мальдивская руфия");
    result.put("MWK", "Малавийская квача");
    result.put("MXN", "Мексиканское новое песо");
    result.put("MXP", "Мексиканское серебряное песо (1861-1992)");
    result.put("MXV", "Мексиканская пересчетная единица (UDI)");
    result.put("MYR", "Малайзийский ринггит");
    result.put("MZE", "Мозамбикское эскудо");
    result.put("MZM", "Старый мозамбикский метикал");
    result.put("MZN", "Метикал");
    result.put("NAD", "Доллар Намибии");
    result.put("NGN", "Нигерийская найра");
    result.put("NIC", "Никарагуанская кордоба");
    result.put("NIO", "Золотая кордоба");
    result.put("NLG", "Нидерландский гульден");
    result.put("NOK", "Норвежская крона");
    result.put("NPR", "Непальская рупия");
    result.put("NZD", "Новозеландский доллар");
    result.put("OMR", "Оманский риал");
    result.put("PAB", "Панамское бальбоа");
    result.put("PEI", "Перуанское инти");
    result.put("PEN", "Перуанский новый соль");
    result.put("PES", "Перуанский соль");
    result.put("PGK", "Кина");
    result.put("PHP", "Филиппинское песо");
    result.put("PKR", "Пакистанская рупия");
    result.put("PLN", "Польский злотый");
    result.put("PLZ", "Злотый");
    result.put("PTE", "Португальское эскудо");
    result.put("PYG", "Парагвайский гуарани");
    result.put("QAR", "Катарский риал");
    result.put("RHD", "Родезийский доллар");
    result.put("ROL", "Старый Румынский лей");
    result.put("RON", "Румынский лей");
    result.put("RSD", "Сербский динар");
    result.put("RUB", "Российский рубль");
    result.put("RUR", "Российский рубль (1991-1998)");
    result.put("RWF", "Франк Руанды");
    result.put("SAR", "Саудовский риал");
    result.put("SBD", "Доллар Соломоновых островов");
    result.put("SCR", "Сейшельская рупия");
    result.put("SDD", "Суданский динар");
    result.put("SDG", "Суданский фунт");
    result.put("SDP", "Старый суданский фунт");
    result.put("SEK", "Шведская крона");
    result.put("SGD", "Сингапурский доллар");
    result.put("SHP", "Фунт острова Святой Елены");
    result.put("SIT", "Словенский толар");
    result.put("SKK", "Словацкая крона");
    result.put("SLL", "Леоне");
    result.put("SOS", "Сомалийский шиллинг");
    result.put("SRD", "Суринамский доллар");
    result.put("SRG", "Суринамский гульден");
    result.put("STD", "Добра");
    result.put("SUR", "Рубль СССР");
    result.put("SVC", "Сальвадорский колон");
    result.put("SYP", "Сирийский фунт");
    result.put("SZL", "Свазилендский лилангени");
    result.put("THB", "Таиландский бат");
    result.put("TJR", "Таджикский рубль");
    result.put("TJS", "Таджикский сомони");
    result.put("TMM", "Туркменский манат");
    result.put("TND", "Тунисский динар");
    result.put("TOP", "Паанга");
    result.put("TPE", "Тиморское эскудо");
    result.put("TRL", "Турецкая лира");
    result.put("TRY", "Новая турецкая лира");
    result.put("TTD", "Доллар Тринидада и Тобаго");
    result.put("TWD", "Новый тайваньский доллар");
    result.put("TZS", "Танзанийский шиллинг");
    result.put("UAH", "Украинская гривна");
    result.put("UAK", "Карбованец (украинский)");
    result.put("UGS", "Старый угандийский шиллинг");
    result.put("UGX", "Угандийский шиллинг");
    result.put("USD", "Доллар США");
    result.put("USN", "Доллар США следующего дня");
    result.put("USS", "Доллар США текущего дня");
    result.put("UYI", "Уругвайский песо (индекс инфляции)");
    result.put("UYP", "Уругвайское старое песо (1975-1993)");
    result.put("UYU", "Уругвайское песо");
    result.put("UZS", "Узбекский сум");
    result.put("VEB", "Венесуэльский боливар");
    result.put("VEF", "Венесуэльский боливар фуэрте");
    result.put("VND", "Вьетнамский донг");
    result.put("VUV", "Вату");
    result.put("WST", "Тала");
    result.put("XAF", "Франк КФА ВЕАС");
    result.put("XAG", "Серебро");
    result.put("XAU", "Золото");
    result.put("XBA", "Европейская составная единица");
    result.put("XBB", "Европейская денежная единица");
    result.put("XBC", "расчетная единица европейского валютного соглашения (XBC)");
    result.put("XBD", "расчетная единица европейского валютного соглашения (XBD)");
    result.put("XCD", "Восточно-карибский доллар");
    result.put("XDR", "СДР (специальные права заимствования)");
    result.put("XEU", "ЭКЮ (единица европейской валюты)");
    result.put("XFO", "Французский золотой франк");
    result.put("XFU", "Французский UIC-франк");
    result.put("XOF", "Франк КФА ВСЕАО");
    result.put("XPD", "Палладий");
    result.put("XPF", "Франк КФП");
    result.put("XPT", "Платина");
    result.put("XRE", "единица RINET-фондов");
    result.put("XTS", "тестовый валютный код");
    result.put("XXX", "Неизвестная или недействительная валюта");
    result.put("YDD", "Йеменский динар");
    result.put("YER", "Йеменский риал");
    result.put("YUD", "Югославский твердый динар");
    result.put("YUM", "Югославский новый динар");
    result.put("YUN", "Югославский динар");
    result.put("ZAL", "Южноафриканский рэнд (финансовый)");
    result.put("ZAR", "Южноафриканский рэнд");
    result.put("ZMK", "Квача (замбийская)");
    result.put("ZRN", "Новый заир");
    result.put("ZRZ", "Заир");
    result.put("ZWD", "Доллар Зимбабве");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "ADP": "Андоррская песета",
      "AED": "Дирхам (ОАЭ)",
      "AFA": "Афгани (1927-2002)",
      "AFN": "Афгани",
      "ALL": "Албанский лек",
      "AMD": "Армянский драм",
      "ANG": "Нидерландский антильский гульден",
      "AOA": "Ангольская кванза",
      "AOK": "Ангольская кванза (1977-1990)",
      "AON": "Ангольская новая кванза (1990-2000)",
      "AOR": "Ангольская кванза реюстадо (1995-1999)",
      "ARA": "Аргентинский аустрал",
      "ARP": "Аргентинское песо (1983-1985)",
      "ARS": "Аргентинское песо",
      "ATS": "Австрийский шиллинг",
      "AUD": "Австралийский доллар",
      "AWG": "Арубанский гульден",
      "AZM": "Старый азербайджанский манат",
      "AZN": "Азербайджанский манат",
      "BAD": "Динар Боснии и Герцеговины",
      "BAM": "Конвертируемая марка Боснии и Герцеговины",
      "BBD": "Барбадосский доллар",
      "BDT": "Бангладешская така",
      "BEC": "Бельгийский франк (конвертируемый)",
      "BEF": "Бельгийский франк",
      "BEL": "Бельгийский франк (финансовый)",
      "BGL": "Лев",
      "BGN": "Болгарский лев",
      "BHD": "Бахрейнский динар",
      "BIF": "Бурундийский франк",
      "BMD": "Бермудский доллар",
      "BND": "Брунейский доллар",
      "BOB": "Боливиано",
      "BOP": "Боливийское песо",
      "BOV": "Боливийский мвдол",
      "BRB": "Бразильский новый крузейро (1967-1986)",
      "BRC": "Бразильское крузадо",
      "BRE": "Бразильский крузейро (1990-1993)",
      "BRL": "Бразильский реал",
      "BRN": "Бразильское новое крузадо",
      "BRR": "Бразильский крузейро",
      "BSD": "Багамский доллар",
      "BTN": "Нгултрум",
      "BUK": "Джа",
      "BWP": "Ботсванская пула",
      "BYB": "Белорусский рубль (1994-1999)",
      "BYR": "Белорусский рубль",
      "BZD": "Белизский доллар",
      "CAD": "Канадский доллар",
      "CDF": "Конголезский франк",
      "CHE": "WIR евро",
      "CHF": "Швейцарский франк",
      "CHW": "WIR франк",
      "CLF": "Условная расчетная единица Чили",
      "CLP": "Чилийское песо",
      "CNY": "Юань Ренминби",
      "COP": "Колумбийское песо",
      "COU": "Единица реальной стоимости Колумбии",
      "CRC": "Костариканский колон",
      "CSD": "Старый Сербский динар",
      "CSK": "Чехословацкая твердая крона",
      "CUP": "Кубинское песо",
      "CVE": "Эскудо Кабо-Верде",
      "CYP": "Кипрский фунт",
      "CZK": "Чешская крона",
      "DDM": "Восточногерманская марка",
      "DEM": "Немецкая марка",
      "DJF": "Франк Джибути",
      "DKK": "Датская крона",
      "DOP": "Доминиканское песо",
      "DZD": "Алжирский динар",
      "ECS": "Эквадорский сукре",
      "ECV": "Постоянная единица стоимости Эквадора",
      "EEK": "Эстонская крона",
      "EGP": "Египетский фунт",
      "ERN": "Накфа",
      "ESA": "Испанская песета (А)",
      "ESB": "Испанская песета (конвертируемая)",
      "ESP": "Испанская песета",
      "ETB": "Эфиопский быр",
      "EUR": "Евро",
      "FIM": "Финская марка",
      "FJD": "Доллар Фиджи",
      "FKP": "Фунт Фолклендских островов",
      "FRF": "Французский франк",
      "GBP": "Английский фунт стерлингов",
      "GEK": "Грузинский купон",
      "GEL": "Грузинский лари",
      "GHC": "Ганский седи",
      "GHS": "Седи Ганы",
      "GIP": "Гибралтарский фунт",
      "GMD": "Гамбийский даласи",
      "GNF": "Гвинейский франк",
      "GNS": "Гвинейская сили",
      "GQE": "Эквеле экваториальной Гвинеи",
      "GRD": "Греческая драхма",
      "GTQ": "Гватемальский кетсаль",
      "GWE": "Эскудо Португальской Гвинеи",
      "GWP": "Песо Гвинеи-Бисау",
      "GYD": "Гайанский доллар",
      "HKD": "Гонконгский доллар",
      "HNL": "Гондурасская лемпира",
      "HRD": "Хорватский динар",
      "HRK": "Хорватская куна",
      "HTG": "Гаитянский гурд",
      "HUF": "Венгерский форинт",
      "IDR": "Индонезийская рупия",
      "IEP": "Ирландский фунт",
      "ILP": "Израильский фунт",
      "ILS": "Новый израильский шекель",
      "INR": "Индийская рупия",
      "IQD": "Иракский динар",
      "IRR": "Иранский риал",
      "ISK": "Исландская крона",
      "ITL": "Итальянская лира",
      "JMD": "Ямайский доллар",
      "JOD": "Иорданский динар",
      "JPY": "Японская иена",
      "KES": "Кенийский шиллинг",
      "KGS": "Киргизский сом",
      "KHR": "Камбоджийский риель",
      "KMF": "Франк Коморских островов",
      "KPW": "Северо-корейская вона",
      "KRW": "Вона Республики Кореи",
      "KWD": "Кувейтский динар",
      "KYD": "Доллар Каймановых островов",
      "KZT": "Казахский тенге",
      "LAK": "Кип ЛНДР",
      "LBP": "Ливанский фунт",
      "LKR": "Шри-Ланкийская рупия",
      "LRD": "Либерийский доллар",
      "LSL": "Лоти",
      "LTL": "Литовский лит",
      "LTT": "Литовский талон",
      "LUC": "Конвертируемый франк Люксембурга",
      "LUF": "Люксембургский франк",
      "LUL": "Финансовый франк Люксембурга",
      "LVL": "Латвийский лат",
      "LVR": "Латвийский рубль",
      "LYD": "Ливийский динар",
      "MAD": "Марокканский дирхам",
      "MAF": "Марокканский франк",
      "MDL": "Молдавский лей",
      "MGA": "Ариари",
      "MGF": "Малагасийский франк",
      "MKD": "Македонский динар",
      "MLF": "Малийский франк",
      "MMK": "Кьят",
      "MNT": "Монгольский тугрик",
      "MOP": "Патака",
      "MRO": "Мавританская угия",
      "MTL": "Мальтийская лира",
      "MTP": "Мальтийский фунт",
      "MUR": "Маврикийская рупия",
      "MVR": "Мальдивская руфия",
      "MWK": "Малавийская квача",
      "MXN": "Мексиканское новое песо",
      "MXP": "Мексиканское серебряное песо (1861-1992)",
      "MXV": "Мексиканская пересчетная единица (UDI)",
      "MYR": "Малайзийский ринггит",
      "MZE": "Мозамбикское эскудо",
      "MZM": "Старый мозамбикский метикал",
      "MZN": "Метикал",
      "NAD": "Доллар Намибии",
      "NGN": "Нигерийская найра",
      "NIC": "Никарагуанская кордоба",
      "NIO": "Золотая кордоба",
      "NLG": "Нидерландский гульден",
      "NOK": "Норвежская крона",
      "NPR": "Непальская рупия",
      "NZD": "Новозеландский доллар",
      "OMR": "Оманский риал",
      "PAB": "Панамское бальбоа",
      "PEI": "Перуанское инти",
      "PEN": "Перуанский новый соль",
      "PES": "Перуанский соль",
      "PGK": "Кина",
      "PHP": "Филиппинское песо",
      "PKR": "Пакистанская рупия",
      "PLN": "Польский злотый",
      "PLZ": "Злотый",
      "PTE": "Португальское эскудо",
      "PYG": "Парагвайский гуарани",
      "QAR": "Катарский риал",
      "RHD": "Родезийский доллар",
      "ROL": "Старый Румынский лей",
      "RON": "Румынский лей",
      "RSD": "Сербский динар",
      "RUB": "Российский рубль",
      "RUR": "Российский рубль (1991-1998)",
      "RWF": "Франк Руанды",
      "SAR": "Саудовский риал",
      "SBD": "Доллар Соломоновых островов",
      "SCR": "Сейшельская рупия",
      "SDD": "Суданский динар",
      "SDG": "Суданский фунт",
      "SDP": "Старый суданский фунт",
      "SEK": "Шведская крона",
      "SGD": "Сингапурский доллар",
      "SHP": "Фунт острова Святой Елены",
      "SIT": "Словенский толар",
      "SKK": "Словацкая крона",
      "SLL": "Леоне",
      "SOS": "Сомалийский шиллинг",
      "SRD": "Суринамский доллар",
      "SRG": "Суринамский гульден",
      "STD": "Добра",
      "SUR": "Рубль СССР",
      "SVC": "Сальвадорский колон",
      "SYP": "Сирийский фунт",
      "SZL": "Свазилендский лилангени",
      "THB": "Таиландский бат",
      "TJR": "Таджикский рубль",
      "TJS": "Таджикский сомони",
      "TMM": "Туркменский манат",
      "TND": "Тунисский динар",
      "TOP": "Паанга",
      "TPE": "Тиморское эскудо",
      "TRL": "Турецкая лира",
      "TRY": "Новая турецкая лира",
      "TTD": "Доллар Тринидада и Тобаго",
      "TWD": "Новый тайваньский доллар",
      "TZS": "Танзанийский шиллинг",
      "UAH": "Украинская гривна",
      "UAK": "Карбованец (украинский)",
      "UGS": "Старый угандийский шиллинг",
      "UGX": "Угандийский шиллинг",
      "USD": "Доллар США",
      "USN": "Доллар США следующего дня",
      "USS": "Доллар США текущего дня",
      "UYI": "Уругвайский песо (индекс инфляции)",
      "UYP": "Уругвайское старое песо (1975-1993)",
      "UYU": "Уругвайское песо",
      "UZS": "Узбекский сум",
      "VEB": "Венесуэльский боливар",
      "VEF": "Венесуэльский боливар фуэрте",
      "VND": "Вьетнамский донг",
      "VUV": "Вату",
      "WST": "Тала",
      "XAF": "Франк КФА ВЕАС",
      "XAG": "Серебро",
      "XAU": "Золото",
      "XBA": "Европейская составная единица",
      "XBB": "Европейская денежная единица",
      "XBC": "расчетная единица европейского валютного соглашения (XBC)",
      "XBD": "расчетная единица европейского валютного соглашения (XBD)",
      "XCD": "Восточно-карибский доллар",
      "XDR": "СДР (специальные права заимствования)",
      "XEU": "ЭКЮ (единица европейской валюты)",
      "XFO": "Французский золотой франк",
      "XFU": "Французский UIC-франк",
      "XOF": "Франк КФА ВСЕАО",
      "XPD": "Палладий",
      "XPF": "Франк КФП",
      "XPT": "Платина",
      "XRE": "единица RINET-фондов",
      "XTS": "тестовый валютный код",
      "XXX": "Неизвестная или недействительная валюта",
      "YDD": "Йеменский динар",
      "YER": "Йеменский риал",
      "YUD": "Югославский твердый динар",
      "YUM": "Югославский новый динар",
      "YUN": "Югославский динар",
      "ZAL": "Южноафриканский рэнд (финансовый)",
      "ZAR": "Южноафриканский рэнд",
      "ZMK": "Квача (замбийская)",
      "ZRN": "Новый заир",
      "ZRZ": "Заир",
      "ZWD": "Доллар Зимбабве",
    };
  }-*/;
}
