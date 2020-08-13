/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WorkerCreator extends Creator<Worker> {
    private final String pathWorkspaceSid;
    private final String friendlyName;
    private String activitySid;
    private String attributes;

    /**
     * Construct a new WorkerCreator.
     *
     * @param pathWorkspaceSid The SID of the Workspace that the new Worker belongs
     *                         to
     * @param friendlyName A string to describe the resource
     */
    public WorkerCreator(final String pathWorkspaceSid,
                         final String friendlyName) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
    }

    /**
     * The SID of a valid Activity that will describe the new Worker's initial
     * state. See [Activities](https://www.twilio.com/docs/taskrouter/api/activity)
     * for more information. If not provided, the new Worker's initial state is the
     * `default_activity_sid` configured on the Workspace..
     *
     * @param activitySid The SID of a valid Activity that describes the new
     *                    Worker's initial state
     * @return this
     */
    public WorkerCreator setActivitySid(final String activitySid) {
        this.activitySid = activitySid;
        return this;
    }

    /**
     * A valid JSON string that describes the new Worker. For example: `{ "email":
     * "Bob@example.com", "phone": "+5095551234" }`. This data is passed to the
     * `assignment_callback_url` when TaskRouter assigns a Task to the Worker.
     * Defaults to {}..
     *
     * @param attributes A valid JSON string that describes the new Worker
     * @return this
     */
    public WorkerCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Worker
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Worker create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workers"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Worker creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Worker.fromJson(response.getStream(), client.getObjectMapper());
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

        if (activitySid != null) {
            request.addPostParam("ActivitySid", activitySid);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
    }
}