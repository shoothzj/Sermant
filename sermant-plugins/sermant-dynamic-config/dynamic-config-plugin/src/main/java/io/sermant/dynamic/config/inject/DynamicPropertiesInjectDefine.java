/*
 * Copyright (C) 2022-2022 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.sermant.dynamic.config.inject;

/**
 * environment variable configuration
 *
 * @author zhouss
 * @since 2022-04-20
 */
public class DynamicPropertiesInjectDefine extends DynamicClassInjectDefine {
    @Override
    public String injectClassName() {
        return "io.sermant.dynamic.config.entity.DynamicProperties";
    }

    @Override
    public String factoryName() {
        return ENABLE_AUTO_CONFIGURATION_FACTORY_NAME;
    }
}
