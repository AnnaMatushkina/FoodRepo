package com.epam.feel.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class EpamFeelResources_ru_InlineClientBundleGenerator implements com.epam.feel.client.EpamFeelResources {
  private static EpamFeelResources_ru_InlineClientBundleGenerator _instance0 = new EpamFeelResources_ru_InlineClientBundleGenerator();
  private void globalInitializer() {
    global = new com.epam.feel.client.EpamFeelResources.GlobalStyles() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "global";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("body{font-size:" + ("small")  + ";font-family:" + ("Helvetica"+ ","+ " " +"Arial"+ ","+ " " +"sans-serif")  + ";color:" + ("#000")  + ";background:" + ("#fff")  + ";}table{font-size:" + ("small")  + ";}a,a:visited{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";color:" + ("#6f7277")  + ";text-decoration:" + ("underline")  + ";}a:hover{color:" + ("#333")  + ";text-decoration:") + (("none")  + ";}.GPG4JGXCN{font-size:" + ("42px")  + ";font-family:" + ("\"Segoe Print\""+ ","+ " " +"\"Monotype Corsiva\""+ ","+ " " +"cursive")  + ";height:" + ("80px")  + ";width:" + ("100%")  + ";text-align:" + ("center")  + ";margin:" + ("auto")  + ";text-decoration:" + ("none")  + ";color:" + ("#000")  + ";}.GPG4JGXCC{text-align:" + ("center")  + ";vertical-align:" + ("middle") ) + (";height:" + ("100%")  + ";}.GPG4JGXCP{width:" + ("100%")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";}.GPG4JGXCBB{font-size:" + ("18px")  + ";font-weight:" + ("bold")  + ";text-decoration:" + ("none")  + ";color:" + ("#6f7277")  + ";}.GPG4JGXCCB,.GPG4JGXCAB{font-size:" + ("12px")  + ";}.GPG4JGXCO{right:" + ("auto")  + " !important;bottom:" + ("auto")  + " !important;}.gwt-DecoratorPanel{padding:") + (("5px"+ " " +"0"+ " " +"0"+ " " +"5px")  + " !important;height:" + ("95%")  + ";}.gwt-DecoratorPanel .middleCenter{height:" + ("95%")  + ";}.GPG4JGXCGB{cursor:" + ("pointer")  + ";margin-left:" + ("2px")  + ";}.GPG4JGXCJ{border-top:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";}.GPG4JGXCL{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";}.GPG4JGXCM{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";text-align:" + ("left") ) + (";}.GPG4JGXCK{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";}.GPG4JGXCK a{font-size:" + ("0.9em")  + ";text-decoration:" + ("none")  + ";}.GPG4JGXCK a:hover{text-decoration:" + ("underline")  + ";}.gwt-Button{padding:" + ("3px"+ " " +"5px")  + " !important;background:" + ("url(epam_feel/hborderstandard.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-27px")  + " !important;border:" + ("1px"+ " " +"outset"+ " " +"#ccc")  + " !important;}.gwt-Button:hover{border-color:" + ("#9cf"+ " " +"#7af"+ " " +"#69e"+ " " +"#69e")  + " !important;}.gwt-StackLayoutPanel .gwt-StackLayoutPanelHeader{background:" + ("#d3def6"+ " " +"url(epam_feel/hborderchrome.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + " !important;font-size:") + (("1.1em")  + " !important;padding:" + ("4px")  + " !important;color:" + ("#333")  + " !important;}.gwt-StackLayoutPanel .gwt-StackLayoutPanelHeader-hovering{background:" + ("#d3def6"+ " " +"url(epam_feel/hborderchrome.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-1464px")  + " !important;}.gwt-StackLayoutPanelContent{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + " !important;}.gwt-TextBox,.gwt-DateBox{height:" + ("auto")  + " !important;padding:" + ("1px")  + " !important;}.gwt-ListBox{border-width:" + ("1px")  + " !important;}.GPG4JGXCFB{font-size:" + ("11px")  + ";color:" + ("#8e8e8e")  + ";}.GPG4JGXCB{cursor:" + ("pointer") ) + (";cursor:" + ("hand")  + ";}.GPG4JGXCA{font-weight:" + ("bold")  + ";color:" + ("#4b4a4a")  + ";}.GPG4JGXCIB{margin-left:" + ("10px")  + ";}.GPG4JGXCHB{margin-right:" + ("10px")  + ";margin-left:" + ("10px")  + ";}.GPG4JGXCKB{margin-right:" + ("100px")  + ";}.GPG4JGXCLB{margin-right:" + ("60px")  + ";}.GPG4JGXCMB{margin-right:" + ("30px")  + ";}.GPG4JGXCCC{margin-left:" + ("10px")  + ";}.gwt-DatePicker{border:") + (("1px"+ " " +"solid"+ " " +"#6f7277")  + ";border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";color:" + ("6b6b6b")  + ";cursor:" + ("default")  + ";width:" + ("7em")  + ";}.datePickerDay,.datePickerWeekdayLabel,.datePickerWeekendLabel{font-family:" + ("Arial")  + ";font-size:" + ("90%")  + ";text-align:" + ("center")  + ";padding:" + ("7px")  + ";outline:" + ("none")  + ";cursor:" + ("default") ) + (";}.gwt-DatePicker td,.datePickerMonthSelector td :focus{outline:" + ("none")  + ";}.gwt-DateBox input{width:" + ("8em")  + ";}.datePickerDays{background-color:" + ("white")  + ";width:" + ("100%")  + ";}.datePickerWeekdayLabel{background:" + ("#ccc")  + ";}.datePickerWeekendLabel{background:" + ("#8e8e8e")  + ";}.datePickerDay{padding:" + ("1px")  + ";cursor:" + ("hand")  + ";width:" + ("1em")  + ";}.datePickerDayIsToday{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";padding:") + (("0")  + ";}.datePickerDayIsWeekend{background:" + ("#f1f1f1")  + ";}.datePickerDayIsFiller{color:" + ("#bfbfbf")  + ";padding:" + ("1px")  + ";cursor:" + ("hand")  + ";}.datePickerDayIsSelected{background:" + ("#ace")  + ";}.datePickerDayIsDisabled{color:" + ("graytext")  + ";}.datePickerDayIsHighlighted{border:" + ("1px"+ " " +"solid"+ " " +"#eee")  + ";padding:" + ("0")  + ";}.datePickerDayIsSelectedAndHighlighted{background:" + ("#bdf")  + ";}.datePickerMonthSelector{background:" + ("#ccc") ) + (";width:" + ("100%")  + ";text-align:" + ("center")  + ";}.datePickerMonth{text-align:" + ("center")  + ";vertical-align:" + ("center")  + ";white-space:" + ("nowrap")  + ";font-weight:" + ("bold")  + ";font-size:" + ("70%")  + ";}.datePickerPreviousButton{text-align:" + ("right")  + ";}.datePickerNextButton{text-align:" + ("left")  + ";}.GPG4JGXCBD{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:") + (("3px"+ " " +"15px")  + ";color:" + ("#4b4a4a")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";background-color:" + ("#eee")  + ";font-weight:" + ("bold")  + ";}.GPG4JGXCPC{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GPG4JGXCAD{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";text-align:" + ("right") ) + (";font-style:" + ("italic")  + ";background-color:" + ("#f6f6f6")  + ";}.GPG4JGXCOC{border-collapse:" + ("collapse")  + ";text-align:" + ("center")  + ";}.GPG4JGXCPB{text-decoration:" + ("none")  + ";font-size:" + ("medium")  + ";}.GPG4JGXCDC{text-align:" + ("left")  + ";}.GPG4JGXCNB{text-align:" + ("right")  + ";}.GPG4JGXCI{float:" + ("left")  + ";}.GPG4JGXCEC{font-size:" + ("85%")  + ";}.GPG4JGXCFC{color:") + (("#4b4a4a")  + ";font-weight:" + ("bold")  + ";}.gwt-RichTextArea{border-width:" + ("1px")  + " !important;}.dataGridHeaderHide{display:" + ("none")  + ";}.GPG4JGXCCD{border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("center")  + ";width:" + ("22px")  + ";}.GPG4JGXCMC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCIC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-60px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCLC{margin:") + (("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-15px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCHC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-75px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCKC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-30px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCGC{margin:") + (("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-90px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCNC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-45px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCJC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-105px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCE{padding:") + (("0"+ " " +"3px")  + ";}.GPG4JGXCD{display:" + ("inline-block")  + ";height:" + ("12px")  + ";vertical-align:" + ("middle")  + ";width:" + ("12px")  + ";}.GPG4JGXCG{background:" + ("url(epam_feel/plus.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCF{background:" + ("url(epam_feel/minus.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCG:hover{background:" + ("url(epam_feel/plus-hover.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCF:hover{background:" + ("url(epam_feel/minus-hover.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCOB{background:" + ("url(epam_feel/logout.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";display:" + ("inline-block") ) + (";width:" + ("32px")  + ";height:" + ("32px")  + ";float:" + ("left")  + ";}.GPG4JGXCH{border-top:" + ("1px"+ " " +"dashed"+ " " +"#9a9a9a")  + ";margin:" + ("5px"+ " " +"0")  + ";}.GPG4JGXCBC{float:" + ("left")  + ";margin:" + ("5px"+ " " +"0"+ " " +"0"+ " " +"5px")  + ";}.GPG4JGXCJB{float:" + ("right")  + ";margin:" + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"5px")  + ";}.GPG4JGXCAC{color:" + ("#4b4a4a")  + ";font-weight:") + (("bold")  + ";padding-right:" + ("5px")  + ";}.GPG4JGXCDB{background:" + ("#f3bf78")  + " !important;}.GPG4JGXCEB{background:" + ("#f26269")  + " !important;}.GPG4JGXCDD{background-color:" + ("#fff")  + ";opacity:" + ("0.7")  + ";-ms-filter:" + ("\"progid:DXImageTransform.Microsoft.Alpha(Opacity=70)\"")  + ";background-image:" + ("url(epam_feel/waiting.gif)")  + ";background-position:" + ("center")  + ";background-repeat:" + ("no-repeat")  + ";}")) : (("body{font-size:" + ("small")  + ";font-family:" + ("Helvetica"+ ","+ " " +"Arial"+ ","+ " " +"sans-serif")  + ";color:" + ("#000")  + ";background:" + ("#fff")  + ";}table{font-size:" + ("small")  + ";}a,a:visited{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";color:" + ("#6f7277")  + ";text-decoration:" + ("underline")  + ";}a:hover{color:" + ("#333")  + ";text-decoration:") + (("none")  + ";}.GPG4JGXCN{font-size:" + ("42px")  + ";font-family:" + ("\"Segoe Print\""+ ","+ " " +"\"Monotype Corsiva\""+ ","+ " " +"cursive")  + ";height:" + ("80px")  + ";width:" + ("100%")  + ";text-align:" + ("center")  + ";margin:" + ("auto")  + ";text-decoration:" + ("none")  + ";color:" + ("#000")  + ";}.GPG4JGXCC{text-align:" + ("center")  + ";vertical-align:" + ("middle") ) + (";height:" + ("100%")  + ";}.GPG4JGXCP{width:" + ("100%")  + ";border-bottom:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";}.GPG4JGXCBB{font-size:" + ("18px")  + ";font-weight:" + ("bold")  + ";text-decoration:" + ("none")  + ";color:" + ("#6f7277")  + ";}.GPG4JGXCCB,.GPG4JGXCAB{font-size:" + ("12px")  + ";}.GPG4JGXCO{left:" + ("auto")  + " !important;bottom:" + ("auto")  + " !important;}.gwt-DecoratorPanel{padding:") + (("5px"+ " " +"5px"+ " " +"0"+ " " +"0")  + " !important;height:" + ("95%")  + ";}.gwt-DecoratorPanel .middleCenter{height:" + ("95%")  + ";}.GPG4JGXCGB{cursor:" + ("pointer")  + ";margin-right:" + ("2px")  + ";}.GPG4JGXCJ{border-top:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";}.GPG4JGXCL{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";}.GPG4JGXCM{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";text-align:" + ("right") ) + (";}.GPG4JGXCK{font-size:" + ("0.9em")  + ";padding:" + ("5px")  + ";}.GPG4JGXCK a{font-size:" + ("0.9em")  + ";text-decoration:" + ("none")  + ";}.GPG4JGXCK a:hover{text-decoration:" + ("underline")  + ";}.gwt-Button{padding:" + ("3px"+ " " +"5px")  + " !important;background:" + ("url(epam_feel/hborderstandard.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-27px")  + " !important;border:" + ("1px"+ " " +"outset"+ " " +"#ccc")  + " !important;}.gwt-Button:hover{border-color:" + ("#9cf"+ " " +"#69e"+ " " +"#69e"+ " " +"#7af")  + " !important;}.gwt-StackLayoutPanel .gwt-StackLayoutPanelHeader{background:" + ("#d3def6"+ " " +"url(epam_feel/hborderchrome.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-989px")  + " !important;font-size:") + (("1.1em")  + " !important;padding:" + ("4px")  + " !important;color:" + ("#333")  + " !important;}.gwt-StackLayoutPanel .gwt-StackLayoutPanelHeader-hovering{background:" + ("#d3def6"+ " " +"url(epam_feel/hborderchrome.png)"+ " " +"repeat-x"+ " " +"0"+ " " +"-1464px")  + " !important;}.gwt-StackLayoutPanelContent{border:" + ("1px"+ " " +"solid"+ " " +"#bbb")  + " !important;}.gwt-TextBox,.gwt-DateBox{height:" + ("auto")  + " !important;padding:" + ("1px")  + " !important;}.gwt-ListBox{border-width:" + ("1px")  + " !important;}.GPG4JGXCFB{font-size:" + ("11px")  + ";color:" + ("#8e8e8e")  + ";}.GPG4JGXCB{cursor:" + ("pointer") ) + (";cursor:" + ("hand")  + ";}.GPG4JGXCA{font-weight:" + ("bold")  + ";color:" + ("#4b4a4a")  + ";}.GPG4JGXCIB{margin-right:" + ("10px")  + ";}.GPG4JGXCHB{margin-left:" + ("10px")  + ";margin-right:" + ("10px")  + ";}.GPG4JGXCKB{margin-left:" + ("100px")  + ";}.GPG4JGXCLB{margin-left:" + ("60px")  + ";}.GPG4JGXCMB{margin-left:" + ("30px")  + ";}.GPG4JGXCCC{margin-right:" + ("10px")  + ";}.gwt-DatePicker{border:") + (("1px"+ " " +"solid"+ " " +"#6f7277")  + ";border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";color:" + ("6b6b6b")  + ";cursor:" + ("default")  + ";width:" + ("7em")  + ";}.datePickerDay,.datePickerWeekdayLabel,.datePickerWeekendLabel{font-family:" + ("Arial")  + ";font-size:" + ("90%")  + ";text-align:" + ("center")  + ";padding:" + ("7px")  + ";outline:" + ("none")  + ";cursor:" + ("default") ) + (";}.gwt-DatePicker td,.datePickerMonthSelector td :focus{outline:" + ("none")  + ";}.gwt-DateBox input{width:" + ("8em")  + ";}.datePickerDays{background-color:" + ("white")  + ";width:" + ("100%")  + ";}.datePickerWeekdayLabel{background:" + ("#ccc")  + ";}.datePickerWeekendLabel{background:" + ("#8e8e8e")  + ";}.datePickerDay{padding:" + ("1px")  + ";cursor:" + ("hand")  + ";width:" + ("1em")  + ";}.datePickerDayIsToday{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";padding:") + (("0")  + ";}.datePickerDayIsWeekend{background:" + ("#f1f1f1")  + ";}.datePickerDayIsFiller{color:" + ("#bfbfbf")  + ";padding:" + ("1px")  + ";cursor:" + ("hand")  + ";}.datePickerDayIsSelected{background:" + ("#ace")  + ";}.datePickerDayIsDisabled{color:" + ("graytext")  + ";}.datePickerDayIsHighlighted{border:" + ("1px"+ " " +"solid"+ " " +"#eee")  + ";padding:" + ("0")  + ";}.datePickerDayIsSelectedAndHighlighted{background:" + ("#bdf")  + ";}.datePickerMonthSelector{background:" + ("#ccc") ) + (";width:" + ("100%")  + ";text-align:" + ("center")  + ";}.datePickerMonth{text-align:" + ("center")  + ";vertical-align:" + ("center")  + ";white-space:" + ("nowrap")  + ";font-weight:" + ("bold")  + ";font-size:" + ("70%")  + ";}.datePickerPreviousButton{text-align:" + ("left")  + ";}.datePickerNextButton{text-align:" + ("right")  + ";}.GPG4JGXCBD{border-bottom:" + ("1px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:") + (("3px"+ " " +"15px")  + ";color:" + ("#4b4a4a")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";background-color:" + ("#eee")  + ";font-weight:" + ("bold")  + ";}.GPG4JGXCPC{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GPG4JGXCAD{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";text-align:" + ("left") ) + (";font-style:" + ("italic")  + ";background-color:" + ("#f6f6f6")  + ";}.GPG4JGXCOC{border-collapse:" + ("collapse")  + ";text-align:" + ("center")  + ";}.GPG4JGXCPB{text-decoration:" + ("none")  + ";font-size:" + ("medium")  + ";}.GPG4JGXCDC{text-align:" + ("right")  + ";}.GPG4JGXCNB{text-align:" + ("left")  + ";}.GPG4JGXCI{float:" + ("right")  + ";}.GPG4JGXCEC{font-size:" + ("85%")  + ";}.GPG4JGXCFC{color:") + (("#4b4a4a")  + ";font-weight:" + ("bold")  + ";}.gwt-RichTextArea{border-width:" + ("1px")  + " !important;}.dataGridHeaderHide{display:" + ("none")  + ";}.GPG4JGXCCD{border:" + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";text-align:" + ("center")  + ";width:" + ("22px")  + ";}.GPG4JGXCMC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCIC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-60px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCLC{margin:") + (("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-15px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCHC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-75px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCKC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-30px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCGC{margin:") + (("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-90px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCNC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px") ) + (";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-45px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCJC{margin:" + ("1px")  + ";cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";height:" + ("8px")  + ";width:" + ("15px")  + ";margin:" + ("1px")  + ";background:" + ("url(epam_feel/spinner.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"-105px"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCE{padding:") + (("0"+ " " +"3px")  + ";}.GPG4JGXCD{display:" + ("inline-block")  + ";height:" + ("12px")  + ";vertical-align:" + ("middle")  + ";width:" + ("12px")  + ";}.GPG4JGXCG{background:" + ("url(epam_feel/plus.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCF{background:" + ("url(epam_feel/minus.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCG:hover{background:" + ("url(epam_feel/plus-hover.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCF:hover{background:" + ("url(epam_feel/minus-hover.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";}.GPG4JGXCOB{background:" + ("url(epam_feel/logout.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";display:" + ("inline-block") ) + (";width:" + ("32px")  + ";height:" + ("32px")  + ";float:" + ("right")  + ";}.GPG4JGXCH{border-top:" + ("1px"+ " " +"dashed"+ " " +"#9a9a9a")  + ";margin:" + ("5px"+ " " +"0")  + ";}.GPG4JGXCBC{float:" + ("right")  + ";margin:" + ("5px"+ " " +"5px"+ " " +"0"+ " " +"0")  + ";}.GPG4JGXCJB{float:" + ("left")  + ";margin:" + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"5px")  + ";}.GPG4JGXCAC{color:" + ("#4b4a4a")  + ";font-weight:") + (("bold")  + ";padding-left:" + ("5px")  + ";}.GPG4JGXCDB{background:" + ("#f3bf78")  + " !important;}.GPG4JGXCEB{background:" + ("#f26269")  + " !important;}.GPG4JGXCDD{background-color:" + ("#fff")  + ";opacity:" + ("0.7")  + ";-ms-filter:" + ("\"progid:DXImageTransform.Microsoft.Alpha(Opacity=70)\"")  + ";background-image:" + ("url(epam_feel/waiting.gif)")  + ";background-position:" + ("center")  + ";background-repeat:" + ("no-repeat")  + ";}"));
      }
      public java.lang.String boldDateLabel(){
        return "GPG4JGXCA";
      }
      public java.lang.String calendarImage(){
        return "GPG4JGXCB";
      }
      public java.lang.String centerBox(){
        return "GPG4JGXCC";
      }
      public java.lang.String counter(){
        return "GPG4JGXCD";
      }
      public java.lang.String counterDishPadding(){
        return "GPG4JGXCE";
      }
      public java.lang.String counterMinus(){
        return "GPG4JGXCF";
      }
      public java.lang.String counterPlus(){
        return "GPG4JGXCG";
      }
      public java.lang.String delimeterLineHeader(){
        return "GPG4JGXCH";
      }
      public java.lang.String floatRight(){
        return "GPG4JGXCI";
      }
      public java.lang.String footer(){
        return "GPG4JGXCJ";
      }
      public java.lang.String footerAdminLinks(){
        return "GPG4JGXCK";
      }
      public java.lang.String footerLabel(){
        return "GPG4JGXCL";
      }
      public java.lang.String footerLabelCopy(){
        return "GPG4JGXCM";
      }
      public java.lang.String header(){
        return "GPG4JGXCN";
      }
      public java.lang.String headerDecoratorPanel(){
        return "GPG4JGXCO";
      }
      public java.lang.String headerMainTable(){
        return "GPG4JGXCP";
      }
      public java.lang.String headerPayment(){
        return "GPG4JGXCAB";
      }
      public java.lang.String headerPersonalAccountLabel(){
        return "GPG4JGXCBB";
      }
      public java.lang.String headerPersonalAccountNum(){
        return "GPG4JGXCCB";
      }
      public java.lang.String highlighted(){
        return "GPG4JGXCDB";
      }
      public java.lang.String highlightedRequired(){
        return "GPG4JGXCEB";
      }
      public java.lang.String hint(){
        return "GPG4JGXCFB";
      }
      public java.lang.String imgAdvice(){
        return "GPG4JGXCGB";
      }
      public java.lang.String labelBetweenFields(){
        return "GPG4JGXCHB";
      }
      public java.lang.String labelWithField(){
        return "GPG4JGXCIB";
      }
      public java.lang.String leftFloatImage(){
        return "GPG4JGXCJB";
      }
      public java.lang.String leftLargeMargin(){
        return "GPG4JGXCKB";
      }
      public java.lang.String leftMediumMargin(){
        return "GPG4JGXCLB";
      }
      public java.lang.String leftSmallMargin(){
        return "GPG4JGXCMB";
      }
      public java.lang.String leftText(){
        return "GPG4JGXCNB";
      }
      public java.lang.String logout(){
        return "GPG4JGXCOB";
      }
      public java.lang.String noUnderlineAnchor(){
        return "GPG4JGXCPB";
      }
      public java.lang.String preMenuNameLabel(){
        return "GPG4JGXCAC";
      }
      public java.lang.String rightFloatImage(){
        return "GPG4JGXCBC";
      }
      public java.lang.String rightSmallMargin(){
        return "GPG4JGXCCC";
      }
      public java.lang.String rightText(){
        return "GPG4JGXCDC";
      }
      public java.lang.String smallText(){
        return "GPG4JGXCEC";
      }
      public java.lang.String smallTextSelected(){
        return "GPG4JGXCFC";
      }
      public java.lang.String spinnerDownGrayed(){
        return "GPG4JGXCGC";
      }
      public java.lang.String spinnerDownHover(){
        return "GPG4JGXCHC";
      }
      public java.lang.String spinnerDownPressed(){
        return "GPG4JGXCIC";
      }
      public java.lang.String spinnerDownReleased(){
        return "GPG4JGXCJC";
      }
      public java.lang.String spinnerUpGrayed(){
        return "GPG4JGXCKC";
      }
      public java.lang.String spinnerUpHover(){
        return "GPG4JGXCLC";
      }
      public java.lang.String spinnerUpPressed(){
        return "GPG4JGXCMC";
      }
      public java.lang.String spinnerUpReleased(){
        return "GPG4JGXCNC";
      }
      public java.lang.String tableMenu(){
        return "GPG4JGXCOC";
      }
      public java.lang.String tableMenuDishRow(){
        return "GPG4JGXCPC";
      }
      public java.lang.String tableMenuDishType(){
        return "GPG4JGXCAD";
      }
      public java.lang.String tableMenuHeader(){
        return "GPG4JGXCBD";
      }
      public java.lang.String timeViewInput(){
        return "GPG4JGXCCD";
      }
      public java.lang.String waitingGlass(){
        return "GPG4JGXCDD";
      }
    }
    ;
  }
  private static class globalInitializer {
    static {
      _instance0.globalInitializer();
    }
    static com.epam.feel.client.EpamFeelResources.GlobalStyles get() {
      return global;
    }
  }
  public com.epam.feel.client.EpamFeelResources.GlobalStyles global() {
    return globalInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.epam.feel.client.EpamFeelResources.GlobalStyles global;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      global(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("global", global());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'global': return this.@com.epam.feel.client.EpamFeelResources::global()();
    }
    return null;
  }-*/;
}
