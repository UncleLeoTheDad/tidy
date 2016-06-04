package com.leohart.tidy.renamestrategies

import java.io.File

import com.leohart.tidy.FileRenameStrategy;;

class PrintCommandFileRenameStrategy implements FileRenameStrategy{

	@Override
	public void rename(File file, String newName) {
		println "mv \"${file}\" \"${file.getParent()}\\${newName}\"";
	}

}
