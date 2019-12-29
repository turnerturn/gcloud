package com.turndawg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/twilio")
public class TwilioController {
	private Logger logger = LoggerFactory.getLogger(TwilioController.class);
	private final TwilioService twilioService;

	@Autowired
	public TwilioController(final TwilioService twilioService) {
		this.twilioService = twilioService;
	}

	@GetMapping("/notify")
	public ResponseEntity<TwilioNotification> notify(@RequestBody TwilioNotification notification) {
		twilioService.handle(notification);
		return ResponseEntity.ok().body(notification);
	}
//	
//	@PostMapping("/notification")
//	public String greeting(@RequestBody TwilioNotification twilioNotification) {
//
//		return "greeting";
//	}

}
