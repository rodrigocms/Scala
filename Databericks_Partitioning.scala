
// Get number of cores 
println(spark.sparkContext.defaultParallelism)  // option 1 
println(sc.defaultParallelism)                  // option 2 

// Get default Shuffle partitions
spark.conf.get("spark.sql.shuffle.partitions")

// Set default Shuffle partitions
spark.conf.set("spark.sql.shuffle.partitions", "8")

// Get df partitions
df.rdd.getNumPartitions

// Repartition
val repartitionedDF = df.repartition(8)


// Coalesce
val coalesceDF = df.coalesce(8)


// Adaptive Query Execution - In Spark 3, AQE is now able to dynamically coalesce shuffle partitions at runtime
spark.conf.get("spark.sql.adaptive.enabled")
