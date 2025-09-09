package chain;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler      = new ContactHandler();
        Handler suggestionHandler   = new SuggestionHandler();
        Handler feedbackHandler     = new FeedbackHandler();

        compensationHandler.setNext(contactHandler)
        .setNext(suggestionHandler).setNext(feedbackHandler);

        List<Message> messages = Arrays.asList(
            new Message(MessageType.COMPENSATION, "I want a refund for my last purchase.",     "john@example.com"),
            new Message(MessageType.CONTACT,      "Please call me regarding my subscription.", "sara@example.com"),
            new Message(MessageType.SUGGESTION,   "It would be great to have dark mode.",      "alex@example.com"),
            new Message(MessageType.FEEDBACK,     "I love the new update!",                    "amet@example.com")
        );

        for (Message msg : messages) {
            String result = compensationHandler.handle(msg);
            System.out.println(result);
        }
    }
}
