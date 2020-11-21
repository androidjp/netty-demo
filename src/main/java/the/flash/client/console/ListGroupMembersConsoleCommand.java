package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.ListGroupMembersRequestPacket;

import java.util.Scanner;

public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.nextLine();

        listGroupMembersRequestPacket.setGroupName(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
