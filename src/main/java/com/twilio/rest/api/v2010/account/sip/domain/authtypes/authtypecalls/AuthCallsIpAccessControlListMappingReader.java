/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip.domain.authtypes.authtypecalls;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AuthCallsIpAccessControlListMappingReader extends Reader<AuthCallsIpAccessControlListMapping> {
    private String pathAccountSid;
    private final String pathDomainSid;

    /**
     * Construct a new AuthCallsIpAccessControlListMappingReader.
     *
     * @param pathDomainSid The SID of the SIP domain that contains the resources
     *                      to read
     */
    public AuthCallsIpAccessControlListMappingReader(final String pathDomainSid) {
        this.pathDomainSid = pathDomainSid;
    }

    /**
     * Construct a new AuthCallsIpAccessControlListMappingReader.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @param pathDomainSid The SID of the SIP domain that contains the resources
     *                      to read
     */
    public AuthCallsIpAccessControlListMappingReader(final String pathAccountSid,
                                                     final String pathDomainSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathDomainSid = pathDomainSid;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return AuthCallsIpAccessControlListMapping ResourceSet
     */
    @Override
    public ResourceSet<AuthCallsIpAccessControlListMapping> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return AuthCallsIpAccessControlListMapping ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<AuthCallsIpAccessControlListMapping> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/Domains/" + this.pathDomainSid + "/Auth/Calls/IpAccessControlListMappings.json"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return AuthCallsIpAccessControlListMapping ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<AuthCallsIpAccessControlListMapping> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<AuthCallsIpAccessControlListMapping> nextPage(final Page<AuthCallsIpAccessControlListMapping> page,
                                                              final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<AuthCallsIpAccessControlListMapping> previousPage(final Page<AuthCallsIpAccessControlListMapping> page,
                                                                  final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of AuthCallsIpAccessControlListMapping Resources for a given
     * request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<AuthCallsIpAccessControlListMapping> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AuthCallsIpAccessControlListMapping read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "contents",
            response.getContent(),
            AuthCallsIpAccessControlListMapping.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}