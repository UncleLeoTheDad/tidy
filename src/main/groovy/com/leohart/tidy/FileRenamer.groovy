package com.leohart.tidy

import com.google.inject.Inject

class FileRenamer {
	
	NameDeterminer nameDeterminer;
	FileRenameStrategy fileRenameStrategy;
	
	@Inject	 
	public FileRenamer(NameDeterminer newNameDeterminationStrategy,
			FileRenameStrategy fileRenameStrategy) {
		super();
		this.nameDeterminer = newNameDeterminationStrategy;
		this.fileRenameStrategy = fileRenameStrategy;
	}
			
	public void rename(File fileToRename){
		String newName = this.nameDeterminer.getNewName(fileToRename);
		this.fileRenameStrategy.rename(fileToRename, newName);
	}	

}
