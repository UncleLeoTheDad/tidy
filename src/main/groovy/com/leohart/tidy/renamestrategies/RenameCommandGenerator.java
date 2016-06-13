package com.leohart.tidy.renamestrategies;

public interface RenameCommandGenerator {

	String generateRenameCommand(String oldFileName, String newFileName);
	
}
