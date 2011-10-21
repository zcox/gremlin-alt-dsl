package pipes;

/** Example of an immutable, persistent, typesafe Pipeline. */
public final class Pipeline<S, E> implements Pipe<S, E> {

  public Pipeline() {

  }

  public Pipeline(Pipe<S, E> pipe) {
    // TODO start this pipeline out with this single pipe
  }

  public Pipeline(Pipeline<S, ?> pipeline, Pipe<?, E> pipe) {
    // TODO start this pipeline out by appending the pipe to the other pipeline
  }

  /** Returns a new pipeline that is this pipeline with the specified pipe appended onto the end. Note that the returned Pipeline properly uses the
   * starting type S of this pipeline and the ending type F of the new pipe. */
  public <F> Pipeline<S, F> add(Pipe<E, F> pipe) {
    return new Pipeline<S, F>(this, pipe);
  }

}
