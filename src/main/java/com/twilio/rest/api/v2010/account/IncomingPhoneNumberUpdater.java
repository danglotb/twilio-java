/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class IncomingPhoneNumberUpdater extends Updater<IncomingPhoneNumber> {
    private String pathAccountSid;
    private final String pathSid;
    private String accountSid;
    private String apiVersion;
    private String friendlyName;
    private String smsApplicationSid;
    private HttpMethod smsFallbackMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsMethod;
    private URI smsUrl;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private String voiceApplicationSid;
    private Boolean voiceCallerIdLookup;
    private HttpMethod voiceFallbackMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceMethod;
    private URI voiceUrl;
    private IncomingPhoneNumber.EmergencyStatus emergencyStatus;
    private String emergencyAddressSid;
    private String trunkSid;
    private IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode;
    private String identitySid;
    private String addressSid;
    private String bundleSid;

    /**
     * Construct a new IncomingPhoneNumberUpdater.
     *
     * @param pathSid The unique string that identifies the resource
     */
    public IncomingPhoneNumberUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new IncomingPhoneNumberUpdater.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       update
     * @param pathSid The unique string that identifies the resource
     */
    public IncomingPhoneNumberUpdater(final String pathAccountSid,
                                      final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * The SID of the [Account](https://www.twilio.com/docs/iam/api/account) that
     * created the IncomingPhoneNumber resource to update.  For more information,
     * see [Exchanging Numbers Between
     * Subaccounts](https://www.twilio.com/docs/iam/api/subaccounts#exchanging-numbers)..
     *
     * @param accountSid The SID of the Account that created the resource to update
     * @return this
     */
    public IncomingPhoneNumberUpdater setAccountSid(final String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * The API version to use for incoming calls made to the phone number. The
     * default is `2010-04-01`..
     *
     * @param apiVersion The API version to use for incoming calls made to the
     *                   phone number
     * @return this
     */
    public IncomingPhoneNumberUpdater setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * A descriptive string that you created to describe this phone number. It can
     * be up to 64 characters long. By default, this is a formatted version of the
     * phone number..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public IncomingPhoneNumberUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The SID of the application that should handle SMS messages sent to the
     * number. If an `sms_application_sid` is present, we ignore all of the
     * `sms_*_url` urls and use those set on the application..
     *
     * @param smsApplicationSid Unique string that identifies the application
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsApplicationSid(final String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    /**
     * The HTTP method that we should use to call `sms_fallback_url`. Can be: `GET`
     * or `POST` and defaults to `POST`..
     *
     * @param smsFallbackMethod HTTP method used with sms_fallback_url
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while requesting or
     * executing the TwiML defined by `sms_url`..
     *
     * @param smsFallbackUrl The URL we call when an error occurs while executing
     *                       TwiML
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while requesting or
     * executing the TwiML defined by `sms_url`..
     *
     * @param smsFallbackUrl The URL we call when an error occurs while executing
     *                       TwiML
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method that we should use to call `sms_url`. Can be: `GET` or `POST`
     * and defaults to `POST`..
     *
     * @param smsMethod The HTTP method to use with sms_url
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL we should call when the phone number receives an incoming SMS
     * message..
     *
     * @param smsUrl The URL we should call when the phone number receives an
     *               incoming SMS message
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL we should call when the phone number receives an incoming SMS
     * message..
     *
     * @param smsUrl The URL we should call when the phone number receives an
     *               incoming SMS message
     * @return this
     */
    public IncomingPhoneNumberUpdater setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public IncomingPhoneNumberUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public IncomingPhoneNumberUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method we should use to call `status_callback`. Can be: `GET` or
     * `POST` and defaults to `POST`..
     *
     * @param statusCallbackMethod The HTTP method we should use to call
     *                             status_callback
     * @return this
     */
    public IncomingPhoneNumberUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * The SID of the application we should use to handle phone calls to the phone
     * number. If a `voice_application_sid` is present, we ignore all of the voice
     * urls and use only those set on the application. Setting a
     * `voice_application_sid` will automatically delete your `trunk_sid` and vice
     * versa..
     *
     * @param voiceApplicationSid The SID of the application to handle the phone
     *                            number
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceApplicationSid(final String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    /**
     * Whether to lookup the caller's name from the CNAM database and post it to
     * your app. Can be: `true` or `false` and defaults to `false`..
     *
     * @param voiceCallerIdLookup Whether to lookup the caller's name
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The HTTP method that we should use to call `voice_fallback_url`. Can be:
     * `GET` or `POST` and defaults to `POST`..
     *
     * @param voiceFallbackMethod The HTTP method used with fallback_url
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     *
     * @param voiceFallbackUrl The URL we will call when an error occurs in TwiML
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     *
     * @param voiceFallbackUrl The URL we will call when an error occurs in TwiML
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method that we should use to call `voice_url`. Can be: `GET` or
     * `POST` and defaults to `POST`..
     *
     * @param voiceMethod The HTTP method used with the voice_url
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that we should call to answer a call to the phone number. The
     * `voice_url` will not be called if a `voice_application_sid` or a `trunk_sid`
     * is set..
     *
     * @param voiceUrl The URL we should call when the phone number receives a call
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL that we should call to answer a call to the phone number. The
     * `voice_url` will not be called if a `voice_application_sid` or a `trunk_sid`
     * is set..
     *
     * @param voiceUrl The URL we should call when the phone number receives a call
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The configuration status parameter that determines whether the phone number
     * is enabled for emergency calling..
     *
     * @param emergencyStatus Whether the phone number is enabled for emergency
     *                        calling
     * @return this
     */
    public IncomingPhoneNumberUpdater setEmergencyStatus(final IncomingPhoneNumber.EmergencyStatus emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
        return this;
    }

    /**
     * The SID of the emergency address configuration to use for emergency calling
     * from this phone number..
     *
     * @param emergencyAddressSid The emergency address configuration to use for
     *                            emergency calling
     * @return this
     */
    public IncomingPhoneNumberUpdater setEmergencyAddressSid(final String emergencyAddressSid) {
        this.emergencyAddressSid = emergencyAddressSid;
        return this;
    }

    /**
     * The SID of the Trunk we should use to handle phone calls to the phone number.
     * If a `trunk_sid` is present, we ignore all of the voice urls and voice
     * applications and use only those set on the Trunk. Setting a `trunk_sid` will
     * automatically delete your `voice_application_sid` and vice versa..
     *
     * @param trunkSid SID of the trunk to handle phone calls to the phone number
     * @return this
     */
    public IncomingPhoneNumberUpdater setTrunkSid(final String trunkSid) {
        this.trunkSid = trunkSid;
        return this;
    }

    /**
     * The configuration parameter for the phone number to receive incoming voice
     * calls or faxes. Can be: `fax` or `voice` and defaults to `voice`..
     *
     * @param voiceReceiveMode Incoming call type: fax or voice
     * @return this
     */
    public IncomingPhoneNumberUpdater setVoiceReceiveMode(final IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode) {
        this.voiceReceiveMode = voiceReceiveMode;
        return this;
    }

    /**
     * The SID of the Identity resource that we should associate with the phone
     * number. Some regions require an identity to meet local regulations..
     *
     * @param identitySid Unique string that identifies the identity associated
     *                    with number
     * @return this
     */
    public IncomingPhoneNumberUpdater setIdentitySid(final String identitySid) {
        this.identitySid = identitySid;
        return this;
    }

    /**
     * The SID of the Address resource we should associate with the phone number.
     * Some regions require addresses to meet local regulations..
     *
     * @param addressSid The SID of the Address resource associated with the phone
     *                   number
     * @return this
     */
    public IncomingPhoneNumberUpdater setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    /**
     * The SID of the Bundle resource that you associate with the phone number. Some
     * regions require a Bundle to meet local Regulations..
     *
     * @param bundleSid The SID of the Bundle resource associated with number
     * @return this
     */
    public IncomingPhoneNumberUpdater setBundleSid(final String bundleSid) {
        this.bundleSid = bundleSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated IncomingPhoneNumber
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IncomingPhoneNumber update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/" + this.pathSid + ".json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IncomingPhoneNumber update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IncomingPhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (accountSid != null) {
            request.addPostParam("AccountSid", accountSid);
        }

        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (smsApplicationSid != null) {
            request.addPostParam("SmsApplicationSid", smsApplicationSid);
        }

        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }

        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }

        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }

        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (voiceApplicationSid != null) {
            request.addPostParam("VoiceApplicationSid", voiceApplicationSid);
        }

        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
        }

        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }

        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }

        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }

        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }

        if (emergencyStatus != null) {
            request.addPostParam("EmergencyStatus", emergencyStatus.toString());
        }

        if (emergencyAddressSid != null) {
            request.addPostParam("EmergencyAddressSid", emergencyAddressSid);
        }

        if (trunkSid != null) {
            request.addPostParam("TrunkSid", trunkSid);
        }

        if (voiceReceiveMode != null) {
            request.addPostParam("VoiceReceiveMode", voiceReceiveMode.toString());
        }

        if (identitySid != null) {
            request.addPostParam("IdentitySid", identitySid);
        }

        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }

        if (bundleSid != null) {
            request.addPostParam("BundleSid", bundleSid);
        }
    }
}