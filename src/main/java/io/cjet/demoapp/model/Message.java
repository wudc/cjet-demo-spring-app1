package io.cjet.demoapp.model;

public class Message {
	
	private String id;
	private String name;
	private String description;
	
	//Associate this message to a topic. 
	private Topic topic = new Topic("","","");
	
	public Message() {}
	
	public Message(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		topic.setId(topicId);;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
