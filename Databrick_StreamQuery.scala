//STREAMING QUERY


// Create StreamQuery - with schema
val schema = "device STRING, ecommerce STRUCT<purchase_revenue_in_usd: DOUBLE, total_item_quantity: BIGINT, unique_items: BIGINT>, event_name STRING, event_previous_timestamp BIGINT, event_timestamp BIGINT, geo STRUCT<city: STRING, state: STRING>, items ARRAY<STRUCT<coupon: STRING, item_id: STRING, item_name: STRING, item_revenue_in_usd: DOUBLE, price_in_usd: DOUBLE, quantity: BIGINT>>, traffic_source STRING, user_first_touch_timestamp BIGINT, user_id STRING"

val df = spark.readStream
  .schema(schema)
  .option("maxFilesPerTrigger", 1)
  .parquet(eventsPath)

// Check if df is Streaming
df.isStreaming     //boolean


// ETL over Streaming 
import org.apache.spark.sql.functions.{col, approx_count_distinct, count}
val emailTrafficDF = df.filter(col("traffic_source") === "email")
  .withColumn("mobile", col("device").isin("iOS", "Android"))
  .select("user_id", "event_timestamp", "mobile")


// Write Streming Query Results
import org.apache.spark.sql.streaming.Trigger

val checkpointPath = workingDir + "/email_traffic/checkpoint"
val outputPath = userhome + "/email_traffic/output"

val devicesQuery = emailTrafficDF.writeStream
  .outputMode("append")
  .format("parquet")
  .queryName("email_traffic_s")
  .trigger(Trigger.ProcessingTime("1 second"))
  .option("checkpointLocation", checkpointPath)
  .start(outputPath)


 // Manitor Sreaming Query
devicesQuery.id                      // java.util.UUID = 15d9206f-433e-4225-b324-a7714d0cb87e
devicesQuery.status                  // org.apache.spark.sql.streaming.StreamingQueryStatus =
//                                      {
//                                        "message" : "Waiting for next trigger",
//                                        "isDataAvailable" : false,
//                                        "isTriggerActive" : false
//                                      }
devicesQuery.awaitTermination(5)     // Boolean = false
devicesQuery.stop()                  