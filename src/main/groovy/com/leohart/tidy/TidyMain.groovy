package com.leohart.tidy

import groovy.util.logging.Slf4j

import java.nio.file.Files

import com.google.inject.Guice
import com.google.inject.Injector

@Slf4j
class TidyMain {

	static main(args) {
		OptionAccessor options = parseCommandLine(args);
		
		Injector injector = Guice.createInjector(new TidyModule(options))
		FileRenamer fileRenamer = injector.getInstance(FileRenamer);

		new File(options.arguments()[0]).eachFile { File file ->
			String contentType = Files.probeContentType(file.toPath());
			log.debug("Processing file ${file} with ContentType ${contentType}");
			
			if (contentType?.contains("image")) {
				fileRenamer.rename(file);
			}
		}
	}

	private static OptionAccessor parseCommandLine(args){
		CliBuilder cli = new CliBuilder(usage:'tidy <path>')
		cli.p(longOpt:'print', args:1, argName:'PRINT', "Print rename command.");
		cli.r(longOpt:'rename', args:1, argName:'RENAME', "Rename file.");

		def options = cli.parse(args)

		if (!cli.options) {
			cli.usage();
		}

		return options;
	}
}
