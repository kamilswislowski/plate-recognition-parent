
package pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ymin",
    "xmin",
    "ymax",
    "xmax"
})
public class Box {

    @JsonProperty("ymin")
    private Integer ymin;
    @JsonProperty("xmin")
    private Integer xmin;
    @JsonProperty("ymax")
    private Integer ymax;
    @JsonProperty("xmax")
    private Integer xmax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ymin")
    public Integer getYmin() {
        return ymin;
    }

    @JsonProperty("ymin")
    public void setYmin(Integer ymin) {
        this.ymin = ymin;
    }

    public Box withYmin(Integer ymin) {
        this.ymin = ymin;
        return this;
    }

    @JsonProperty("xmin")
    public Integer getXmin() {
        return xmin;
    }

    @JsonProperty("xmin")
    public void setXmin(Integer xmin) {
        this.xmin = xmin;
    }

    public Box withXmin(Integer xmin) {
        this.xmin = xmin;
        return this;
    }

    @JsonProperty("ymax")
    public Integer getYmax() {
        return ymax;
    }

    @JsonProperty("ymax")
    public void setYmax(Integer ymax) {
        this.ymax = ymax;
    }

    public Box withYmax(Integer ymax) {
        this.ymax = ymax;
        return this;
    }

    @JsonProperty("xmax")
    public Integer getXmax() {
        return xmax;
    }

    @JsonProperty("xmax")
    public void setXmax(Integer xmax) {
        this.xmax = xmax;
    }

    public Box withXmax(Integer xmax) {
        this.xmax = xmax;
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

    public Box withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Box.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ymin");
        sb.append('=');
        sb.append(((this.ymin == null)?"<null>":this.ymin));
        sb.append(',');
        sb.append("xmin");
        sb.append('=');
        sb.append(((this.xmin == null)?"<null>":this.xmin));
        sb.append(',');
        sb.append("ymax");
        sb.append('=');
        sb.append(((this.ymax == null)?"<null>":this.ymax));
        sb.append(',');
        sb.append("xmax");
        sb.append('=');
        sb.append(((this.xmax == null)?"<null>":this.xmax));
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
        result = ((result* 31)+((this.ymin == null)? 0 :this.ymin.hashCode()));
        result = ((result* 31)+((this.xmin == null)? 0 :this.xmin.hashCode()));
        result = ((result* 31)+((this.ymax == null)? 0 :this.ymax.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.xmax == null)? 0 :this.xmax.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Box) == false) {
            return false;
        }
        Box rhs = ((Box) other);
        return ((((((this.ymin == rhs.ymin)||((this.ymin!= null)&&this.ymin.equals(rhs.ymin)))&&((this.xmin == rhs.xmin)||((this.xmin!= null)&&this.xmin.equals(rhs.xmin))))&&((this.ymax == rhs.ymax)||((this.ymax!= null)&&this.ymax.equals(rhs.ymax))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.xmax == rhs.xmax)||((this.xmax!= null)&&this.xmax.equals(rhs.xmax))));
    }

}
