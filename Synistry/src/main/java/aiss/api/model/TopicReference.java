package aiss.api.model;

public class TopicReference {
	
	private String topicId;
	private String topicName;
	
	
	public TopicReference() {
		super();
	}

	public TopicReference(String topicName) {
		this.topicName = topicName;
	}

	public TopicReference(String topicId, String topicName) {
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public String getTopicId() {
		return topicId;
	}

	public String getTopicName() {
		return topicName;
	}
	
	public Boolean equalsToTopic(Topic topic) {
		Boolean res = topic.getId().equals(getTopicId())&&topic.getName().equals(getTopicName());
		return res;
	}

}
