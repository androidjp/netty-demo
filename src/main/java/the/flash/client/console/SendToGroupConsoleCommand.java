package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.GroupMessageRequestPacket;

import java.util.Scanner;

public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("群组名：");

        String toGroupName = scanner.nextLine();
        System.out.print("发送消息：");
        String message = scanner.nextLine();
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupName, message));

    }
}
