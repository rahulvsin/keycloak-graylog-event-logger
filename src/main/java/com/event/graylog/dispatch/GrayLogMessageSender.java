package com.event.graylog.dispatch;

import java.io.IOException;

import biz.paluch.logging.gelf.GelfMessageBuilder;
import biz.paluch.logging.gelf.intern.GelfMessage;
import biz.paluch.logging.gelf.intern.GelfSender;
import biz.paluch.logging.gelf.intern.sender.GelfUDPSender;

public class GrayLogMessageSender {
	
	private static GrayLogMessageSender sender = null;
	
	private GrayLogMessageSender() {
		
	}
	
	public static GrayLogMessageSender getIntance() {
		if (sender == null) {
			sender = new GrayLogMessageSender();
		}
		return sender;
	}

	@SuppressWarnings("resource")
	public boolean sendMessage(String fullMessage, String shortMessage) {
		 GelfMessage gelfMessage = GelfMessageBuilder.newInstance()
				 .withShortMessage(shortMessage)
				 .withFullMessage(fullMessage)
				 .withHost(GrayLogMessageSenderContants.HOST)
				 .build();
	        GelfSender sender;
			try {
				sender = new GelfUDPSender(GrayLogMessageSenderContants.HOST, GrayLogMessageSenderContants.PORT, null);
				return sender.sendMessage(gelfMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
	}
	
}
