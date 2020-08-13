/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.recording;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class TranscriptionFetcher extends Fetcher<Transcription> {
    private String pathAccountSid;
    private final String pathRecordingSid;
    private final String pathSid;

    /**
     * Construct a new TranscriptionFetcher.
     *
     * @param pathRecordingSid The SID of the recording that created the
     *                         transcriptions to fetch
     * @param pathSid The unique string that identifies the resource
     */
    public TranscriptionFetcher(final String pathRecordingSid,
                                final String pathSid) {
        this.pathRecordingSid = pathRecordingSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new TranscriptionFetcher.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathRecordingSid The SID of the recording that created the
     *                         transcriptions to fetch
     * @param pathSid The unique string that identifies the resource
     */
    public TranscriptionFetcher(final String pathAccountSid,
                                final String pathRecordingSid,
                                final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathRecordingSid = pathRecordingSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Transcription
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Transcription fetch(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Recordings/" + this.pathRecordingSid + "/Transcriptions/" + this.pathSid + ".json"
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Transcription fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Transcription.fromJson(response.getStream(), client.getObjectMapper());
    }
}