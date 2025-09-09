package chain;

public class SuggestionHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMsgType() == MessageType.SUGGESTION;
    }

    @Override
    protected String process(Message message) {
        return "Suggestion logged from " + message.getSenderEmail() +
        ": '" + message.getContent() + "'. Added to product backlog.";
    }
    
}
