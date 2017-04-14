/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.travelzen.fare.galileo.shopping.flight;

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

public class GalileoShoppingFlightStopOver implements org.apache.thrift.TBase<GalileoShoppingFlightStopOver, GalileoShoppingFlightStopOver._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GalileoShoppingFlightStopOver");

  private static final org.apache.thrift.protocol.TField STOP_AIRPORT_FIELD_DESC = new org.apache.thrift.protocol.TField("stopAirport", org.apache.thrift.protocol.TType.STRING, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new GalileoShoppingFlightStopOverStandardSchemeFactory());
    schemes.put(TupleScheme.class, new GalileoShoppingFlightStopOverTupleSchemeFactory());
  }

  public String stopAirport; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STOP_AIRPORT((short)1, "stopAirport");

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
        case 1: // STOP_AIRPORT
          return STOP_AIRPORT;
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
  private _Fields optionals[] = {_Fields.STOP_AIRPORT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STOP_AIRPORT, new org.apache.thrift.meta_data.FieldMetaData("stopAirport", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GalileoShoppingFlightStopOver.class, metaDataMap);
  }

  public GalileoShoppingFlightStopOver() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GalileoShoppingFlightStopOver(GalileoShoppingFlightStopOver other) {
    if (other.isSetStopAirport()) {
      this.stopAirport = other.stopAirport;
    }
  }

  public GalileoShoppingFlightStopOver deepCopy() {
    return new GalileoShoppingFlightStopOver(this);
  }

  @Override
  public void clear() {
    this.stopAirport = null;
  }

  public String getStopAirport() {
    return this.stopAirport;
  }

  public GalileoShoppingFlightStopOver setStopAirport(String stopAirport) {
    this.stopAirport = stopAirport;
    return this;
  }

  public void unsetStopAirport() {
    this.stopAirport = null;
  }

  /** Returns true if field stopAirport is set (has been assigned a value) and false otherwise */
  public boolean isSetStopAirport() {
    return this.stopAirport != null;
  }

  public void setStopAirportIsSet(boolean value) {
    if (!value) {
      this.stopAirport = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case STOP_AIRPORT:
      if (value == null) {
        unsetStopAirport();
      } else {
        setStopAirport((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STOP_AIRPORT:
      return getStopAirport();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STOP_AIRPORT:
      return isSetStopAirport();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GalileoShoppingFlightStopOver)
      return this.equals((GalileoShoppingFlightStopOver)that);
    return false;
  }

  public boolean equals(GalileoShoppingFlightStopOver that) {
    if (that == null)
      return false;

    boolean this_present_stopAirport = true && this.isSetStopAirport();
    boolean that_present_stopAirport = true && that.isSetStopAirport();
    if (this_present_stopAirport || that_present_stopAirport) {
      if (!(this_present_stopAirport && that_present_stopAirport))
        return false;
      if (!this.stopAirport.equals(that.stopAirport))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(GalileoShoppingFlightStopOver other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    GalileoShoppingFlightStopOver typedOther = (GalileoShoppingFlightStopOver)other;

    lastComparison = Boolean.valueOf(isSetStopAirport()).compareTo(typedOther.isSetStopAirport());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStopAirport()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stopAirport, typedOther.stopAirport);
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
    StringBuilder sb = new StringBuilder("GalileoShoppingFlightStopOver(");
    boolean first = true;

    if (isSetStopAirport()) {
      sb.append("stopAirport:");
      if (this.stopAirport == null) {
        sb.append("null");
      } else {
        sb.append(this.stopAirport);
      }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class GalileoShoppingFlightStopOverStandardSchemeFactory implements SchemeFactory {
    public GalileoShoppingFlightStopOverStandardScheme getScheme() {
      return new GalileoShoppingFlightStopOverStandardScheme();
    }
  }

  private static class GalileoShoppingFlightStopOverStandardScheme extends StandardScheme<GalileoShoppingFlightStopOver> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GalileoShoppingFlightStopOver struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STOP_AIRPORT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.stopAirport = iprot.readString();
              struct.setStopAirportIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GalileoShoppingFlightStopOver struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.stopAirport != null) {
        if (struct.isSetStopAirport()) {
          oprot.writeFieldBegin(STOP_AIRPORT_FIELD_DESC);
          oprot.writeString(struct.stopAirport);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GalileoShoppingFlightStopOverTupleSchemeFactory implements SchemeFactory {
    public GalileoShoppingFlightStopOverTupleScheme getScheme() {
      return new GalileoShoppingFlightStopOverTupleScheme();
    }
  }

  private static class GalileoShoppingFlightStopOverTupleScheme extends TupleScheme<GalileoShoppingFlightStopOver> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingFlightStopOver struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetStopAirport()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetStopAirport()) {
        oprot.writeString(struct.stopAirport);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GalileoShoppingFlightStopOver struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.stopAirport = iprot.readString();
        struct.setStopAirportIsSet(true);
      }
    }
  }

}

