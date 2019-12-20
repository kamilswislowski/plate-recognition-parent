
package pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "processing_time",
    "results",
    "filename",
    "version",
    "camera_id",
    "timestamp"
})
public class PlateRecognizerResponse {

    @JsonProperty("processing_time")
    private Double processingTime;
    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("camera_id")
    private Object cameraId;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("processing_time")
    public Double getProcessingTime() {
        return processingTime;
    }

    @JsonProperty("processing_time")
    public void setProcessingTime(Double processingTime) {
        this.processingTime = processingTime;
    }

    public PlateRecognizerResponse withProcessingTime(Double processingTime) {
        this.processingTime = processingTime;
        return this;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public PlateRecognizerResponse withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public PlateRecognizerResponse withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    public PlateRecognizerResponse withVersion(Integer version) {
        this.version = version;
        return this;
    }

    @JsonProperty("camera_id")
    public Object getCameraId() {
        return cameraId;
    }

    @JsonProperty("camera_id")
    public void setCameraId(Object cameraId) {
        this.cameraId = cameraId;
    }

    public PlateRecognizerResponse withCameraId(Object cameraId) {
        this.cameraId = cameraId;
        return this;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public PlateRecognizerResponse withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PlateRecognizerResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PlateRecognizerResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("processingTime");
        sb.append('=');
        sb.append(((this.processingTime == null)?"<null>":this.processingTime));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        sb.append("filename");
        sb.append('=');
        sb.append(((this.filename == null)?"<null>":this.filename));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("cameraId");
        sb.append('=');
        sb.append(((this.cameraId == null)?"<null>":this.cameraId));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.filename == null)? 0 :this.filename.hashCode()));
        result = ((result* 31)+((this.cameraId == null)? 0 :this.cameraId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.results == null)? 0 :this.results.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.processingTime == null)? 0 :this.processingTime.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlateRecognizerResponse) == false) {
            return false;
        }
        PlateRecognizerResponse rhs = ((PlateRecognizerResponse) other);
        return ((((((((this.filename == rhs.filename)||((this.filename!= null)&&this.filename.equals(rhs.filename)))&&((this.cameraId == rhs.cameraId)||((this.cameraId!= null)&&this.cameraId.equals(rhs.cameraId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.results == rhs.results)||((this.results!= null)&&this.results.equals(rhs.results))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.processingTime == rhs.processingTime)||((this.processingTime!= null)&&this.processingTime.equals(rhs.processingTime))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
