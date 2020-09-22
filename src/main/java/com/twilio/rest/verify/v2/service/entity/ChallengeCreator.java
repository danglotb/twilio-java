/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.twilio.base.Creator;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ChallengeCreator extends Creator<Challenge> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String factorSid;
    private DateTime expirationDate;
    private String details;
    private String hiddenDetails;
    private String twilioSandboxMode;

    /**
     * Construct a new ChallengeCreator.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param factorSid Factor Sid.
     */
    public ChallengeCreator(final String pathServiceSid,
                            final String pathIdentity,
                            final String factorSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.factorSid = factorSid;
    }

    /**
     * The future date in which this Challenge will expire, given in <a
     * href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a> format..
     *
     * @param expirationDate The future date in which this Challenge will expire
     * @return this
     */
    public ChallengeCreator setExpirationDate(final DateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * Details provided to give context about the Challenge. Shown to the end user.
     * It must be a stringified JSON with the following structure: {"message":
     * "string", "fields": <a href="https://www.twilio.com/docs/verify/api/service">
     * { "label": "string", "value": "string"}]}. `message` is required. If you send
     * the `fields` property, each field has to include `label` and `value`
     * properties. If you had set `include_date=true` in the `push` configuration of
     * the [service</a>, the response will also include the challenge's date created
     * value as an additional field called `date`.
     *
     * @param details Public details provided to contextualize the Challenge
     * @return this
     */
    public ChallengeCreator setDetails(final String details) {
        this.details = details;
        return this;
    }

    /**
     * Details provided to give context about the Challenge. Not shown to the end
     * user. It must be a stringified JSON with only strings values eg. `{"ip":
     * "172.168.1.234"}`.
     *
     * @param hiddenDetails Hidden details provided to contextualize the Challenge
     * @return this
     */
    public ChallengeCreator setHiddenDetails(final String hiddenDetails) {
        this.hiddenDetails = hiddenDetails;
        return this;
    }

    /**
     * The Twilio-Sandbox-Mode HTTP request header.
     *
     * @param twilioSandboxMode The Twilio-Sandbox-Mode HTTP request header
     * @return this
     */
    public ChallengeCreator setTwilioSandboxMode(final String twilioSandboxMode) {
        this.twilioSandboxMode = twilioSandboxMode;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Challenge
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Challenge create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Entities/" + this.pathIdentity + "/Challenges"
        );

        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Challenge creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Challenge.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested header parameters to the Request.
     *
     * @param request Request to add header params to
     */
    private void addHeaderParams(final Request request) {
        if (twilioSandboxMode != null) {
            request.addHeaderParam("Twilio-Sandbox-Mode", twilioSandboxMode);
        }
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (factorSid != null) {
            request.addPostParam("FactorSid", factorSid);
        }

        if (expirationDate != null) {
            request.addPostParam("ExpirationDate", expirationDate.toString());
        }

        if (details != null) {
            request.addPostParam("Details", details);
        }

        if (hiddenDetails != null) {
            request.addPostParam("HiddenDetails", hiddenDetails);
        }
    }
}