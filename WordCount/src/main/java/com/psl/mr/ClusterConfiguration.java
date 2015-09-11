package com.psl.mr;

import org.apache.hadoop.conf.Configuration;

public class ClusterConfiguration 
{
	private static ClusterConfiguration clusterConfig = null;
	public Configuration conf=null;
	private ClusterConfiguration()
	{	
		instantiateconf();
	}

	public static ClusterConfiguration getInstance()
	{
		if (clusterConfig == null)
		{
			clusterConfig = new ClusterConfiguration();
		}
		return clusterConfig;
	}
	
	private void instantiateconf()
	{
		conf = new Configuration();
		conf.set("mapreduce.framework.name", "yarn");
		conf.set("yarn.resourcemanager.address", "localhost:8032");
		conf.set("yarn.resourcemanager.scheduler.address", "localhost:8030");
		conf.set("fs.defaultFS", "localhost:9000");
		conf.set("tmpjars", "wc.jar");
	}
	
	public Configuration getConf()
	{
		return conf;
	}
}
