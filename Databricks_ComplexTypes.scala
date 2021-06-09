
// Explode
import org.apache.spark.sql.functions._
val detailsDF = (df.withColumn("items", explode(col("items")))
                    .select("email", "items.item_name")
                    .withColumn("details", split(col("item_name"), " "))             
)

// Get element in a list
val mattressDF = detailsDF.filter(array_contains(col("details"), "Mattress"))
  .withColumn("size", element_at(col("details"), 2))


// Filter contains
val pillowDF = detailsDF.filter(array_contains(col("details"), "Pillow"))
  .withColumn("size", element_at(col("details"), 1))


// Union two DFs
val unionDF = mattressDF.unionByName(pillowDF)


// Collect_set - aggregate creating a list
val optionsDF = unionDF.groupBy("email")
  .agg(collect_set("size").alias("size options"), collect_set("quality").alias("quality options"))


