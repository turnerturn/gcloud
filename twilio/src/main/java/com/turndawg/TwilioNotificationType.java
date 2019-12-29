package com.turndawg;

import java.util.Arrays;

import org.springframework.util.StringUtils;

public enum TwilioNotificationType {

	CALL("call"), FAX("fax"), SMS("sms"), UNKOWN("unkown");

	private String type;

	TwilioNotificationType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static TwilioNotificationType get(String value) {
		return Arrays.asList(values()).stream().filter(v -> !StringUtils.isEmpty(v.getType()))
				.filter(v -> v.getType().equalsIgnoreCase(value.trim())).findFirst().orElse(UNKOWN);
	}
}
