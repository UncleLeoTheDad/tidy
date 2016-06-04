package com.leohart.tidy.namedeterminer

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
		
		println tags;
	}
}
