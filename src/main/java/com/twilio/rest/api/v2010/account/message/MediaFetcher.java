/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.message;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MediaFetcher extends Fetcher<Media> {
    private String pathAccountSid;
    private final String pathMessageSid;
    private final String pathSid;

    /**
     * Construct a new MediaFetcher.
     *
     * @param pathMessageSid The SID of the Message resource that this Media
     *                       resource belongs to
     * @param pathSid The unique string that identifies this resource
     */
    public MediaFetcher(final String pathMessageSid,
                        final String pathSid) {
        this.pathMessageSid = pathMessageSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new MediaFetcher.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       fetch
     * @param pathMessageSid The SID of the Message resource that this Media
     *                       resource belongs to
     * @param pathSid The unique string that identifies this resource
     */
    public MediaFetcher(final String pathAccountSid,
                        final String pathMessageSid,
                        final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathMessageSid = pathMessageSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Media
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Media fetch(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Messages/" + this.pathMessageSid + "/Media/" + this.pathSid + ".json"
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Media fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Media.fromJson(response.getStream(), client.getObjectMapper());
    }
}