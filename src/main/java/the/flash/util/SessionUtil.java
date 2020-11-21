package the.flash.util;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import the.flash.attribute.Attributes;
import the.flash.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();
    private static final Map<String, Channel> userNameChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupNameChannelGroupMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        userNameChannelMap.put(session.getUserName(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            Session session = getSession(channel);
            userIdChannelMap.remove(session.getUserId());
            userNameChannelMap.remove(session.getUserName());
            channel.attr(Attributes.SESSION).set(null);
            System.out.println(session + " 退出登录!");
        }
    }

    public static boolean hasLogin(Channel channel) {

        return getSession(channel) != null;
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }

    public static Channel getChannelByName(String userName) {
        return userNameChannelMap.get(userName);
    }

    public static void bindChannelGroup(String groupName, ChannelGroup channelGroup) {
        groupNameChannelGroupMap.put(groupName, channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupName) {
        return groupNameChannelGroupMap.get(groupName);
    }
}
