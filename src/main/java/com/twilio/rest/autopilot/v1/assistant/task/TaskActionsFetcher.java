/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1.assistant.task;

import com.twilio.base.Fetcher;
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
public class TaskActionsFetcher extends Fetcher<TaskActions> {
    private final String pathAssistantSid;
    private final String pathTaskSid;

    /**
     * Construct a new TaskActionsFetcher.
     *
     * @param pathAssistantSid The SID of the Assistant that is the parent of the
     *                         Task for which the task actions to fetch were defined
     * @param pathTaskSid The SID of the Task for which the task actions to fetch
     *                    were defined
     */
    public TaskActionsFetcher(final String pathAssistantSid,
                              final String pathTaskSid) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched TaskActions
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TaskActions fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.AUTOPILOT.toString(),
            "/v1/Assistants/" + this.pathAssistantSid + "/Tasks/" + this.pathTaskSid + "/Actions"
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TaskActions fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return TaskActions.fromJson(response.getStream(), client.getObjectMapper());
    }
}