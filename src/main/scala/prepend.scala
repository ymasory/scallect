package com.yuvimasory.scallect

import com.google.caliper.Param

import java.util.LinkedList

class PrependBenchmark extends SimpleScalaBenchmark {
  
  @Param(Array("10000"))
  val length: Int = 0
  
  def timePrependLinkedListJava(reps: Int) = repeat(reps) {
    var iter = 0
    var col: LinkedList[String] = new LinkedList()
    while(iter < length) {
      col addFirst iter.toString
      iter += 1
    }
    iter
  }

  def timePrependListScala(reps: Int) = repeat(reps) {
    var iter = 0
    var col: List[String] = Nil
    while(iter < length) {
      col = iter.toString :: col
      iter += 1
    }
    iter
  }

  def timePrependVectorScala(reps: Int) = repeat(reps) {
    var iter = 0
    var col: List[String] = Nil
    while(iter < length) {
      col +: iter.toString
      iter += 1
    }
    iter
  }
}

