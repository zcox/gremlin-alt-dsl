package gremlin;

import pipes.AbstractConcretePipelineDsl;
import pipes.GenericPipelineDsl;
import pipes.Pipeline;
import blueprints.Edge;

/** DSL methods you can call on a Pipeline<S, Edge>. There is (at least) one method for each implementation of Pipe<Edge, E>. */
public class EdgePipelineDsl<S> extends AbstractConcretePipelineDsl<S, Edge> {

  public EdgePipelineDsl(Pipeline<S, Edge> pipeline) {
    super(pipeline);
  }

  /** Converts GenericPipelineDsl<S, Edge> => EdgePipelineDsl<S>. */
  public static <S> EdgePipelineDsl<S> from(GenericPipelineDsl<S, Edge> dsl) {
    return new EdgePipelineDsl<S>(dsl.pipeline());
  }

  /** Adds a new InVertexPipe onto the end of this pipeline. Pipeline<S, Edge> + Pipe<Edge, Vertex> = Pipeline<S, Vertex>. */
  public VertexPipelineDsl<S> inV() {
    return new VertexPipelineDsl<S>(InVertexPipe.addTo(pipeline));
  }

}
