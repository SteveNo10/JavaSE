package com.ifnoelse.jpush;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushExample {
	
	public static void Push() {
		JPushClient jpushClient = new JPushClient("534c5f570812b73db39b9b7b", "f50ca7ccc224818ad1aa4f09");

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result.isResultOK());
            //LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            //LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            //LOG.error("Should review the error, and fix the request", e);
            //LOG.info("HTTP Status: " + e.getStatus());
            //LOG.info("Error Code: " + e.getErrorCode());
            //LOG.info("Error Message: " + e.getErrorMessage());
        }
	}
	
	//��ݵع������Ͷ�������ƽ̨�������豸������Ϊ ALERT ��֪ͨ��
	public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("alert");
    }
	
	//�������Ͷ�������ƽ̨������Ŀ���Ǳ���Ϊ "alias1"��֪ͨ����Ϊ ALERT��
	public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert("alert"))
                .build();
    }
	
	//�������Ͷ���ƽ̨�� Android��Ŀ���� tag Ϊ "tag1" ���豸�������� Android ֪ͨ ALERT�����ұ���Ϊ TITLE��
	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android("alert", "title", null))
                .build();
    }
	
	//�������Ͷ���ƽ̨�� iOS������Ŀ���� "tag1", "tag_all" �Ľ�������������ͬʱ����֪ͨ����Ϣ - ֪ͨ��Ϣ�� ALERT���Ǳ�����Ϊ 5��֪ͨ����Ϊ "happy"�����Ҹ����ֶ� from = "JPush"����Ϣ������ MSG_CONTENT��֪ͨ�� APNs ����ͨ���ģ���Ϣ�� JPush Ӧ������Ϣͨ���ġ�APNs �����ͻ����ǡ����������������ʽ���õĻ���Library ��Ĭ��ָ��Ϊ������
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and("tag1", "tag_all"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert("alsert")
                                .setBadge(5)
                                .setSound("happy.caf")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                 .setMessage(Message.content("msg_content"))
                 .setOptions(Options.newBuilder()
                         .setApnsProduction(true)
                         .build())
                 .build();
    }
	
	//�������Ͷ���ƽ̨�� Andorid �� iOS������Ŀ���� ��"tag1" �� "tag2" �Ĳ������ң�"alias1" �� "alias2" �Ĳ����������������� - ����Ϊ MSG_CONTENT ����Ϣ�����Ҹ����ֶ� from = JPush��
	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent("msg_content")
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }
}
