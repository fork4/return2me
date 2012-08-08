package com.fork4.return2me.twilio;

/**
 * Stores the Twilio account information.
 * 
 * @author Chris Foster
 */
public class TwilioAccount {
	private final String from;
	private final String callback;
	private final String sid;
	private final String token;
	
	public TwilioAccount(final String number,	final String sid, final String token) {
		this(number, number, sid, token);
	}

	public TwilioAccount(final String from, final String callback, 
			final String sid, final String token) {
		this.from = from;
		this.callback = callback;
		this.sid = sid;
		this.token = token;
	}

	public String getFromNumber() {
		return from;
	}

	public String getCallbackNumber() {
		return callback;
	}

	public String getSid() {
		return sid;
	}

	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "TwilioAccount [number=" + from + ", sid=" + sid + ", token="
				+ token + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwilioAccount other = (TwilioAccount) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
	
	

}
