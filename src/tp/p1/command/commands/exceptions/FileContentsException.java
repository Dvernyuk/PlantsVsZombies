package tp.p1.command.commands.exceptions;

import java.io.IOException;

public class FileContentsException extends IOException {

	public FileContentsException() {
		super();
	}
	
	public FileContentsException(String message) {
		super(message);
	}
}
