package org.thunlp.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

/**
 * 用于读取HDFS上的普通文本文件
 * 
 * @author lipeng
 *
 */
public class HdfsPlainFileReader implements HdfsReader {
	private BufferedReader reader;

	public HdfsPlainFileReader(Path path) throws IOException {
		this(path, FileSystem.get(new JobConf()));
	}

	public HdfsPlainFileReader(Path path, FileSystem fs) throws IOException {
		InputStreamReader isr = new InputStreamReader(fs.open(path));
		reader = new BufferedReader(isr);
	}

	public String readLine() throws IOException {
		if (reader == null)
			return null;
		else
			return reader.readLine();
	}

	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}
}
