/*
 * Copyright (C) 2024-2024 Sermant Authors. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.sermant.implement.service.xds.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * XdsCommonUtilsTest
 *
 * @author daizhenyu
 * @since 2024-08-23
 **/
public class XdsCommonUtilsTest {
    @Test
    public void testGetServiceNameFromCluster() {
        String clusterName = "outbound|8080||serviceA.default.svc.cluster.local";
        Optional<String> serviceNameFromCluster = XdsCommonUtils.getServiceNameFromCluster(clusterName);
        Assert.assertTrue(serviceNameFromCluster.isPresent());
        Assert.assertEquals("serviceA", serviceNameFromCluster.get());

        clusterName = "outbound|8080|sub-set|serviceA.default.svc.cluster.local";
        serviceNameFromCluster = XdsCommonUtils.getServiceNameFromCluster(clusterName);
        Assert.assertTrue(serviceNameFromCluster.isPresent());
        Assert.assertEquals("serviceA", serviceNameFromCluster.get());

        clusterName = "outbound|8080|subset|serviceA";
        serviceNameFromCluster = XdsCommonUtils.getServiceNameFromCluster(clusterName);
        Assert.assertTrue(serviceNameFromCluster.isPresent());
        Assert.assertEquals("serviceA", serviceNameFromCluster.get());

        clusterName = "outbound|8080|serviceA.default.svc.cluster.local";
        serviceNameFromCluster = XdsCommonUtils.getServiceNameFromCluster(clusterName);
        Assert.assertFalse(serviceNameFromCluster.isPresent());
    }
}