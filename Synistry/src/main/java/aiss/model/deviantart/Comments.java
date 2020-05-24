
package aiss.model.deviantart;

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
    "has_more",
    "next_offset",
    "has_less",
    "prev_offset",
    "thread"
})
public class Comments {

    @JsonProperty("has_more")
    private Boolean hasMore;
    @JsonProperty("next_offset")
    private Object nextOffset;
    @JsonProperty("has_less")
    private Boolean hasLess;
    @JsonProperty("prev_offset")
    private Object prevOffset;
    @JsonProperty("thread")
    private List<Thread> thread = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("has_more")
    public Boolean getHasMore() {
        return hasMore;
    }

    @JsonProperty("has_more")
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @JsonProperty("next_offset")
    public Object getNextOffset() {
        return nextOffset;
    }

    @JsonProperty("next_offset")
    public void setNextOffset(Object nextOffset) {
        this.nextOffset = nextOffset;
    }

    @JsonProperty("has_less")
    public Boolean getHasLess() {
        return hasLess;
    }

    @JsonProperty("has_less")
    public void setHasLess(Boolean hasLess) {
        this.hasLess = hasLess;
    }

    @JsonProperty("prev_offset")
    public Object getPrevOffset() {
        return prevOffset;
    }

    @JsonProperty("prev_offset")
    public void setPrevOffset(Object prevOffset) {
        this.prevOffset = prevOffset;
    }

    @JsonProperty("thread")
    public List<Thread> getThread() {
        return thread;
    }

    @JsonProperty("thread")
    public void setThread(List<Thread> thread) {
        this.thread = thread;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
