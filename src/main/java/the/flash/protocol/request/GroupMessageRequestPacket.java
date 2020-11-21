package the.flash.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.GROUP_MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    private String toGroupName;
    private String message;

    public GroupMessageRequestPacket(String toGroupName, String message) {
        this.toGroupName = toGroupName;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
