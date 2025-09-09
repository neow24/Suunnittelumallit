package chain;

public class CompensationHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getMsgType() == MessageType.COMPENSATION;
    }

    @Override
    protected String process(Message message) {
        return "Compensation claim from " + message.getSenderEmail() +
        " reviewed: APPROVED/REJECTED. Content: " + message.getContent();
    }
}
