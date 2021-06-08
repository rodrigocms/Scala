/// WRITE -------------------------------------------------------------------------------


/// READ  -------------------------------------------------------------------------------

//Read - Infer schema
val usersCsvPath = "/mnt/training/ecommerce/users/users-500k.csv"

val usersDF = spark.read
  .option("sep", "\t")
  .option("header", true)
  .option("inferSchema", true)
  .csv(usersCsvPath)

// Read - Define Schema - METODO 1
val DDLSchema = "user_id string, user_first_touch_timestamp long, email string"

val usersDF = spark.read
  .option("sep", "\t")
  .option("header", true)
  .schema(DDLSchema)
  .csv(usersCsvPath)


// Read - Define Schema - METODO 2
import org.apache.spark.sql.types.{LongType, StringType, StructType, StructField}
// other ShortType,IntegerType,LongType,FloatType,DoubleType,DecimalType,BigDecimal,StringType,VarcharType,CharType,BooleanType,TimestampType,DateType,MapType,ArrayType,
//https://spark.apache.org/docs/latest/sql-ref-datatypes.html

val userDefinedSchema = StructType(Seq(
  StructField("user_id", StringType, true),  
  StructField("user_first_touch_timestamp", LongType, true),
  StructField("email", StringType, true)
))
val usersDF = spark.read
  .option("sep", "\t")
  .option("header", true)
  .schema(userDefinedSchema)
  .csv(usersCsvPath)




  ///// ---> Create SCHEMA from PARQUET file              -------------------------------------- #bizumaster

spark.read.parquet("/mnt/training/ecommerce/events/events.parquet").schema.toDDL
val DDLSchema = "`device` STRING,`ecommerce` STRUCT<`purchase_revenue_in_usd`: DOUBLE, `total_item_quantity`: BIGINT, `unique_items`: BIGINT>,`event_name` STRING,`event_previous_timestamp` BIGINT,`event_timestamp` BIGINT,`geo` STRUCT<`city`: STRING, `state`: STRING>,`items` ARRAY<STRUCT<`coupon`: STRING, `item_id`: STRING, `item_name`: STRING, `item_revenue_in_usd`: DOUBLE, `price_in_usd`: DOUBLE, `quantity`: BIGINT>>,`traffic_source` STRING,`user_first_touch_timestamp` BIGINT,`user_id` STRING"

val eventsDF = spark.read
  .schema(DDLSchema)
  .json(eventsJsonPath)