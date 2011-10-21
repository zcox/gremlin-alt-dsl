package gremlin.scala

import blueprints._
import pipes._
import gremlin._
import implicits._
import _root_.scala.collection.JavaConversions._

object ScalaDslTest {
  def test() {
    val v = new Vertex
    val vertices = List(v)
    
    //the implicits eliminate need for generic(), pipeline(), and VertexPipelineDsl.from() calls, producing a nice fluent API
    val p: Pipeline[Vertex, Vertex] = VertexPipelineDsl.from(v).outE().inV().dedup().retain(vertices).outE().inV()
  }
}