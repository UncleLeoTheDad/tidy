package com.leohart.tidy.renamestrategies

import com.google.inject.Inject
import com.leohart.tidy.FileRenameStrategy

class PrintCommandFileRenameStrategy implements FileRenameStrategy{
	
	@Inject
	RenameCommandGenerator renameCommandGenerator;

	@Override
	public void rename(File file, String newName) {
		String newFilePath = "${file.getParent()}\\${newName}S";
		println this.renameCommandGenerator.generateRenameCommand(file.toString(), newFilePath);
	}

}
