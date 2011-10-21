package gremlin;

import pipes.Pipe;
import pipes.Pipeline;
import blueprints.Edge;
import blueprints.Vertex;

public class OutEdgesPipe implements Pipe<Vertex, Edge> {

  public static <S> Pipeline<S, Edge> addTo(Pipeline<S, Vertex> pipeline) {
    // other complex pipe-adding logic can go here...
    return pipeline.add(new OutEdgesPipe());
  }

}
