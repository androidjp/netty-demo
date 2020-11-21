package the.flash.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String toUsername;
    private String message;

    public MessageRequestPacket(String toUsername, String message) {
        this.toUsername = toUsername;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
