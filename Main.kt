package org.example
fun main() {
val hall = arrayOf(
    intArrayOf(0, 0, 1, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 1, 0),
    intArrayOf(1, 0, 0, 0, 0, 1),
    intArrayOf(0, 0, 0, 0, 0, 0)
)

val price = arrayOf(
    intArrayOf(500),
    intArrayOf(400),
    intArrayOf(300),
    intArrayOf(200)
)

val group = intArrayOf(3, 4, 0, 7, 2, 3, 6, 1, 2)

var revenue = 0
var acceptedGroups = 0
var rejections = 0

var i = 0

while (i < group.size) {

    val groupSize = group[i]

    if (groupSize < 1 || groupSize > 6) {
        rejections++
    } else {

        var row = 0

        var placed = false
    
        while (row < hall.size && !placed) {


            var seat = 0

            while (seat <= hall[row].size - groupSize && !placed){


                var free = true
                var j = 0
                

                while (j < groupSize) {

                    if(hall[row][seat + j] == 1)
                        free = false
                
                    

                    j++
                }
                  if(free){
                    j = 0
                      while (j < groupSize) {
                        hall[row][seat + j] = 1
                        j++

                          

                       
                      }
                      var r = 0
while (r < hall.size) {
    println(hall[r].contentToString())
    r++
}
                      placed = true

                      println("Группа $groupSize посажена в ряд $row, начиная с места $seat")
                          val payment = groupSize * price[row][0]
                          revenue += payment
                          acceptedGroups++
                          

                          
                      
                  }

                seat++
            }

            row++
            }
        if(!placed){
            rejections++
        }
    }

    i++
}
  println("Выручка: $revenue")
  println("Принято групп: $acceptedGroups")
  println("Отклонено групп: $rejections")
}