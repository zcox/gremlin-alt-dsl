package pipes;

import java.util.Collection;

/** Emits an object only if it is contained in a collection. */
public class RetainFilterPipe<S> implements Pipe<S, S> {

  public RetainFilterPipe(Collection<S> collection) {

  }

  public static <S, E> Pipeline<S, E> addTo(Pipeline<S, E> pipeline, Collection<E> collection) {
    // other complex pipe-adding logic can go here...
    return pipeline.add(new RetainFilterPipe<E>(collection));
  }

}
