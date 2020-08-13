/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WorkersRealTimeStatisticsFetcher extends Fetcher<WorkersRealTimeStatistics> {
    private final String pathWorkspaceSid;
    private String taskChannel;

    /**
     * Construct a new WorkersRealTimeStatisticsFetcher.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the resource to fetch
     */
    public WorkersRealTimeStatisticsFetcher(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    /**
     * Only calculate real-time statistics on this TaskChannel. Can be the
     * TaskChannel's SID or its `unique_name`, such as `voice`, `sms`, or
     * `default`..
     *
     * @param taskChannel Only calculate real-time statistics on this TaskChannel
     * @return this
     */
    public WorkersRealTimeStatisticsFetcher setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched WorkersRealTimeStatistics
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public WorkersRealTimeStatistics fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workers/RealTimeStatistics"
        );

        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("WorkersRealTimeStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return WorkersRealTimeStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (taskChannel != null) {
            request.addQueryParam("TaskChannel", taskChannel);
        }
    }
}