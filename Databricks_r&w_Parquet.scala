/// WRITE PARQUET - Snappy --------------------------------------------------------------------------------
val usersOutputPath = workingDir + "/users.parquet"

usersDF.write
            .option("compression", "snappy")
            .mode("overwrite")
            .parquet(usersOutputPath)




/// READ Parquet ---------------------------------------------------------------------------------------
val df_test = spark.read.parquet(path+"file_name")


