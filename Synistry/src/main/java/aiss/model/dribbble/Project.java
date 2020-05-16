package aiss.model.dribbble;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "shot_counts", "created_at", "updated_at" })
public class Project {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("shot_counts")
	private Integer shot_counts;
	@JsonProperty("created_at")
	private LocalDate created_at;
	@JsonProperty("updated_at")
	private LocalDate updated_at;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("shot_counts")
	public Integer getShot_counts() {
		return shot_counts;
	}

	@JsonProperty("created_at")
	public LocalDate getCreated_at() {
		return created_at;
	}

	@JsonProperty("updated_at")
	public LocalDate getUpdated_at() {
		return updated_at;
	}

}
