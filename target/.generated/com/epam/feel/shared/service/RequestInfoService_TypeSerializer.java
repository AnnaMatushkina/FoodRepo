package com.epam.feel.shared.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class RequestInfoService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final MethodMap methodMapNative;
  private static final JsArrayString signatureMapNative;
  
  static {
    methodMapNative = loadMethodsNative();
    signatureMapNative = loadSignaturesNative();
  }
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["com.epam.feel.client.ui.util.AliveMenuDetails/2602943283"] = [
        @com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/client/ui/util/AliveMenuDetails;),
        @com.epam.feel.client.ui.util.AliveMenuDetails_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/client/ui/util/AliveMenuDetails;)
      ];
    
    result["com.epam.feel.shared.dto.ClientDTO/575441241"] = [
        @com.epam.feel.shared.dto.ClientDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.ClientDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/ClientDTO;),
        @com.epam.feel.shared.dto.ClientDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/ClientDTO;)
      ];
    
    result["com.epam.feel.shared.dto.DishTypeDTO/3379931121"] = [
        @com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/DishTypeDTO;),
        @com.epam.feel.shared.dto.DishTypeDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/DishTypeDTO;)
      ];
    
    result["com.epam.feel.shared.dto.ExtendedRequestDTO/1310784871"] = [
        @com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/ExtendedRequestDTO;),
        @com.epam.feel.shared.dto.ExtendedRequestDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/ExtendedRequestDTO;)
      ];
    
    result["[Lcom.epam.feel.shared.dto.ExtendedRequestDTO;/4133365399"] = [
        @com.epam.feel.shared.dto.ExtendedRequestDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.ExtendedRequestDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/epam/feel/shared/dto/ExtendedRequestDTO;),
      ];
    
    result["com.epam.feel.shared.dto.ExtendedRequestGroupDTO/4036140324"] = [
        @com.epam.feel.shared.dto.ExtendedRequestGroupDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.ExtendedRequestGroupDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/ExtendedRequestGroupDTO;),
      ];
    
    result["[Lcom.epam.feel.shared.dto.ExtendedRequestGroupDTO;/1460985729"] = [
        @com.epam.feel.shared.dto.ExtendedRequestGroupDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.ExtendedRequestGroupDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/epam/feel/shared/dto/ExtendedRequestGroupDTO;),
      ];
    
    result["com.epam.feel.shared.dto.MenuDTO/3560685466"] = [
        @com.epam.feel.shared.dto.MenuDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.MenuDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/MenuDTO;),
        @com.epam.feel.shared.dto.MenuDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/MenuDTO;)
      ];
    
    result["com.epam.feel.shared.dto.MenuDetailsDTO/2632711538"] = [
        @com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/MenuDetailsDTO;),
        @com.epam.feel.shared.dto.MenuDetailsDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/MenuDetailsDTO;)
      ];
    
    result["[Lcom.epam.feel.shared.dto.MenuDetailsDTO;/3781366291"] = [
        @com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/epam/feel/shared/dto/MenuDetailsDTO;),
        @com.epam.feel.shared.dto.MenuDetailsDTO_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lcom/epam/feel/shared/dto/MenuDetailsDTO;)
      ];
    
    result["com.epam.feel.shared.dto.RequestDTO/3610644213"] = [
        @com.epam.feel.shared.dto.RequestDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.RequestDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/RequestDTO;),
        @com.epam.feel.shared.dto.RequestDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/RequestDTO;)
      ];
    
    result["[Lcom.epam.feel.shared.dto.RequestDTO;/2957074186"] = [
        @com.epam.feel.shared.dto.RequestDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.RequestDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/epam/feel/shared/dto/RequestDTO;),
      ];
    
    result["com.epam.feel.shared.dto.RequestDetailsDTO/4117466465"] = [
        @com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/dto/RequestDetailsDTO;),
        @com.epam.feel.shared.dto.RequestDetailsDTO_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/dto/RequestDetailsDTO;)
      ];
    
    result["[Lcom.epam.feel.shared.dto.RequestDetailsDTO;/1901210751"] = [
        @com.epam.feel.shared.dto.RequestDetailsDTO_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.dto.RequestDetailsDTO_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/epam/feel/shared/dto/RequestDetailsDTO;),
        @com.epam.feel.shared.dto.RequestDetailsDTO_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lcom/epam/feel/shared/dto/RequestDetailsDTO;)
      ];
    
    result["com.epam.feel.shared.enums.GroupStatus/614846326"] = [
        @com.epam.feel.shared.enums.GroupStatus_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.enums.GroupStatus_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/enums/GroupStatus;),
      ];
    
    result["com.epam.feel.shared.enums.MenuStatus/1298115897"] = [
        @com.epam.feel.shared.enums.MenuStatus_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.enums.MenuStatus_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/enums/MenuStatus;),
        @com.epam.feel.shared.enums.MenuStatus_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/enums/MenuStatus;)
      ];
    
    result["com.epam.feel.shared.enums.RequestStatus/3718825498"] = [
        @com.epam.feel.shared.enums.RequestStatus_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.enums.RequestStatus_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/enums/RequestStatus;),
        @com.epam.feel.shared.enums.RequestStatus_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/enums/RequestStatus;)
      ];
    
    result["com.epam.feel.shared.enums.Role/1816515713"] = [
        @com.epam.feel.shared.enums.Role_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.enums.Role_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/enums/Role;),
        @com.epam.feel.shared.enums.Role_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/enums/Role;)
      ];
    
    result["com.epam.feel.shared.excel.Cell/2439422150"] = [
        ,
        ,
        @com.epam.feel.shared.excel.Cell_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/epam/feel/shared/excel/Cell;)
      ];
    
    result["[Lcom.epam.feel.shared.excel.Cell;/1200748068"] = [
        ,
        ,
        @com.epam.feel.shared.excel.Cell_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Lcom/epam/feel/shared/excel/Cell;)
      ];
    
    result["com.epam.feel.shared.exception.EstimatedRequestDetailsException/2032237847"] = [
        @com.epam.feel.shared.exception.EstimatedRequestDetailsException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.exception.EstimatedRequestDetailsException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/exception/EstimatedRequestDetailsException;),
      ];
    
    result["com.epam.feel.shared.exception.RequestCantBeSavedException/3436653510"] = [
        @com.epam.feel.shared.exception.RequestCantBeSavedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.exception.RequestCantBeSavedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/exception/RequestCantBeSavedException;),
      ];
    
    result["com.epam.feel.shared.exception.RequestCantBeSavedException$Type/4121410472"] = [
        @com.epam.feel.shared.exception.RequestCantBeSavedException_Type_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.exception.RequestCantBeSavedException_Type_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/exception/RequestCantBeSavedException$Type;),
      ];
    
    result["com.epam.feel.shared.exception.RequestHasGroupException/2862740989"] = [
        @com.epam.feel.shared.exception.RequestHasGroupException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.epam.feel.shared.exception.RequestHasGroupException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/epam/feel/shared/exception/RequestHasGroupException;),
      ];
    
    result["com.google.gwt.i18n.shared.impl.DateRecord/3375188634"] = [
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/shared/impl/DateRecord;),
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/shared/impl/DateRecord;)
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["com.google.gwt.user.client.rpc.RpcTokenException/2345075298"] = [
        @com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/RpcTokenException;),
      ];
    
    result["com.google.gwt.user.client.rpc.XsrfToken/4254043109"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/XsrfToken;)
      ];
    
    result["java.lang.Boolean/476441737"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Boolean;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Boolean;)
      ];
    
    result["java.lang.Double/858496421"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Double;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Double;)
      ];
    
    result["java.lang.Integer/3438268394"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Integer;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Integer;)
      ];
    
    result["java.lang.Long/4227064769"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Long;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Long;)
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    result["java.sql.Date/730999118"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Date;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Date;)
      ];
    
    result["java.sql.Time/1816797103"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Time;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Time;)
      ];
    
    result["java.sql.Timestamp/3040052672"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Timestamp;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Timestamp;)
      ];
    
    result["java.util.ArrayList/4159755760"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/ArrayList;)
      ];
    
    result["java.util.Arrays$ArrayList/2507071751"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptyList/4157118744"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptyMap/4174664486"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Map;)
      ];
    
    result["java.util.Collections$SingletonList/1586180994"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Date/3385151746"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Date;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Date;)
      ];
    
    result["java.util.HashMap/1797211028"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/HashMap;)
      ];
    
    result["java.util.IdentityHashMap/1839153020"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/IdentityHashMap;)
      ];
    
    result["java.util.LinkedHashMap/3008245022"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedHashMap;)
      ];
    
    result["java.util.LinkedList/3953877921"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedList;)
      ];
    
    result["java.util.Stack/1346942793"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Stack;)
      ];
    
    result["java.util.TreeMap/1493889780"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeMap;)
      ];
    
    result["java.util.Vector/3057315478"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Vector;)
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.client.ui.util.AliveMenuDetails::class)] = "com.epam.feel.client.ui.util.AliveMenuDetails/2602943283";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.ClientDTO::class)] = "com.epam.feel.shared.dto.ClientDTO/575441241";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.DishTypeDTO::class)] = "com.epam.feel.shared.dto.DishTypeDTO/3379931121";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.ExtendedRequestDTO::class)] = "com.epam.feel.shared.dto.ExtendedRequestDTO/1310784871";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.ExtendedRequestDTO[]::class)] = "[Lcom.epam.feel.shared.dto.ExtendedRequestDTO;/4133365399";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.ExtendedRequestGroupDTO::class)] = "com.epam.feel.shared.dto.ExtendedRequestGroupDTO/4036140324";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.ExtendedRequestGroupDTO[]::class)] = "[Lcom.epam.feel.shared.dto.ExtendedRequestGroupDTO;/1460985729";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.MenuDTO::class)] = "com.epam.feel.shared.dto.MenuDTO/3560685466";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.MenuDetailsDTO::class)] = "com.epam.feel.shared.dto.MenuDetailsDTO/2632711538";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.MenuDetailsDTO[]::class)] = "[Lcom.epam.feel.shared.dto.MenuDetailsDTO;/3781366291";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.RequestDTO::class)] = "com.epam.feel.shared.dto.RequestDTO/3610644213";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.RequestDTO[]::class)] = "[Lcom.epam.feel.shared.dto.RequestDTO;/2957074186";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.RequestDetailsDTO::class)] = "com.epam.feel.shared.dto.RequestDetailsDTO/4117466465";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.dto.RequestDetailsDTO[]::class)] = "[Lcom.epam.feel.shared.dto.RequestDetailsDTO;/1901210751";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.enums.GroupStatus::class)] = "com.epam.feel.shared.enums.GroupStatus/614846326";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.enums.MenuStatus::class)] = "com.epam.feel.shared.enums.MenuStatus/1298115897";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.enums.RequestStatus::class)] = "com.epam.feel.shared.enums.RequestStatus/3718825498";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.enums.Role::class)] = "com.epam.feel.shared.enums.Role/1816515713";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.excel.Cell::class)] = "com.epam.feel.shared.excel.Cell/2439422150";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.excel.Cell[]::class)] = "[Lcom.epam.feel.shared.excel.Cell;/1200748068";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.exception.EstimatedRequestDetailsException::class)] = "com.epam.feel.shared.exception.EstimatedRequestDetailsException/2032237847";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.exception.RequestCantBeSavedException::class)] = "com.epam.feel.shared.exception.RequestCantBeSavedException/3436653510";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.exception.RequestCantBeSavedException.Type::class)] = "com.epam.feel.shared.exception.RequestCantBeSavedException$Type/4121410472";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.epam.feel.shared.exception.RequestHasGroupException::class)] = "com.epam.feel.shared.exception.RequestHasGroupException/2862740989";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.shared.impl.DateRecord::class)] = "com.google.gwt.i18n.shared.impl.DateRecord/3375188634";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.RpcTokenException::class)] = "com.google.gwt.user.client.rpc.RpcTokenException/2345075298";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.XsrfToken::class)] = "com.google.gwt.user.client.rpc.XsrfToken/4254043109";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Boolean::class)] = "java.lang.Boolean/476441737";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Double::class)] = "java.lang.Double/858496421";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Integer::class)] = "java.lang.Integer/3438268394";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long::class)] = "java.lang.Long/4227064769";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Date::class)] = "java.sql.Date/730999118";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Time::class)] = "java.sql.Time/1816797103";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Timestamp::class)] = "java.sql.Timestamp/3040052672";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ArrayList::class)] = "java.util.ArrayList/4159755760";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Arrays.ArrayList::class)] = "java.util.Arrays$ArrayList/2507071751";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.EmptyList::class)] = "java.util.Collections$EmptyList/4157118744";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.EmptyMap::class)] = "java.util.Collections$EmptyMap/4174664486";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.SingletonList::class)] = "java.util.Collections$SingletonList/1586180994";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Date::class)] = "java.util.Date/3385151746";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashMap::class)] = "java.util.HashMap/1797211028";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.IdentityHashMap::class)] = "java.util.IdentityHashMap/1839153020";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashMap::class)] = "java.util.LinkedHashMap/3008245022";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedList::class)] = "java.util.LinkedList/3953877921";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Stack::class)] = "java.util.Stack/1346942793";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeMap::class)] = "java.util.TreeMap/1493889780";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Vector::class)] = "java.util.Vector/3057315478";
    return result;
  }-*/;
  
  public RequestInfoService_TypeSerializer() {
    super(null, methodMapNative, null, signatureMapNative);
  }
  
}
