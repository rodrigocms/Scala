
// Documentation
https://spark.apache.org/docs/latest/api/scala/org/apache/spark/sql/DataFrameReader.html


// Reference to Columns - Scala
col("columnName")
df("columnName")
$"columnName"
$"columnName.fieldName"

//Columns Expressions
$"a" + $"b"
$"a".desc
$"a".cast("int")*100

//Column Operators & Methods
&& , || - Boolean
* , +, <, >= - Math
===,=!=  - Equal , Different
alias, as Give Column alias
cast  - cast column to Different datatype
isNull, isNotNull, isNan 
asc, desc 


//Dataframe Methods
select
drop
withColumnRenamed
withColumn
filter, where 
sort, orderBy 
dropDuplicates, distinct 
limit 
groupBy

//Dataframe Actions
show
count
describe, summary - computes basic statistics for numeric and string Columns
first  -  returns the first rows
head  - returns the first N rows
collect -  returns an array that contains all rows in the df
take - returns an array of the first N rows in the df

// ROWS METHODS - SCALA
fieldIndex - Returns the index of given field name
get(i)     - Returns the value at position i as type Any