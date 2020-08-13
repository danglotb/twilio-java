/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Creator;
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

public class ValidationRequestCreator extends Creator<ValidationRequest> {
    private String pathAccountSid;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private String friendlyName;
    private Integer callDelay;
    private String extension;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;

    /**
     * Construct a new ValidationRequestCreator.
     *
     * @param phoneNumber The phone number to verify in E.164 format
     */
    public ValidationRequestCreator(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Construct a new ValidationRequestCreator.
     *
     * @param pathAccountSid The SID of the Account responsible for the new Caller
     *                       ID
     * @param phoneNumber The phone number to verify in E.164 format
     */
    public ValidationRequestCreator(final String pathAccountSid,
                                    final com.twilio.type.PhoneNumber phoneNumber) {
        this.pathAccountSid = pathAccountSid;
        this.phoneNumber = phoneNumber;
    }

    /**
     * A descriptive string that you create to describe the new caller ID resource.
     * It can be up to 64 characters long. The default value is a formatted version
     * of the phone number..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public ValidationRequestCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The number of seconds to delay before initiating the verification call. Can
     * be an integer between `0` and `60`, inclusive. The default is `0`..
     *
     * @param callDelay The number of seconds to delay before initiating the
     *                  verification call
     * @return this
     */
    public ValidationRequestCreator setCallDelay(final Integer callDelay) {
        this.callDelay = callDelay;
        return this;
    }

    /**
     * The digits to dial after connecting the verification call..
     *
     * @param extension The digits to dial after connecting the verification call
     * @return this
     */
    public ValidationRequestCreator setExtension(final String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information about the verification process to your application..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public ValidationRequestCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information about the verification process to your application..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public ValidationRequestCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method we should use to call `status_callback`. Can be: `GET` or
     * `POST`, and the default is `POST`..
     *
     * @param statusCallbackMethod The HTTP method we should use to call
     *                             status_callback
     * @return this
     */
    public ValidationRequestCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created ValidationRequest
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ValidationRequest create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/OutgoingCallerIds.json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ValidationRequest creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ValidationRequest.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (callDelay != null) {
            request.addPostParam("CallDelay", callDelay.toString());
        }

        if (extension != null) {
            request.addPostParam("Extension", extension);
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
    }
}