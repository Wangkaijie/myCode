/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.travelzen.fare.galileo.shopping.requestresponse;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GalileoShoppingResponse implements org.apache.thrift.TBase<GalileoShoppingResponse, GalileoShoppingResponse._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GalileoShoppingResponse");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField GALILEO_SHOPPING_ROUTE_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("GalileoShoppingRouteList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField ERROR_FIELD_DESC = new org.apache.thrift.protocol.TField("error", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField QUERY_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("queryKey", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField GALILEO_SHOPPING_RESPONSE_STATUS_ENUM_FIELD_DESC = new org.apache.thrift.protocol.TField("galileoShoppingResponseStatusEnum", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField SEARCH_SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("searchSource", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GalileoShoppingResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GalileoShoppingResponseTupleSchemeFactory());
  }

  public String id; // optional
  public List<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute> GalileoShoppingRouteList; // optional
  public com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable error; // optional
  public String queryKey; // optional
  /**
   * 
   * @see GalileoShoppingResponseStatusEnum
   */
  public GalileoShoppingResponseStatusEnum galileoShoppingResponseStatusEnum; // optional
  public String searchSource; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    GALILEO_SHOPPING_ROUTE_LIST((short)2, "GalileoShoppingRouteList"),
    ERROR((short)3, "error"),
    QUERY_KEY((short)4, "queryKey"),
    /**
     * 
     * @see GalileoShoppingResponseStatusEnum
     */
    GALILEO_SHOPPING_RESPONSE_STATUS_ENUM((short)5, "galileoShoppingResponseStatusEnum"),
    SEARCH_SOURCE((short)6, "searchSource");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // GALILEO_SHOPPING_ROUTE_LIST
          return GALILEO_SHOPPING_ROUTE_LIST;
        case 3: // ERROR
          return ERROR;
        case 4: // QUERY_KEY
          return QUERY_KEY;
        case 5: // GALILEO_SHOPPING_RESPONSE_STATUS_ENUM
          return GALILEO_SHOPPING_RESPONSE_STATUS_ENUM;
        case 6: // SEARCH_SOURCE
          return SEARCH_SOURCE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.ID,_Fields.GALILEO_SHOPPING_ROUTE_LIST,_Fields.ERROR,_Fields.QUERY_KEY,_Fields.GALILEO_SHOPPING_RESPONSE_STATUS_ENUM,_Fields.SEARCH_SOURCE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GALILEO_SHOPPING_ROUTE_LIST, new org.apache.thrift.meta_data.FieldMetaData("GalileoShoppingRouteList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute.class))));
    tmpMap.put(_Fields.ERROR, new org.apache.thrift.meta_data.FieldMetaData("error", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable.class)));
    tmpMap.put(_Fields.QUERY_KEY, new org.apache.thrift.meta_data.FieldMetaData("queryKey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GALILEO_SHOPPING_RESPONSE_STATUS_ENUM, new org.apache.thrift.meta_data.FieldMetaData("galileoShoppingResponseStatusEnum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, GalileoShoppingResponseStatusEnum.class)));
    tmpMap.put(_Fields.SEARCH_SOURCE, new org.apache.thrift.meta_data.FieldMetaData("searchSource", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GalileoShoppingResponse.class, metaDataMap);
  }

  public GalileoShoppingResponse() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GalileoShoppingResponse(GalileoShoppingResponse other) {
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetGalileoShoppingRouteList()) {
      List<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute> __this__GalileoShoppingRouteList = new ArrayList<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute>();
      for (com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute other_element : other.GalileoShoppingRouteList) {
        __this__GalileoShoppingRouteList.add(new com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute(other_element));
      }
      this.GalileoShoppingRouteList = __this__GalileoShoppingRouteList;
    }
    if (other.isSetError()) {
      this.error = new com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable(other.error);
    }
    if (other.isSetQueryKey()) {
      this.queryKey = other.queryKey;
    }
    if (other.isSetGalileoShoppingResponseStatusEnum()) {
      this.galileoShoppingResponseStatusEnum = other.galileoShoppingResponseStatusEnum;
    }
    if (other.isSetSearchSource()) {
      this.searchSource = other.searchSource;
    }
  }

  public GalileoShoppingResponse deepCopy() {
    return new GalileoShoppingResponse(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.GalileoShoppingRouteList = null;
    this.error = null;
    this.queryKey = null;
    this.galileoShoppingResponseStatusEnum = null;
    this.searchSource = null;
  }

  public String getId() {
    return this.id;
  }

  public GalileoShoppingResponse setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public int getGalileoShoppingRouteListSize() {
    return (this.GalileoShoppingRouteList == null) ? 0 : this.GalileoShoppingRouteList.size();
  }

  public java.util.Iterator<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute> getGalileoShoppingRouteListIterator() {
    return (this.GalileoShoppingRouteList == null) ? null : this.GalileoShoppingRouteList.iterator();
  }

  public void addToGalileoShoppingRouteList(com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute elem) {
    if (this.GalileoShoppingRouteList == null) {
      this.GalileoShoppingRouteList = new ArrayList<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute>();
    }
    this.GalileoShoppingRouteList.add(elem);
  }

  public List<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute> getGalileoShoppingRouteList() {
    return this.GalileoShoppingRouteList;
  }

  public GalileoShoppingResponse setGalileoShoppingRouteList(List<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute> GalileoShoppingRouteList) {
    this.GalileoShoppingRouteList = GalileoShoppingRouteList;
    return this;
  }

  public void unsetGalileoShoppingRouteList() {
    this.GalileoShoppingRouteList = null;
  }

  /** Returns true if field GalileoShoppingRouteList is set (has been assigned a value) and false otherwise */
  public boolean isSetGalileoShoppingRouteList() {
    return this.GalileoShoppingRouteList != null;
  }

  public void setGalileoShoppingRouteListIsSet(boolean value) {
    if (!value) {
      this.GalileoShoppingRouteList = null;
    }
  }

  public com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable getError() {
    return this.error;
  }

  public GalileoShoppingResponse setError(com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable error) {
    this.error = error;
    return this;
  }

  public void unsetError() {
    this.error = null;
  }

  /** Returns true if field error is set (has been assigned a value) and false otherwise */
  public boolean isSetError() {
    return this.error != null;
  }

  public void setErrorIsSet(boolean value) {
    if (!value) {
      this.error = null;
    }
  }

  public String getQueryKey() {
    return this.queryKey;
  }

  public GalileoShoppingResponse setQueryKey(String queryKey) {
    this.queryKey = queryKey;
    return this;
  }

  public void unsetQueryKey() {
    this.queryKey = null;
  }

  /** Returns true if field queryKey is set (has been assigned a value) and false otherwise */
  public boolean isSetQueryKey() {
    return this.queryKey != null;
  }

  public void setQueryKeyIsSet(boolean value) {
    if (!value) {
      this.queryKey = null;
    }
  }

  /**
   * 
   * @see GalileoShoppingResponseStatusEnum
   */
  public GalileoShoppingResponseStatusEnum getGalileoShoppingResponseStatusEnum() {
    return this.galileoShoppingResponseStatusEnum;
  }

  /**
   * 
   * @see GalileoShoppingResponseStatusEnum
   */
  public GalileoShoppingResponse setGalileoShoppingResponseStatusEnum(GalileoShoppingResponseStatusEnum galileoShoppingResponseStatusEnum) {
    this.galileoShoppingResponseStatusEnum = galileoShoppingResponseStatusEnum;
    return this;
  }

  public void unsetGalileoShoppingResponseStatusEnum() {
    this.galileoShoppingResponseStatusEnum = null;
  }

  /** Returns true if field galileoShoppingResponseStatusEnum is set (has been assigned a value) and false otherwise */
  public boolean isSetGalileoShoppingResponseStatusEnum() {
    return this.galileoShoppingResponseStatusEnum != null;
  }

  public void setGalileoShoppingResponseStatusEnumIsSet(boolean value) {
    if (!value) {
      this.galileoShoppingResponseStatusEnum = null;
    }
  }

  public String getSearchSource() {
    return this.searchSource;
  }

  public GalileoShoppingResponse setSearchSource(String searchSource) {
    this.searchSource = searchSource;
    return this;
  }

  public void unsetSearchSource() {
    this.searchSource = null;
  }

  /** Returns true if field searchSource is set (has been assigned a value) and false otherwise */
  public boolean isSetSearchSource() {
    return this.searchSource != null;
  }

  public void setSearchSourceIsSet(boolean value) {
    if (!value) {
      this.searchSource = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case GALILEO_SHOPPING_ROUTE_LIST:
      if (value == null) {
        unsetGalileoShoppingRouteList();
      } else {
        setGalileoShoppingRouteList((List<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute>)value);
      }
      break;

    case ERROR:
      if (value == null) {
        unsetError();
      } else {
        setError((com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable)value);
      }
      break;

    case QUERY_KEY:
      if (value == null) {
        unsetQueryKey();
      } else {
        setQueryKey((String)value);
      }
      break;

    case GALILEO_SHOPPING_RESPONSE_STATUS_ENUM:
      if (value == null) {
        unsetGalileoShoppingResponseStatusEnum();
      } else {
        setGalileoShoppingResponseStatusEnum((GalileoShoppingResponseStatusEnum)value);
      }
      break;

    case SEARCH_SOURCE:
      if (value == null) {
        unsetSearchSource();
      } else {
        setSearchSource((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case GALILEO_SHOPPING_ROUTE_LIST:
      return getGalileoShoppingRouteList();

    case ERROR:
      return getError();

    case QUERY_KEY:
      return getQueryKey();

    case GALILEO_SHOPPING_RESPONSE_STATUS_ENUM:
      return getGalileoShoppingResponseStatusEnum();

    case SEARCH_SOURCE:
      return getSearchSource();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case GALILEO_SHOPPING_ROUTE_LIST:
      return isSetGalileoShoppingRouteList();
    case ERROR:
      return isSetError();
    case QUERY_KEY:
      return isSetQueryKey();
    case GALILEO_SHOPPING_RESPONSE_STATUS_ENUM:
      return isSetGalileoShoppingResponseStatusEnum();
    case SEARCH_SOURCE:
      return isSetSearchSource();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GalileoShoppingResponse)
      return this.equals((GalileoShoppingResponse)that);
    return false;
  }

  public boolean equals(GalileoShoppingResponse that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_GalileoShoppingRouteList = true && this.isSetGalileoShoppingRouteList();
    boolean that_present_GalileoShoppingRouteList = true && that.isSetGalileoShoppingRouteList();
    if (this_present_GalileoShoppingRouteList || that_present_GalileoShoppingRouteList) {
      if (!(this_present_GalileoShoppingRouteList && that_present_GalileoShoppingRouteList))
        return false;
      if (!this.GalileoShoppingRouteList.equals(that.GalileoShoppingRouteList))
        return false;
    }

    boolean this_present_error = true && this.isSetError();
    boolean that_present_error = true && that.isSetError();
    if (this_present_error || that_present_error) {
      if (!(this_present_error && that_present_error))
        return false;
      if (!this.error.equals(that.error))
        return false;
    }

    boolean this_present_queryKey = true && this.isSetQueryKey();
    boolean that_present_queryKey = true && that.isSetQueryKey();
    if (this_present_queryKey || that_present_queryKey) {
      if (!(this_present_queryKey && that_present_queryKey))
        return false;
      if (!this.queryKey.equals(that.queryKey))
        return false;
    }

    boolean this_present_galileoShoppingResponseStatusEnum = true && this.isSetGalileoShoppingResponseStatusEnum();
    boolean that_present_galileoShoppingResponseStatusEnum = true && that.isSetGalileoShoppingResponseStatusEnum();
    if (this_present_galileoShoppingResponseStatusEnum || that_present_galileoShoppingResponseStatusEnum) {
      if (!(this_present_galileoShoppingResponseStatusEnum && that_present_galileoShoppingResponseStatusEnum))
        return false;
      if (!this.galileoShoppingResponseStatusEnum.equals(that.galileoShoppingResponseStatusEnum))
        return false;
    }

    boolean this_present_searchSource = true && this.isSetSearchSource();
    boolean that_present_searchSource = true && that.isSetSearchSource();
    if (this_present_searchSource || that_present_searchSource) {
      if (!(this_present_searchSource && that_present_searchSource))
        return false;
      if (!this.searchSource.equals(that.searchSource))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(GalileoShoppingResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    GalileoShoppingResponse typedOther = (GalileoShoppingResponse)other;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGalileoShoppingRouteList()).compareTo(typedOther.isSetGalileoShoppingRouteList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGalileoShoppingRouteList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.GalileoShoppingRouteList, typedOther.GalileoShoppingRouteList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetError()).compareTo(typedOther.isSetError());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error, typedOther.error);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQueryKey()).compareTo(typedOther.isSetQueryKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueryKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queryKey, typedOther.queryKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGalileoShoppingResponseStatusEnum()).compareTo(typedOther.isSetGalileoShoppingResponseStatusEnum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGalileoShoppingResponseStatusEnum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.galileoShoppingResponseStatusEnum, typedOther.galileoShoppingResponseStatusEnum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSearchSource()).compareTo(typedOther.isSetSearchSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSearchSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.searchSource, typedOther.searchSource);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GalileoShoppingResponse(");
    boolean first = true;

    if (isSetId()) {
      sb.append("id:");
      if (this.id == null) {
        sb.append("null");
      } else {
        sb.append(this.id);
      }
      first = false;
    }
    if (isSetGalileoShoppingRouteList()) {
      if (!first) sb.append(", ");
      sb.append("GalileoShoppingRouteList:");
      if (this.GalileoShoppingRouteList == null) {
        sb.append("null");
      } else {
        sb.append(this.GalileoShoppingRouteList);
      }
      first = false;
    }
    if (isSetError()) {
      if (!first) sb.append(", ");
      sb.append("error:");
      if (this.error == null) {
        sb.append("null");
      } else {
        sb.append(this.error);
      }
      first = false;
    }
    if (isSetQueryKey()) {
      if (!first) sb.append(", ");
      sb.append("queryKey:");
      if (this.queryKey == null) {
        sb.append("null");
      } else {
        sb.append(this.queryKey);
      }
      first = false;
    }
    if (isSetGalileoShoppingResponseStatusEnum()) {
      if (!first) sb.append(", ");
      sb.append("galileoShoppingResponseStatusEnum:");
      if (this.galileoShoppingResponseStatusEnum == null) {
        sb.append("null");
      } else {
        sb.append(this.galileoShoppingResponseStatusEnum);
      }
      first = false;
    }
    if (isSetSearchSource()) {
      if (!first) sb.append(", ");
      sb.append("searchSource:");
      if (this.searchSource == null) {
        sb.append("null");
      } else {
        sb.append(this.searchSource);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (error != null) {
      error.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GalileoShoppingResponseStandardSchemeFactory implements SchemeFactory {
    public GalileoShoppingResponseStandardScheme getScheme() {
      return new GalileoShoppingResponseStandardScheme();
    }
  }

  private static class GalileoShoppingResponseStandardScheme extends StandardScheme<GalileoShoppingResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GalileoShoppingResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GALILEO_SHOPPING_ROUTE_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list32 = iprot.readListBegin();
                struct.GalileoShoppingRouteList = new ArrayList<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute>(_list32.size);
                for (int _i33 = 0; _i33 < _list32.size; ++_i33)
                {
                  com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute _elem34; // required
                  _elem34 = new com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute();
                  _elem34.read(iprot);
                  struct.GalileoShoppingRouteList.add(_elem34);
                }
                iprot.readListEnd();
              }
              struct.setGalileoShoppingRouteListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ERROR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.error = new com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable();
              struct.error.read(iprot);
              struct.setErrorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUERY_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.queryKey = iprot.readString();
              struct.setQueryKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // GALILEO_SHOPPING_RESPONSE_STATUS_ENUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.galileoShoppingResponseStatusEnum = GalileoShoppingResponseStatusEnum.findByValue(iprot.readI32());
              struct.setGalileoShoppingResponseStatusEnumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // SEARCH_SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.searchSource = iprot.readString();
              struct.setSearchSourceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, GalileoShoppingResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        if (struct.isSetId()) {
          oprot.writeFieldBegin(ID_FIELD_DESC);
          oprot.writeString(struct.id);
          oprot.writeFieldEnd();
        }
      }
      if (struct.GalileoShoppingRouteList != null) {
        if (struct.isSetGalileoShoppingRouteList()) {
          oprot.writeFieldBegin(GALILEO_SHOPPING_ROUTE_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.GalileoShoppingRouteList.size()));
            for (com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute _iter35 : struct.GalileoShoppingRouteList)
            {
              _iter35.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.error != null) {
        if (struct.isSetError()) {
          oprot.writeFieldBegin(ERROR_FIELD_DESC);
          struct.error.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.queryKey != null) {
        if (struct.isSetQueryKey()) {
          oprot.writeFieldBegin(QUERY_KEY_FIELD_DESC);
          oprot.writeString(struct.queryKey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.galileoShoppingResponseStatusEnum != null) {
        if (struct.isSetGalileoShoppingResponseStatusEnum()) {
          oprot.writeFieldBegin(GALILEO_SHOPPING_RESPONSE_STATUS_ENUM_FIELD_DESC);
          oprot.writeI32(struct.galileoShoppingResponseStatusEnum.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.searchSource != null) {
        if (struct.isSetSearchSource()) {
          oprot.writeFieldBegin(SEARCH_SOURCE_FIELD_DESC);
          oprot.writeString(struct.searchSource);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GalileoShoppingResponseTupleSchemeFactory implements SchemeFactory {
    public GalileoShoppingResponseTupleScheme getScheme() {
      return new GalileoShoppingResponseTupleScheme();
    }
  }

  private static class GalileoShoppingResponseTupleScheme extends TupleScheme<GalileoShoppingResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetGalileoShoppingRouteList()) {
        optionals.set(1);
      }
      if (struct.isSetError()) {
        optionals.set(2);
      }
      if (struct.isSetQueryKey()) {
        optionals.set(3);
      }
      if (struct.isSetGalileoShoppingResponseStatusEnum()) {
        optionals.set(4);
      }
      if (struct.isSetSearchSource()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetGalileoShoppingRouteList()) {
        {
          oprot.writeI32(struct.GalileoShoppingRouteList.size());
          for (com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute _iter36 : struct.GalileoShoppingRouteList)
          {
            _iter36.write(oprot);
          }
        }
      }
      if (struct.isSetError()) {
        struct.error.write(oprot);
      }
      if (struct.isSetQueryKey()) {
        oprot.writeString(struct.queryKey);
      }
      if (struct.isSetGalileoShoppingResponseStatusEnum()) {
        oprot.writeI32(struct.galileoShoppingResponseStatusEnum.getValue());
      }
      if (struct.isSetSearchSource()) {
        oprot.writeString(struct.searchSource);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list37 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.GalileoShoppingRouteList = new ArrayList<com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute>(_list37.size);
          for (int _i38 = 0; _i38 < _list37.size; ++_i38)
          {
            com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute _elem39; // required
            _elem39 = new com.travelzen.fare.galileo.shopping.route.GalileoShoppingRoute();
            _elem39.read(iprot);
            struct.GalileoShoppingRouteList.add(_elem39);
          }
        }
        struct.setGalileoShoppingRouteListIsSet(true);
      }
      if (incoming.get(2)) {
        struct.error = new com.travelzen.fare.galileo.shopping.error.GalileoShoppingErrorTable();
        struct.error.read(iprot);
        struct.setErrorIsSet(true);
      }
      if (incoming.get(3)) {
        struct.queryKey = iprot.readString();
        struct.setQueryKeyIsSet(true);
      }
      if (incoming.get(4)) {
        struct.galileoShoppingResponseStatusEnum = GalileoShoppingResponseStatusEnum.findByValue(iprot.readI32());
        struct.setGalileoShoppingResponseStatusEnumIsSet(true);
      }
      if (incoming.get(5)) {
        struct.searchSource = iprot.readString();
        struct.setSearchSourceIsSet(true);
      }
    }
  }

}

