
// Cast to Timestamp
val timestampDF = df.withColumn("timestamp", (col("timestamp") / 1e6).cast("timestamp"))

import org.apache.spark.sql.types.TimestampType
val timestampDF = df.withColumn("timestamp", (col("timestamp") / 1e6).cast(TimestampType))


//Cast to Date Format
import org.apache.spark.sql.functions.date_format
val formattedDF = timestampDF.withColumn("date string", date_format(col("timestamp"), "MMMM dd, yyyy"))
  .withColumn("time string", date_format(col("timestamp"), "HH:mm:ss.SSSSSS"))


//Extract Datetime attributes from Timestamp
import org.apache.spark.sql.functions.{year, month, dayofweek, minute, second}
val datetimeDF = timestampDF.withColumn("year", year(col("timestamp")))
  .withColumn("month", month(col("timestamp")))
  .withColumn("dayofweek", dayofweek(col("timestamp")))
  .withColumn("minute", minute(col("timestamp")))
  .withColumn("second", second(col("timestamp"))) 


