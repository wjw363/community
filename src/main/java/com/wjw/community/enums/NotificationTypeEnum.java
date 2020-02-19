package com.wjw.community.enums;

public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了你的问题"),
    REPLY_COMMENT(2,"回复了你的评论");
    private int type;
    private String name;

    public static String nameOfType(Integer type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType()==type){
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
