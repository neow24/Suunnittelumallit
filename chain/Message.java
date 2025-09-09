package chain;

class Message {
    private MessageType msgType;
    private String      content;
    private String  senderEmail;

    public Message(MessageType msgType, String content, String senderEmail) {
        this.msgType     =     msgType;
        this.content     =     content;
        this.senderEmail = senderEmail;
    }

    public MessageType getMsgType() { return msgType    ; }
    public String      getContent() { return content    ; }
    public String  getSenderEmail() { return senderEmail; }
}
