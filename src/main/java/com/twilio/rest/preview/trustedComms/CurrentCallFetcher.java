/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.trustedComms;

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
public class CurrentCallFetcher extends Fetcher<CurrentCall> {
    private String xXcnamSensitivePhoneNumberFrom;
    private String xXcnamSensitivePhoneNumberTo;

    /**
     * The originating Phone Number, given in <a
     * href="https://www.twilio.com/docs/glossary/what-e164">E.164 format</a>. This
     * phone number should be a Twilio number, otherwise it will return an error
     * with HTTP Status Code 400..
     *
     * @param xXcnamSensitivePhoneNumberFrom The originating Phone Number
     * @return this
     */
    public CurrentCallFetcher setXXcnamSensitivePhoneNumberFrom(final String xXcnamSensitivePhoneNumberFrom) {
        this.xXcnamSensitivePhoneNumberFrom = xXcnamSensitivePhoneNumberFrom;
        return this;
    }

    /**
     * The terminating Phone Number, given in <a
     * href="https://www.twilio.com/docs/glossary/what-e164">E.164 format</a>..
     *
     * @param xXcnamSensitivePhoneNumberTo The terminating Phone Number
     * @return this
     */
    public CurrentCallFetcher setXXcnamSensitivePhoneNumberTo(final String xXcnamSensitivePhoneNumberTo) {
        this.xXcnamSensitivePhoneNumberTo = xXcnamSensitivePhoneNumberTo;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched CurrentCall
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public CurrentCall fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            "/TrustedComms/CurrentCall"
        );

        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CurrentCall fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CurrentCall.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested header parameters to the Request.
     *
     * @param request Request to add header params to
     */
    private void addHeaderParams(final Request request) {
        if (xXcnamSensitivePhoneNumberFrom != null) {
            request.addHeaderParam("X-Xcnam-Sensitive-Phone-Number-From", xXcnamSensitivePhoneNumberFrom);
        }

        if (xXcnamSensitivePhoneNumberTo != null) {
            request.addHeaderParam("X-Xcnam-Sensitive-Phone-Number-To", xXcnamSensitivePhoneNumberTo);
        }
    }
}