
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


//Methods for AGGREGATIONS on a df.groupBy()

agg 
avg 
count 
max 
min 
mean
pivot
sum 

// Buit-in Functions - Aggregations
//df.groupBy("email").agg(collect_set("size").alias("size_options"),collect_set("cor").alias("cor_options") )
approx_count_distinct
avg 
collect_list - Returns list of object with duplicates 
collect_set - Returns list of object without duplicates
corr - Returns the Person collection Coefficient for two Columns
max 
mean 
stddev_samp - returns the sample  standard deviation of the expression in a group
sumDistinct - Returns the sum of distinct values in expression
var_pop - Results the population variance of the values in a group

// Math Functions
ceil 
log 
round
sqrt 


//Datetime
// from import org.apache.spark.sql.functions._
//df.withColumn("XXXperiod", month(col("timestamp")))
month
hour
minute
second
dayofweek
to_date

//df.withColumns("new_date", add_date(col("timestamp"),2))
date_add
add_month 

from_unixtime - 
unix_timestamp
date_format - coverts a date/timestamp/string to a value os STRING in specified date_format

dayoftheweek


//Datetime Patterns - https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html
/// df.withColumn("dateXXX", date_format("timestamp", "HH:mm:ss.SSSSSS))
G - era - AD
y - year - 2020
D - day of the year - 189
M/L - month of the year - 7;07;Jul;July
d - day-of-the-month - 28
Q/q quarter-of-year -  3;03;Q3;3rd quarter
E - day-of-the-week - Tue ; Tuesday
F - week-of-the-month - 42
a - am-pm
h clock-hour- (1-12)
k - clock-hour-of-day (1-24)

//Complex Types
translate  <<------ ??
regexp_replace
ltrim <<------ ??
lower
split

// df.withColumn("items", explode("items"))
//      .select("email","items.item_name")
//      .withColumn("details", split(col("item_name"), " ")
//      .withColumn("size", element_at(col("details"),2))  
//      .filter(array_contains(col("details"), "Mattress"))

array_contains
explode
element_at
slice   <<------ ??

//Union
df = df1.unionByName(df2)

// Additional functions
col
list
isnull - return true iff the column is null
rand -  generates a random column with independent and identically distributed

//Dataframe Na Functions
drop
fill - replace null values with the specified value for an optional sunset of Columns
replace - 


//User Defined Function
def firstLetter(email):
    return email.take(1)

firstLetter("teste@mail.com")
