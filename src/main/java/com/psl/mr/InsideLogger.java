package com.psl.mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class InsideLogger
{
	public static void main(String[] args)
	{
		try
		{
			ClusterConfiguration clusterConfig = ClusterConfiguration.getInstance();
			FileSystem fs = FileSystem.get(clusterConfig.getConf());
			String[] data = { "hello its line44.", "hello its line3.", "hello its line2." };
			File f = new File("/home/rachit/Desktop/logs/sep-9");
			writeToFile(fs, "inputfile3.txt" + 90, f);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void createFile(FileSystem fs, String path) throws IOException
	{
		// TODO learn to use Progressable.

		FileSystem fsCrt = fs.newInstance(fs.getConf());

		short replicationFactor = 1;
		fsCrt.create(new Path(path), replicationFactor);
		fsCrt.close();
		System.out.println("File " + path + " Created Successfully.");

	}

	public static void writeToFile(FileSystem fs, String path, String data) throws IOException
	{
		System.out.println("inside writeToHDFS");
		if (!fs.exists(new Path(path)))
		{
			createFile(fs, path);
		}

		FSDataOutputStream opStream = fs.append(new Path(path));
		BufferedWriter bfrWrtr = new BufferedWriter(new OutputStreamWriter(opStream));
		bfrWrtr.write(data + System.getProperty("line.separator"));
		bfrWrtr.close();

		System.out.println("Writing done.");

	}

	public static void writeToFile(FileSystem fs, String path, String[] data) throws IOException
	{
		System.out.println("inside writeToHDFS");
		if (!fs.exists(new Path(path)))
		{
			createFile(fs, path);
		}

		FSDataOutputStream opStream = fs.append(new Path(path));
		BufferedWriter bfrWrtr = new BufferedWriter(new OutputStreamWriter(opStream));
		for (String string : data)
		{
			bfrWrtr.write(string + System.getProperty("line.separator"));
		}

		bfrWrtr.close();

		System.out.println("Writing done.");

	}

	public static void writeToFile(FileSystem fs, String path, File file) throws IOException
	{
		System.out.println("inside writeToHDFS");
		if (!fs.exists(new Path(path)))
		{
			createFile(fs, path);
		}

		BufferedReader bfrRdr = new BufferedReader(new FileReader(file));

		FSDataOutputStream opStream = fs.append(new Path(path));
		BufferedWriter bfrWrtr = new BufferedWriter(new OutputStreamWriter(opStream));
		String line = null;
		while ((line = bfrRdr.readLine()) != null)
		{
			bfrWrtr.write(line + System.getProperty("line.separator"));
		}

		bfrWrtr.close();

		System.out.println("Writing done.");
	}

}
