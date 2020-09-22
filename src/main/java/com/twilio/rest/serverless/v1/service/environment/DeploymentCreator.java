/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.environment;

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
public class DeploymentCreator extends Creator<Deployment> {
    private final String pathServiceSid;
    private final String pathEnvironmentSid;
    private String buildSid;

    /**
     * Construct a new DeploymentCreator.
     *
     * @param pathServiceSid The SID of the Service to create the Deployment
     *                       resource under
     * @param pathEnvironmentSid The SID of the Environment for the Deployment
     */
    public DeploymentCreator(final String pathServiceSid,
                             final String pathEnvironmentSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathEnvironmentSid = pathEnvironmentSid;
    }

    /**
     * The SID of the Build for the Deployment..
     *
     * @param buildSid The SID of the Build for the Deployment
     * @return this
     */
    public DeploymentCreator setBuildSid(final String buildSid) {
        this.buildSid = buildSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Deployment
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Deployment create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Environments/" + this.pathEnvironmentSid + "/Deployments"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Deployment creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Deployment.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (buildSid != null) {
            request.addPostParam("BuildSid", buildSid);
        }
    }
}