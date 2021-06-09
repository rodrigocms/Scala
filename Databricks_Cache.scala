
// Persist DATASET with the default storage level
df.cache().count()  //action to materialize df



// Removes cache for a DataFrame
df.unpersist()


//Cache a table to assign a nicer name to the cached RDD for the Storage UI
df.createOrReplaceTempView("Pageviews_DF_Scala")
spark.catalog.cacheTable("Pageviews_DF_Scala")

df.count()