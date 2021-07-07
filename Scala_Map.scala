// Map is a object similar to Dictionary

val mymap = Map(1->"Rodrigo", 2->"Gi", 3->"Cat"); //Map
println( lst.map( _*2) )
println( lst.map( x => x*4) )
println( lst.map( x => "hi"*x ))
println( mymap.map( x => "Hello" * x ))


//
val mymap = Map(801->"Max", 802->"Tom", 803->"July")

println(mymap)                  // Map(801 -> Max, 802 -> Tom, 803 -> July)
println(mymap(801))             // Max
println(mymap.keys)             // Set(801, 802, 803)
println(mymap.values)           // MapLike.DefaultValuesIterable(Max, Tom, July)
println(mymap.isEmpty)          // false

mymap.keys.foreach { key=>
  println("key: "+key) 
  println("value: "+mymap(key))}
/*
key: 801
value: Max
key: 802
value: Tom
key: 803
value: July
*/

println(mymap.contains(802))    // true

// Concat
val mymap2 = Map(804->"Gorge", 805->"Ringo", 806->"Paul", 807->"John")
val newMap = mymap ++ mymap2