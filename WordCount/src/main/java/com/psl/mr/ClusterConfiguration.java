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
		//Rachit's Cluster
//		conf = new Configuration();
//		conf.set("mapreduce.framework.name", "yarn");
//		conf.set("yarn.resourcemanager.address", "localhost:8032");
//		conf.set("yarn.resourcemanager.scheduler.address", "localhost:8030");
//		conf.set("fs.defaultFS", "hdfs://localhost:9000");
//		conf.set("tmpjars", "wc.jar");
		
		
		//Extra Cluster
		conf = new Configuration();
		conf.set("mapreduce.framework.name", "yarn");
		conf.set("yarn.resourcemanager.address", "10.88.206.119:8032");
		conf.set("yarn.resourcemanager.scheduler.address", "10.88.206.119:8030");
		conf.set("fs.defaultFS", "hdfs://10.88.206.119:8020");
		conf.set("tmpjars", "wc.jar");
		conf.set("yarn.application.classpath","/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*");
			
	}
	
	public Configuration getConf()
	{
		return conf;
	}
}
