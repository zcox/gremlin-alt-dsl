package pipes;

/** Does not emit any object that has already been emitted. */
public class DuplicateFilterPipe<S> implements Pipe<S, S> {

  public static <S, E> Pipeline<S, E> addTo(Pipeline<S, E> pipeline) {
    // other complex pipe-adding logic can go here...
    return pipeline.add(new DuplicateFilterPipe<E>());
  }

}
