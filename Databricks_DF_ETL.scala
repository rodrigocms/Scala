// Select Columns
val devicesDF = eventsDF.select("user_id", "device")
display(devicesDF)

// Select as SQL Expression
val appleDF = eventsDF.selectExpr("user_id", "device in ('macOS', 'iOS') as apple_user")

// DROP Column
val anonymousDF = eventsDF.drop("user_id", "geo", "device")

val noSalesDF = eventsDF.drop(col("ecommerce"))

// CREATE or REPLACE Columns
val mobileDF = eventsDF.withColumn("mobile", col("device").isin("iOS", "Android"))

val purchaseQuantityDF = eventsDF.withColumn("purchase_quantity", col("ecommerce.total_item_quantity").cast("int"))

// CREATE Column from column.sub
val purchaseQuantityDF = eventsDF.withColumn("purchase_quantity", col("ecommerce.total_item_quantity").cast("int"))


// RENAME column
val locationDF = eventsDF.withColumnRenamed("geo", "location")
val df = spark.read.parquet(eventsPath).select(col("user_id"), col("event_timestamp").alias("timestamp"))


// STRINGS
val df = df_raw.withColumn("firstName", initcap(col("firstName")) ) // proper
val df = df_raw.withColumn("firstName", lower(col("firstName")) )   // upper
val df = df_raw.withColumn("firstName", uuper(col("firstName")) )   // lower


// FILTER rows
val abandonedCartsDF = emailCartsDF.filter(col("converted")==="False")

val purchasesDF = eventsDF.filter("ecommerce.total_item_quantity > 0")

val revenueDF = eventsDF.filter(col("ecommerce.purchase_revenue_in_usd").isNotNull)

val androidDF = eventsDF.filter((col("traffic_source") =!= "direct") && (col("device") === "Android"))

val pillowDF = detailsDF.filter(array_contains(col("details"), "Pillow"))
  

// DROP Duplicates
val distinctUsersDF = eventsDF.dropDuplicates(Seq("user_id"))

// Limit
val limitDF = eventsDF.limit(100)

// SORT or ORDERBY
val decreaseTimestampsDF = eventsDF.sort(col("event_timestamp").desc)

val increaseSessionsDF   = eventsDF.orderBy("user_first_touch_timestamp", "event_timestamp")

val decreaseSessionsDF = eventsDF.sort(col("user_first_touch_timestamp").desc, col("event_timestamp"))


//Aprox_Count_Distinct
import org.apache.spark.sql.functions.approx_count_distinct
val activeUsersDF = datetimeDF.groupBy("date").agg(approx_count_distinct("user_id").alias("active_users"))


//Union 2 DFs
val unionDF = mattressDF.unionByName(pillowDF)

val conversionsDF = usersDF.join(convertedUsersDF, Seq("email"), "outer")
  .filter(col("email").isNotNull)
  .na.fill("False")


// Explode
import org.apache.spark.sql.functions._
val detailsDF = (df.withColumn("items", explode(col("items")))
                    .select("email", "items.item_name")
                    .withColumn("details", split(col("item_name"), " "))             
)

// Collect_Set - aggregate creating a list
val cartsDF = (eventsDF
                   .withColumn("items",explode(col("items")))
                   .groupBy("user_id").agg(collect_set("items.item_id").alias("cart")
)


// String Replace
val df = (df_raw
            .withColumn("ssn", regexp_replace(col("ssn"),lit("-"),lit(""))
)

