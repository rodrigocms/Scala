
/// Create Schema Easy.
// 1st Import file using inferSchema and create a productsDF 
// 2nd println(productsDF.schema)
// 3rd Get the output and use to create UDFSchema - need to ajust "include Set(" and "" in col names


///// ---> Create SCHEMA from PARQUET file              -------------------------------------- #bizumaster

spark.read.parquet("/mnt/training/ecommerce/events/events.parquet").schema.toDDL
val DDLSchema = "`device` STRING,`ecommerce` STRUCT<`purchase_revenue_in_usd`: DOUBLE, `total_item_quantity`: BIGINT, `unique_items`: BIGINT>,`event_name` STRING,`event_previous_timestamp` BIGINT,`event_timestamp` BIGINT,`geo` STRUCT<`city`: STRING, `state`: STRING>,`items` ARRAY<STRUCT<`coupon`: STRING, `item_id`: STRING, `item_name`: STRING, `item_revenue_in_usd`: DOUBLE, `price_in_usd`: DOUBLE, `quantity`: BIGINT>>,`traffic_source` STRING,`user_first_touch_timestamp` BIGINT,`user_id` STRING"

val eventsDF = spark.read
                        .schema(DDLSchema)
                        .json(eventsJsonPath)


