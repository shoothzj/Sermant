/*
 * Copyright (C) 2023-2023 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sermant.core.event;

import io.sermant.core.common.LoggerFactory;
import io.sermant.core.service.ServiceManager;
import io.sermant.core.service.send.api.GatewayClient;

import java.util.logging.Logger;

/**
 * Event sending tool class
 *
 * @author luanwenfei
 * @since 2023-03-07
 */
public class EventSender {
    private static final Logger LOGGER = LoggerFactory.getLogger();

    private static final int EVENT_DATA_VALUE = 1;

    private static GatewayClient gatewayClient;

    private EventSender() {
    }

    /**
     * Initialize to get the GatewayClient
     */
    public static void init() {
        gatewayClient = ServiceManager.getService(GatewayClient.class);
    }

    /**
     * Send event message
     *
     * @param eventMessage event message
     */
    public static void sendEvent(EventMessage eventMessage) {
        if (gatewayClient == null) {
            LOGGER.warning("GatewayClient is null, can not send events by gateway.");
            LOGGER.info(eventMessage.toString());
            return;
        }
        if (gatewayClient.sendImmediately(eventMessage, EVENT_DATA_VALUE)) {
            String logMsg = "Send events successful. MetaHash: " + eventMessage.getMetaHash();
            LOGGER.info(logMsg);
        } else {
            LOGGER.severe("Fail to send event by gateway!");
            LOGGER.info(eventMessage.toString());
        }
    }
}