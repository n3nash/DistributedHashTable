// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/distributedhashtable/messageexchange/dataToRedistribute.proto

package com.distributedhashtable.messageexchange;

public final class RedistributeData {
  private RedistributeData() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface DataRedistributionOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // repeated string key = 1;
    java.util.List<String> getKeyList();
    int getKeyCount();
    String getKey(int index);
    
    // repeated string value = 2;
    java.util.List<String> getValueList();
    int getValueCount();
    String getValue(int index);
  }
  public static final class DataRedistribution extends
      com.google.protobuf.GeneratedMessage
      implements DataRedistributionOrBuilder {
    // Use DataRedistribution.newBuilder() to construct.
    private DataRedistribution(Builder builder) {
      super(builder);
    }
    private DataRedistribution(boolean noInit) {}
    
    private static final DataRedistribution defaultInstance;
    public static DataRedistribution getDefaultInstance() {
      return defaultInstance;
    }
    
    public DataRedistribution getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.distributedhashtable.messageexchange.RedistributeData.internal_static_messageexchange_DataRedistribution_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.distributedhashtable.messageexchange.RedistributeData.internal_static_messageexchange_DataRedistribution_fieldAccessorTable;
    }
    
    // repeated string key = 1;
    public static final int KEY_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList key_;
    public java.util.List<String>
        getKeyList() {
      return key_;
    }
    public int getKeyCount() {
      return key_.size();
    }
    public String getKey(int index) {
      return key_.get(index);
    }
    
    // repeated string value = 2;
    public static final int VALUE_FIELD_NUMBER = 2;
    private com.google.protobuf.LazyStringList value_;
    public java.util.List<String>
        getValueList() {
      return value_;
    }
    public int getValueCount() {
      return value_.size();
    }
    public String getValue(int index) {
      return value_.get(index);
    }
    
    private void initFields() {
      key_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      value_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < key_.size(); i++) {
        output.writeBytes(1, key_.getByteString(i));
      }
      for (int i = 0; i < value_.size(); i++) {
        output.writeBytes(2, value_.getByteString(i));
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < key_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(key_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getKeyList().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < value_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(value_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getValueList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.distributedhashtable.messageexchange.RedistributeData.DataRedistributionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.distributedhashtable.messageexchange.RedistributeData.internal_static_messageexchange_DataRedistribution_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.distributedhashtable.messageexchange.RedistributeData.internal_static_messageexchange_DataRedistribution_fieldAccessorTable;
      }
      
      // Construct using com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        key_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        value_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.getDescriptor();
      }
      
      public com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution getDefaultInstanceForType() {
        return com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.getDefaultInstance();
      }
      
      public com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution build() {
        com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution buildPartial() {
        com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution result = new com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          key_ = new com.google.protobuf.UnmodifiableLazyStringList(
              key_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.key_ = key_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          value_ = new com.google.protobuf.UnmodifiableLazyStringList(
              value_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.value_ = value_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution) {
          return mergeFrom((com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution other) {
        if (other == com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.getDefaultInstance()) return this;
        if (!other.key_.isEmpty()) {
          if (key_.isEmpty()) {
            key_ = other.key_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureKeyIsMutable();
            key_.addAll(other.key_);
          }
          onChanged();
        }
        if (!other.value_.isEmpty()) {
          if (value_.isEmpty()) {
            value_ = other.value_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureValueIsMutable();
            value_.addAll(other.value_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 10: {
              ensureKeyIsMutable();
              key_.add(input.readBytes());
              break;
            }
            case 18: {
              ensureValueIsMutable();
              value_.add(input.readBytes());
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // repeated string key = 1;
      private com.google.protobuf.LazyStringList key_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureKeyIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          key_ = new com.google.protobuf.LazyStringArrayList(key_);
          bitField0_ |= 0x00000001;
         }
      }
      public java.util.List<String>
          getKeyList() {
        return java.util.Collections.unmodifiableList(key_);
      }
      public int getKeyCount() {
        return key_.size();
      }
      public String getKey(int index) {
        return key_.get(index);
      }
      public Builder setKey(
          int index, String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureKeyIsMutable();
        key_.set(index, value);
        onChanged();
        return this;
      }
      public Builder addKey(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureKeyIsMutable();
        key_.add(value);
        onChanged();
        return this;
      }
      public Builder addAllKey(
          java.lang.Iterable<String> values) {
        ensureKeyIsMutable();
        super.addAll(values, key_);
        onChanged();
        return this;
      }
      public Builder clearKey() {
        key_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      void addKey(com.google.protobuf.ByteString value) {
        ensureKeyIsMutable();
        key_.add(value);
        onChanged();
      }
      
      // repeated string value = 2;
      private com.google.protobuf.LazyStringList value_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureValueIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          value_ = new com.google.protobuf.LazyStringArrayList(value_);
          bitField0_ |= 0x00000002;
         }
      }
      public java.util.List<String>
          getValueList() {
        return java.util.Collections.unmodifiableList(value_);
      }
      public int getValueCount() {
        return value_.size();
      }
      public String getValue(int index) {
        return value_.get(index);
      }
      public Builder setValue(
          int index, String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureValueIsMutable();
        value_.set(index, value);
        onChanged();
        return this;
      }
      public Builder addValue(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureValueIsMutable();
        value_.add(value);
        onChanged();
        return this;
      }
      public Builder addAllValue(
          java.lang.Iterable<String> values) {
        ensureValueIsMutable();
        super.addAll(values, value_);
        onChanged();
        return this;
      }
      public Builder clearValue() {
        value_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      void addValue(com.google.protobuf.ByteString value) {
        ensureValueIsMutable();
        value_.add(value);
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:messageexchange.DataRedistribution)
    }
    
    static {
      defaultInstance = new DataRedistribution(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:messageexchange.DataRedistribution)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_messageexchange_DataRedistribution_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messageexchange_DataRedistribution_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nAcom/distributedhashtable/messageexchan" +
      "ge/dataToRedistribute.proto\022\017messageexch" +
      "ange\"0\n\022DataRedistribution\022\013\n\003key\030\001 \003(\t\022" +
      "\r\n\005value\030\002 \003(\tB<\n(com.distributedhashtab" +
      "le.messageexchangeB\020RedistributeData"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_messageexchange_DataRedistribution_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_messageexchange_DataRedistribution_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_messageexchange_DataRedistribution_descriptor,
              new java.lang.String[] { "Key", "Value", },
              com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.class,
              com.distributedhashtable.messageexchange.RedistributeData.DataRedistribution.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
