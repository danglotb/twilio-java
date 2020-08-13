/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

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
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class AssignedAddOnCreator extends Creator<AssignedAddOn> {
    private String pathAccountSid;
    private final String pathResourceSid;
    private final String installedAddOnSid;

    /**
     * Construct a new AssignedAddOnCreator.
     *
     * @param pathResourceSid The SID of the Phone Number to assign the Add-on
     * @param installedAddOnSid The SID that identifies the Add-on installation
     */
    public AssignedAddOnCreator(final String pathResourceSid,
                                final String installedAddOnSid) {
        this.pathResourceSid = pathResourceSid;
        this.installedAddOnSid = installedAddOnSid;
    }

    /**
     * Construct a new AssignedAddOnCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param pathResourceSid The SID of the Phone Number to assign the Add-on
     * @param installedAddOnSid The SID that identifies the Add-on installation
     */
    public AssignedAddOnCreator(final String pathAccountSid,
                                final String pathResourceSid,
                                final String installedAddOnSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathResourceSid = pathResourceSid;
        this.installedAddOnSid = installedAddOnSid;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created AssignedAddOn
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AssignedAddOn create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/" + this.pathResourceSid + "/AssignedAddOns.json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AssignedAddOn creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AssignedAddOn.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (installedAddOnSid != null) {
            request.addPostParam("InstalledAddOnSid", installedAddOnSid);
        }
    }
}