package com.leohart.tidy

import com.google.inject.AbstractModule
import com.google.inject.multibindings.Multibinder
import com.leohart.tidy.namedeterminers.ExifNameDeterminer
import com.leohart.tidy.renamecommandgenerators.NixRenameCommandGenerator
import com.leohart.tidy.renamestrategies.ExecuteCommandFileRenameStrategy
import com.leohart.tidy.renamestrategies.PrintCommandFileRenameStrategy
import com.leohart.tidy.renamestrategies.RenameCommandGenerator

import groovy.util.OptionAccessor;

class TidyModule extends AbstractModule {
	
	OptionAccessor options;
	
	public TidyModule(OptionAccessor options) {
		super();
		this.options = options;
	}

	@Override
	protected void configure() {
		bind(NameDeterminer.class).to(ExifNameDeterminer.class);
		bind(FileRenameStrategy.class).to(PrintCommandFileRenameStrategy.class);
		
		Multibinder<FileRenameStrategy> fileRenameStrategyBinder = Multibinder.newSetBinder(binder(), FileRenameStrategy.class);
		
		if (options.p || !options.r) {fileRenameStrategyBinder.addBinding().to(PrintCommandFileRenameStrategy.class);}
		if (options.r) {fileRenameStrategyBinder.addBinding().to(ExecuteCommandFileRenameStrategy.class);}
		
		bind(RenameCommandGenerator.class).to(NixRenameCommandGenerator.class);
	}

}
