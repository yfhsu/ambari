/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.registry.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.ambari.server.registry.RegistryMpackCompatiblity;
import org.apache.ambari.server.registry.RegistryMpackService;
import org.apache.ambari.server.registry.RegistryMpackVersion;

import com.google.gson.annotations.SerializedName;

/**
 * JSON implemenation of {@link RegistryMpackVersion}
 */
public class JsonRegistryMpackVersion implements RegistryMpackVersion {
  @SerializedName("version")
  private String version;

  @SerializedName("buildNumber")
  private String buildNumber;

  @SerializedName("mpackUrl")
  private String mpackUrl;

  @SerializedName("docUrl")
  private String docUrl;

  @SerializedName("stack-id")
  private String stackId;

  @SerializedName("services")
  private ArrayList<JsonRegistryMpackService> services;

  @SerializedName("compatibleMpacks")
  private ArrayList<JsonRegistryMpackCompatibility> compatibleMpacks;

  @Override
  public String getMpackVersion() {
    return version;
  }

  @Override
  public String getMpackBuildNumber() {
    return buildNumber;
  }

  @Override
  public String getMpackUrl() {
    return mpackUrl;
  }

  @Override
  public String getMpackDocUrl() {
    return docUrl;
  }

  @Override
  public List<? extends RegistryMpackService> getMpackServices() {
    return services;
  }

  @Override
  public List<? extends RegistryMpackCompatiblity> getCompatibleMpacks() {
    return compatibleMpacks;
  }

  @Override
  public String getMpackStackId() {
    return stackId;
  }
}