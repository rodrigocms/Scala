//Group By
val eventCountsDF = df.groupBy("event_name").count()

val avgStatePurchasesDF = df.groupBy("geo.state").avg("ecommerce.purchase_revenue_in_usd")

val cityPurchaseQuantitiesDF = df.groupBy("geo.state", "geo.city").sum("ecommerce.total_item_quantity")


// BuiltIn Aggregate Functions
import org.apache.spark.sql.functions.sum
val statePurchasesDF = df.groupBy("geo.state").agg(sum("ecommerce.total_item_quantity").alias("total_purchases"))

import org.apache.spark.sql.functions.{avg, approx_count_distinct}
val stateAggregatesDF = df.groupBy("geo.state").agg(
  avg("ecommerce.total_item_quantity").alias("avg_quantity"),
  approx_count_distinct("user_id").alias("distinct_users"))


  