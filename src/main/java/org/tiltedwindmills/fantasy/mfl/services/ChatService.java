package org.tiltedwindmills.fantasy.mfl.services;

import java.util.List;

import org.tiltedwindmills.fantasy.mfl.model.chat.Message;

/**
 * Interface defining operations required for working with MFL League chat entities.
 */
public interface ChatService {

	/**
	 * Gets the chat messages.
	 *
	 * @param leagueId the league id
	 * @param serverId the server id
	 * @param year the year
	 * @return the chat messages
	 */
	List<Message> getChatMessages(int leagueId, int serverId, int year);

	/**
	 * Post chat message.
	 *
	 * @param leagueId the league id
	 * @param serverId the server id
	 * @param year the year
	 * @param message the message
	 * @param toFranchise the to franchise
	 * @param sessionId the session id
	 * @return true, if successful
	 */
	boolean postChatMessage(int leagueId, int serverId, int year, String message, String toFranchise, String sessionId);
}
