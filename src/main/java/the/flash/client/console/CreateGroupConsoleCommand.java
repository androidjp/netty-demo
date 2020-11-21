package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

public class CreateGroupConsoleCommand implements ConsoleCommand {

    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();

        System.out.print("【创建群聊】输入 群聊名：");
        String groupName = scanner.nextLine();
        System.out.print("【创建群聊】输入 用户名 列表，用户名 之间英文逗号隔开：");
        String userNames = scanner.nextLine();
        createGroupRequestPacket.setGroupName(groupName);
        createGroupRequestPacket.setUserNameList(Arrays.asList(userNames.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }

}
