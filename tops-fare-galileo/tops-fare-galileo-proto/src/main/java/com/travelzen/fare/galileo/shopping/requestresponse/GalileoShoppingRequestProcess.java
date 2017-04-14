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

public class GalileoShoppingRequestProcess implements org.apache.thrift.TBase<GalileoShoppingRequestProcess, GalileoShoppingRequestProcess._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GalileoShoppingRequestProcess");

  private static final org.apache.thrift.protocol.TField FROM_CITY_FIELD_DESC = new org.apache.thrift.protocol.TField("fromCity", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TO_CITY_FIELD_DESC = new org.apache.thrift.protocol.TField("toCity", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FROM_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("fromDate", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GalileoShoppingRequestProcessStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GalileoShoppingRequestProcessTupleSchemeFactory());
  }

  public String fromCity; // required
  public String toCity; // required
  public String fromDate; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FROM_CITY((short)1, "fromCity"),
    TO_CITY((short)2, "toCity"),
    FROM_DATE((short)3, "fromDate");

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
        case 1: // FROM_CITY
          return FROM_CITY;
        case 2: // TO_CITY
          return TO_CITY;
        case 3: // FROM_DATE
          return FROM_DATE;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FROM_CITY, new org.apache.thrift.meta_data.FieldMetaData("fromCity", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TO_CITY, new org.apache.thrift.meta_data.FieldMetaData("toCity", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FROM_DATE, new org.apache.thrift.meta_data.FieldMetaData("fromDate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GalileoShoppingRequestProcess.class, metaDataMap);
  }

  public GalileoShoppingRequestProcess() {
  }

  public GalileoShoppingRequestProcess(
    String fromCity,
    String toCity,
    String fromDate)
  {
    this();
    this.fromCity = fromCity;
    this.toCity = toCity;
    this.fromDate = fromDate;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GalileoShoppingRequestProcess(GalileoShoppingRequestProcess other) {
    if (other.isSetFromCity()) {
      this.fromCity = other.fromCity;
    }
    if (other.isSetToCity()) {
      this.toCity = other.toCity;
    }
    if (other.isSetFromDate()) {
      this.fromDate = other.fromDate;
    }
  }

  public GalileoShoppingRequestProcess deepCopy() {
    return new GalileoShoppingRequestProcess(this);
  }

  @Override
  public void clear() {
    this.fromCity = null;
    this.toCity = null;
    this.fromDate = null;
  }

  public String getFromCity() {
    return this.fromCity;
  }

  public GalileoShoppingRequestProcess setFromCity(String fromCity) {
    this.fromCity = fromCity;
    return this;
  }

  public void unsetFromCity() {
    this.fromCity = null;
  }

  /** Returns true if field fromCity is set (has been assigned a value) and false otherwise */
  public boolean isSetFromCity() {
    return this.fromCity != null;
  }

  public void setFromCityIsSet(boolean value) {
    if (!value) {
      this.fromCity = null;
    }
  }

  public String getToCity() {
    return this.toCity;
  }

  public GalileoShoppingRequestProcess setToCity(String toCity) {
    this.toCity = toCity;
    return this;
  }

  public void unsetToCity() {
    this.toCity = null;
  }

  /** Returns true if field toCity is set (has been assigned a value) and false otherwise */
  public boolean isSetToCity() {
    return this.toCity != null;
  }

  public void setToCityIsSet(boolean value) {
    if (!value) {
      this.toCity = null;
    }
  }

  public String getFromDate() {
    return this.fromDate;
  }

  public GalileoShoppingRequestProcess setFromDate(String fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  public void unsetFromDate() {
    this.fromDate = null;
  }

  /** Returns true if field fromDate is set (has been assigned a value) and false otherwise */
  public boolean isSetFromDate() {
    return this.fromDate != null;
  }

  public void setFromDateIsSet(boolean value) {
    if (!value) {
      this.fromDate = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FROM_CITY:
      if (value == null) {
        unsetFromCity();
      } else {
        setFromCity((String)value);
      }
      break;

    case TO_CITY:
      if (value == null) {
        unsetToCity();
      } else {
        setToCity((String)value);
      }
      break;

    case FROM_DATE:
      if (value == null) {
        unsetFromDate();
      } else {
        setFromDate((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FROM_CITY:
      return getFromCity();

    case TO_CITY:
      return getToCity();

    case FROM_DATE:
      return getFromDate();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FROM_CITY:
      return isSetFromCity();
    case TO_CITY:
      return isSetToCity();
    case FROM_DATE:
      return isSetFromDate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GalileoShoppingRequestProcess)
      return this.equals((GalileoShoppingRequestProcess)that);
    return false;
  }

  public boolean equals(GalileoShoppingRequestProcess that) {
    if (that == null)
      return false;

    boolean this_present_fromCity = true && this.isSetFromCity();
    boolean that_present_fromCity = true && that.isSetFromCity();
    if (this_present_fromCity || that_present_fromCity) {
      if (!(this_present_fromCity && that_present_fromCity))
        return false;
      if (!this.fromCity.equals(that.fromCity))
        return false;
    }

    boolean this_present_toCity = true && this.isSetToCity();
    boolean that_present_toCity = true && that.isSetToCity();
    if (this_present_toCity || that_present_toCity) {
      if (!(this_present_toCity && that_present_toCity))
        return false;
      if (!this.toCity.equals(that.toCity))
        return false;
    }

    boolean this_present_fromDate = true && this.isSetFromDate();
    boolean that_present_fromDate = true && that.isSetFromDate();
    if (this_present_fromDate || that_present_fromDate) {
      if (!(this_present_fromDate && that_present_fromDate))
        return false;
      if (!this.fromDate.equals(that.fromDate))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(GalileoShoppingRequestProcess other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    GalileoShoppingRequestProcess typedOther = (GalileoShoppingRequestProcess)other;

    lastComparison = Boolean.valueOf(isSetFromCity()).compareTo(typedOther.isSetFromCity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFromCity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fromCity, typedOther.fromCity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetToCity()).compareTo(typedOther.isSetToCity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetToCity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.toCity, typedOther.toCity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFromDate()).compareTo(typedOther.isSetFromDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFromDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fromDate, typedOther.fromDate);
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
    StringBuilder sb = new StringBuilder("GalileoShoppingRequestProcess(");
    boolean first = true;

    sb.append("fromCity:");
    if (this.fromCity == null) {
      sb.append("null");
    } else {
      sb.append(this.fromCity);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("toCity:");
    if (this.toCity == null) {
      sb.append("null");
    } else {
      sb.append(this.toCity);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fromDate:");
    if (this.fromDate == null) {
      sb.append("null");
    } else {
      sb.append(this.fromDate);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (fromCity == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'fromCity' was not present! Struct: " + toString());
    }
    if (toCity == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'toCity' was not present! Struct: " + toString());
    }
    if (fromDate == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'fromDate' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GalileoShoppingRequestProcessStandardSchemeFactory implements SchemeFactory {
    public GalileoShoppingRequestProcessStandardScheme getScheme() {
      return new GalileoShoppingRequestProcessStandardScheme();
    }
  }

  private static class GalileoShoppingRequestProcessStandardScheme extends StandardScheme<GalileoShoppingRequestProcess> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GalileoShoppingRequestProcess struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FROM_CITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fromCity = iprot.readString();
              struct.setFromCityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TO_CITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.toCity = iprot.readString();
              struct.setToCityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FROM_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fromDate = iprot.readString();
              struct.setFromDateIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GalileoShoppingRequestProcess struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fromCity != null) {
        oprot.writeFieldBegin(FROM_CITY_FIELD_DESC);
        oprot.writeString(struct.fromCity);
        oprot.writeFieldEnd();
      }
      if (struct.toCity != null) {
        oprot.writeFieldBegin(TO_CITY_FIELD_DESC);
        oprot.writeString(struct.toCity);
        oprot.writeFieldEnd();
      }
      if (struct.fromDate != null) {
        oprot.writeFieldBegin(FROM_DATE_FIELD_DESC);
        oprot.writeString(struct.fromDate);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GalileoShoppingRequestProcessTupleSchemeFactory implements SchemeFactory {
    public GalileoShoppingRequestProcessTupleScheme getScheme() {
      return new GalileoShoppingRequestProcessTupleScheme();
    }
  }

  private static class GalileoShoppingRequestProcessTupleScheme extends TupleScheme<GalileoShoppingRequestProcess> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingRequestProcess struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.fromCity);
      oprot.writeString(struct.toCity);
      oprot.writeString(struct.fromDate);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingRequestProcess struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.fromCity = iprot.readString();
      struct.setFromCityIsSet(true);
      struct.toCity = iprot.readString();
      struct.setToCityIsSet(true);
      struct.fromDate = iprot.readString();
      struct.setFromDateIsSet(true);
    }
  }

}
