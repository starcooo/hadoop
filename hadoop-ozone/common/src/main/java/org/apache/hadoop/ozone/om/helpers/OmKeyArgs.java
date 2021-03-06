/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.ozone.om.helpers;
import org.apache.hadoop.hdds.protocol.proto.HddsProtos.ReplicationType;
import org.apache.hadoop.hdds.protocol.proto.HddsProtos.ReplicationFactor;

import java.util.List;

/**
 * Args for key. Client use this to specify key's attributes on  key creation
 * (putKey()).
 */
public final class OmKeyArgs {
  private final String volumeName;
  private final String bucketName;
  private final String keyName;
  private long dataSize;
  private final ReplicationType type;
  private final ReplicationFactor factor;
  private List<OmKeyLocationInfo> locationInfoList;

  private OmKeyArgs(String volumeName, String bucketName, String keyName,
      long dataSize, ReplicationType type, ReplicationFactor factor,
      List<OmKeyLocationInfo> locationInfoList) {
    this.volumeName = volumeName;
    this.bucketName = bucketName;
    this.keyName = keyName;
    this.dataSize = dataSize;
    this.type = type;
    this.factor = factor;
    this.locationInfoList = locationInfoList;
  }

  public ReplicationType getType() {
    return type;
  }

  public ReplicationFactor getFactor() {
    return factor;
  }

  public String getVolumeName() {
    return volumeName;
  }

  public String getBucketName() {
    return bucketName;
  }

  public String getKeyName() {
    return keyName;
  }

  public long getDataSize() {
    return dataSize;
  }

  public void setDataSize(long size) {
    dataSize = size;
  }

  public void setLocationInfoList(List<OmKeyLocationInfo> locationInfoList) {
    this.locationInfoList = locationInfoList;
  }

  public List<OmKeyLocationInfo> getLocationInfoList() {
    return locationInfoList;
  }

  /**
   * Builder class of OmKeyArgs.
   */
  public static class Builder {
    private String volumeName;
    private String bucketName;
    private String keyName;
    private long dataSize;
    private ReplicationType type;
    private ReplicationFactor factor;
    private List<OmKeyLocationInfo> locationInfoList;

    public Builder setVolumeName(String volume) {
      this.volumeName = volume;
      return this;
    }

    public Builder setBucketName(String bucket) {
      this.bucketName = bucket;
      return this;
    }

    public Builder setKeyName(String key) {
      this.keyName = key;
      return this;
    }

    public Builder setDataSize(long size) {
      this.dataSize = size;
      return this;
    }

    public Builder setType(ReplicationType replicationType) {
      this.type = replicationType;
      return this;
    }

    public Builder setFactor(ReplicationFactor replicationFactor) {
      this.factor = replicationFactor;
      return this;
    }

    public Builder setLocationInfoList(List<OmKeyLocationInfo> locationInfos) {
      this.locationInfoList = locationInfos;
      return this;
    }

    public OmKeyArgs build() {
      return new OmKeyArgs(volumeName, bucketName, keyName, dataSize, type,
          factor, locationInfoList);
    }
  }
}
