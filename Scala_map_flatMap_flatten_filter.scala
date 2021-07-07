// Map and Filter   ( => significa "faz o segunte")

val lst = List(1,2,3,5,7,10)
val mymap = Map(1 -> "Ro", 2 -> "Gi" , 3 -> "Cat")
println(lst.map( x => x * 2))
println(lst.map( x => "hi" * x))

 

println ("hello".map(_.toUpper))   // upper

println( List(List(1,2,3) , List(4,5,6)).flatten)  /// List(1,2,3,4,5,6)

lst.map( x => List(x , x*4))                       /// List(List(1, 4), List(2, 8), List(3, 12), List(9, 36))

lst.flatMap( x => List(x , x*4))                   /// List(1, 4, 2, 8, 3, 12, 9, 36)  ( Map + Flatten)

lst.filter( x => x%2 ==0)                          /// List(2,10)

