package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.JoinGroupRequestPacket;

import java.util.Scanner;

public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 群聊名，加入群聊：");
        String groupName = scanner.nextLine();

        joinGroupRequestPacket.setGroupName(groupName);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
