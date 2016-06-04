package com.leohart.tidy

import com.google.inject.AbstractModule
import com.leohart.tidy.namedeterminer.ExifNameDeterminer
import com.leohart.tidy.renamestrategies.PrintCommandFileRenameStrategy

class TidyModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(NameDeterminer.class).to(ExifNameDeterminer.class);
		bind(FileRenameStrategy.class).to(PrintCommandFileRenameStrategy.class);

	}

}
