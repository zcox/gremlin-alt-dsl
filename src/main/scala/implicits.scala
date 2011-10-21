package gremlin.scala

import blueprints._
import pipes._
import gremlin._

object implicits {
  //pipeline => dsl
  implicit def pipeline2VertexDsl[S](pipeline: Pipeline[S, Vertex]): VertexPipelineDsl[S] = new VertexPipelineDsl[S](pipeline)
  implicit def pipeline2EdgeDsl[S](pipeline: Pipeline[S, Edge]): EdgePipelineDsl[S] = new EdgePipelineDsl[S](pipeline)
  implicit def pipeline2GenericDsl[S, E](pipeline: Pipeline[S, E]): GenericPipelineDsl[S, E] = new GenericPipelineDsl[S, E](pipeline)
  
  //dsl => pipeline
  implicit def vertexDsl2Pipeline[S](dsl: VertexPipelineDsl[S]): Pipeline[S, Vertex] = dsl.pipeline
  implicit def edgeDsl2Pipeline[S](dsl: EdgePipelineDsl[S]): Pipeline[S, Edge] = dsl.pipeline
  implicit def genericDsl2Pipeline[S, E](dsl: GenericPipelineDsl[S, E]): Pipeline[S, E] = dsl.pipeline
  
  //gremlin dsl => pipes dsl
  implicit def vertexDsl2GenericDsl[S](dsl: VertexPipelineDsl[S]): GenericPipelineDsl[S, Vertex] = dsl.generic
  implicit def edgeDsl2GenericDsl[S](dsl: EdgePipelineDsl[S]): GenericPipelineDsl[S, Edge] = dsl.generic
  
  //pipes dsl => gremlin dsl
  implicit def genericDsl2VertexDsl[S](dsl: GenericPipelineDsl[S, Vertex]): VertexPipelineDsl[S] = VertexPipelineDsl.from(dsl)
  implicit def genericDsl2EdgeDsl[S](dsl: GenericPipelineDsl[S, Edge]): EdgePipelineDsl[S] = EdgePipelineDsl.from(dsl)
}