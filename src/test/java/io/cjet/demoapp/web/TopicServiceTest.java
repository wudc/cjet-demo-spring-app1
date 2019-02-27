package io.cjet.demoapp.web;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import io.cjet.demoapp.model.Topic;
import io.cjet.demoapp.service.TopicServiceImpl;

@RunWith(SpringRunner.class)
public class TopicServiceTest {

	@InjectMocks
	private TopicServiceImpl topicService;
	
	@Test
	public void getAllTopicsTest() throws Exception {
		List<Topic> topics = topicService.getAllTopics();
		assertEquals(3, topics.size());
		assertEquals("1", topics.get(0).getId());
		assertEquals("Second", topics.get(1).getName());		
		assertEquals("Third Topic", topics.get(2).getDescription());		
	}
	
	@Test
	public void getTopicTest() throws Exception {
		Topic topic = topicService.getTopic("2");
		assertEquals("2", topic.getId());
		assertEquals("Second", topic.getName());		
		assertEquals("Second Topic", topic.getDescription());		
	}
	
	@Test
	public void getTopicByNameTest() throws Exception {
		Topic topic = topicService.getTopicByName("Third");
		assertEquals("3", topic.getId());
		assertEquals("Third", topic.getName());		
		assertEquals("Third Topic", topic.getDescription());		
	}
	
	@Test
	public void addTopicTest() throws Exception {
		Topic topic4 = new Topic("4", "Fourth", "Fourth Topic");
		topicService.addTopic(topic4);
		
		List<Topic> topics = topicService.getAllTopics();
		assertEquals(4, topics.size());
		assertEquals("4", topics.get(3).getId());
		assertEquals("Fourth", topics.get(3).getName());		
		assertEquals("Fourth Topic", topics.get(3).getDescription());		
	}
	
	@Test
	public void updateTopicTest() throws Exception {
		Topic topic4 = new Topic("3", "Five", "Fifth Topic");
		topicService.updateTopic(topic4);
		
		List<Topic> topics = topicService.getAllTopics();
		assertEquals("3", topics.get(2).getId());
		assertEquals("Five", topics.get(2).getName());		
		assertEquals("Fifth Topic", topics.get(2).getDescription());		
	}

	@Test
	public void deleteTopicTest() throws Exception {
		Topic topic4 = new Topic("4", "Fourth", "Fourth Topic");
		topicService.addTopic(topic4);
		
		List<Topic> topics = topicService.getAllTopics();
		assertEquals(4, topics.size());
		
		topicService.deleteTopic("4");
		topics = topicService.getAllTopics();
		assertEquals(3, topics.size());
		assertEquals("3", topics.get(2).getId());
		
	}	
}
