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

package org.apache.ambari.server.api.services;

import org.apache.ambari.eventdb.webservice.WorkflowJsonService;
import org.apache.ambari.server.api.resources.ResourceInstance;
import org.apache.ambari.server.api.util.ApiVersion;
import org.apache.ambari.server.controller.spi.Resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.ambari.server.api.rest.BootStrapResource;
import org.apache.ambari.server.api.rest.HealthCheck;
import org.apache.ambari.server.api.rest.KdcServerReachabilityCheck;


public abstract class AbstractVersionService {

  /**
   * Handles /actions request.
   *
   * @return action service
   */
  @Path("/actions")
  public ActionService getActionService(@PathParam("apiVersion") String apiVersion) {
    return new ActionService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /alert_targets request.
   *
   * @return alert targets service
   */
  @Path("/alert_targets")
  public AlertTargetService getAlertTargetService(@PathParam("apiVersion") String apiVersion) {
    return new AlertTargetService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /privileges request.
   *
   * @return privileges service
   */
  @Path("/privileges")
  public AmbariPrivilegeService getAmbariPrivilegeService(@PathParam("apiVersion") String apiVersion) {
    return new AmbariPrivilegeService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /blueprints request.
   *
   * @return blueprints service
   */
  @Path("/blueprints")
  public BlueprintService getBlueprintService(@PathParam("apiVersion") String apiVersion) {
    return new BlueprintService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /clusters request.
   *
   * @return cluster service
   */
  @Path("/clusters")
  public ClusterService getClusterService(@PathParam("apiVersion") String apiVersion) {
    return new ClusterService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /feeds request.
   * TODO: Cleanup?
   *
   * @return feed service
   */
  @Path("/feeds")
  public FeedService getFeedService(@PathParam("apiVersion") String apiVersion) {
    return new FeedService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /groups request.
   *
   * @return group service
   */
  @Path("/groups")
  public GroupService getGroupService(@PathParam("apiVersion") String apiVersion) {
    return new GroupService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /hosts request.
   *
   * @return host service
   */
  @Path("/hosts")
  public HostService getHostService(@PathParam("apiVersion") String apiVersion) {
    return new HostService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /instances request.
   * TODO: Cleanup?
   *
   * @return instance service
   */
  @Path("/instances")
  public InstanceService getInstanceService(@PathParam("apiVersion") String apiVersion) {
    return new InstanceService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /kerberos_descriptors request.
   *
   * @return kerberos descriptor service
   */
  @Path("/kerberos_descriptors")
  public KerberosDescriptorService getKerberosDescriptorService(@PathParam("apiVersion") String apiVersion) {
    return new KerberosDescriptorService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /keys request.
   *
   * @return key service
   */
  @Path("/keys")
  public KeyService getKeyService(@PathParam("apiVersion") String apiVersion) {
    return new KeyService();
  }

  /**
   * Handles /ldap_sync_events request.
   *
   * @return Ldap sync event service
   */
  @Path("/ldap_sync_events")
  public LdapSyncEventService getLdapSyncEventService(@PathParam("apiVersion") String apiVersion) {
    return new LdapSyncEventService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /logout request.
   *
   * @return logout service
   */
  @Path("/logout")
  public LogoutService getLogoutService(@PathParam("apiVersion") String apiVersion) {
    return new LogoutService();
  }

  /**
   * Handles /permissions request.
   *
   * @return permission service
   */
  @Path("/permissions")
  public PermissionService getPermissionService(@PathParam("apiVersion") String apiVersion) {
    return new PermissionService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /persist request.
   *
   * @return persist service
   */
  @Path("/persist")
  public PersistKeyValueService getPersistKeyValueService(@PathParam("apiVersion") String apiVersion) {
    return new PersistKeyValueService();
  }

  /**
   * Handles /remoteclusters request
   *
   * @return remote clusters service
   */
  @Path("/remoteclusters")
  public RemoteClustersService getRemoteClustersService(@PathParam("apiVersion") String apiVersion) {
    return new RemoteClustersService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /requests request.
   *
   * @return request service
   */
  @Path("/requests")
  public RequestService getRequestService(@PathParam("apiVersion") String apiVersion) {
    return new RequestService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /settings request.
   *
   * @return request service
   */
  @Path("/settings")
  public SettingService getSettingService(@PathParam("apiVersion") String apiVersion) {
    return new SettingService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /authorizations request.
   *
   * @return role authorization service
   */
  @Path("/authorizations")
  public RoleAuthorizationService getRoleAuthorizationService(@PathParam("apiVersion") String apiVersion) {
    return new RoleAuthorizationService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /services request.
   *
   * @return root service service
   */
  @Path("/services")
  public RootServiceService getRootServiceService(@PathParam("apiVersion") String apiVersion) {
    return new RootServiceService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /targets request.
   * TODO: Cleanup?
   *
   * @return target cluster service
   */
  @Path("/targets")
  public TargetClusterService getTargetClusterService(@PathParam("apiVersion") String apiVersion) {
    return new TargetClusterService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /users request.
   *
   * @return user service
   */
  @Path("/users")
  public UserService getUserService(@PathParam("apiVersion") String apiVersion) {
    return new UserService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /version_definitions request.
   *
   * @return version definition service
   */
  @Path("/version_definitions")
  public VersionDefinitionService getVersionDefinitionService(@PathParam("apiVersion") String apiVersion) {
    return new VersionDefinitionService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /views request.
   *
   * @return view service
   */
  @Path("/views")
  public ViewService getViewService(@PathParam("apiVersion") String apiVersion) {
    return new ViewService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /view/urls request.
   *
   * @return view urls service
   */
  @Path("/view/urls")
  public ViewUrlsService getViewUrlsService(@PathParam("apiVersion") String apiVersion) {
    return new ViewUrlsService(ApiVersion.valueOf(apiVersion));
  }

  /**
   * Handles /stacks request.
   *
   * @return stacks service
   */
  @Path("/stacks")
  public StacksService getStacksService(@PathParam("apiVersion") String apiVersion) {
    return new StacksService(ApiVersion.valueOf(apiVersion));
  }


  /**
   * Handles /bootstrap request.
   *
   * @return bootstrap service
   */
  @Path("/bootstrap")
  public BootStrapResource getBootStrapResource(@PathParam("apiVersion") String apiVersion) {
    return new BootStrapResource();
  }


  /**
   * Handles /check request.
   *
   * @return health check service
   */
  @Path("/check")
  public HealthCheck getHealthCheck(@PathParam("apiVersion") String apiVersion) {
    return new HealthCheck();
  }

  /**
   * Handles /kdc_check request.
   *
   * @return kdc server reachability service
   */
  @Path("/kdc_check")
  public KdcServerReachabilityCheck getKdcServerReachabilityCheck(@PathParam("apiVersion") String apiVersion) {
    return new KdcServerReachabilityCheck();
  }

  /**
   * Handles /kdc_check request.
   *
   * @return kdc server reachability service
   */
  @Path("/jobhistory")
  public WorkflowJsonService getWorkflowJsonService(@PathParam("apiVersion") String apiVersion) {
    return new WorkflowJsonService();
  }

}
