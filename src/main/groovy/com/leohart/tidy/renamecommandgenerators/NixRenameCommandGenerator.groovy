package com.leohart.tidy.renamecommandgenerators

import com.leohart.tidy.renamestrategies.RenameCommandGenerator;

class NixRenameCommandGenerator implements  RenameCommandGenerator{

	@Override
	public String generateRenameCommand(String oldFileName, String newFileName) {
		return "mv \"${oldFileName}\" \"${newFileName}\"";
	}

}
