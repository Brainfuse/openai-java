package com.theokanning.openai.completion.chat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseFormat{

	/**
	 * Must be either 'text',  or 'json_object'.<br>
	 * You may use {@link ResponseFormatType} enum.
	 */
	String type = ResponseFormatType.TEXT.value();
}
