package chain;

public class ContactHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMsgType() == MessageType.CONTACT;
    }

    @Override
    protected String process(Message message) {
        return "Contact request from " + message.getSenderEmail() +
        " forwarded to support team. Content: " + message.getContent();
    }
}
