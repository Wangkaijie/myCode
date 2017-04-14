/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.travelzen.fare.galileo.shopping.error;

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

public class GalileoShoppingErrorTable implements org.apache.thrift.TBase<GalileoShoppingErrorTable, GalileoShoppingErrorTable._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GalileoShoppingErrorTable");

  private static final org.apache.thrift.protocol.TField QUERY_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("queryKey", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ERROR_MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMsg", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField LAST_UPDATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("lastUpdateTime", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GalileoShoppingErrorTableStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GalileoShoppingErrorTableTupleSchemeFactory());
  }

  public String queryKey; // optional
  public String errorCode; // optional
  public String errorMsg; // optional
  public long lastUpdateTime; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUERY_KEY((short)1, "queryKey"),
    ERROR_CODE((short)2, "errorCode"),
    ERROR_MSG((short)3, "errorMsg"),
    LAST_UPDATE_TIME((short)4, "lastUpdateTime");

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
        case 1: // QUERY_KEY
          return QUERY_KEY;
        case 2: // ERROR_CODE
          return ERROR_CODE;
        case 3: // ERROR_MSG
          return ERROR_MSG;
        case 4: // LAST_UPDATE_TIME
          return LAST_UPDATE_TIME;
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
  private static final int __LASTUPDATETIME_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.QUERY_KEY,_Fields.ERROR_CODE,_Fields.ERROR_MSG,_Fields.LAST_UPDATE_TIME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERY_KEY, new org.apache.thrift.meta_data.FieldMetaData("queryKey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errorCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ERROR_MSG, new org.apache.thrift.meta_data.FieldMetaData("errorMsg", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAST_UPDATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("lastUpdateTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GalileoShoppingErrorTable.class, metaDataMap);
  }

  public GalileoShoppingErrorTable() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GalileoShoppingErrorTable(GalileoShoppingErrorTable other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetQueryKey()) {
      this.queryKey = other.queryKey;
    }
    if (other.isSetErrorCode()) {
      this.errorCode = other.errorCode;
    }
    if (other.isSetErrorMsg()) {
      this.errorMsg = other.errorMsg;
    }
    this.lastUpdateTime = other.lastUpdateTime;
  }

  public GalileoShoppingErrorTable deepCopy() {
    return new GalileoShoppingErrorTable(this);
  }

  @Override
  public void clear() {
    this.queryKey = null;
    this.errorCode = null;
    this.errorMsg = null;
    setLastUpdateTimeIsSet(false);
    this.lastUpdateTime = 0;
  }

  public String getQueryKey() {
    return this.queryKey;
  }

  public GalileoShoppingErrorTable setQueryKey(String queryKey) {
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

  public String getErrorCode() {
    return this.errorCode;
  }

  public GalileoShoppingErrorTable setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  public void unsetErrorCode() {
    this.errorCode = null;
  }

  /** Returns true if field errorCode is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorCode() {
    return this.errorCode != null;
  }

  public void setErrorCodeIsSet(boolean value) {
    if (!value) {
      this.errorCode = null;
    }
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public GalileoShoppingErrorTable setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }

  public void unsetErrorMsg() {
    this.errorMsg = null;
  }

  /** Returns true if field errorMsg is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMsg() {
    return this.errorMsg != null;
  }

  public void setErrorMsgIsSet(boolean value) {
    if (!value) {
      this.errorMsg = null;
    }
  }

  public long getLastUpdateTime() {
    return this.lastUpdateTime;
  }

  public GalileoShoppingErrorTable setLastUpdateTime(long lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    setLastUpdateTimeIsSet(true);
    return this;
  }

  public void unsetLastUpdateTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTUPDATETIME_ISSET_ID);
  }

  /** Returns true if field lastUpdateTime is set (has been assigned a value) and false otherwise */
  public boolean isSetLastUpdateTime() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTUPDATETIME_ISSET_ID);
  }

  public void setLastUpdateTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTUPDATETIME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUERY_KEY:
      if (value == null) {
        unsetQueryKey();
      } else {
        setQueryKey((String)value);
      }
      break;

    case ERROR_CODE:
      if (value == null) {
        unsetErrorCode();
      } else {
        setErrorCode((String)value);
      }
      break;

    case ERROR_MSG:
      if (value == null) {
        unsetErrorMsg();
      } else {
        setErrorMsg((String)value);
      }
      break;

    case LAST_UPDATE_TIME:
      if (value == null) {
        unsetLastUpdateTime();
      } else {
        setLastUpdateTime((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERY_KEY:
      return getQueryKey();

    case ERROR_CODE:
      return getErrorCode();

    case ERROR_MSG:
      return getErrorMsg();

    case LAST_UPDATE_TIME:
      return Long.valueOf(getLastUpdateTime());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUERY_KEY:
      return isSetQueryKey();
    case ERROR_CODE:
      return isSetErrorCode();
    case ERROR_MSG:
      return isSetErrorMsg();
    case LAST_UPDATE_TIME:
      return isSetLastUpdateTime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GalileoShoppingErrorTable)
      return this.equals((GalileoShoppingErrorTable)that);
    return false;
  }

  public boolean equals(GalileoShoppingErrorTable that) {
    if (that == null)
      return false;

    boolean this_present_queryKey = true && this.isSetQueryKey();
    boolean that_present_queryKey = true && that.isSetQueryKey();
    if (this_present_queryKey || that_present_queryKey) {
      if (!(this_present_queryKey && that_present_queryKey))
        return false;
      if (!this.queryKey.equals(that.queryKey))
        return false;
    }

    boolean this_present_errorCode = true && this.isSetErrorCode();
    boolean that_present_errorCode = true && that.isSetErrorCode();
    if (this_present_errorCode || that_present_errorCode) {
      if (!(this_present_errorCode && that_present_errorCode))
        return false;
      if (!this.errorCode.equals(that.errorCode))
        return false;
    }

    boolean this_present_errorMsg = true && this.isSetErrorMsg();
    boolean that_present_errorMsg = true && that.isSetErrorMsg();
    if (this_present_errorMsg || that_present_errorMsg) {
      if (!(this_present_errorMsg && that_present_errorMsg))
        return false;
      if (!this.errorMsg.equals(that.errorMsg))
        return false;
    }

    boolean this_present_lastUpdateTime = true && this.isSetLastUpdateTime();
    boolean that_present_lastUpdateTime = true && that.isSetLastUpdateTime();
    if (this_present_lastUpdateTime || that_present_lastUpdateTime) {
      if (!(this_present_lastUpdateTime && that_present_lastUpdateTime))
        return false;
      if (this.lastUpdateTime != that.lastUpdateTime)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(GalileoShoppingErrorTable other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    GalileoShoppingErrorTable typedOther = (GalileoShoppingErrorTable)other;

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
    lastComparison = Boolean.valueOf(isSetErrorCode()).compareTo(typedOther.isSetErrorCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorCode, typedOther.errorCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrorMsg()).compareTo(typedOther.isSetErrorMsg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMsg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMsg, typedOther.errorMsg);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastUpdateTime()).compareTo(typedOther.isSetLastUpdateTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastUpdateTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastUpdateTime, typedOther.lastUpdateTime);
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
    StringBuilder sb = new StringBuilder("GalileoShoppingErrorTable(");
    boolean first = true;

    if (isSetQueryKey()) {
      sb.append("queryKey:");
      if (this.queryKey == null) {
        sb.append("null");
      } else {
        sb.append(this.queryKey);
      }
      first = false;
    }
    if (isSetErrorCode()) {
      if (!first) sb.append(", ");
      sb.append("errorCode:");
      if (this.errorCode == null) {
        sb.append("null");
      } else {
        sb.append(this.errorCode);
      }
      first = false;
    }
    if (isSetErrorMsg()) {
      if (!first) sb.append(", ");
      sb.append("errorMsg:");
      if (this.errorMsg == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMsg);
      }
      first = false;
    }
    if (isSetLastUpdateTime()) {
      if (!first) sb.append(", ");
      sb.append("lastUpdateTime:");
      sb.append(this.lastUpdateTime);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GalileoShoppingErrorTableStandardSchemeFactory implements SchemeFactory {
    public GalileoShoppingErrorTableStandardScheme getScheme() {
      return new GalileoShoppingErrorTableStandardScheme();
    }
  }

  private static class GalileoShoppingErrorTableStandardScheme extends StandardScheme<GalileoShoppingErrorTable> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GalileoShoppingErrorTable struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERY_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.queryKey = iprot.readString();
              struct.setQueryKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERROR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorCode = iprot.readString();
              struct.setErrorCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ERROR_MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMsg = iprot.readString();
              struct.setErrorMsgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LAST_UPDATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lastUpdateTime = iprot.readI64();
              struct.setLastUpdateTimeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GalileoShoppingErrorTable struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.queryKey != null) {
        if (struct.isSetQueryKey()) {
          oprot.writeFieldBegin(QUERY_KEY_FIELD_DESC);
          oprot.writeString(struct.queryKey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.errorCode != null) {
        if (struct.isSetErrorCode()) {
          oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
          oprot.writeString(struct.errorCode);
          oprot.writeFieldEnd();
        }
      }
      if (struct.errorMsg != null) {
        if (struct.isSetErrorMsg()) {
          oprot.writeFieldBegin(ERROR_MSG_FIELD_DESC);
          oprot.writeString(struct.errorMsg);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetLastUpdateTime()) {
        oprot.writeFieldBegin(LAST_UPDATE_TIME_FIELD_DESC);
        oprot.writeI64(struct.lastUpdateTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GalileoShoppingErrorTableTupleSchemeFactory implements SchemeFactory {
    public GalileoShoppingErrorTableTupleScheme getScheme() {
      return new GalileoShoppingErrorTableTupleScheme();
    }
  }

  private static class GalileoShoppingErrorTableTupleScheme extends TupleScheme<GalileoShoppingErrorTable> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingErrorTable struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQueryKey()) {
        optionals.set(0);
      }
      if (struct.isSetErrorCode()) {
        optionals.set(1);
      }
      if (struct.isSetErrorMsg()) {
        optionals.set(2);
      }
      if (struct.isSetLastUpdateTime()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetQueryKey()) {
        oprot.writeString(struct.queryKey);
      }
      if (struct.isSetErrorCode()) {
        oprot.writeString(struct.errorCode);
      }
      if (struct.isSetErrorMsg()) {
        oprot.writeString(struct.errorMsg);
      }
      if (struct.isSetLastUpdateTime()) {
        oprot.writeI64(struct.lastUpdateTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingErrorTable struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.queryKey = iprot.readString();
        struct.setQueryKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.errorCode = iprot.readString();
        struct.setErrorCodeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.errorMsg = iprot.readString();
        struct.setErrorMsgIsSet(true);
      }
      if (incoming.get(3)) {
        struct.lastUpdateTime = iprot.readI64();
        struct.setLastUpdateTimeIsSet(true);
      }
    }
  }

}
