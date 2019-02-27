package io.cjet.demoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.cjet.demoapp.model.Message;
import io.cjet.demoapp.model.Topic;
import io.cjet.demoapp.service.MessageService;

/**
 * GET /messages ->gets (GET) all Messages http://localhost:8080/topics/2/messages
 * GET /messages/id->gets Message by id http://localhost:8080/messages/1
 * POST /messages->Creates (POST) new a Message http://localhost:8080/topics/2/message
 * PUT /messages/id->Updates (PUT) the Message http://localhost:8080/topics/2/message
 * DELETE /messages/id->deletes (DELETE) the Message http://localhost:8080/messages/3
 * 
 * @author wudc
 *
 */
@RestController
public class MessageController {

	@Autowired
	@Qualifier("MessageServiceImpl") 
	private MessageService messageService;
	
	@RequestMapping("/topics/{id}/messages")
	public List<Message> getAllMessages(@PathVariable String id) {
		return messageService.getAllMessages(id);
	}
	
	@RequestMapping("/topics/{topicId}/message/{id}")
	public Message getMessage(@PathVariable String id) {
		return messageService.getMessage(id);
	}
		
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/message")
	public void addMessage(@RequestBody Message message, @PathVariable String topicId) {
		message.setTopic(new Topic(topicId, "",""));
		messageService.addMessage(message);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/message")
	public void updateMessage(@RequestBody Message message, @PathVariable String topicId) {
		message.setTopic(new Topic(topicId, "", ""));
		messageService.updateMessage(message);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/messages/{id}")
	public void deleteMessage(@PathVariable String id) {
		messageService.deleteMessage(id);
	}
}
