package org.thunlp.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

public class GzipTextFileWriter extends TextFileWriter {
	public GzipTextFileWriter(String filename) throws IOException {
		super(filename);
	}

	public GzipTextFileWriter(String filename, boolean append) throws IOException {
		super(new File(filename), "UTF-8", append);
	}

	public GzipTextFileWriter(File file) throws IOException {
		super(file, "UTF-8", false);
	}

	public GzipTextFileWriter(String filename, String charset) throws IOException {
		super(new File(filename), charset, false);
	}

	public GzipTextFileWriter(String filename, String charset, boolean append) throws IOException {
		super(new File(filename), charset, append);
	}

	public GzipTextFileWriter(File file, String charset, boolean append) throws IOException {
		super(file, charset, append);
	}

	@Override
	protected BufferedWriter constructWriter(File file, String charset, boolean append) throws IOException {
		return new BufferedWriter(
				new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file, append)), charset));
	}
}
