package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.QuitGroupRequestPacket;

import java.util.Scanner;

public class QuitGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();

        System.out.print("输入 群聊名，退出群聊：");
        String groupName = scanner.nextLine();

        quitGroupRequestPacket.setGroupName(groupName);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
