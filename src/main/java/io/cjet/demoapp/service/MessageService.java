package io.cjet.demoapp.service;

import java.io.Serializable;
import java.util.List;

import io.cjet.demoapp.model.Message;

public interface MessageService extends Serializable {
	public List<Message> getAllMessages(String topicId);
	public Message getMessage(String id);
	public Message getMessageByName(String name);
	public void addMessage(Message message);
	public void updateMessage(Message message);
	public void deleteMessage(String id);
}
