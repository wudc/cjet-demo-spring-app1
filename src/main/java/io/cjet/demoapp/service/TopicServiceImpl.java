package io.cjet.demoapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.cjet.demoapp.model.Topic;

/**
 * Spring service is singleton
 * 
 * @author wudc
 *
 */

@SuppressWarnings("serial")
@Service
@Qualifier("TopicServiceImpl")
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "First", "First Topic"),
			new Topic("2", "Second", "Second Topic"), new Topic("3", "Third", "Third Topic")));

	// ArrayList<Topic> topics = new ArrayList<Topic>();

	// public TopicServiceImpl() {
	// // topics.add(new Topic("1", "First", "First Topic"));
	// // topics.add(new Topic("2", "Second", "Second Topic"));
	// // topics.add(new Topic("3", "Third", "Third Topic"));
	// topics = Arrays.asList(new Topic("1", "First", "First Topic"), new Topic("2",
	// "Second", "Second Topic"),
	// new Topic("3", "Third", "Third Topic"));
	//
	// }

	public List<Topic> getAllTopics() {
		// ArrayList<Topic> topics = new ArrayList<Topic>();
		// topics.add(new Topic("1", "First", "First Topic"));
		// topics.add(new Topic("2", "Second", "Second Topic"));
		// topics.add(new Topic("3", "Third", "Third Topic"));
		//
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public Topic getTopicByName(String name) {
		return topics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		System.out.println("topics: " + topics);
		System.out.println("topics size: " + topics.size());
		System.out.println("topics[1]: " + topics.get(0));
		System.out.println("topic: " + topic);

		topics.add(topic);
	}
	
	public void updateTopic(Topic topic) {
		String id = topic.getId();
	
		for (int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}

	}
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
