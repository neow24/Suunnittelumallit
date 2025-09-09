package chain;

public class FeedbackHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMsgType() == MessageType.FEEDBACK;
    }

    @Override
    protected String process(Message message) {
        return "General feedback from " + message.getSenderEmail() +
        " analyzed. Response prepared. Content: " + message.getContent();
    }    
}
