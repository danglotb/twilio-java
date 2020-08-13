/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class QueueCreator extends Creator<Queue> {
    private String pathAccountSid;
    private final String friendlyName;
    private Integer maxSize;

    /**
     * Construct a new QueueCreator.
     *
     * @param friendlyName A string to describe this resource
     */
    public QueueCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * Construct a new QueueCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param friendlyName A string to describe this resource
     */
    public QueueCreator(final String pathAccountSid,
                        final String friendlyName) {
        this.pathAccountSid = pathAccountSid;
        this.friendlyName = friendlyName;
    }

    /**
     * The maximum number of calls allowed to be in the queue. The default is 100.
     * The maximum is 5000..
     *
     * @param maxSize The max number of calls allowed in the queue
     * @return this
     */
    public QueueCreator setMaxSize(final Integer maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Queue
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Queue create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Queues.json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Queue creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Queue.fromJson(response.getStream(), client.getObjectMapper());
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

        if (maxSize != null) {
            request.addPostParam("MaxSize", maxSize.toString());
        }
    }
}