/*
 * #%L
 * TeamSpeak 3 Java API
 * %%
 * Copyright (C) 2014 Bert De Geyter
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.util.HashMap;
import java.util.logging.Level;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;

public class CreateChannelExample {

	public static void main(String[] args) {
		new ChatBotExample();
	}

	public CreateChannelExample() {
		final TS3Config config = new TS3Config();
		config.setHost("77.77.77.77");
		config.setDebugLevel(Level.ALL);
		config.setLoginCredentials("serveradmin", "serveradminpassword");

		final TS3Query query = new TS3Query(config);
		query.connect();

		final TS3Api api = query.getApi();
		api.selectVirtualServerById(1);
		api.setNickname("PutPutBot");
		api.sendChannelMessage("PutPutBot is online!");

		final HashMap<ChannelProperty, String> properties = new HashMap<>();
		properties.put(ChannelProperty.CHANNEL_FLAG_PERMANENT, "1"); // Make
																		// channel
																		// permanent
		properties.put(ChannelProperty.CPID, "3"); // Make it a subchannel of
													// channel 3

		api.createChannel("New Channel", properties); // Create the channel with
														// our properties :)
	}

}
