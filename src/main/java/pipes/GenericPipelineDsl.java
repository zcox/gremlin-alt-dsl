package pipes;

import java.util.Collection;

/** DSL methods you can call on a generic Pipeline<S, E>. There is (at least) one method for each Pipe implementation. */
public final class GenericPipelineDsl<S, E> extends AbstractPipelineDsl<S, E> {

  public GenericPipelineDsl(Pipeline<S, E> pipeline) {
    super(pipeline);
  }

  public GenericPipelineDsl<S, E> dedup() {
    return new GenericPipelineDsl<S, E>(DuplicateFilterPipe.addTo(pipeline));
  }

  public GenericPipelineDsl<S, E> retain(Collection<E> collection) {
    return new GenericPipelineDsl<S, E>(RetainFilterPipe.addTo(pipeline, collection));
  }
}
