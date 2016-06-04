package com.leohart.tidy;

import java.io.File;

public interface FileRenameStrategy {
	
	void rename(File file, String newName);

}
