/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class FactorCreator extends Creator<Factor> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String friendlyName;
    private final Factor.FactorTypes factorType;
    private String bindingAlg;
    private String bindingPublicKey;
    private String configAppId;
    private Factor.NotificationPlatforms configNotificationPlatform;
    private String configNotificationToken;
    private String configSdkVersion;

    /**
     * Construct a new FactorCreator.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param friendlyName The friendly name of this Factor
     * @param factorType The Type of this Factor
     */
    public FactorCreator(final String pathServiceSid,
                         final String pathIdentity,
                         final String friendlyName,
                         final Factor.FactorTypes factorType) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.friendlyName = friendlyName;
        this.factorType = factorType;
    }

    /**
     * The algorithm used when `factor_type` is `push`. Algorithm supported:
     * `ES256`.
     *
     * @param bindingAlg The algorithm used when `factor_type` is `push`
     * @return this
     */
    public FactorCreator setBindingAlg(final String bindingAlg) {
        this.bindingAlg = bindingAlg;
        return this;
    }

    /**
     * The Ecdsa public key in PKIX, ASN.1 DER format encoded in Base64.
     *
     * @param bindingPublicKey The public key encoded in Base64
     * @return this
     */
    public FactorCreator setBindingPublicKey(final String bindingPublicKey) {
        this.bindingPublicKey = bindingPublicKey;
        return this;
    }

    /**
     * The ID that uniquely identifies your app in the Google or Apple store, such
     * as `com.example.myapp`. Required when `factor_type` is `push`.
     *
     * @param configAppId The ID that uniquely identifies your app in the Google or
     *                    Apple store
     * @return this
     */
    public FactorCreator setConfigAppId(final String configAppId) {
        this.configAppId = configAppId;
        return this;
    }

    /**
     * The transport technology used to generate the Notification Token. Can be
     * `apn` or `fcm`. Required when `factor_type` is `push`.
     *
     * @param configNotificationPlatform The transport technology used to generate
     *                                   the Notification Token
     * @return this
     */
    public FactorCreator setConfigNotificationPlatform(final Factor.NotificationPlatforms configNotificationPlatform) {
        this.configNotificationPlatform = configNotificationPlatform;
        return this;
    }

    /**
     * For APN, the device token. For FCM the registration token. It used to send
     * the push notifications. Required when `factor_type` is `push`.
     *
     * @param configNotificationToken For APN, the device token. For FCM the
     *                                registration token
     * @return this
     */
    public FactorCreator setConfigNotificationToken(final String configNotificationToken) {
        this.configNotificationToken = configNotificationToken;
        return this;
    }

    /**
     * The Verify Push SDK version used to configure the factor.
     *
     * @param configSdkVersion The Verify Push SDK version used to configure the
     *                         factor
     * @return this
     */
    public FactorCreator setConfigSdkVersion(final String configSdkVersion) {
        this.configSdkVersion = configSdkVersion;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Factor
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Factor create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Entities/" + this.pathIdentity + "/Factors"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Factor creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Factor.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (factorType != null) {
            request.addPostParam("FactorType", factorType.toString());
        }

        if (bindingAlg != null) {
            request.addPostParam("Binding.Alg", bindingAlg);
        }

        if (bindingPublicKey != null) {
            request.addPostParam("Binding.PublicKey", bindingPublicKey.toString());
        }

        if (configAppId != null) {
            request.addPostParam("Config.AppId", configAppId);
        }

        if (configNotificationPlatform != null) {
            request.addPostParam("Config.NotificationPlatform", configNotificationPlatform.toString());
        }

        if (configNotificationToken != null) {
            request.addPostParam("Config.NotificationToken", configNotificationToken);
        }

        if (configSdkVersion != null) {
            request.addPostParam("Config.SdkVersion", configSdkVersion);
        }
    }
}