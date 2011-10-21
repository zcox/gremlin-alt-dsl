package gremlin;

import pipes.Pipe;
import pipes.Pipeline;
import blueprints.Edge;
import blueprints.Vertex;

public class InVertexPipe implements Pipe<Edge, Vertex> {

  public static <S> Pipeline<S, Vertex> addTo(Pipeline<S, Edge> pipeline) {
    // other complex pipe-adding logic can go here...
    return pipeline.add(new InVertexPipe());
  }

}
