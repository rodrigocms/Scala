
// Cast to Timestamp
val timestampDF = df.withColumn("timestamp", (col("timestamp") / 1e6).cast("timestamp"))

import org.apache.spark.sql.types.TimestampType
val timestampDF = df.withColumn("timestamp", (col("timestamp") / 1e6).cast(TimestampType))


//Cast to Date Format
import org.apache.spark.sql.functions.date_format
val formattedDF = timestampDF.withColumn("date string", date_format(col("timestamp"), "MMMM dd, yyyy"))
  .withColumn("time string", date_format(col("timestamp"), "HH:mm:ss.SSSSSS"))
    //("yyyy MM dd")     2019-08-08 
    //("MM/dd/yyyy")     2019 08 08
    //("yyyy MMMM dd")   08/08/2019 09:03
    //("yyyy MMMM dd E") 2019 August 08 Thu
    //("E") Thu    


//Extract Datetime attributes from Timestamp
import org.apache.spark.sql.functions.{year, month, dayofweek, minute, second}
val datetimeDF = timestampDF.withColumn("year", year(col("timestamp")))
  .withColumn("month", month(col("timestamp")))
  .withColumn("dayofweek", dayofweek(col("timestamp")))
  .withColumn("minute", minute(col("timestamp")))
  .withColumn("second", second(col("timestamp"))) 

//Convert to_date
import org.apache.spark.sql.functions.to_date
val dateDF = timestampDF.withColumn("date", to_date(col("timestamp")))


// Date_add
import org.apache.spark.sql.functions.date_add
val plus2DF = timestampDF.withColumn("plus_two_days", date_add(col("timestamp"), 2))


