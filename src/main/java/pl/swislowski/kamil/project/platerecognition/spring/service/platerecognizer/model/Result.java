
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
    "box",
    "plate",
    "region",
    "vehicle",
    "score",
    "candidates",
    "dscore"
})
public class Result {

    @JsonProperty("box")
    private Box box;
    @JsonProperty("plate")
    private String plate;
    @JsonProperty("region")
    private Region region;
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("candidates")
    private List<Candidate> candidates = new ArrayList<Candidate>();
    @JsonProperty("dscore")
    private Double dscore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("box")
    public Box getBox() {
        return box;
    }

    @JsonProperty("box")
    public void setBox(Box box) {
        this.box = box;
    }

    public Result withBox(Box box) {
        this.box = box;
        return this;
    }

    @JsonProperty("plate")
    public String getPlate() {
        return plate;
    }

    @JsonProperty("plate")
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Result withPlate(String plate) {
        this.plate = plate;
        return this;
    }

    @JsonProperty("region")
    public Region getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(Region region) {
        this.region = region;
    }

    public Result withRegion(Region region) {
        this.region = region;
        return this;
    }

    @JsonProperty("vehicle")
    public Vehicle getVehicle() {
        return vehicle;
    }

    @JsonProperty("vehicle")
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Result withVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    public Result withScore(Double score) {
        this.score = score;
        return this;
    }

    @JsonProperty("candidates")
    public List<Candidate> getCandidates() {
        return candidates;
    }

    @JsonProperty("candidates")
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Result withCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
        return this;
    }

    @JsonProperty("dscore")
    public Double getDscore() {
        return dscore;
    }

    @JsonProperty("dscore")
    public void setDscore(Double dscore) {
        this.dscore = dscore;
    }

    public Result withDscore(Double dscore) {
        this.dscore = dscore;
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

    public Result withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("box");
        sb.append('=');
        sb.append(((this.box == null)?"<null>":this.box));
        sb.append(',');
        sb.append("plate");
        sb.append('=');
        sb.append(((this.plate == null)?"<null>":this.plate));
        sb.append(',');
        sb.append("region");
        sb.append('=');
        sb.append(((this.region == null)?"<null>":this.region));
        sb.append(',');
        sb.append("vehicle");
        sb.append('=');
        sb.append(((this.vehicle == null)?"<null>":this.vehicle));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("candidates");
        sb.append('=');
        sb.append(((this.candidates == null)?"<null>":this.candidates));
        sb.append(',');
        sb.append("dscore");
        sb.append('=');
        sb.append(((this.dscore == null)?"<null>":this.dscore));
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
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.candidates == null)? 0 :this.candidates.hashCode()));
        result = ((result* 31)+((this.dscore == null)? 0 :this.dscore.hashCode()));
        result = ((result* 31)+((this.box == null)? 0 :this.box.hashCode()));
        result = ((result* 31)+((this.plate == null)? 0 :this.plate.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.region == null)? 0 :this.region.hashCode()));
        result = ((result* 31)+((this.vehicle == null)? 0 :this.vehicle.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return (((((((((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score)))&&((this.candidates == rhs.candidates)||((this.candidates!= null)&&this.candidates.equals(rhs.candidates))))&&((this.dscore == rhs.dscore)||((this.dscore!= null)&&this.dscore.equals(rhs.dscore))))&&((this.box == rhs.box)||((this.box!= null)&&this.box.equals(rhs.box))))&&((this.plate == rhs.plate)||((this.plate!= null)&&this.plate.equals(rhs.plate))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.region == rhs.region)||((this.region!= null)&&this.region.equals(rhs.region))))&&((this.vehicle == rhs.vehicle)||((this.vehicle!= null)&&this.vehicle.equals(rhs.vehicle))));
    }

}
