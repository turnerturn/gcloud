package com.turndawg;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class TwilioServiceImpl implements TwilioService {
	private Logger logger = LoggerFactory.getLogger(TwilioController.class);

	public TwilioServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(TwilioNotification notification) {
		sms(notification);
		switch (TwilioNotificationType.get(notification.getNotificationType())) {
		case CALL:
			logger.info("handling call");
			call(notification);
			break;
		case SMS:
			logger.info("handling sms");
			sms(notification);
			break;
		case FAX:
			logger.info("handling fax");
			break;
		default:
			logger.info("handling ubknown twilio notification type");
			break;
		}
	}

	private void sms(TwilioNotification notification) {
		Twilio.init(notification.getAccountSid(), notification.getAuthToken());
		Message message = Message.creator(new com.twilio.type.PhoneNumber(notification.getTo()),
				new com.twilio.type.PhoneNumber(notification.getFrom()), notification.getBody()).create();
		logger.info(message.getSid());
	}

	private void call(TwilioNotification notification) {
		Call call = Call.creator(new com.twilio.type.PhoneNumber(notification.getTo()),
				new com.twilio.type.PhoneNumber(notification.getFrom()), notification.getBody()).create();

		logger.info(call.getSid());
	}
}
