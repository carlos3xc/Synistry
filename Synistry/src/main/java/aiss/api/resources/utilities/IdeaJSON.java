package aiss.api.resources.utilities;

import aiss.api.model.Idea;

public class IdeaJSON {
	
	private String link;
	private String imageURL;
	private String title;
	private String text;
	private String topicId;
	
	public IdeaJSON() {
		super();
	}

	public IdeaJSON(String link, String imageURL, String title, String text, String topicId) {
		super();
		this.link = link;
		this.imageURL = imageURL;
		this.title = title;
		this.text = text;
		this.topicId = topicId;
	}
	
	public Idea toIdea() {
		Idea res;
		res = new Idea(getLink(), getImageURL(), getTitle(), getText(), getTopicId());
		return res;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	
	

}
