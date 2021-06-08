
// Check Schema Column Names - comparing to Array
assert(userDefinedSchema.fieldNames.sameElements(Array("item_id", "name", "price")))


//Get first line from Dataframe
val result1 = productsDF2.first()

//Create a row manualy
import org.apache.spark.sql.Row

val expected1 = Row("M_STAN_Q", "Standard Queen Mattress", 1045.0)