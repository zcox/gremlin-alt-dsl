package gremlin;

import pipes.AbstractConcretePipelineDsl;
import pipes.GenericPipelineDsl;
import pipes.Pipeline;
import blueprints.Vertex;

/** DSL methods you can call on a Pipeline<S, Vertex>. There is (at least) one method for each implementation of Pipe<Vertex, E>. */
public class VertexPipelineDsl<S> extends AbstractConcretePipelineDsl<S, Vertex> {

  public VertexPipelineDsl(Pipeline<S, Vertex> pipeline) {
    super(pipeline);
  }

  /** Converts GenericPipelineDsl<S, Vertex> => VertexPipelineDsl<S>. */
  public static <S> VertexPipelineDsl<S> from(GenericPipelineDsl<S, Vertex> dsl) {
    return new VertexPipelineDsl<S>(dsl.pipeline());
  }

  public static VertexPipelineDsl<Vertex> from(Vertex vertex) {
    return new VertexPipelineDsl<Vertex>(new Pipeline<Vertex, Vertex>());
  }

  /** Adds a new OutEdgesPipe onto the end of this pipeline. Pipeline<S, Vertex> + Pipe<Vertex, Edge> = Pipeline<S, Edge>. */
  public EdgePipelineDsl<S> outE() {
    return new EdgePipelineDsl<S>(OutEdgesPipe.addTo(pipeline));
  }

}
