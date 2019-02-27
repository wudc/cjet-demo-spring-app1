package io.cjet.demoapp.service;

import java.io.Serializable;
import java.util.List;

import io.cjet.demoapp.model.Topic;

public interface TopicService extends Serializable {
	public List<Topic> getAllTopics();
	public Topic getTopic(String id);
	public Topic getTopicByName(String name);
	public void addTopic(Topic topic);
	public void updateTopic(Topic topic);
	public void deleteTopic(String id);
}
