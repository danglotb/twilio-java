/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ServiceCreator extends Creator<Service> {
    private final String friendlyName;
    private Integer codeLength;
    private Boolean lookupEnabled;
    private Boolean skipSmsToLandlines;
    private Boolean dtmfInputRequired;
    private String ttsName;
    private Boolean psd2Enabled;
    private Boolean doNotShareWarningEnabled;
    private Boolean customCodeEnabled;
    private Boolean pushIncludeDate;
    private String pushApnCredentialSid;
    private String pushFcmCredentialSid;

    /**
     * Construct a new ServiceCreator.
     *
     * @param friendlyName A string to describe the verification service
     */
    public ServiceCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * The length of the verification code to generate. Must be an integer value
     * between 4 and 10, inclusive..
     *
     * @param codeLength The length of the verification code to generate
     * @return this
     */
    public ServiceCreator setCodeLength(final Integer codeLength) {
        this.codeLength = codeLength;
        return this;
    }

    /**
     * Whether to perform a lookup with each verification started and return info
     * about the phone number..
     *
     * @param lookupEnabled Whether to perform a lookup with each verification
     * @return this
     */
    public ServiceCreator setLookupEnabled(final Boolean lookupEnabled) {
        this.lookupEnabled = lookupEnabled;
        return this;
    }

    /**
     * Whether to skip sending SMS verifications to landlines. Requires
     * `lookup_enabled`..
     *
     * @param skipSmsToLandlines Whether to skip sending SMS verifications to
     *                           landlines
     * @return this
     */
    public ServiceCreator setSkipSmsToLandlines(final Boolean skipSmsToLandlines) {
        this.skipSmsToLandlines = skipSmsToLandlines;
        return this;
    }

    /**
     * Whether to ask the user to press a number before delivering the verify code
     * in a phone call..
     *
     * @param dtmfInputRequired Whether to ask the user to press a number before
     *                          delivering the verify code in a phone call
     * @return this
     */
    public ServiceCreator setDtmfInputRequired(final Boolean dtmfInputRequired) {
        this.dtmfInputRequired = dtmfInputRequired;
        return this;
    }

    /**
     * The name of an alternative text-to-speech service to use in phone calls.
     * Applies only to TTS languages..
     *
     * @param ttsName The name of an alternative text-to-speech service to use in
     *                phone calls
     * @return this
     */
    public ServiceCreator setTtsName(final String ttsName) {
        this.ttsName = ttsName;
        return this;
    }

    /**
     * Whether to pass PSD2 transaction parameters when starting a verification..
     *
     * @param psd2Enabled Whether to pass PSD2 transaction parameters when starting
     *                    a verification
     * @return this
     */
    public ServiceCreator setPsd2Enabled(final Boolean psd2Enabled) {
        this.psd2Enabled = psd2Enabled;
        return this;
    }

    /**
     * Whether to add a security warning at the end of an SMS verification body.
     * Disabled by default and applies only to SMS. Example SMS body: `Your AppName
     * verification code is: 1234. Don’t share this code with anyone; our employees
     * will never ask for the code`.
     *
     * @param doNotShareWarningEnabled Whether to add a security warning at the end
     *                                 of an SMS.
     * @return this
     */
    public ServiceCreator setDoNotShareWarningEnabled(final Boolean doNotShareWarningEnabled) {
        this.doNotShareWarningEnabled = doNotShareWarningEnabled;
        return this;
    }

    /**
     * Whether to allow sending verifications with a custom code instead of a
     * randomly generated one. Not available for all customers..
     *
     * @param customCodeEnabled Whether to allow sending verifications with a
     *                          custom code.
     * @return this
     */
    public ServiceCreator setCustomCodeEnabled(final Boolean customCodeEnabled) {
        this.customCodeEnabled = customCodeEnabled;
        return this;
    }

    /**
     * Optional configuration for the Push factors. If true, include the date in the
     * Challenge's reponse. Otherwise, the date is omitted from the response. See <a
     * href="https://www.twilio.com/docs/verify/api/challenge">Challenge</a>
     * resource’s details parameter for more info. Default: true.
     *
     * @param pushIncludeDate Optional. Include the date in the Challenge's
     *                        reponse. Default: true
     * @return this
     */
    public ServiceCreator setPushIncludeDate(final Boolean pushIncludeDate) {
        this.pushIncludeDate = pushIncludeDate;
        return this;
    }

    /**
     * Optional configuration for the Push factors. Set the APN Credential for this
     * service. This will allow to send push notifications to iOS devices. See <a
     * href="https://www.twilio.com/docs/notify/api/credential-resource">Credential
     * Resource</a>.
     *
     * @param pushApnCredentialSid Optional. Set APN Credential for this service.
     * @return this
     */
    public ServiceCreator setPushApnCredentialSid(final String pushApnCredentialSid) {
        this.pushApnCredentialSid = pushApnCredentialSid;
        return this;
    }

    /**
     * Optional configuration for the Push factors. Set the FCM Credential for this
     * service. This will allow to send push notifications to Android devices. See
     * <a
     * href="https://www.twilio.com/docs/notify/api/credential-resource">Credential
     * Resource</a>.
     *
     * @param pushFcmCredentialSid Optional. Set FCM Credential for this service.
     * @return this
     */
    public ServiceCreator setPushFcmCredentialSid(final String pushFcmCredentialSid) {
        this.pushFcmCredentialSid = pushFcmCredentialSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Service.fromJson(response.getStream(), client.getObjectMapper());
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

        if (codeLength != null) {
            request.addPostParam("CodeLength", codeLength.toString());
        }

        if (lookupEnabled != null) {
            request.addPostParam("LookupEnabled", lookupEnabled.toString());
        }

        if (skipSmsToLandlines != null) {
            request.addPostParam("SkipSmsToLandlines", skipSmsToLandlines.toString());
        }

        if (dtmfInputRequired != null) {
            request.addPostParam("DtmfInputRequired", dtmfInputRequired.toString());
        }

        if (ttsName != null) {
            request.addPostParam("TtsName", ttsName);
        }

        if (psd2Enabled != null) {
            request.addPostParam("Psd2Enabled", psd2Enabled.toString());
        }

        if (doNotShareWarningEnabled != null) {
            request.addPostParam("DoNotShareWarningEnabled", doNotShareWarningEnabled.toString());
        }

        if (customCodeEnabled != null) {
            request.addPostParam("CustomCodeEnabled", customCodeEnabled.toString());
        }

        if (pushIncludeDate != null) {
            request.addPostParam("Push.IncludeDate", pushIncludeDate.toString());
        }

        if (pushApnCredentialSid != null) {
            request.addPostParam("Push.ApnCredentialSid", pushApnCredentialSid);
        }

        if (pushFcmCredentialSid != null) {
            request.addPostParam("Push.FcmCredentialSid", pushFcmCredentialSid);
        }
    }
}