package com.theokanning.openai.completion.chat;

public enum ResponseFormatType {

	TEXT("text"),
	JSON_OBJECT("json_object");

	private final String value;

	ResponseFormatType(final String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public static ResponseFormatType fromValue(String value) {
		for (ResponseFormatType formatType : ResponseFormatType.values()) {
			if (formatType.value.equals(value)) {
				return formatType;
			}
		}
		throw new IllegalArgumentException("Unknown ResponseFormatType value: " + value);
	}
}
