package gremlin.scala

import blueprints._
import pipes._
import gremlin._
import _root_.scala.collection.JavaConversions._

object JavaDslTest {
  def test() {
    val v = new Vertex
    val vertices = List(v)
    
    val p8 = VertexPipelineDsl.from(VertexPipelineDsl.from(v).outE().inV().generic().dedup().retain(vertices)).outE().inV().pipeline()
  }
}