/*
 * Copyright 2024 - 2024 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.query.connector.aws.iam;

import java.util.Map;

import com.blazebit.query.spi.ConfigurationProvider;
import com.blazebit.query.spi.DataFetcher;
import com.blazebit.query.spi.QuerySchemaProvider;
import software.amazon.awssdk.services.iam.model.PasswordPolicy;
import software.amazon.awssdk.services.iam.model.MFADevice;
import software.amazon.awssdk.services.iam.model.User;

/**
 * The schema provider for the AWS IAM connector.
 *
 * @author Christian Beikov
 * @since 1.0.0
 */
public final class AwsIAMSchemaProvider implements QuerySchemaProvider {
    /**
     * Creates a new schema provider.
     */
    public AwsIAMSchemaProvider() {
    }

    @Override
    public Map<Class<?>, ? extends DataFetcher<?>> resolveSchemaObjects(ConfigurationProvider configurationProvider) {
        return Map.<Class<?>, DataFetcher<?>>of(
                User.class, UserDataFetcher.INSTANCE,
                PasswordPolicy.class, PasswordPolicyDataFetcher.INSTANCE,
                MFADevice.class, MFADeviceDataFetcher.INSTANCE,
                AccountSummary.class, AccountSummaryDataFetcher.INSTANCE
        );
    }
}
