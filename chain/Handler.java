package chain;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public String handle(Message message) {
        if (canHandle(message)) {
            return process(message);
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        } else {
            return "No handler available for message type: " + message.getMsgType();
        }
    }

    protected abstract boolean canHandle(Message message);

    protected abstract String process(Message message);
}
