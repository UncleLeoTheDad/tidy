package com.leohart.tidy.renamestrategies

import org.junit.After;

import com.google.inject.Inject
import com.leohart.tidy.FileRenameStrategy

class MultipleFileRenameStrategy implements FileRenameStrategy {
	
	@Inject
	Set<FileRenameStrategy> fileRenameStrategies;

	@Override
	public void rename(File file, String newName) {
		for (FileRenameStrategy fileRenameStrategy : this.fileRenameStrategies){
			fileRenameStrategy.rename(file, newName);
		}
	}

}
