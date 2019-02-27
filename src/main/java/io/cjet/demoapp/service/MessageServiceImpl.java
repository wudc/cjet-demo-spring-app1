package io.cjet.demoapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.cjet.demoapp.model.Message;

/**
 * Spring service is singleton
 * 
 * @author wudc
 *
 */

@SuppressWarnings("serial")
@Service
@Qualifier("MessageServiceImpl")
public class MessageServiceImpl implements MessageService {

	private List<Message> messages = new ArrayList<>(Arrays.asList(new Message("1", "First", "First message", "1"),
			new Message("2", "Second", "Second message", "2"), new Message("3", "Third", "Third message", "3")));
	
	public List<Message> getAllMessages(String topicId) {
		return messages;
	}

	public Message getMessage(String id) {
		return messages.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public Message getMessageByName(String name) {
		return messages.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addMessage(Message message) {
		System.out.println("Message: " + message);

		messages.add(message);
	}

	public void updateMessage(Message message) {
	
		String id = message.getId();
		
		for (int i=0; i<messages.size(); i++) {
			Message t = messages.get(i);
			if (t.getId().equals(id)) {
				messages.set(i, message);
				return;
			}
		}
		
	}

	public void deleteMessage(String id) {
		messages.removeIf(t -> t.getId().equals(id));
	}

}
