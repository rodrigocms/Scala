
// Check Schema Column Names - comparing to Array
assert(userDefinedSchema.fieldNames.sameElements(Array("item_id", "name", "price")))


//Get first line from Dataframe
val result1 = productsDF2.first()
val result1b = datetimeDF.sort("date").first().get(2).toString    // pegar 3 item

//Create a row manualy
import org.apache.spark.sql.Row

val expected1 = Row("M_STAN_Q", "Standard Queen Mattress", 1045.0)


//Get elements in a list
val mattressDF = (detailsDF
                        .filter(array_contains(col("details"), "Mattress"))
                        .withColumn("size", element_at(col("details"), 2))
                        .withColumn("quality", element_at(col("details"), 1))
                        )
           