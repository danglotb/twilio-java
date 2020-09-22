/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.bulkExports;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ExportConfigurationUpdater extends Updater<ExportConfiguration> {
    private final String pathResourceType;
    private Boolean enabled;
    private URI webhookUrl;
    private String webhookMethod;

    /**
     * Construct a new ExportConfigurationUpdater.
     *
     * @param pathResourceType The type of communication – Messages, Calls
     */
    public ExportConfigurationUpdater(final String pathResourceType) {
        this.pathResourceType = pathResourceType;
    }

    /**
     * If true, Twilio will automatically generate every day's file when the day is
     * over..
     *
     * @param enabled Whether files are automatically generated
     * @return this
     */
    public ExportConfigurationUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Stores the URL destination for the method specified in webhook_method..
     *
     * @param webhookUrl URL targeted at export
     * @return this
     */
    public ExportConfigurationUpdater setWebhookUrl(final URI webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    /**
     * Stores the URL destination for the method specified in webhook_method..
     *
     * @param webhookUrl URL targeted at export
     * @return this
     */
    public ExportConfigurationUpdater setWebhookUrl(final String webhookUrl) {
        return setWebhookUrl(Promoter.uriFromString(webhookUrl));
    }

    /**
     * Sets whether Twilio should call a webhook URL when the automatic generation
     * is complete, using GET or POST. The actual destination is set in the
     * webhook_url.
     *
     * @param webhookMethod Whether to GET or POST to the webhook url
     * @return this
     */
    public ExportConfigurationUpdater setWebhookMethod(final String webhookMethod) {
        this.webhookMethod = webhookMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated ExportConfiguration
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ExportConfiguration update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/BulkExports/Exports/" + this.pathResourceType + "/Configuration"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ExportConfiguration update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExportConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }

        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl.toString());
        }

        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod);
        }
    }
}