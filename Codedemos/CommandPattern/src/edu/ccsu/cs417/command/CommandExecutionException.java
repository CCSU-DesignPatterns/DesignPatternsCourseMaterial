package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public class CommandExecutionException extends Exception{
	private static final long serialVersionUID = 5687650411032241601L;

	public CommandExecutionException(String message){
		super(message);
	}
}
