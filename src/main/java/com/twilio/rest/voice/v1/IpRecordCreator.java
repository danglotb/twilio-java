/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.voice.v1;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class IpRecordCreator extends Creator<IpRecord> {
    private final String ipAddress;
    private String friendlyName;
    private Integer cidrPrefixLength;

    /**
     * Construct a new IpRecordCreator.
     *
     * @param ipAddress An IP address in dotted decimal notation, IPv4 only.
     */
    public IpRecordCreator(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * A descriptive string that you create to describe the resource. It is not
     * unique and can be up to 255 characters long..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public IpRecordCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * An integer representing the length of the <a
     * href="https://tools.ietf.org/html/rfc4632">CIDR</a> prefix to use with this
     * IP address. By default the entire IP address is used, which for IPv4 is value
     * 32..
     *
     * @param cidrPrefixLength An integer representing the length of the
     *                         <a href="https://tools.ietf.org/html/rfc4632">CIDR</a> prefix to
     *                         use with this IP address. By default the entire IP
     *                         address is used, which for IPv4 is value 32.
     * @return this
     */
    public IpRecordCreator setCidrPrefixLength(final Integer cidrPrefixLength) {
        this.cidrPrefixLength = cidrPrefixLength;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created IpRecord
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IpRecord create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VOICE.toString(),
            "/v1/IpRecords"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpRecord creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpRecord.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (ipAddress != null) {
            request.addPostParam("IpAddress", ipAddress);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (cidrPrefixLength != null) {
            request.addPostParam("CidrPrefixLength", cidrPrefixLength.toString());
        }
    }
}