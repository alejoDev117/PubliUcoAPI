package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.utils.UtilObject;
import co.edu.uco.crosscutting.utils.UtilText;

public final class Result {

	
	private List<String> messages;
	
	private Result(final List<String> message) {
		setMessages(message);
	}
	
	public static Result create() {
		return new Result(new ArrayList<>());
	}
	
	private static Result create(final List<String> message) {
		return new Result(message);
	}
	
	public final  void addMessage(String message) {
		if(!UtilText.getUtilText().isEmpty(message)) {
		messages.add(UtilText.getUtilText().applyTrim(message));
	}
		
	}
	
	
	public final  void addMessages(final List<String> messages) {
		getMessages().addAll(UtilObject.getDefault(messages, new ArrayList<>()));
	}
	
	public final boolean isValid() {
		return messages.isEmpty();
	}

	private final void setMessages(List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}

	public final List<String> getMessages() {
		return messages;
	}
	
	
	
	
	
}
