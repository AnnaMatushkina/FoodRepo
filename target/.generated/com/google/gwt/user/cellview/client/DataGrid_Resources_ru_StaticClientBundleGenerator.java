package com.google.gwt.user.cellview.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class DataGrid_Resources_ru_StaticClientBundleGenerator implements com.google.gwt.user.cellview.client.DataGrid.Resources {
  private static DataGrid_Resources_ru_StaticClientBundleGenerator _instance0 = new DataGrid_Resources_ru_StaticClientBundleGenerator();
  private void dataGridLoadingInitializer() {
    dataGridLoading = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "dataGridLoading",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?externalImage_rtl : externalImage),
      0, 0, 43, 11, true, false
    );
  }
  private static class dataGridLoadingInitializer {
    static {
      _instance0.dataGridLoadingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return dataGridLoading;
    }
  }
  public com.google.gwt.resources.client.ImageResource dataGridLoading() {
    return dataGridLoadingInitializer.get();
  }
  private void dataGridSortAscendingInitializer() {
    dataGridSortAscending = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "dataGridSortAscending",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      11, 0, 11, 7, false, false
    );
  }
  private static class dataGridSortAscendingInitializer {
    static {
      _instance0.dataGridSortAscendingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return dataGridSortAscending;
    }
  }
  public com.google.gwt.resources.client.ImageResource dataGridSortAscending() {
    return dataGridSortAscendingInitializer.get();
  }
  private void dataGridSortDescendingInitializer() {
    dataGridSortDescending = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "dataGridSortDescending",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ?bundledImage_None_rtl : bundledImage_None),
      0, 0, 11, 7, false, false
    );
  }
  private static class dataGridSortDescendingInitializer {
    static {
      _instance0.dataGridSortDescendingInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return dataGridSortDescending;
    }
  }
  public com.google.gwt.resources.client.ImageResource dataGridSortDescending() {
    return dataGridSortDescendingInitializer.get();
  }
  private void dataGridStyleInitializer() {
    dataGridStyle = new com.google.gwt.user.cellview.client.DataGrid.Style() {
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
        return "dataGridStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GPG4JGXCLJ{border-top:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("right")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";}.GPG4JGXCMJ{border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("right")  + ";color:") + (("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";}.GPG4JGXCFJ{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GPG4JGXCJK{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.GPG4JGXCJK:hover{color:" + ("#6c6b6b")  + ";}.GPG4JGXCGJ{background:" + ("#fff")  + ";}.GPG4JGXCHJ{border:" + ("2px"+ " " +"solid"+ " " +"#fff") ) + (";}.GPG4JGXCFK{background:" + ("#f3f7fb")  + ";}.GPG4JGXCGK{border:" + ("2px"+ " " +"solid"+ " " +"#f3f7fb")  + ";}.GPG4JGXCNJ{background:" + ("#eee")  + ";}.GPG4JGXCOJ{border:" + ("2px"+ " " +"solid"+ " " +"#eee")  + ";}.GPG4JGXCAK{background:" + ("#ffc")  + ";}.GPG4JGXCBK{border:" + ("2px"+ " " +"solid"+ " " +"#ffc")  + ";}.GPG4JGXCHK{background:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("auto")  + ";}.GPG4JGXCIK{border:") + (("2px"+ " " +"solid"+ " " +"#628cd5")  + ";}.GPG4JGXCPJ{border:" + ("2px"+ " " +"solid"+ " " +"#d7dde8")  + ";}")) : ((".GPG4JGXCLJ{border-top:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("left")  + ";color:" + ("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";}.GPG4JGXCMJ{border-bottom:" + ("2px"+ " " +"solid"+ " " +"#6f7277")  + ";padding:" + ("3px"+ " " +"15px")  + ";text-align:" + ("left")  + ";color:") + (("#4b4a4a")  + ";text-shadow:" + ("#ddf"+ " " +"1px"+ " " +"1px"+ " " +"0")  + ";overflow:" + ("hidden")  + ";white-space:" + ("nowrap")  + ";}.GPG4JGXCFJ{padding:" + ("2px"+ " " +"15px")  + ";overflow:" + ("hidden")  + ";}.GPG4JGXCJK{cursor:" + ("pointer")  + ";cursor:" + ("hand")  + ";}.GPG4JGXCJK:hover{color:" + ("#6c6b6b")  + ";}.GPG4JGXCGJ{background:" + ("#fff")  + ";}.GPG4JGXCHJ{border:" + ("2px"+ " " +"solid"+ " " +"#fff") ) + (";}.GPG4JGXCFK{background:" + ("#f3f7fb")  + ";}.GPG4JGXCGK{border:" + ("2px"+ " " +"solid"+ " " +"#f3f7fb")  + ";}.GPG4JGXCNJ{background:" + ("#eee")  + ";}.GPG4JGXCOJ{border:" + ("2px"+ " " +"solid"+ " " +"#eee")  + ";}.GPG4JGXCAK{background:" + ("#ffc")  + ";}.GPG4JGXCBK{border:" + ("2px"+ " " +"solid"+ " " +"#ffc")  + ";}.GPG4JGXCHK{background:" + ("#628cd5")  + ";color:" + ("white")  + ";height:" + ("auto")  + ";overflow:" + ("auto")  + ";}.GPG4JGXCIK{border:") + (("2px"+ " " +"solid"+ " " +"#628cd5")  + ";}.GPG4JGXCPJ{border:" + ("2px"+ " " +"solid"+ " " +"#d7dde8")  + ";}"));
      }
      public java.lang.String dataGridCell(){
        return "GPG4JGXCFJ";
      }
      public java.lang.String dataGridEvenRow(){
        return "GPG4JGXCGJ";
      }
      public java.lang.String dataGridEvenRowCell(){
        return "GPG4JGXCHJ";
      }
      public java.lang.String dataGridFirstColumn(){
        return "GPG4JGXCIJ";
      }
      public java.lang.String dataGridFirstColumnFooter(){
        return "GPG4JGXCJJ";
      }
      public java.lang.String dataGridFirstColumnHeader(){
        return "GPG4JGXCKJ";
      }
      public java.lang.String dataGridFooter(){
        return "GPG4JGXCLJ";
      }
      public java.lang.String dataGridHeader(){
        return "GPG4JGXCMJ";
      }
      public java.lang.String dataGridHoveredRow(){
        return "GPG4JGXCNJ";
      }
      public java.lang.String dataGridHoveredRowCell(){
        return "GPG4JGXCOJ";
      }
      public java.lang.String dataGridKeyboardSelectedCell(){
        return "GPG4JGXCPJ";
      }
      public java.lang.String dataGridKeyboardSelectedRow(){
        return "GPG4JGXCAK";
      }
      public java.lang.String dataGridKeyboardSelectedRowCell(){
        return "GPG4JGXCBK";
      }
      public java.lang.String dataGridLastColumn(){
        return "GPG4JGXCCK";
      }
      public java.lang.String dataGridLastColumnFooter(){
        return "GPG4JGXCDK";
      }
      public java.lang.String dataGridLastColumnHeader(){
        return "GPG4JGXCEK";
      }
      public java.lang.String dataGridOddRow(){
        return "GPG4JGXCFK";
      }
      public java.lang.String dataGridOddRowCell(){
        return "GPG4JGXCGK";
      }
      public java.lang.String dataGridSelectedRow(){
        return "GPG4JGXCHK";
      }
      public java.lang.String dataGridSelectedRowCell(){
        return "GPG4JGXCIK";
      }
      public java.lang.String dataGridSortableHeader(){
        return "GPG4JGXCJK";
      }
      public java.lang.String dataGridSortedHeaderAscending(){
        return "GPG4JGXCKK";
      }
      public java.lang.String dataGridSortedHeaderDescending(){
        return "GPG4JGXCLK";
      }
      public java.lang.String dataGridWidget(){
        return "GPG4JGXCMK";
      }
    }
    ;
  }
  private static class dataGridStyleInitializer {
    static {
      _instance0.dataGridStyleInitializer();
    }
    static com.google.gwt.user.cellview.client.DataGrid.Style get() {
      return dataGridStyle;
    }
  }
  public com.google.gwt.user.cellview.client.DataGrid.Style dataGridStyle() {
    return dataGridStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String bundledImage_None = GWT.getModuleBaseURL() + "AB196D9D7834625802449A82C5811B43.cache.png";
  private static final java.lang.String bundledImage_None_rtl = GWT.getModuleBaseURL() + "3E13412DD77AE068AAF96B6978824A75.cache.png";
  private static final java.lang.String externalImage = GWT.getModuleBaseURL() + "0F89659FF3F324AE4116F700257E32BD.cache.gif";
  private static final java.lang.String externalImage_rtl = GWT.getModuleBaseURL() + "13D2931874E71D07F248A0CDF051CC85.cache.png";
  private static com.google.gwt.resources.client.ImageResource dataGridLoading;
  private static com.google.gwt.resources.client.ImageResource dataGridSortAscending;
  private static com.google.gwt.resources.client.ImageResource dataGridSortDescending;
  private static com.google.gwt.user.cellview.client.DataGrid.Style dataGridStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      dataGridLoading(), 
      dataGridSortAscending(), 
      dataGridSortDescending(), 
      dataGridStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("dataGridLoading", dataGridLoading());
        resourceMap.put("dataGridSortAscending", dataGridSortAscending());
        resourceMap.put("dataGridSortDescending", dataGridSortDescending());
        resourceMap.put("dataGridStyle", dataGridStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'dataGridLoading': return this.@com.google.gwt.user.cellview.client.DataGrid.Resources::dataGridLoading()();
      case 'dataGridSortAscending': return this.@com.google.gwt.user.cellview.client.DataGrid.Resources::dataGridSortAscending()();
      case 'dataGridSortDescending': return this.@com.google.gwt.user.cellview.client.DataGrid.Resources::dataGridSortDescending()();
      case 'dataGridStyle': return this.@com.google.gwt.user.cellview.client.DataGrid.Resources::dataGridStyle()();
    }
    return null;
  }-*/;
}
