/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RestoreAssistant extends Resource {
    private static final long serialVersionUID = 267361082192414L;

    /**
     * Create a RestoreAssistantUpdater to execute update.
     *
     * @param assistant The unique string that identifies the resource
     * @return RestoreAssistantUpdater capable of executing the update
     */
    public static RestoreAssistantUpdater updater(final String assistant) {
        return new RestoreAssistantUpdater(assistant);
    }

    /**
     * Converts a JSON String into a RestoreAssistant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return RestoreAssistant object represented by the provided JSON
     */
    public static RestoreAssistant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RestoreAssistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a RestoreAssistant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return RestoreAssistant object represented by the provided JSON
     */
    public static RestoreAssistant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RestoreAssistant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String uniqueName;
    private final String friendlyName;
    private final Boolean needsModelBuild;
    private final String latestModelBuildSid;
    private final Boolean logQueries;
    private final String developmentStage;
    private final URI callbackUrl;
    private final String callbackEvents;

    @JsonCreator
    private RestoreAssistant(@JsonProperty("account_sid")
                             final String accountSid,
                             @JsonProperty("sid")
                             final String sid,
                             @JsonProperty("date_created")
                             final String dateCreated,
                             @JsonProperty("date_updated")
                             final String dateUpdated,
                             @JsonProperty("unique_name")
                             final String uniqueName,
                             @JsonProperty("friendly_name")
                             final String friendlyName,
                             @JsonProperty("needs_model_build")
                             final Boolean needsModelBuild,
                             @JsonProperty("latest_model_build_sid")
                             final String latestModelBuildSid,
                             @JsonProperty("log_queries")
                             final Boolean logQueries,
                             @JsonProperty("development_stage")
                             final String developmentStage,
                             @JsonProperty("callback_url")
                             final URI callbackUrl,
                             @JsonProperty("callback_events")
                             final String callbackEvents) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.uniqueName = uniqueName;
        this.friendlyName = friendlyName;
        this.needsModelBuild = needsModelBuild;
        this.latestModelBuildSid = latestModelBuildSid;
        this.logQueries = logQueries;
        this.developmentStage = developmentStage;
        this.callbackUrl = callbackUrl;
        this.callbackEvents = callbackEvents;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was created.
     *
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns An application-defined string that uniquely identifies the resource.
     *
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns Whether model needs to be rebuilt.
     *
     * @return Whether model needs to be rebuilt
     */
    public final Boolean getNeedsModelBuild() {
        return this.needsModelBuild;
    }

    /**
     * Returns Reserved.
     *
     * @return Reserved
     */
    public final String getLatestModelBuildSid() {
        return this.latestModelBuildSid;
    }

    /**
     * Returns Whether queries should be logged and kept after training.
     *
     * @return Whether queries should be logged and kept after training
     */
    public final Boolean getLogQueries() {
        return this.logQueries;
    }

    /**
     * Returns A string describing the state of the assistant..
     *
     * @return A string describing the state of the assistant.
     */
    public final String getDevelopmentStage() {
        return this.developmentStage;
    }

    /**
     * Returns Reserved.
     *
     * @return Reserved
     */
    public final URI getCallbackUrl() {
        return this.callbackUrl;
    }

    /**
     * Returns Reserved.
     *
     * @return Reserved
     */
    public final String getCallbackEvents() {
        return this.callbackEvents;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RestoreAssistant other = (RestoreAssistant) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(needsModelBuild, other.needsModelBuild) &&
               Objects.equals(latestModelBuildSid, other.latestModelBuildSid) &&
               Objects.equals(logQueries, other.logQueries) &&
               Objects.equals(developmentStage, other.developmentStage) &&
               Objects.equals(callbackUrl, other.callbackUrl) &&
               Objects.equals(callbackEvents, other.callbackEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            dateCreated,
                            dateUpdated,
                            uniqueName,
                            friendlyName,
                            needsModelBuild,
                            latestModelBuildSid,
                            logQueries,
                            developmentStage,
                            callbackUrl,
                            callbackEvents);
    }
}