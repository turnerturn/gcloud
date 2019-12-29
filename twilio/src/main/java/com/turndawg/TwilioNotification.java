package com.turndawg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.twilio.twiml.messaging.Message;

public class TwilioNotification implements Serializable{

	// Find your Account Sid and Token at twilio.com/user/account
	@NotNull
	public String accountSid ;
	@NotNull
	public String authToken ;
	@NotNull
	@Size(min= 12,max = 12)
	public String from;
	@NotNull
	@Size(min= 12,max = 12)
	public String to ;
	@NotNull
	public String body;
	@NotNull
	public String notificationType;
	
	
	private TwilioNotification() {
		
	}




	public TwilioNotification(@NotNull String accountSid, @NotNull String authToken,
			@NotNull @Size(min = 12, max = 12) String from, @NotNull @Size(min = 12, max = 12) String to,
			@NotNull String body, @NotNull String notificationType) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.from = from;
		this.to = to;
		this.body = body;
		this.notificationType = notificationType;
	}




	public String getAccountSid() {
		return accountSid;
	}


	public String getAuthToken() {
		return authToken;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}
	
	public String getBody() {
		return body;
	}


	public String getNotificationType() {
		return notificationType;
	}

}
