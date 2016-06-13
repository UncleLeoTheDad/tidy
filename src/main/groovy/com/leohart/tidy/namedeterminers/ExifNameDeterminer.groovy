package com.leohart.tidy.namedeterminers

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import com.google.common.io.Files
import com.leohart.tidy.NameDeterminer
import com.thebuzzmedia.exiftool.ExifTool
import com.thebuzzmedia.exiftool.ExifToolBuilder
import com.thebuzzmedia.exiftool.Tag
import com.thebuzzmedia.exiftool.core.StandardTag

class ExifNameDeterminer implements NameDeterminer {

	@Override
	public String getNewName(File file) {
		ExifTool exifTool = new ExifToolBuilder().build();
		
		Map<Tag, String> tags = exifTool.getImageMeta(file, Arrays.asList(
			StandardTag.DATE_TIME_ORIGINAL,
			StandardTag.CREATION_DATE,
		));
		
		String dateTimeOriginal = tags.get(StandardTag.DATE_TIME_ORIGINAL);
		String creationDate = tags.get(StandardTag.CREATION_DATE);
		
		String dateStringToUse = dateTimeOriginal;
		 
		if (dateStringToUse == null) {
			dateStringToUse = creationDate;
		}
		
		if (dateStringToUse == null) {
			return "[ERROR: NO-VALID-DATE-FOUND]";
		}
		
		DateTime dateToUse = DateTime.parse(dateStringToUse, DateTimeFormat.forPattern("yyyy:MM:dd HH:mm:ss"));
		
		return DateTimeFormat.forPattern("yyyy-MM-dd_HH.mm.ss").print(dateToUse) + "." + Files.getFileExtension(file.getAbsolutePath()).toLowerCase();
	}
}
