/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1.service;

import com.twilio.base.Updater;
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
public class PhoneNumberUpdater extends Updater<PhoneNumber> {
    private final String pathServiceSid;
    private final String pathSid;
    private Boolean isReserved;

    /**
     * Construct a new PhoneNumberUpdater.
     *
     * @param pathServiceSid The SID of the parent Service resource of the
     *                       PhoneNumber resource to update
     * @param pathSid The unique string that identifies the resource
     */
    public PhoneNumberUpdater(final String pathServiceSid,
                              final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * Whether the phone number should be reserved and not be assigned to a
     * participant using proxy pool logic. See [Reserved Phone
     * Numbers](https://www.twilio.com/docs/proxy/reserved-phone-numbers) for more
     * information..
     *
     * @param isReserved Whether the new phone number should be reserved
     * @return this
     */
    public PhoneNumberUpdater setIsReserved(final Boolean isReserved) {
        this.isReserved = isReserved;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated PhoneNumber
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PhoneNumber update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/PhoneNumbers/" + this.pathSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("PhoneNumber update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (isReserved != null) {
            request.addPostParam("IsReserved", isReserved.toString());
        }
    }
}