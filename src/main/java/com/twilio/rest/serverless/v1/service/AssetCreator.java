/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service;

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
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class AssetCreator extends Creator<Asset> {
    private final String pathServiceSid;
    private final String friendlyName;

    /**
     * Construct a new AssetCreator.
     *
     * @param pathServiceSid The SID of the Service to create the Asset resource
     *                       under
     * @param friendlyName A string to describe the Asset resource
     */
    public AssetCreator(final String pathServiceSid,
                        final String friendlyName) {
        this.pathServiceSid = pathServiceSid;
        this.friendlyName = friendlyName;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Asset
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Asset create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Assets"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Asset creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Asset.fromJson(response.getStream(), client.getObjectMapper());
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
    }
}